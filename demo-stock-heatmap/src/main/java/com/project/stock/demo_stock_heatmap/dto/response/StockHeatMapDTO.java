package com.project.stock.demo_stock_heatmap.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class StockHeatMapDTO {
  private String symbol;
  private String percentChange;


  // double percent = -0.432423746;
  // String formatted = String.format("%.2f%%", percent);
  // System.out.println(formatted);

}
