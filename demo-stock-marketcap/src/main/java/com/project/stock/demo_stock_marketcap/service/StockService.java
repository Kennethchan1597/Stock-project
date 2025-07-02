package com.project.stock.demo_stock_marketcap.service;

import java.util.List;
import com.project.stock.demo_stock_marketcap.entity.NDX100Entity;
import com.project.stock.demo_stock_marketcap.model.StockMKTCap;

public interface StockService {

  StockMKTCap fetchStockMC(String symbol);

  List<NDX100Entity> saveAll(List<NDX100Entity> list);

  NDX100Entity save(NDX100Entity stock);

}
