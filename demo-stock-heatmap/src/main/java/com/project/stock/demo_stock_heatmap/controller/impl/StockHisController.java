package com.project.stock.demo_stock_heatmap.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.stock.demo_stock_heatmap.service.StockHisService;

@RestController
public class StockHisController {
  @Autowired
  private StockHisService stockHisService;

  // @GetMapping(value = "/stock/history")
  // public StockHisData getData() {
  //   return this.stockHisService.fetchMonthData();
  // }

}
