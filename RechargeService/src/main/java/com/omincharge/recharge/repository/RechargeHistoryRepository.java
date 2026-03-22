package com.omincharge.recharge.repository;

import com.omincharge.recharge.entity.RechargeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RechargeHistoryRepository
        extends JpaRepository<RechargeHistory, Long> {
    List<RechargeHistory> findByRechargeIdOrderByTimestampDesc(Long rechargeId);
}