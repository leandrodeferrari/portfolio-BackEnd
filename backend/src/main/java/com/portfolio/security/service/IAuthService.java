package com.portfolio.security.service;

import com.portfolio.security.dto.LoginInDto;
import com.portfolio.security.dto.LoginOutDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAuthService {

    LoginOutDto login(LoginInDto loginInDto);
    void logout(HttpServletRequest request, HttpServletResponse response);

}
