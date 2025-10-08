package com.arsenyvekshin.lab1infsecurity.controller;


import com.arsenyvekshin.lab1infsecurity.dto.JwtAuthenticationResponse;
import com.arsenyvekshin.lab1infsecurity.dto.SignInRequest;
import com.arsenyvekshin.lab1infsecurity.dto.SignUpRequest;
import com.arsenyvekshin.lab1infsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signUp(request);
    }
}
