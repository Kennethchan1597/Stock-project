package com.project.stock.demo_stock_heatmap.dto.mapper;

import org.springframework.stereotype.Component;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;

@Component
public class DtoMapper {
  
  public StockHeatMapDTO map(StockQuoteDTO s) {
    return StockHeatMapDTO.builder()
    .symbol(s.getSymbol())
    .percentChange(s.getPercentChange())
    .build();
  }
}
