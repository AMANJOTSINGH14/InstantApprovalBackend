package com.authentication.AuthenticationService.service;

import com.authentication.AuthenticationService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String,String> generateToken(User user);
}
