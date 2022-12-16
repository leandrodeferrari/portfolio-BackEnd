package com.portfolio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDto implements Serializable {

    private String firstName;
    private String lastName;
    private String profilePhotoUrl;
    private String title;
    private String aboutMe;
    private String email;
    private String bannerUrl;
    private String linkedInUrl;
    private String gitHubUrl;
    private String cvUrl;
    private AddressDto addressDto;

}
