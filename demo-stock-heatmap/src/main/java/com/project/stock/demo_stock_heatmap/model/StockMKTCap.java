package com.project.stock.demo_stock_heatmap.model;

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
  private Long id;
  @JsonProperty(value = "Symbol")
  private String symbol;
  @JsonProperty(value = "MarketCapitalization")
  private Long marketcapitalization;


}
