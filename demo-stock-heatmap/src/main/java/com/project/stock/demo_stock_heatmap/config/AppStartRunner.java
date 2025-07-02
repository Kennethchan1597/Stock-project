// package com.project.stock.demo_stock_heatmap.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
// import com.project.stock.demo_stock_heatmap.entity.EntityMapper;
// import com.project.stock.demo_stock_heatmap.entity.NDX100Entity;
// import com.project.stock.demo_stock_heatmap.model.StockMKTCap;
// import com.project.stock.demo_stock_heatmap.service.StockService;

// @Component
// public class AppStartRunner implements CommandLineRunner{
//   @Autowired
//   private StockService stockService;
//   @Autowired
//   private EntityMapper entityMapper;
  
//   @Override
//   public void run(String... args) throws Exception {
    
 
//       StockMKTCap stock = this.stockService.fetchStockMC("AAPL");
//       System.out.println("thisstock" + stock.getSymbol() + stock.getMarketcapitalization());
//       NDX100Entity result = this.entityMapper.map(stock);
//       System.out.println("thisresult" + result.getSymbol() + stock.getMarketcapitalization());
//       this.stockService.save(result);


//   }


    //   List<String> symbols = List.of(
    //   "AAPL", "MSFT", "GOOGL", "GOOG", "AMZN", "NVDA",
    //   "PEP", "COST", "NFLX", "INTC", "CSCO", "AMGN", "TMUS", "TXN", "QCOM", "HON",
    //   "INTU", "SBUX", "AMD", "AMAT", "ISRG", "BKNG", "ADP", "VRTX", "REGN", "MU",
    //   "ADI", "GILD", "MDLZ", "LRCX", "ATVI", "PDD", "KDP", "PANW", "MAR", "CTSH",
    //   "FISV", "EXC", "ADSK", "MNST", "ROST", "MCHP", "ASML", "CDNS", "NXPI", "IDXX",
    //   "BIIB", "FTNT", "WBD", "CHTR", "EA", "CRWD", "CSGP", "AZN", "ODFL", "DLTR",
    //   "PAYX", "ORLY", "MRVL", "LCID", "ZS", "TEAM", "CPRT", "SNPS", "TTD", "WBA",
    //   "SIRI", "FAST", "CTAS", "ILMN", "DOCU", "BIDU", "VRSK", "KLAC", "ALGN", "XEL",
    //   "LULU", "SBAC", "ANSS", "PCAR", "VRSN", "OKTA", "JD", "ZM", "EXPE", "NTES",
    //   "AEP", "GEN", "EBAY", "BMRN", "RIVN", "DDOG", "SGEN", "SWKS", "ENPH"
    // );

// }
