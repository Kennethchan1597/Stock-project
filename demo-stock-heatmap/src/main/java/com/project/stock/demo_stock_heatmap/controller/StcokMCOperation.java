package com.project.stock.demo_stock_heatmap.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.stock.demo_stock_heatmap.entity.NDX100Entity;


public interface StcokMCOperation {

  @GetMapping(value = "/stock/marketcap")
  NDX100Entity getMatketCap(@RequestParam String symbol);

  @GetMapping(value = "/stocks/marketcap")
  List<NDX100Entity> getAllMatketCap();

  @PostMapping(value = "/stock/marketcap/{symbol}")
  NDX100Entity saveStock(@PathVariable String symbol);

  
}
