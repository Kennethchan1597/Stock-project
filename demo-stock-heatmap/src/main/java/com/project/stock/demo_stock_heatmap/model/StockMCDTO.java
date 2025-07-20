package com.project.stock.demo_stock_heatmap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class StockMCDTO {
  private Long id;
  private String symbol;
  private Long marketCap;
}
