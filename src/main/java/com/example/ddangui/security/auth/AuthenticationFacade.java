package com.example.ddangui.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getId() {
        return getAuthentication().getName();
    }

    public boolean isLogin() {
        return getAuthentication() != null;
    }
}
