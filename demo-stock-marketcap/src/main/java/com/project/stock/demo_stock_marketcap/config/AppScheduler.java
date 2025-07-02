package com.project.stock.demo_stock_marketcap.config;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.project.stock.demo_stock_marketcap.entity.EntityMapper;
import com.project.stock.demo_stock_marketcap.model.StockMKTCap;
import com.project.stock.demo_stock_marketcap.service.StockService;

@Component
public class AppScheduler {
  @Autowired
  private StockService stockService;
  @Autowired
  private EntityMapper entityMapper;
  private AtomicInteger index = new AtomicInteger(0);

  List<String> symbols = Arrays.asList(
      "ADI", "GILD", "MDLZ", "LRCX", "ATVI", "PDD", "KDP", "PANW", "MAR", "CTSH",
      "FISV", "EXC", "ADSK", "MNST", "ROST", "MCHP", "ASML", "CDNS", "NXPI", "IDXX",
      "BIIB", "FTNT", "WBD", "CHTR", "EA", "CRWD", "CSGP", "AZN", "ODFL", "DLTR",
      "PAYX", "ORLY", "MRVL", "LCID", "ZS", "TEAM", "CPRT", "SNPS", "TTD", "WBA",
      "SIRI", "FAST", "CTAS", "ILMN", "DOCU", "BIDU", "VRSK", "KLAC", "ALGN", "XEL",
      "LULU", "SBAC", "ANSS", "PCAR", "VRSN", "OKTA", "JD", "ZM", "EXPE", "NTES",
      "AEP", "GEN", "EBAY", "BMRN", "RIVN", "DDOG", "SGEN", "SWKS", "ENPH"
    );

  @Scheduled(fixedDelay = 15000)
  public void initMarketCap() {
    int current = index.getAndIncrement();
    if(current >= symbols.size()){
      index.set(0);
      return;
    }
    StockMKTCap stock = this.stockService.fetchStockMC(symbols.get(current));
    this.stockService.save(this.entityMapper.map(stock));
  }




}
