package com.portfolio.util;

import com.portfolio.exception.BadRequestException;

public final class ValidationUtil {

    public ValidationUtil(){
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void validateId(Integer id){

        if(id == null){
            throw new BadRequestException("The ID cannot be null");
        }

        if(id < 1){
            throw new BadRequestException("The ID cannot be less than 1");
        }

    }

}
