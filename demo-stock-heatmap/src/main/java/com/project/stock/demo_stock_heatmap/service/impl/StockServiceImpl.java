package com.project.stock.demo_stock_heatmap.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.stock.demo_stock_heatmap.model.StockMKTCap;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;
import com.project.stock.demo_stock_heatmap.service.StockService;

@Service
public class StockServiceImpl implements StockService{
  @Autowired
  private RestTemplate restTemplate;
  @Value("${twelvedata.api.host}")
  private String host;
  @Value("${twelvedata.api.scheme}")
  private String scheme;
  @Value("${twelvedata.api.endpoints.marketCap}")
  private String marketCapEndPoint;
  @Value("${twelvedata.api.endpoints.quote}")
  private String quoteEndPoint;
  @Value("${twelvedata.api.key}")
  private String apiKey;

  @Override
  public List<StockQuoteDTO> fetchStockData() {
    String url = "https://api.twelvedata.com/quote?symbol=AAPL&apikey=3b4c1a0bd9de4b5fb77e842e89487c4c";
    return Arrays.asList(this.restTemplate.getForObject(url, StockQuoteDTO[].class));
  }

  @Override
  public List<StockMKTCap> fetchStockMC() {
    List<String> symbols = List.of(
      "AAPL", "MSFT", "GOOGL", "GOOG", "AMZN", "NVDA", "META", "TSLA", "AVGO", "ADBE",
      "PEP", "COST", "NFLX", "INTC", "CSCO", "AMGN", "TMUS", "TXN", "QCOM", "HON",
      "INTU", "SBUX", "AMD", "AMAT", "ISRG", "BKNG", "ADP", "VRTX", "REGN", "MU",
      "ADI", "GILD", "MDLZ", "LRCX", "ATVI", "PDD", "KDP", "PANW", "MAR", "CTSH",
      "FISV", "EXC", "ADSK", "MNST", "ROST", "MCHP", "ASML", "CDNS", "NXPI", "IDXX",
      "BIIB", "FTNT", "WBD", "CHTR", "EA", "CRWD", "CSGP", "AZN", "ODFL", "DLTR",
      "PAYX", "ORLY", "MRVL", "LCID", "ZS", "TEAM", "CPRT", "SNPS", "TTD", "WBA",
      "SIRI", "FAST", "CTAS", "ILMN", "DOCU", "BIDU", "VRSK", "KLAC", "ALGN", "XEL",
      "LULU", "SBAC", "ANSS", "PCAR", "VRSN", "OKTA", "JD", "ZM", "EXPE", "NTES",
      "AEP", "GEN", "EBAY", "BMRN", "RIVN", "DDOG", "SGEN", "SWKS", "ENPH"
    );
    String joinedSymbols = String.join(",", symbols);
    String url = UriComponentsBuilder.newInstance()
    .scheme(this.scheme)
    .host(this.host)
    .pathSegment(this.marketCapEndPoint)
    .queryParam("symbol", joinedSymbols)
    .queryParam("apikey", this.apiKey)
    .build()
    .toUriString();
    System.out.println("thisURL: " + url);
    return Arrays.asList(this.restTemplate.getForObject(url, StockMKTCap[].class));
  }

}
