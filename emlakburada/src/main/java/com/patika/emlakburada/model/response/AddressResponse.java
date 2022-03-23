package com.patika.emlakburada.model.response;

import com.patika.emlakburada.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressResponse {
    private Long id;
    private User user;
    private String county;
    private String district;
    private String description;
}
