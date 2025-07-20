package com.project.stock.demo_stock_heatmap.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.stock.demo_stock_heatmap.controller.StcokMCOperation;
import com.project.stock.demo_stock_heatmap.entity.EntityMapper;
import com.project.stock.demo_stock_heatmap.entity.NDX100Entity;
import com.project.stock.demo_stock_heatmap.service.StockMCService;


@RestController
public class StockMCController implements StcokMCOperation {
  @Autowired
  private StockMCService stockService;
  @Autowired
  private EntityMapper entityMapper;

  @Override
  public NDX100Entity getMatketCap(String symbol) {
    NDX100Entity result =
        this.entityMapper.map(this.stockService.fetchStockMC(symbol));
    this.stockService.save(result);
    return result;
  }

  @Override
  public List<NDX100Entity> getAllMatketCap() {
    return this.stockService.getAll();
  }

  @Override
  public NDX100Entity saveStock(String symbol) {
    return this.stockService.save(this.entityMapper.map(this.stockService.fetchStockMC(symbol)));
  }

}

