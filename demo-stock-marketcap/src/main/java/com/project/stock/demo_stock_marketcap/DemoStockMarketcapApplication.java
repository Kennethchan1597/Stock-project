package com.project.stock.demo_stock_marketcap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoStockMarketcapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStockMarketcapApplication.class, args);
	}

}
