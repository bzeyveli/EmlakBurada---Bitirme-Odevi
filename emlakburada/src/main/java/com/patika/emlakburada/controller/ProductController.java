package com.patika.emlakburada.controller;

import com.patika.emlakburada.model.contact.PaymentInput;
import com.patika.emlakburada.model.request.ProductsRequest;
import com.patika.emlakburada.model.response.ProductsResponse;

import com.patika.emlakburada.service.abstracts.PaymentService;
import com.patika.emlakburada.service.concrete.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    PaymentService paymentService;

    @PostMapping("/{result}")
    @PreAuthorize("hasAnyRole('CORPORATE','INDIVIDUAL')")
    public ResponseEntity<ProductsResponse> create(@PathVariable Boolean result, @RequestBody ProductsRequest productsRequest) {

        ProductsResponse productsResponse = productService.saveProduct(result, productsRequest);
        return ResponseEntity.ok(productsResponse);
    }

    @PostMapping("/payment")
    @PreAuthorize("hasAnyRole('CORPORATE','INDIVIDUAL')")
    public Boolean payment(@RequestBody PaymentInput paymentInput){
         return   paymentService.pay(paymentInput);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CORPORATE','INDIVIDUAL')")
    public List<ProductsResponse> findAll(@PathVariable Long id){
        return productService.productAll(id);
    }
}
