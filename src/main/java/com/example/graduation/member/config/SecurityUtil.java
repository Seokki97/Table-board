package com.example.graduation.member.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static String getLoginUserName(){
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        return user.getName();
    }

}
