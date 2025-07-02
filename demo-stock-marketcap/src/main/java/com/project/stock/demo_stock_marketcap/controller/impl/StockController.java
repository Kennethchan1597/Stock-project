package com.project.stock.demo_stock_marketcap.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.stock.demo_stock_marketcap.controller.StcokOperation;
import com.project.stock.demo_stock_marketcap.entity.EntityMapper;
import com.project.stock.demo_stock_marketcap.entity.NDX100Entity;
import com.project.stock.demo_stock_marketcap.service.StockService;

@RestController
public class StockController implements StcokOperation{
@Autowired
private StockService stockService;
@Autowired
private EntityMapper entityMapper;

  @Override
  public NDX100Entity getMatketCap(String symbol) {
    NDX100Entity result = this.entityMapper.map(this.stockService.fetchStockMC(symbol));
    this.stockService.save(result);
    return result;
  }
  

}
