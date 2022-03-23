package com.patika.emlakburada.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.emlakburada.model.enums.Status;
import com.patika.emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserType userType; // bireysel & kurumsal & yeniTip
    private String name;
    private String email;
    private String password;

    private Boolean isDeleted;

}
