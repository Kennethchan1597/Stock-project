package com.project.stock.demo_stock_heatmap.entity;

import org.springframework.stereotype.Component;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;

@Component
public class EntityMapper {

  public NDX100QuoteEntity map(StockQuoteDTO quote) {
    return NDX100QuoteEntity.builder()
    .datetime(quote.getDatetime())
    .fiftyTwoHigh(quote.getFiftyTwoWeek().getHigh())
    .fiftyTwoLow(quote.getFiftyTwoWeek().getLow())
    .name(quote.getName())
    .symbol(quote.getSymbol())
    .build();
  }
}
