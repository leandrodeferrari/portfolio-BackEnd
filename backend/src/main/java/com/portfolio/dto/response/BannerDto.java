package com.portfolio.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BannerDto implements Serializable {

    private Integer id;
    private String bannerUrl;

}
