package com.project.stock.demo_stock_heatmap.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class StockQuoteDTO {
  private String symbol;
  private String name;
  private String exchange;
  @JsonProperty(value = "mic_code")
  private String micCode;
  private String currency;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate datetime;
  private Long timestamp;
  @JsonProperty(value = "last_quote_at")
  private Long lastQuoteAt;
  private String open;
  private String high;
  private String low;
  private String close;
  private String volume;
  @JsonProperty(value = "previous_close")
  private String previousClose;
  private String change;
  @JsonProperty(value = "percent_change")
  private String percentChange;
  @JsonProperty(value = "average_volume")
  private String avgVolume;
  @JsonProperty(value = "is_market_open")
  private Boolean marketStatus;
  @JsonProperty(value = "fifty_two_week")
  private FiftyTwoWeek fiftyTwoWeek;

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class FiftyTwoWeek {
    private String low;
    private String high;
    @JsonProperty(value = "low_change")
    private String lowChange;
    @JsonProperty(value = "high_change")
    private String highChange;
    @JsonProperty(value = "low_change_percent")
    private String lowChangePer;
    @JsonProperty(value = "high_change_percent")
    private String highChangePer;
    private String range;
  }
}
