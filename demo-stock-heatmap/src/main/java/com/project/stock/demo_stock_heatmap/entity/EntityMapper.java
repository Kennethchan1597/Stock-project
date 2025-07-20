package com.project.stock.demo_stock_heatmap.entity;

import org.springframework.stereotype.Component;
import com.project.stock.demo_stock_heatmap.model.StockMKTCap;
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
    .avgVolume(quote.getAvgVolume())
    .priceChange(quote.getChange())
    .priceClose(quote.getClose())
    .high(quote.getHigh())
    .low(quote.getLow())
    .priceOpen(quote.getOpen())
    .previousClose(quote.getPreviousClose())
    .percentChange(quote.getPercentChange())
    .volume(quote.getVolume())
    .build();
  }

  // public NDX100QuoteEntity map(StockHeatMapDTO s) {
  //   return NDX100QuoteEntity.builder()
  //   .symbol(s.getSymbol())
  //   .sector(s.getSector())
  //   .build();
  // }

  public NDX100Entity map(StockMKTCap sCap) {
    return NDX100Entity.builder()
    .marketCap(sCap.getMarketcapitalization())
    .symbol(sCap.getSymbol())
    .build();
  }

}


// 1. DTO -> Entity (mapper)
// 2. save to DB