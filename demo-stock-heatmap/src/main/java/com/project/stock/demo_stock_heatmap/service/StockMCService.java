package com.project.stock.demo_stock_heatmap.service;

import java.util.List;
import com.project.stock.demo_stock_heatmap.entity.NDX100Entity;
import com.project.stock.demo_stock_heatmap.model.StockMKTCap;


public interface StockMCService {

  StockMKTCap fetchStockMC(String symbol);

  List<NDX100Entity> saveAll(List<NDX100Entity> list);

  NDX100Entity save(NDX100Entity stock);

  List<NDX100Entity> getAll();

}
