package com.patika.emlakburada.controller;

import com.patika.emlakburada.model.request.LoginRequest;
import com.patika.emlakburada.model.utilities.Utility;
import com.patika.emlakburada.security.JwtTokenProvider;
import com.patika.emlakburada.security.UserPrincipal;
import com.patika.emlakburada.service.concrete.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationRestController {

    final AuthenticationManager authenticationManager;
    final UserService userService;
    final JwtTokenProvider tokenProvider;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationRestController(
            AuthenticationManager authenticationManager,
            UserService userService, JwtTokenProvider tokenProvider,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(authentication);
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            return ResponseEntity.ok("");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

    @GetMapping(value = "/isvalid")
    public ResponseEntity<?> isValid() {
        String token = Utility.getJwtFromRequest(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest());
        if (token == null || token.isEmpty()) {
            return ResponseEntity.badRequest().body("");
        }

        boolean isValid = tokenProvider.validateToken(token);
        if (isValid) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
    }
}
