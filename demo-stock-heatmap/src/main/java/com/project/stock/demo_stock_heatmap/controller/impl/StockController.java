package com.project.stock.demo_stock_heatmap.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.stock.demo_stock_heatmap.controller.StcokOperation;
import com.project.stock.demo_stock_heatmap.dto.mapper.DtoMapper;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.entity.EntityMapper;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.service.StockService;

@RestController
public class StockController implements StcokOperation{
@Autowired
private StockService stockService;
@Autowired
private EntityMapper entityMapper;
@Autowired
private DtoMapper dtoMapper;


  @Override
  public List<StockHeatMapDTO> getStockQuote() {
     return this.stockService.fetchStockData().values().stream().map(c -> this.dtoMapper.map(c)).toList();
  }

  @Override
  public List<NDX100QuoteEntity> saveStockQuote() {
    List<NDX100QuoteEntity> result = this.stockService.fetchStockData().values().stream().map(c -> this.entityMapper.map(c)).toList();
    this.stockService.saveAll(result);
    return result;
  }

}
