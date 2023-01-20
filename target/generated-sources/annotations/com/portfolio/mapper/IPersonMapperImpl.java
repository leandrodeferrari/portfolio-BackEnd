package com.portfolio.mapper;

import com.portfolio.dto.response.AboutDto;
import com.portfolio.dto.response.ContactDto;
import com.portfolio.dto.response.PersonDto;
import com.portfolio.model.entity.Person;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-20T17:33:24-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IPersonMapperImpl implements IPersonMapper {

    private final IAddressMapper iAddressMapper;

    @Autowired
    public IPersonMapperImpl(IAddressMapper iAddressMapper) {

        this.iAddressMapper = iAddressMapper;
    }

    @Override
    public PersonDto personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setAddressDto( iAddressMapper.addressToAddressDto( person.getAddress() ) );
        personDto.setFirstName( person.getFirstName() );
        personDto.setLastName( person.getLastName() );
        personDto.setProfilePhotoUrl( person.getProfilePhotoUrl() );
        personDto.setTitle( person.getTitle() );
        personDto.setAboutMe( person.getAboutMe() );
        personDto.setEmail( person.getEmail() );
        personDto.setBannerUrl( person.getBannerUrl() );
        personDto.setLinkedInUrl( person.getLinkedInUrl() );
        personDto.setGitHubUrl( person.getGitHubUrl() );
        personDto.setCvUrl( person.getCvUrl() );

        return personDto;
    }

    @Override
    public ContactDto personToContactDto(Person person) {
        if ( person == null ) {
            return null;
        }

        ContactDto contactDto = new ContactDto();

        contactDto.setAddressDto( iAddressMapper.addressToAddressDto( person.getAddress() ) );
        contactDto.setEmail( person.getEmail() );
        contactDto.setLinkedInUrl( person.getLinkedInUrl() );
        contactDto.setGitHubUrl( person.getGitHubUrl() );
        contactDto.setCvUrl( person.getCvUrl() );

        return contactDto;
    }

    @Override
    public AboutDto personToAboutDto(Person person) {
        if ( person == null ) {
            return null;
        }

        AboutDto aboutDto = new AboutDto();

        aboutDto.setId( person.getId() );
        aboutDto.setTitle( person.getTitle() );
        aboutDto.setAboutMe( person.getAboutMe() );
        aboutDto.setProfilePhotoUrl( person.getProfilePhotoUrl() );

        aboutDto.setFullName( person.getFirstName() + ' ' + person.getLastName() );

        return aboutDto;
    }
}
