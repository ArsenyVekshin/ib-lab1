package com.arsenyvekshin.lab1infsecurity.service;

import com.arsenyvekshin.lab1infsecurity.dto.JwtAuthenticationResponse;
import com.arsenyvekshin.lab1infsecurity.dto.SignInRequest;
import com.arsenyvekshin.lab1infsecurity.dto.SignUpRequest;
import com.arsenyvekshin.lab1infsecurity.entity.Role;
import com.arsenyvekshin.lab1infsecurity.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    @Transactional(rollbackFor = Exception.class)
    public JwtAuthenticationResponse signUp(SignUpRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userService.create(user);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt, false);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        boolean isAdmin = userService.getByUsername(request.getUsername()).getRole() == Role.ADMIN;

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt, isAdmin);
    }

}