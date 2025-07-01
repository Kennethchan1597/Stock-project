package com.project.stock.demo_stock_heatmap.service;

import java.util.List;
import com.project.stock.demo_stock_heatmap.model.StockMKTCap;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;

public interface StockService {
  List<StockQuoteDTO> fetchStockData();

  List<StockMKTCap> fetchStockMC();

}
