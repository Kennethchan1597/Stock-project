package com.project.stock.demo_stock_heatmap.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;
import com.project.stock.demo_stock_heatmap.repository.StockRepository;
import com.project.stock.demo_stock_heatmap.service.StockService;

@Service
public class StockServiceImpl implements StockService{
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

  @Override
  public Map<String, StockQuoteDTO> fetchStockData() {
    // String url = "https://api.twelvedata.com/quote?symbol=AAPL&apikey=3b4c1a0bd9de4b5fb77e842e89487c4c";
    List<String> symbolList = Arrays.asList(
      
      "MDLZ", "LRCX", "ATVI", "PDD", "KDP", "PANW"
      // "MAR", "CTSH"
      // "FISV", "EXC", "ADSK", "MNST", "ROST", "MCHP", "ASML", "CDNS",
      // "NXPI", "IDXX", "BIIB", "FTNT", "WBD", "CHTR", "EA", "CRWD", 
      // "CSGP", "AZN", "ODFL", "DLTR", "PAYX", "ORLY", "MRVL", "LCID"
      // "ZS", "TEAM", "CPRT", "SNPS", "TTD", "WBA", "SIRI", "FAST",
      // "CTAS", "ILMN", "DOCU", "BIDU", "VRSK", "KLAC", "ALGN", "XEL",
      // "LULU", "SBAC", "ANSS", "PCAR", "VRSN", "OKTA", "JD", "ZM",
      // "EXPE", "NTES", "AEP", "GEN", "EBAY", "BMRN", 
      // "RIVN", "DDOG", "SGEN", "SWKS", "ENPH"
    );
    String symbols = String.join(",", symbolList);
    String url = UriComponentsBuilder.newInstance()
    .scheme(this.tweScheme)
    .host(this.tweHost)
    .pathSegment(this.tweQuoteEndPoint)
    .queryParam("symbol", symbols)
    .queryParam("apikey", this.tweApiKey)
    .build()
    .toUriString();
    System.out.println("stockData url: " + url);
    ParameterizedTypeReference<Map<String, StockQuoteDTO>> typeref = 
    new ParameterizedTypeReference<Map<String,StockQuoteDTO>>() {};
    return this.restTemplate.exchange(url, HttpMethod.GET, null, typeref).getBody();
  }

  @Override
  public List<NDX100QuoteEntity> saveAll(List<NDX100QuoteEntity> list) {
    return this.stockRepository.saveAll(list);
  }


}
