package com.patika.emlakburada.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.emlakburada.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequest {

    @JoinColumn(name = "user_id")
    private Long userId;

    @JsonIgnore
    private int advertCount;

    private int usedCount;

}
