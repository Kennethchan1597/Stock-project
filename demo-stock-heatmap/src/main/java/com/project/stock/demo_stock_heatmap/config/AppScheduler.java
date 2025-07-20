package com.project.stock.demo_stock_heatmap.config;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.project.stock.demo_stock_heatmap.entity.EntityMapper;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;
import com.project.stock.demo_stock_heatmap.model.StockQuoteDTO;
import com.project.stock.demo_stock_heatmap.service.StockService;

@Component
public class AppScheduler {
  @Autowired
  private StockService stockService;
  @Autowired
  private EntityMapper entityMapper;

  @Scheduled(fixedRate = 15000) // 21:30 each weekday
  public String saveDataDuringMarket() {
    ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));

    DayOfWeek day = now.getDayOfWeek();
    LocalTime time = now.toLocalTime();

    boolean isWeekday = (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY);

      boolean isInMarketWindow = (!time.isBefore(LocalTime.of(9, 30))
          && time.isBefore(LocalTime.of(16, 1)));

    if (isWeekday && isInMarketWindow) {
      System.out.println("Saving stock data at " + now);
      StockQuoteDTO stock = this.stockService.fetchStockData("AAPL");
      NDX100QuoteEntity entity = this.entityMapper.map(stock);
      NDX100QuoteEntity aapl = this.stockService.findBySymbol("AAPL");
      aapl.setDatetime(entity.getDatetime());
      aapl.setPriceOpen(entity.getPriceOpen());
      aapl.setPriceClose(entity.getPriceClose());
      aapl.setHigh(entity.getHigh());
      aapl.setLow(entity.getLow());
      aapl.setAvgVolume(entity.getAvgVolume());
      aapl.setVolume(entity.getVolume());
      aapl.setPriceChange(entity.getPriceChange());
      aapl.setPercentChange(entity.getPercentChange());
      this.stockService.save(aapl);
    }
    return "not now";
  }

  // @Scheduled(fixedDelay = 15000)
  // public void initMarketCap() {
  // int current = index.getAndIncrement();
  // if(current >= symbols.size()){
  // index.set(0);
  // return;
  // }
  // StockMKTCap stock = this.stockService.fetchStockMC(symbols.get(current));
  // this.stockService.save(this.entityMapper.map(stock));
  // }

  // List<String> symbols = List.of(
  // "AAPL", "MSFT", "GOOGL", "GOOG", "AMZN", "NVDA",
  // "PEP", "COST", "NFLX", "INTC", "CSCO", "AMGN", "TMUS", "TXN", "QCOM", "HON",
  // "INTU", "SBUX", "AMD", "AMAT", "ISRG", "BKNG", "ADP", "VRTX", "REGN", "MU",
  // "ADI", "GILD", "MDLZ", "LRCX", "ATVI", "PDD", "KDP", "PANW", "MAR", "CTSH",
  // "FISV", "EXC", "ADSK", "MNST", "ROST", "MCHP", "ASML", "CDNS", "NXPI", "IDXX",
  // "BIIB", "FTNT", "WBD", "CHTR", "EA", "CRWD", "CSGP", "AZN", "ODFL", "DLTR",
  // "PAYX", "ORLY", "MRVL", "LCID", "ZS", "TEAM", "CPRT", "SNPS", "TTD", "WBA",
  // "SIRI", "FAST", "CTAS", "ILMN", "DOCU", "BIDU", "VRSK", "KLAC", "ALGN", "XEL",
  // "LULU", "SBAC", "ANSS", "PCAR", "VRSN", "OKTA", "JD", "ZM", "EXPE", "NTES",
  // "AEP", "GEN", "EBAY", "BMRN", "RIVN", "DDOG", "SGEN", "SWKS", "ENPH"
  // );

}
