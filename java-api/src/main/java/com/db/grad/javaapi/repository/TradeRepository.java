package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
//    Map<Object, Object> findBySettlementDate();

@Query(nativeQuery = true, value = "select * from trade t where t.tradeSettlementDate = :tradeSettlementDate")
List<Trade> findBySettlementDate(@Param("tradeSettlementDate") String tradeSettlementDate);
//
//    @Query(nativeQuery = true, value = "select * from users u where u.name like %:name%")
//    List<User> findByName(@Param("name")String name);
}
