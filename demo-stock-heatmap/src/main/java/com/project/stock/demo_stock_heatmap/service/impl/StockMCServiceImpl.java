package com.project.stock.demo_stock_heatmap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.project.stock.demo_stock_heatmap.entity.NDX100Entity;
import com.project.stock.demo_stock_heatmap.model.StockMKTCap;
import com.project.stock.demo_stock_heatmap.repository.StockMCRepository;
import com.project.stock.demo_stock_heatmap.service.StockMCService;


@Service
public class StockMCServiceImpl implements StockMCService{
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
  private StockMCRepository stockRepository;


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

  @Override
  public List<NDX100Entity> getAll() {
    return this.stockRepository.findAll();
  }

}








  // Service
  // 1. save method -> save to DB
  // 2. fetchData -> get Data from external API, return Stock

  // controller
  // 1. saveToDB {
  // call fetchData,
  // save 
  // return
  // }