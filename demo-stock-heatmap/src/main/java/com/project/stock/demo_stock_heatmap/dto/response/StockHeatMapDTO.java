package com.project.stock.demo_stock_heatmap.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class StockHeatMapDTO {
  private String symbol;
  private Double percentChange;
  private String name;
  private LocalDate datetime;
  private String fiftyTwoHigh;
  private String fiftyTwoLow;
  private String high;
  private String low;
  private String previousClose;
  private String avgVolume;
  @Setter
  private String logoPath;
  @Setter
  private Long marketCap;
  @Setter
  private String sector;


  // double percent = -0.432423746;
  // String formatted = String.format("%.2f%%", percent);
  // System.out.println(formatted);

}
