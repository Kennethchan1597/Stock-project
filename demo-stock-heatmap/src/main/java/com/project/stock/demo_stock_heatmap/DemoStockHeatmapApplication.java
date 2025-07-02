package com.project.stock.demo_stock_heatmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoStockHeatmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStockHeatmapApplication.class, args);
	}

}
