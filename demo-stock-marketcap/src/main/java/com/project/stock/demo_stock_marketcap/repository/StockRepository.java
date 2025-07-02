package com.project.stock.demo_stock_marketcap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.stock.demo_stock_marketcap.entity.NDX100Entity;


@Repository
public interface StockRepository extends JpaRepository<NDX100Entity, Long> {

}
