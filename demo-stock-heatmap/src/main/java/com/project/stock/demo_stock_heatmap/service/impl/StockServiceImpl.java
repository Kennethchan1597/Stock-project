package com.project.stock.demo_stock_heatmap.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.stock.demo_stock_heatmap.dto.mapper.DtoMapper;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.entity.SectorEntity;
import com.project.stock.demo_stock_heatmap.model.StockMCDTO;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;
import com.project.stock.demo_stock_heatmap.repository.StockMCRepository;
import com.project.stock.demo_stock_heatmap.repository.StockRepository;
import com.project.stock.demo_stock_heatmap.repository.StockSectorRepository;
import com.project.stock.demo_stock_heatmap.service.StockService;

@Service
public class StockServiceImpl implements StockService {
  @Autowired
  private RestTemplate restTemplate;
  @Value("${twelvedata.api.host}")
  private String tweHost;
  @Value("${twelvedata.api.scheme}")
  private String tweScheme;
  @Value("${twelvedata.api.endpoints.quote}")
  private String tweQuoteEndPoint;
  @Value("${twelvedata.api.key}")
  private String tweApiKey;

  @Value("${alphavantagedata.api.host}")
  private String alpHost;
  @Value("${alphavantagedata.api.scheme}")
  private String alpScheme;
  @Value("${alphavantagedata.api.endpoints.query}")
  private String alpQuery;
  @Value("${alphavantagedata.api.function}")
  private String alpFunction;
  @Value("${alphavantagedata.api.key}")
  private String alpApiKey;

  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private StockMCRepository stockMCRepository;

  @Autowired
  private DtoMapper dtoMapper;

  @Autowired
  private StockSectorRepository sectorRepository;

  @Override
  public StockQuoteDTO fetchStockData(String symbol) {
    String url = "https://api.twelvedata.com/quote?symbol=" + symbol
        + "&apikey=3b4c1a0bd9de4b5fb77e842e89487c4c";
    return this.restTemplate.getForObject(url, StockQuoteDTO.class);
  }

  @Override
  public Map<String, StockQuoteDTO> fetchStocksData() {
    // String url = "https://api.twelvedata.com/quote?symbol=AAPL&apikey=3b4c1a0bd9de4b5fb77e842e89487c4c";
    List<String> symbolList = Arrays.asList("AAPL", "MSFT", "GOOGL", "GOOG",
        "AMZN", "NVDA", "PEP", "COST", "NFLX", "INTC", "CSCO", "AMGN", "TMUS",
        "TXN", "QCOM", "HON", "INTU", "SBUX", "AMD", "AMAT", "ISRG", "BKNG",
        "ADP", "VRTX", "REGN", "MU", "ADI", "GILD", "MDLZ", "LRCX", "ATVI",
        "PDD", "KDP", "PANW", "MAR", "CTSH", "FISV", "EXC", "ADSK", "MNST",
        "ROST", "MCHP", "ASML", "CDNS", "NXPI", "IDXX", "BIIB", "FTNT", "WBD",
        "CHTR", "EA", "CRWD", "CSGP", "AZN", "ODFL", "DLTR", "PAYX", "ORLY",
        "MRVL", "LCID", "ZS", "TEAM", "CPRT", "SNPS", "TTD", "WBA", "SIRI",
        "FAST", "CTAS", "ILMN", "DOCU", "BIDU", "VRSK", "KLAC", "ALGN", "XEL",
        "LULU", "SBAC", "ANSS", "PCAR", "VRSN", "OKTA", "JD", "ZM", "EXPE",
        "NTES", "AEP", "GEN", "EBAY", "BMRN", "RIVN", "DDOG", "SGEN", "SWKS",
        "ENPH");
    String symbols = String.join(",", symbolList);
    String url = UriComponentsBuilder.newInstance().scheme(this.tweScheme)
        .host(this.tweHost).pathSegment(this.tweQuoteEndPoint)
        .queryParam("symbol", symbols).queryParam("apikey", this.tweApiKey)
        .build().toUriString();
    System.out.println("stockData url: " + url);
    ParameterizedTypeReference<Map<String, StockQuoteDTO>> typeref =
        new ParameterizedTypeReference<Map<String, StockQuoteDTO>>() {};
    return this.restTemplate.exchange(url, HttpMethod.GET, null, typeref)
        .getBody();
  }

  @Override
  public NDX100QuoteEntity save(NDX100QuoteEntity stock) {
    return this.stockRepository.save(stock);
  }

  @Override
  public List<NDX100QuoteEntity> saveAll(List<NDX100QuoteEntity> list) {
    return this.stockRepository.saveAll(list);
  }

  @Override
  public List<NDX100QuoteEntity> getAll() {
    return this.stockRepository.findAll();
  }

  @Override
  public NDX100QuoteEntity findBySymbol(String symbol) {
    return this.stockRepository.findBySymbol(symbol);
  }

  @Override
  public List<StockMCDTO> getMarketCap() {
    return this.stockMCRepository.findAll().stream()
        .map(c -> this.dtoMapper.map(c)).toList();
  }

  @Override
  public void setMarketCap(List<StockHeatMapDTO> list) {
    List<StockMCDTO> marketCaps = this.getMarketCap();
    for (int i = 0; i < marketCaps.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        if (marketCaps.get(i).getSymbol().equals(list.get(j).getSymbol()))
          list.get(j).setMarketCap(marketCaps.get(i).getMarketCap());
      }
    }
  }

  @Override
  public void setLogo(List<StockHeatMapDTO> list) {
    for (StockHeatMapDTO c : list) {
      c.setLogoPath("/StockLogo/" + c.getSymbol() + ".jpg");
    }
  }

  @Override
  public void setSector() {
    List<SectorEntity> sectors = this.sectorRepository.findAll();
    Map<String, String> map = sectors.stream().collect(
        Collectors.toMap(SectorEntity::getSymbol, SectorEntity::getSector));
        List<NDX100QuoteEntity> list = this.stockRepository.findAll();
    for (NDX100QuoteEntity c : list) {
      String sector = map.get(c.getSymbol());
      if(sector != null)
      c.setSector(sector);
    }
    this.stockRepository.saveAll(list);
  }

}
