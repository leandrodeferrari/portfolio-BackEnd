package com.portfolio.util;

import org.springframework.security.core.context.SecurityContextHolder;

public final class PersonUtil {

    private PersonUtil(){
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String getEmail(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
