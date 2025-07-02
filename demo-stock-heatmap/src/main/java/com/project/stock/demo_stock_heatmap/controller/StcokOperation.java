package com.project.stock.demo_stock_heatmap.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;

public interface StcokOperation {


  @GetMapping(value = "/stock/quote")
  List<StockHeatMapDTO> getStockQuote();

  @GetMapping(value = "/stock/quotes/")
  List<NDX100QuoteEntity> saveStockQuote();

}
