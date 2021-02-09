package com.example.ddangui.security.auth;

import com.example.ddangui.entity.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public AuthDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findById(username)
                .map(AuthDetails::new)
                .orElseThrow();
    }
}
