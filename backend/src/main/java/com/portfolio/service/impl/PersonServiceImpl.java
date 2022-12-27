package com.portfolio.service.impl;

import com.portfolio.dto.response.PersonDto;
import com.portfolio.mapper.IPersonMapper;
import com.portfolio.model.entity.Person;
import com.portfolio.repository.IPersonRepository;
import com.portfolio.service.IPersonService;
import com.portfolio.util.PersonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    private final IPersonMapper personMapper;
    private final IPersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(IPersonMapper personMapper,
                             IPersonRepository personRepository){
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public PersonDto getPerson() {

        Person person = personRepository.findByEmail(PersonUtil.EMAIL).orElseThrow();

        return personMapper.personToPersonDto(person);

    }

    @Override
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email).orElseThrow();
    }

}
