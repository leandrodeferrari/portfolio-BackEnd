package com.portfolio.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class PersonUtil {

    public static String getEmail(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
