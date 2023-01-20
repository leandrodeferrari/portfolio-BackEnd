package com.portfolio.dto.request;

import lombok.Data;

@Data
public class EmailDto {

    private String subject;
    private String name;
    private String email;
    private String message;

}
