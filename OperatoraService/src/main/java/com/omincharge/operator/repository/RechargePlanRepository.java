package com.omincharge.operator.repository;

import com.omincharge.operator.entity.RechargePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long> {
    List<RechargePlan> findByOperatorId(Long operatorId);
    List<RechargePlan> findByOperatorIdAndStatus(
        Long operatorId, RechargePlan.Status status);
}