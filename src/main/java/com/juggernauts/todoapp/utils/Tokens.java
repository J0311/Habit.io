package com.juggernauts.todoapp.utils;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.juggernauts.todoapp.models.User;

public class Tokens {
    private static final Logger logger = LogManager.getLogger(Tokens.class);

    private Tokens() {}

    public static String generateToken(User user) {
        logger.info("generating user token for user {}", user.getEmail());
        String input = String.format("%s:%s", user.getEmail(), user.getPassword());
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public static String generateTokenURL(HttpServletRequest request, User user, String token) {
        return String.format("%s://%s:%d/verify/%d/%s", request.getScheme(), request.getServerName(), request.getServerPort(), user.getId(), token);
    }
}
