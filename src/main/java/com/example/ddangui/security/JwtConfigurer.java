package com.example.ddangui.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;

    public void configurer(HttpSecurity security) {
        TokenFilter tokenFilter = new TokenFilter(jwtTokenProvider);
        security.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
