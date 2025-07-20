package com.project.stock.demo_stock_heatmap.model;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StockHisData {
  private Meta meta;
  private List<Value> values;
  private String status;

  @AllArgsConstructor
  @Getter
  public static class Meta {
    private String symbol;
    private String interval;
    private String currency;
    @JsonProperty(value = "exchange_timezone")
    private String exchangeTimezone;
    private String exchange;
    @JsonProperty(value = "mic_code")
    private String micCode;
    private String type;
  }

  @AllArgsConstructor
  @Getter
  public static class Value {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datetime;
    private String open;
    private String close;
    private String high;
    private String low;
    private String volume;
  }

}
