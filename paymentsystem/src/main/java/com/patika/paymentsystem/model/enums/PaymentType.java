package com.patika.paymentsystem.model.enums;

public enum PaymentType {
    CREDICARD("Credicard"), BANKCARD("Bankcard"),PAYPAL("Paypal");

    private final String text;

    PaymentType(String text) {
        this.text = text;
    }
}
