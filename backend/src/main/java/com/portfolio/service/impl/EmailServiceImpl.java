package com.portfolio.service.impl;

import com.portfolio.dto.request.EmailDto;
import com.portfolio.exception.EmailException;
import com.portfolio.service.IEmailService;
import com.portfolio.util.PersonUtil;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class EmailServiceImpl implements IEmailService {

    private final SendGrid sendGrid;
    private final MessageSource messageSource;

    @Autowired
    public EmailServiceImpl(SendGrid sendGrid, MessageSource messageSource) {
        this.sendGrid = sendGrid;
        this.messageSource = messageSource;
    }

    @Override
    public Map<String, String> sendEMail(EmailDto emailDto) throws EmailException {

        Email from = new Email(PersonUtil.EMAIL);
        Email to = new Email(PersonUtil.EMAIL);
        String subject = emailDto.getSubject()
                .concat(" - ")
                .concat(emailDto.getName())
                .concat(" - ")
                .concat(emailDto.getEmail());

        Content content = new Content("text/plain", emailDto.getMessage());
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();

        try {

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = this.sendGrid.api(request);

            Map<String, String> statusCode = new HashMap<>();
            statusCode.put("code", String.valueOf(response.getStatusCode()));

            return statusCode;

        } catch (IOException ex) {

            throw new EmailException(messageSource.getMessage("send.grid.error", null, Locale.getDefault()));

        }

    }

}
