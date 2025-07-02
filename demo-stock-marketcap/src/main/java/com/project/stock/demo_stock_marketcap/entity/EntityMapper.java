package com.project.stock.demo_stock_marketcap.entity;

import org.springframework.stereotype.Component;
import com.project.stock.demo_stock_marketcap.model.StockMKTCap;

@Component
public class EntityMapper {

  public NDX100Entity map(StockMKTCap sCap) {
    return NDX100Entity.builder()
    .marketCap(sCap.getMarketcapitalization())
    .symbol(sCap.getSymbol())
    .build();
  }


}
