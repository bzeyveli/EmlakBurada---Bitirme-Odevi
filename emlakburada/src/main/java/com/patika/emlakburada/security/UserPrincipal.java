package com.patika.emlakburada.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.emlakburada.model.entity.User;
import com.patika.emlakburada.model.enums.RoleType;
import com.patika.emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserPrincipal implements UserDetails {

    private Long id;

    @JsonIgnore
    private String name;

    private String email;

    private String password;

    @JsonIgnore
    private UserType userType;

    @JsonIgnore
    private Boolean isDeleted;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("user"));

        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getUserType(),
                user.getIsDeleted(),
                authorities
        );
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getFirstRole() {
        SimpleGrantedAuthority authority = (SimpleGrantedAuthority) authorities.toArray()[0];
        for (Enum enumConstant : RoleType.class.getEnumConstants()){
            if (enumConstant.name().equals(authority.getAuthority())) {
                return enumConstant.ordinal();
            }
        }
        return null;
    }

}
