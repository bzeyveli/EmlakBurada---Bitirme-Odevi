package com.patika.emlakburada.model.response;

import com.patika.emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {

    private Long id;
    private UserType userType; // bireysel & kurumsal & yeniTip
    private String name;
    private String email;
    private String password;
    private Boolean isDeleted;

}
