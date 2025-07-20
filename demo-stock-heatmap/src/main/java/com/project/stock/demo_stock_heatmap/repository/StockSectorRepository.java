package com.project.stock.demo_stock_heatmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.stock.demo_stock_heatmap.entity.SectorEntity;

@Repository
public interface StockSectorRepository extends JpaRepository<SectorEntity, Long>{
  
}
