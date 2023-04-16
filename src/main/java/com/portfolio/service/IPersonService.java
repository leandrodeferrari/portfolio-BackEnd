package com.portfolio.service;

import com.portfolio.dto.request.AboutInDto;
import com.portfolio.dto.response.AboutDto;
import com.portfolio.dto.response.BannerDto;
import com.portfolio.dto.response.ContactDto;
import com.portfolio.dto.response.PersonDto;
import com.portfolio.model.entity.Person;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPersonService {

    PersonDto getPerson();
    Person findByEmail(String email);
    BannerDto getBanner();
    ContactDto getContact();
    AboutDto getAbout();
    BannerDto updateBanner(MultipartFile file) throws IOException;
    void deleteBanner();
    AboutDto updateAbout(AboutInDto dto);
    void deleteAbout();

}
