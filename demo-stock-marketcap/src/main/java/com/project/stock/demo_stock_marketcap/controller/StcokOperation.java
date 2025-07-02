package com.project.stock.demo_stock_marketcap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.stock.demo_stock_marketcap.entity.NDX100Entity;

public interface StcokOperation {

  @GetMapping(value = "/stoke/marketcap")
  NDX100Entity getMatketCap(@RequestParam String symbol);



}
