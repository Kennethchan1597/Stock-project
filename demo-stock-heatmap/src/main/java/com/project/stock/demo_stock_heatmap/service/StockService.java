package com.project.stock.demo_stock_heatmap.service;

import java.util.List;
import java.util.Map;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;

public interface StockService {
  Map<String, StockQuoteDTO> fetchStockData();

  List<NDX100QuoteEntity> saveAll(List<NDX100QuoteEntity> list);

}
