package com.project.stock.demo_stock_heatmap.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeatmapController {
  
  @GetMapping(value = "/stock/heatmap")
  public String getHeatmap(Model model){
    model.addAttribute(null, model);
    return "Heatmap";
  }
}
