package com.project.stock.demo_stock_heatmap.model;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StockMKTCap {
  private Meta meta;
  @JsonProperty(value = "market_cap")
  private List<MarketCap> marketCaps;

  @Getter
  @AllArgsConstructor
  @Builder
  @NoArgsConstructor
  public static class Meta {
    private String symbol;
    private String name;
    private String currency;
    private String exchange;
    @JsonProperty(value = "mic_code")
    private String micCode;
    @JsonProperty(value = "exchange_timezone")
    private String exchangeTimeZone;
  }

  @Getter
  @AllArgsConstructor
  @Builder
  @NoArgsConstructor
  public static class MarketCap {
    private LocalDate date;
    private Long value;
  }

}
