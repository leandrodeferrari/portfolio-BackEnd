package com.portfolio.security.jwt;

import com.portfolio.security.model.UserDetailsImpl;
import com.portfolio.security.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public JwtAuthorizationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsServiceImpl userDetailsServiceImpl){
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String bearerToken = request.getHeader("Authorization");

        String userNameOrEmail = null;
        String jwtToken = null;

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {

            jwtToken = bearerToken.substring(7);

            userNameOrEmail = jwtTokenProvider.getUsernameFromToken(jwtToken);

        }

        if (userNameOrEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetailsImpl userDetailsImpl = this.userDetailsServiceImpl.loadUserByUsername(userNameOrEmail);

            if (jwtTokenProvider.validateToken(jwtToken, userDetailsImpl)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetailsImpl, null, userDetailsImpl.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }

        }

        chain.doFilter(request, response);

    }

}
