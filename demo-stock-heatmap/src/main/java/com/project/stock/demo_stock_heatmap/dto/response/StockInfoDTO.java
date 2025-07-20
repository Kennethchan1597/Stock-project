package com.project.stock.demo_stock_heatmap.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StockInfoDTO {
  
  private String name;
  private LocalDate datetime;
  private String fiftyTwoHigh;
  private String fiftyTwoLow;
  private String high;
  private String low;
  private String previousClose;
  private String avgVolume;
}

