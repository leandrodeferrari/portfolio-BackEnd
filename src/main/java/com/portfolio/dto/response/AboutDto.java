package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class AboutDto implements Serializable {

    private Integer id;
    private String fullName;
    private String title;
    private String aboutMe;
    private String profilePhotoUrl;

}
