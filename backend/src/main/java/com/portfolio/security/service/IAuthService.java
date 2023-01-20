package com.portfolio.security.service;

import com.portfolio.security.dto.LoginInDto;
import com.portfolio.security.dto.LoginOutDto;

public interface IAuthService {

    LoginOutDto login(LoginInDto loginInDto);

}
