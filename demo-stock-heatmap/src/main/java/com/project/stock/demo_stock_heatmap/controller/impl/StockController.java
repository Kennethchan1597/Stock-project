package com.project.stock.demo_stock_heatmap.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.stock.demo_stock_heatmap.controller.StcokOperation;
import com.project.stock.demo_stock_heatmap.dto.mapper.DtoMapper;
import com.project.stock.demo_stock_heatmap.dto.response.StockHeatMapDTO;
import com.project.stock.demo_stock_heatmap.entity.EntityMapper;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;
import com.project.stock.demo_stock_heatmap.service.StockService;

@RestController
public class StockController implements StcokOperation{
@Autowired
private StockService stockService;
@Autowired
private EntityMapper entityMapper;
@Autowired
private DtoMapper dtoMapper;


  @Override
  public List<StockHeatMapDTO> getStocksQuote() {
     return this.stockService.fetchStocksData().values().stream().map(c -> this.dtoMapper.map(c)).toList();
  }

  @Override
  public List<NDX100QuoteEntity> saveStockQuote() {
    List<NDX100QuoteEntity> result = this.stockService.fetchStocksData().values().stream().map(c -> this.entityMapper.map(c)).toList();
    this.stockService.saveAll(result);
    return result;
  }

  @Override
  public NDX100QuoteEntity saveStock(String symbol) {
    StockQuoteDTO s1 = this.stockService.fetchStockData(symbol);
    return this.stockService.save(this.entityMapper.map(s1));
  }

  @Override
  public List<String> missedSymbols() {
    List<String> result = new ArrayList<>();
    List<String> symbolList = this.stockService.getAll().stream().map(c -> c.getSymbol()).toList();
    System.out.println("the size of symbol list is" + symbolList.size());
          List<String> symbols = List.of(
      "AAPL", "MSFT", "GOOGL", "GOOG", "AMZN", "NVDA",
      "PEP", "COST", "NFLX", "INTC", "CSCO", "AMGN", "TMUS", "TXN", "QCOM", "HON",
      "INTU", "SBUX", "AMD", "AMAT", "ISRG", "BKNG", "ADP", "VRTX", "REGN", "MU",
      "ADI", "GILD", "MDLZ", "LRCX", "ATVI", "PDD", "KDP", "PANW", "MAR", "CTSH",
      "FISV", "EXC", "ADSK", "MNST", "ROST", "MCHP", "ASML", "CDNS", "NXPI", "IDXX",
      "BIIB", "FTNT", "WBD", "CHTR", "EA", "CRWD", "CSGP", "AZN", "ODFL", "DLTR",
      "PAYX", "ORLY", "MRVL", "LCID", "ZS", "TEAM", "CPRT", "SNPS", "TTD", "WBA",
      "SIRI", "FAST", "CTAS", "ILMN", "DOCU", "BIDU", "VRSK", "KLAC", "ALGN", "XEL",
      "LULU", "SBAC", "ANSS", "PCAR", "VRSN", "OKTA", "JD", "ZM", "EXPE", "NTES",
      "AEP", "GEN", "EBAY", "BMRN", "RIVN", "DDOG", "SGEN", "SWKS", "ENPH"
    );
    for (String symbol : symbols) {
      if(!symbolList.contains(symbol))
      result.add(symbol);
    }
    return result;
  }

  @Override
  public void saveSectors() {
    this.stockService.setSector();
  }

}
