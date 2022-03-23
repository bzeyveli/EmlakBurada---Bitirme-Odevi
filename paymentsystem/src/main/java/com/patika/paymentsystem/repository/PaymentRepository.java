package com.patika.paymentsystem.repository;

import com.patika.paymentsystem.model.entity.PaymentInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentInput, Long> {
}
