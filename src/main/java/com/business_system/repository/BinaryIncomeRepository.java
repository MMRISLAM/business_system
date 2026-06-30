package com.business_system.repository;

import com.business_system.model.BinaryIncome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BinaryIncomeRepository extends JpaRepository<BinaryIncome, Long> {
    Optional<BinaryIncome> findByUserId(int userId);
}
