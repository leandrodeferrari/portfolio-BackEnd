package com.portfolio.service;

import com.portfolio.dto.response.PersonDto;
import com.portfolio.model.entity.Person;

public interface IPersonService {

    PersonDto getPerson();

    Person findByEmail(String email);

}
