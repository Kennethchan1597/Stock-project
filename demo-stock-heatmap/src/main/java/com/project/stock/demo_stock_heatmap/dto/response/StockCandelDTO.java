package com.project.stock.demo_stock_heatmap.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class StockCandelDTO {
  private String symbol;
  private LocalDate date;
  private String priceOpen;
  private String priceClose;
  private String high;
  private String low;
  private String volume;
}
