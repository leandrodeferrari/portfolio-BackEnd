package com.portfolio.service;

import com.portfolio.dto.response.AboutDto;
import com.portfolio.dto.response.BannerDto;
import com.portfolio.dto.response.ContactDto;
import com.portfolio.dto.response.PersonDto;
import com.portfolio.model.entity.Person;

public interface IPersonService {

    PersonDto getPerson();
    Person findByEmail(String email);
    BannerDto getBanner();
    ContactDto getContact();
    AboutDto getAbout();

}
