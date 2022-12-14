package com.portfolio.security.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class LoginInDto implements Serializable {

    @NotBlank(message = "The username or email cannot be blank")
    @NotNull(message = "The username or email cannot be null")
    private String userNameOrEmail;

    @NotBlank(message = "The password cannot be blank")
    @NotNull(message = "The password cannot be null")
    @Size(min = 8, message = "The password cannot be less than 8 characters")
    private String password;

}