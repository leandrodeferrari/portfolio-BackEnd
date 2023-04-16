package com.portfolio.service.impl;

import com.portfolio.dto.request.AboutInDto;
import com.portfolio.dto.response.AboutDto;
import com.portfolio.dto.response.BannerDto;
import com.portfolio.dto.response.ContactDto;
import com.portfolio.dto.response.PersonDto;
import com.portfolio.mapper.IPersonMapper;
import com.portfolio.model.entity.Person;
import com.portfolio.repository.IPersonRepository;
import com.portfolio.service.ICloudinaryService;
import com.portfolio.service.IPersonService;
import com.portfolio.util.PersonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    private final ICloudinaryService cloudinaryService;
    private final IPersonMapper personMapper;
    private final IPersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(ICloudinaryService cloudinaryService,
                             IPersonMapper personMapper,
                             IPersonRepository personRepository){
        this.cloudinaryService = cloudinaryService;
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public PersonDto getPerson() {

        Person person = personRepository.findByEmail(PersonUtil.EMAIL).orElseThrow();

        return personMapper.personToPersonDto(person);

    }

    @Transactional(readOnly = true)
    @Override
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public BannerDto getBanner() {

        Person person = personRepository.findByEmail(PersonUtil.EMAIL).orElseThrow();

        BannerDto bannerDto = new BannerDto();
        bannerDto.setId(person.getId());
        bannerDto.setBannerUrl(person.getBannerUrl());

        return bannerDto;

    }

    @Transactional(readOnly = true)
    @Override
    public ContactDto getContact() {

        Person person = personRepository.findByEmail(PersonUtil.EMAIL).orElseThrow();

        return personMapper.personToContactDto(person);

    }

    @Transactional(readOnly = true)
    @Override
    public AboutDto getAbout() {

        Person person = personRepository.findByEmail(PersonUtil.EMAIL).orElseThrow();

        return personMapper.personToAboutDto(person);

    }

    @Transactional(readOnly = false)
    @Override
    public BannerDto updateBanner(MultipartFile file) throws IOException {

        Optional<Person> optional = this.personRepository.findByEmail(PersonUtil.EMAIL);

        String bannerUrl = this.cloudinaryService.uploadBanner(file);

        optional.ifPresent(person -> person.setBannerUrl(bannerUrl));

        BannerDto dto = new BannerDto();
        dto.setId(optional.get().getId());
        dto.setBannerUrl(bannerUrl);

        return dto;

    }

    @Transactional(readOnly = false)
    @Override
    public void deleteBanner() {
        Optional<Person> optional = this.personRepository.findByEmail(PersonUtil.EMAIL);
        optional.ifPresent(person -> person.setBannerUrl("https://res.cloudinary.com/dwirzebm8/image/upload/v1681607923/32016-negro_bmizis.jpg"));
    }

    @Transactional(readOnly = false)
    @Override
    public AboutDto updateAbout(AboutInDto dto) {

        Optional<Person> optional = this.personRepository.findByEmail(PersonUtil.EMAIL);

        optional.ifPresent(person -> {
            person.setAboutMe(dto.getAboutMe());
            person.setFirstName(dto.getFirstName());
            person.setLastName(dto.getLastName());
            person.setTitle(dto.getTitle());
        });

        AboutDto aboutDto = new AboutDto();
        aboutDto.setAboutMe(dto.getAboutMe());
        aboutDto.setFullName(dto.getFirstName().concat(" ".concat(dto.getLastName())));
        aboutDto.setTitle(dto.getTitle());
        aboutDto.setProfilePhotoUrl(optional.get().getProfilePhotoUrl());
        aboutDto.setId(optional.get().getId());

        return aboutDto;

    }

    @Transactional(readOnly = false)
    @Override
    public void deleteAbout() {

        Optional<Person> optional = this.personRepository.findByEmail(PersonUtil.EMAIL);

        optional.ifPresent(person -> {
            person.setAboutMe("");
            person.setTitle("");
            person.setLastName("");
            person.setFirstName("");
            person.setProfilePhotoUrl("https://res.cloudinary.com/dwirzebm8/image/upload/v1681607656/blank-profile-picture-g1dce0b35c_1280_n8xflw.png");
        });

    }

}
