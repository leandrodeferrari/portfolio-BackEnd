package com.portfolio.service.impl;

import com.portfolio.dto.request.CareerInDto;
import com.portfolio.dto.response.CareerDto;
import com.portfolio.exception.BadRequestException;
import com.portfolio.mapper.ICareerMapper;
import com.portfolio.model.entity.Career;
import com.portfolio.repository.ICareerRepository;
import com.portfolio.service.ICareerService;
import com.portfolio.service.ICareerTypeService;
import com.portfolio.service.IInstituteUniversityService;
import com.portfolio.service.IPersonService;
import com.portfolio.util.PersonUtil;
import com.portfolio.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class CareerServiceImpl implements ICareerService {

    private final ICareerMapper careerMapper;
    private final ICareerRepository careerRepository;
    private final ICareerTypeService careerTypeService;
    private final IInstituteUniversityService instituteUniversityService;
    private final IPersonService personService;
    private final MessageSource messageSource;

    @Autowired
    public CareerServiceImpl(ICareerMapper careerMapper,
                             ICareerRepository careerRepository,
                             ICareerTypeService careerTypeService,
                             IInstituteUniversityService instituteUniversityService,
                             IPersonService personService,
                             MessageSource messageSource){
        this.careerMapper = careerMapper;
        this.careerRepository = careerRepository;
        this.careerTypeService = careerTypeService;
        this.instituteUniversityService = instituteUniversityService;
        this.personService = personService;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CareerDto> getAll() {
        return careerRepository.findAll()
                .stream()
                .map(careerMapper::careerToCareerDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        ValidationUtil.validateId(id);
        careerRepository.findById(id).orElseThrow();

        careerRepository.deleteById(id);

    }

    @Transactional
    @Override
    public CareerDto create(CareerInDto careerInDto) {

        Career career = careerMapper.careerInDtoToCareer(careerInDto);

        career.setInstituteUniversity(instituteUniversityService
                .findById(careerInDto.getInstituteUniversityId()));

        career.setCareerType(careerTypeService.findById(careerInDto.getCareerTypeId()));

        career.setPerson(personService.findByEmail(PersonUtil.EMAIL));

        careerRepository.save(career);

        return careerMapper.careerToCareerDto(career);

    }

    @Transactional
    @Override
    public CareerDto update(CareerInDto careerInDto, Integer id) {

        ValidationUtil.validateId(id);

        if(careerRepository.existsById(id)){

            Career career = careerMapper.careerInDtoToCareer(careerInDto);
            career.setId(id);

            career.setInstituteUniversity(instituteUniversityService
                    .findById(careerInDto.getInstituteUniversityId()));

            career.setCareerType(careerTypeService.findById(careerInDto.getCareerTypeId()));

            career.setPerson(personService.findByEmail(PersonUtil.EMAIL));

            careerRepository.save(career);

            return careerMapper.careerToCareerDto(career);

        } else {

            throw new BadRequestException(messageSource.getMessage("validation.id.not.exists", null, Locale.getDefault()));

        }

    }

}
