package com.project.stock.demo_stock_heatmap.service;

import com.project.stock.demo_stock_heatmap.model.StockHisData;

public interface StockHisService {
  StockHisData fetchDayData(String symbol);

  StockHisData fetchWeekData(String symbol);

  StockHisData fetchMonthData(String symbol);
}
