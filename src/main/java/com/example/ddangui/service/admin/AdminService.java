package com.example.ddangui.service.admin;

import com.example.ddangui.payload.request.SignInRequest;
import com.example.ddangui.payload.response.AccessTokenResponse;
import com.example.ddangui.payload.response.TokenResponse;

public interface AdminService {
    TokenResponse signIn(SignInRequest request);

    AccessTokenResponse tokenRefresh(String receivedToken);

}
