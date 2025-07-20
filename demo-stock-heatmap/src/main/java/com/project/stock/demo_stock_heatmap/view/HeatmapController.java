package com.project.stock.demo_stock_heatmap.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.stock.demo_stock_heatmap.dto.mapper.DtoMapper;
import com.project.stock.demo_stock_heatmap.dto.response.StockCandelDTO;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.service.StockHisService;
import com.project.stock.demo_stock_heatmap.service.StockService;

@Controller
public class HeatmapController {
  @Autowired
  private StockService stockService;
  @Autowired
  private StockHisService stockHisService;
  @Autowired
  private DtoMapper dtoMapper;
  
  @GetMapping(value = "/stock/home")
  public String homePage(Model model){
    List<StockHeatMapDTO> stocks = this.stockService.getAll().stream().map(c -> this.dtoMapper.map(c)).toList();
    this.stockService.setMarketCap(stocks);
    this.stockService.setLogo(stocks);
    model.addAttribute("stocks", stocks);
    return "Home";
  }

  @GetMapping(value = "/stock/heatmap")
  public String heatmapPage(Model model) {
    List<StockHeatMapDTO> stocks = this.stockService.getAll().stream().map(c -> this.dtoMapper.map(c)).toList();
    this.stockService.setMarketCap(stocks);
    model.addAttribute("stocks", stocks);
    return "Heatmap";
  }

  @GetMapping(value = "/stock/candlestick/day/{symbol}")
  public String candlestickDayPage(@PathVariable String symbol, Model model) {
    List<StockCandelDTO> candles = this.dtoMapper.map(this.stockHisService.fetchDayData(symbol));
    model.addAttribute("symbol", symbol);
    model.addAttribute("candles", candles);
    return "CandlestickDay";
  }

  @GetMapping(value = "/stock/candlestick/week/{symbol}")
  public String candlestickWeekPage(@PathVariable String symbol, Model model) {
    List<StockCandelDTO> candles = this.dtoMapper.map(this.stockHisService.fetchWeekData(symbol));
    model.addAttribute("symbol", symbol);
    model.addAttribute("candles", candles);
    return "CandlestickWeek";
  }

  @GetMapping(value = "/stock/candlestick/month/{symbol}")
  public String candlestickMonthPage(@PathVariable String symbol, Model model) {
    List<StockCandelDTO> candles = this.dtoMapper.map(this.stockHisService.fetchMonthData(symbol));
    model.addAttribute("symbol", symbol);
    model.addAttribute("candles", candles);
    return "CandlestickMonth";
  }

}
