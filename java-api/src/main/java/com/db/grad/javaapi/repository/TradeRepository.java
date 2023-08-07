package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
//    Map<Object, Object> findBySettlementDate();

@Query(nativeQuery = true, value = "select * from trade where tradeSettlementDate = :tradeSettlementDate")
List<Trade> findBySettlementDate(String tradeSettlementDate);
}
