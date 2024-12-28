package com.alura.foro.hub.controller;

import com.alura.foro.hub.domain.user.DataUserAuthentication;
import com.alura.foro.hub.domain.user.User;
import com.alura.foro.hub.infra.security.JWTtokenDTO;
import com.alura.foro.hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid DataUserAuthentication dataUserAuthentication) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataUserAuthentication.username(),
                dataUserAuthentication.password());

        User authenticatedUser = (User) authenticationManager.authenticate(authToken).getPrincipal();

        String JWTtoken = tokenService.generateToken(authenticatedUser);
        return ResponseEntity.ok(new JWTtokenDTO(JWTtoken));
    }
}
