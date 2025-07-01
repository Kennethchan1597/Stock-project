package com.project.stock.demo_stock_heatmap.entity;

import java.util.Comparator;
import org.springframework.stereotype.Component;
import com.project.stock.demo_stock_heatmap.model.StockMKTCap;

@Component
public class EntityMapper {

  public NDX100Entity map(StockMKTCap sCap) {

    StockMKTCap.MarketCap maxMarketCap = sCap.getMarketCaps().stream()
        .max(Comparator.comparing((StockMKTCap.MarketCap::getDate)))
        .orElseThrow(
            () -> new IllegalArgumentException("No market cap data available"));

    return NDX100Entity.builder().symbol(sCap.getMeta().getSymbol())
        .date(maxMarketCap.getDate()).marketCap(maxMarketCap.getValue())
        .build();
  }
}
