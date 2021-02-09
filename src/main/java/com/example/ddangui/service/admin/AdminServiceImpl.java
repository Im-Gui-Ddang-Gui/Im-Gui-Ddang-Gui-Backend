package com.example.ddangui.service.admin;

import com.example.ddangui.entity.admin.Admin;
import com.example.ddangui.entity.admin.AdminRepository;
import com.example.ddangui.entity.refreshtoken.RefreshToken;
import com.example.ddangui.entity.refreshtoken.RefreshTokenRepository;
import com.example.ddangui.exception.InvalidTokenException;
import com.example.ddangui.exception.UserNotFoundException;
import com.example.ddangui.payload.request.SignInRequest;
import com.example.ddangui.payload.response.AccessTokenResponse;
import com.example.ddangui.payload.response.TokenResponse;
import com.example.ddangui.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${auth.jwt.exp.refresh}")
    private Long refreshExp;


    @Override
    public TokenResponse signIn(SignInRequest request) {
        Admin admin = adminRepository.findById(request.getId())
                .orElseThrow(UserNotFoundException::new);

        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getId());

        RefreshToken refresh = refreshTokenRepository.save(
                RefreshToken.builder()
                        .id(request.getId())
                        .refreshExp(refreshExp)
                        .refreshToken(refreshToken)
                        .build());

        String accessToken = jwtTokenProvider.generateAccessToken(request.getId());
        return new TokenResponse(accessToken, refresh.getRefreshToken(), refresh.getRefreshExp());
    }

    @Override
    public AccessTokenResponse tokenRefresh(String receivedToken) {
        if(!jwtTokenProvider.isRefreshToken(receivedToken)) {
            throw new InvalidTokenException();
        }

        RefreshToken refreshToken = refreshTokenRepository.findByRefreshToken(receivedToken)
                .orElseThrow(InvalidTokenException::new);

        return new AccessTokenResponse(jwtTokenProvider.generateAccessToken(refreshToken.getId()));
    }


}
