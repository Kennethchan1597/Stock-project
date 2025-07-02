package com.project.stock.demo_stock_heatmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.stock.demo_stock_heatmap.entity.NDX100QuoteEntity;

@Repository
public interface StockRepository extends JpaRepository<NDX100QuoteEntity, Long> {

}
