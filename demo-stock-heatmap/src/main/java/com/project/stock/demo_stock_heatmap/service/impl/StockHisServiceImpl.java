package com.project.stock.demo_stock_heatmap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.project.stock.demo_stock_heatmap.model.StockHisData;
import com.project.stock.demo_stock_heatmap.service.StockHisService;

@Service
public class StockHisServiceImpl implements StockHisService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public StockHisData fetchDayData(String symbol) {
    String url =
        "https://api.twelvedata.com/time_series?symbol=" + symbol + "&interval=1day&start_date=2025-01-01&apikey=3b4c1a0bd9de4b5fb77e842e89487c4c";
    ResponseEntity<StockHisData> response =
        this.restTemplate.getForEntity(url, StockHisData.class);
    StockHisData data = response.getBody();
    if (data == null) {
      throw new RuntimeException("Failed to fetch stock data from API.");
    }
    return data;
  }

  @Override
  public StockHisData fetchWeekData(String symbol) {
    String url =
        "https://api.twelvedata.com/time_series?symbol=" + symbol + "&interval=1week&start_date=2020-01-01&apikey=3b4c1a0bd9de4b5fb77e842e89487c4c";
    ResponseEntity<StockHisData> response =
        this.restTemplate.getForEntity(url, StockHisData.class);
    StockHisData data = response.getBody();
    if (data == null) {
      throw new RuntimeException("Failed to fetch stock data from API.");
    }
    return data;
  }

  @Override
  public StockHisData fetchMonthData(String symbol) {
    String url =
        "https://api.twelvedata.com/time_series?symbol=" + symbol + "&interval=1month&start_date=2015-01-01&apikey=3b4c1a0bd9de4b5fb77e842e89487c4c";
    ResponseEntity<StockHisData> response =
        this.restTemplate.getForEntity(url, StockHisData.class);
    StockHisData data = response.getBody();
    if (data == null) {
      throw new RuntimeException("Failed to fetch stock data from API.");
    }
    return data;
  }
}
