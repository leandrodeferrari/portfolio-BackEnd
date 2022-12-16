package com.portfolio.service.impl;

import com.portfolio.dto.PersonDto;
import com.portfolio.mapper.IAddressMapper;
import com.portfolio.mapper.IPersonMapper;
import com.portfolio.model.entity.Person;
import com.portfolio.repository.IPersonRepository;
import com.portfolio.service.IPersonService;
import com.portfolio.util.PersonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    private final IAddressMapper addressMapper;
    private final IPersonRepository personRepository;
    private final IPersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(IAddressMapper addressMapper,
                             IPersonMapper personMapper,
                             IPersonRepository personRepository){
        this.addressMapper = addressMapper;
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public PersonDto getPerson() {

        String loggedUserEmail = PersonUtil.getEmail();
        Person person = personRepository.findByEmail(loggedUserEmail).orElseThrow();

        PersonDto personDto = personMapper.personToPersonDto(person);
        personDto.setAddressDto(addressMapper.addressToAddressDto(person.getAddress()));

        return personDto;

    }

}
