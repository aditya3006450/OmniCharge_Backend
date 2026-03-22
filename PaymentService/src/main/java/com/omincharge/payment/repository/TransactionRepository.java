package com.omincharge.payment.repository;

import com.omincharge.payment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserIdOrderByCreatedAtDesc(Long userId);
    Optional<Transaction> findByTransactionRef(String transactionRef);
    List<Transaction> findByRechargeId(Long rechargeId);
}