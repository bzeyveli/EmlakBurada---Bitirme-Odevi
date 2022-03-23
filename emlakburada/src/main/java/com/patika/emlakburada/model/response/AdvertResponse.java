package com.patika.emlakburada.model.response;

import com.patika.emlakburada.model.entity.Address;
import com.patika.emlakburada.model.entity.User;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class AdvertResponse {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private Address address;

    private User user;

    private boolean status;  // aktive - passive

    private boolean inReiew;  //incelendi mi

}
