package com.project.stock.demo_stock_heatmap.dto.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.stock.demo_stock_heatmap.dto.response.StockCandelDTO;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.entity.NDX100Entity;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.model.StockHisData;
import com.project.stock.demo_stock_heatmap.model.StockMCDTO;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;

@Component
public class DtoMapper {
  @Autowired
  private ObjectMapper objectMapper;
  
  public StockHeatMapDTO map(StockQuoteDTO s) {
    return StockHeatMapDTO.builder()
    .symbol(s.getSymbol())
    .percentChange(new BigDecimal(s.getPercentChange()).setScale(2, RoundingMode.HALF_UP).doubleValue())
    .build();
  }

  public StockHeatMapDTO map(NDX100QuoteEntity en) {
    return StockHeatMapDTO.builder()
    .symbol(en.getSymbol())
    .percentChange(new BigDecimal(en.getPercentChange()).setScale(2, RoundingMode.HALF_UP).doubleValue())
    .avgVolume(en.getAvgVolume())
    .datetime(en.getDatetime())
    .fiftyTwoHigh(en.getFiftyTwoHigh())
    .fiftyTwoLow(en.getFiftyTwoLow())
    .high(en.getHigh())
    .low(en.getLow())
    .name(en.getName())
    .previousClose(en.getPreviousClose())
    .sector(en.getSector())
    .build();
  }

  public StockCandelDTO mapCandle(NDX100QuoteEntity e) {
    return StockCandelDTO.builder()
    .priceClose(e.getPriceClose())
    .priceOpen(e.getPriceOpen())
    .date(e.getDatetime())
    .high(e.getHigh())
    .low(e.getLow())
    .symbol(e.getSymbol())
    .volume(e.getVolume())
    .build();
  }


  public List<StockCandelDTO> map(StockHisData s) {
    return  s.getValues().stream().map(c -> 
      StockCandelDTO.builder()
      .date(c.getDatetime())
      .high(c.getHigh())
      .low(c.getLow())
      .priceClose(c.getClose())
      .priceOpen(c.getOpen())
      .volume(c.getVolume())
      .symbol(s.getMeta().getSymbol())
      .build()).toList();
  }

  public StockMCDTO map(NDX100Entity n) {
    return this.objectMapper.convertValue(n, StockMCDTO.class);
  } 



}
