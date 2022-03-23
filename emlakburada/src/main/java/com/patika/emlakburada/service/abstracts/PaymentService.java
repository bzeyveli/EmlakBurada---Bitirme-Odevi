package com.patika.emlakburada.service.abstracts;

import com.patika.emlakburada.model.contact.PaymentInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentsystem",url = "http://localhost:8081/pay")
public interface PaymentService {

    @PostMapping
    Boolean pay(@RequestBody PaymentInput paymentInput);
}
