package com.patika.emlakburada.model.request;

import com.patika.emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

    private UserType userType; // bireysel & kurumsal & yeniTip
    private String name;
    private String email;
    private String password;
    private Boolean isDeleted;


}
