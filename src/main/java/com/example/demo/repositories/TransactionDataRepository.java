package com.example.demo.repositories;

import com.example.demo.entities.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDataRepository extends JpaRepository<TransactionData, Long> {
}