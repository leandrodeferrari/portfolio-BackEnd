package com.portfolio.security.controller;

import com.portfolio.security.dto.LoginInDto;
import com.portfolio.security.dto.LoginOutDto;
import com.portfolio.security.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginOutDto> login(@Valid @RequestBody LoginInDto loginInDto){
        return ResponseEntity.ok().body(authService.login(loginInDto));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response){
        authService.logout(request, response);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
