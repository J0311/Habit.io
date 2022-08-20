package com.juggernauts.todoapp.web;

import com.juggernauts.todoapp.models.EmailVerification;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.services.EmailVerificationService;
import com.juggernauts.todoapp.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("verify")
public class EmailVerificationController {
    private static final Logger logger = LogManager.getLogger(EmailVerificationController.class);
    @Autowired EmailVerificationService emailVerificationService;
    @Autowired UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmailVerification> createNewEmailVerification(@RequestBody EmailVerification emailVerification) {
        emailVerificationService.addEmailVerification(emailVerification);
        return ResponseEntity.ok(emailVerification);
    }

    @GetMapping("/{userId}/{token}")
    public ResponseEntity<String> verifyEmail(@PathVariable int userId, @PathVariable String token) {
        User user = userService.getUser(userId);
        if (user == null)
            return ResponseEntity.badRequest().body("This token and/or user ID are not valid.");

        EmailVerification ev = emailVerificationService.getEmailVerification(user, token);
        if (ev == null)
            return ResponseEntity.badRequest().body("This token and/or user ID are not valid.");
            
        userService.verifyEmail(user);
        logger.info("verified email {}", user.getEmail());
        return ResponseEntity.ok("Your email has been verified.");
    }
}
