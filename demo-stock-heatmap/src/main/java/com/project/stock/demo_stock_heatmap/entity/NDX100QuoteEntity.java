package com.project.stock.demo_stock_heatmap.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "stock_quote_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@Setter
public class NDX100QuoteEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String symbol;
  private String name;
  private LocalDate datetime;
  @JsonProperty(value = "fifty_two_high")
  @Column(name = "fifty_two_high")
  private String fiftyTwoHigh;
  @JsonProperty(value = "fifty_two_low")
  @Column(name = "fifty_two_low")
  private String fiftyTwoLow;
  @JsonProperty(value = "price_open")
  @Column(name = "price_open")
  private String priceOpen;
  private String high;
  private String low;
  @JsonProperty(value = "price_close")
  @Column(name = "price_close")
  private String priceClose;
  private String volume;
  @JsonProperty(value = "previous_close")
  @Column(name = "previous_close")
  private String previousClose;
  @JsonProperty(value = "price_change")
  @Column(name = "price_change")
  private String priceChange;
  @JsonProperty(value = "percent_change")
  @Column(name = "percent_change")
  private String percentChange;
  @JsonProperty(value = "avg_volume")
  @Column(name = "avg_volume")
  private String avgVolume;
  @Setter
  private String sector;
}
