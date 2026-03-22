package com.omincharge.operator.repository;

import com.omincharge.operator.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OperatorRepository extends JpaRepository<Operator, Long> {
    boolean existsByCode(String code);
    boolean existsByName(String name);
    Optional<Operator> findByCode(String code);
}