package com.project.stock.demo_stock_heatmap.service;

import java.util.List;
import java.util.Map;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.model.StockMCDTO;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;

public interface StockService {
  Map<String, StockQuoteDTO> fetchStocksData();

  StockQuoteDTO fetchStockData(String symbol);

  List<NDX100QuoteEntity> saveAll(List<NDX100QuoteEntity> list);

  NDX100QuoteEntity save(NDX100QuoteEntity stock);

  List<NDX100QuoteEntity> getAll();

  List<StockMCDTO> getMarketCap();

  void setMarketCap(List<StockHeatMapDTO> list);

  void setLogo(List<StockHeatMapDTO> list);

  void setSector();

  NDX100QuoteEntity findBySymbol(String symbol);

}
