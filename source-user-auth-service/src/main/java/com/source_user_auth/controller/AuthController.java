package com.source_user_auth.controller;

import com.api.framework.security.BearerContextHolder;
import com.source_user_auth.domain.auth.RegisterRequest;
import com.source_user_auth.domain.auth.RegisterResponse;
import com.source_user_auth.service.AuthService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(description = "Module Authenticate")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Register] {}", masterAccount, request);
        return ResponseEntity.ok(authService.register(request));
    }

}
