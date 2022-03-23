package com.patika.paymentsystem.controller;

import com.patika.paymentsystem.model.entity.PaymentInput;
import com.patika.paymentsystem.model.enums.PaymentType;
import com.patika.paymentsystem.repository.PaymentRepository;
import com.patika.paymentsystem.service.BankCardPayment;
import com.patika.paymentsystem.service.CreditCardPayment;
import com.patika.paymentsystem.service.PayableInterface;
import com.patika.paymentsystem.service.PaypalPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;


    @PostMapping
    public Boolean pay(@RequestBody PaymentInput paymentInput) {

        Boolean result = false;

        if (paymentInput.getPaymentType().equals(PaymentType.CREDICARD)) {
            CreditCardPayment creditCardPayment = new CreditCardPayment(paymentRepository);
            result = creditCardPayment.pay(paymentInput);
        }
        if (paymentInput.getPaymentType().equals(PaymentType.BANKCARD)) {
            BankCardPayment bankCardPayment = new BankCardPayment(paymentRepository);
            result = bankCardPayment.pay(paymentInput);
        }
        if (paymentInput.getPaymentType().equals(PaymentType.PAYPAL)) {
            PaypalPayment paypalPayment = new PaypalPayment(paymentRepository);
            result = paypalPayment.pay(paymentInput);

        }
        return result;
    }
}
