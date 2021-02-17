package com.example.ddangui.controller;

import com.example.ddangui.payload.request.SignInRequest;
import com.example.ddangui.payload.response.AccessTokenResponse;
import com.example.ddangui.payload.response.TokenResponse;
import com.example.ddangui.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/auth")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public TokenResponse signIn(@RequestBody SignInRequest request) {
        return adminService.signIn(request);
    }

    @PutMapping
    public AccessTokenResponse tokenRefresh(String receivedToken) {
        return adminService.tokenRefresh(receivedToken);
    }
}
