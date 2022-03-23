package com.patika.paymentsystem.service;

import com.patika.paymentsystem.model.entity.PaymentInput;

public interface PayableInterface {

    Boolean pay(PaymentInput paymentInput);
}
