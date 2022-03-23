package com.patika.emlakburada.model.request;

import com.patika.emlakburada.model.entity.Address;
import com.patika.emlakburada.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertRequest {

    private String title;

    private String description;

    private BigDecimal price;

    private Address address;

    private User user;

    private boolean status;  // aktive - passive

    private boolean inReiew;  //incelendi mi
}
