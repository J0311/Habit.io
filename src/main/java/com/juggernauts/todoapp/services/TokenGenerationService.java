package com.juggernauts.todoapp.services;

import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.juggernauts.todoapp.models.User;

@Service
public class TokenGenerationService {
    private static final Logger logger = LogManager.getLogger(TokenGenerationService.class);

    public String generateUserToken(User user) {
        logger.info("generating user token for user {}", user.getEmail());
        String input = String.format("%s:%s", user.getEmail(), user.getPassword());
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}