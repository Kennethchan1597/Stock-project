package com.project.stock.demo_stock_marketcap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.stock.demo_stock_marketcap.entity.NDX100Entity;
import com.project.stock.demo_stock_marketcap.model.StockMKTCap;
import com.project.stock.demo_stock_marketcap.repository.StockRepository;
import com.project.stock.demo_stock_marketcap.service.StockService;

@Service
public class StockServiceImpl implements StockService{
  @Autowired
  private RestTemplate restTemplate;

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
  public StockMKTCap fetchStockMC(String symbol) {
    String url = UriComponentsBuilder.newInstance()
    .scheme(this.alpScheme)
    .host(this.alpHost)
    .pathSegment(this.alpQuery)
    .queryParam("function", this.alpFunction)
    .queryParam("symbol", symbol)
    .queryParam("apikey", this.alpApiKey)
    .build()
    .toUriString();
    System.out.println("thisURL: " + url);
    return this.restTemplate.getForObject(url, StockMKTCap.class);
  }

  @Override
  public List<NDX100Entity> saveAll(List<NDX100Entity> list) {
    return this.stockRepository.saveAll(list);
  }

  @Override
  public NDX100Entity save(NDX100Entity stock) {
    return this.stockRepository.save(stock);
  }

}
