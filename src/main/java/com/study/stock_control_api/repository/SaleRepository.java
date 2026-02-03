package com.study.stock_control_api.repository;

import com.study.stock_control_api.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
