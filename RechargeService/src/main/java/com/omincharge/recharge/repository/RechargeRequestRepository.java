package com.omincharge.recharge.repository;

import com.omincharge.recharge.entity.RechargeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RechargeRequestRepository
        extends JpaRepository<RechargeRequest, Long> {
    List<RechargeRequest> findByUserId(Long userId);
    List<RechargeRequest> findByUserIdOrderByCreatedAtDesc(Long userId);
}