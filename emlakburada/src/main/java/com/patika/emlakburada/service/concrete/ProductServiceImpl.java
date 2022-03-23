package com.patika.emlakburada.service.concrete;


import com.patika.emlakburada.model.contact.PaymentInput;
import com.patika.emlakburada.model.entity.Products;
import com.patika.emlakburada.model.request.ProductsRequest;
import com.patika.emlakburada.model.response.ProductsResponse;
import com.patika.emlakburada.model.utilities.ProductsDateFormatter;
import com.patika.emlakburada.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ErrorLogService errorLogService;

    // ödemesi gerçekleşmiş paketi db ye ekliyor
    public ProductsResponse saveProduct(Boolean resultPay, ProductsRequest productsRequest) {

        Products products = modelMapper.map(productsRequest, Products.class);
        if (resultPay) {  // odeme gerçekleştiği için true geliyor
            Date now = new Date();
            products.setUserId(productsRequest.getUserId());
            products.setAdvertCount(10);
            products.setStartDate(now);
            products.setEndDate(ProductsDateFormatter.AfterAmountDateFormat(now));
            products = productRepository.saveAndFlush(products);
        } else {
            errorLogService.add("", "Ödeme islemi başarısız", "Error");
        }
        return modelMapper.map(products, ProductsResponse.class);
    }

    public List<ProductsResponse> productAll(Long id){
        List<Products> productsList = productRepository.productAllById(id);
        List<ProductsResponse> productsResponses = new ArrayList<>();
        for (Products product : productsList) {
           productsResponses.add(modelMapper.map(product,ProductsResponse.class));
        }
        return productsResponses;
    }
}
