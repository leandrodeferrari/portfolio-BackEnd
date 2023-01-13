package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {

    private String email;
    private String linkedInUrl;
    private String gitHubUrl;
    private String cvUrl;
    private AddressDto addressDto;

}
