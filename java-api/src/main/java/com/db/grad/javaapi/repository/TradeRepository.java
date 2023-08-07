package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
//    Map<Object, Object> findBySettlementDate();
@Query(nativeQuery = true, value = "select * from trade t where t.trade_settlement_date like %:tradeSettlementDate% escape '/'")
List<Trade> findBySettlementDate( @Param("tradeSettlementDate") String tradeSettlementDate);
    //
//@Query(nativeQuery = true, value = "select * from dogs where name = :name")
//List<Trade> findByName(Dog name);
}
