package com.project.stock.demo_stock_heatmap.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock_quote_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class NDX100QuoteEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String symbol;
  private String name;
  private LocalDate datetime;
  private String fiftyTwoHigh;
  private String fiftyTwoLow;
}
