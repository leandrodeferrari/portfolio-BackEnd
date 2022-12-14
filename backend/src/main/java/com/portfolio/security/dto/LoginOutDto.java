package com.portfolio.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class LoginOutDto implements Serializable {

    private String email;
    private String token;

}
