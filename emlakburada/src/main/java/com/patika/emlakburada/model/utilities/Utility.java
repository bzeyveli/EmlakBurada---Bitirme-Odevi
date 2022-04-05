package com.patika.emlakburada.model.utilities;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;


public class Utility {

    public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
