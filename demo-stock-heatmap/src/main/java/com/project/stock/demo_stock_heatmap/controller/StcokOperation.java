package com.project.stock.demo_stock_heatmap.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;

public interface StcokOperation {


  @GetMapping(value = "/stocks/quote")
  List<StockHeatMapDTO> getStocksQuote();

  @GetMapping(value = "/stock/quotes")
  List<NDX100QuoteEntity> saveStockQuote();

  @GetMapping(value = "/stock/missed")
  List<String> missedSymbols();

  @PostMapping(value = "/stock/quote/{symbol}")
  NDX100QuoteEntity saveStock(@PathVariable String symbol);

  @PostMapping(value = "/stock/quote/sectors")
  void saveSectors();

}
