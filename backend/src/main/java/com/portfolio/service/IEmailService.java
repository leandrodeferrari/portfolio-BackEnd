package com.portfolio.service;

import com.portfolio.dto.request.EmailDto;
import com.portfolio.exception.EmailException;

import java.util.Map;

public interface IEmailService {

    Map<String, String> sendEMail(EmailDto emailDto) throws EmailException;

}
