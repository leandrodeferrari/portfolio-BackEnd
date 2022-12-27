package com.portfolio.security.service.impl;

import com.portfolio.security.dto.LoginInDto;
import com.portfolio.security.dto.LoginOutDto;
import com.portfolio.security.jwt.JwtTokenProvider;
import com.portfolio.security.model.UserDetailsImpl;
import com.portfolio.security.service.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authManager,
                           JwtTokenProvider jwtTokenProvider,
                           UserDetailsServiceImpl userDetailsServiceImpl){
        this.authManager = authManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    public LoginOutDto login(LoginInDto loginInDto) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginInDto.getUserNameOrEmail(),
                        loginInDto.getPassword()));

        UserDetailsImpl userDetailsImpl = userDetailsServiceImpl.
                loadUserByUsername(loginInDto.getUserNameOrEmail());

        String token = jwtTokenProvider.generateToken(userDetailsImpl);

        return new LoginOutDto(userDetailsImpl.getUsername(), token);

    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

    }

}
