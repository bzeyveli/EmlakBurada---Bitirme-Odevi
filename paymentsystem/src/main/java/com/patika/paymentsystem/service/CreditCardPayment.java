package com.patika.paymentsystem.service;

import com.patika.paymentsystem.model.entity.PaymentInput;
import com.patika.paymentsystem.model.enums.Status;
import com.patika.paymentsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreditCardPayment {


    PaymentRepository paymentRepository;

    @Autowired
    public CreditCardPayment(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Boolean pay(PaymentInput paymentInput) {
        paymentInput.setStatus(Status.PAID);
        paymentInput.setPaymentType(paymentInput.getPaymentType());
        paymentInput.setPaymentDate(new Date());
        paymentRepository.saveAndFlush(paymentInput);
        return true;
    }
}
