package com.patika.emlakburada.model.request;

import com.patika.emlakburada.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressRequest {

    private User user;
    private String county;
    private String district;
    private String description;
}
