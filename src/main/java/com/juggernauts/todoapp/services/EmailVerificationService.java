package com.juggernauts.todoapp.services;


import com.juggernauts.todoapp.models.EmailVerification;

import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.EmailVerificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationService {
    private EmailVerificationRepo emailVerificationRepo;

    @Autowired
    public void setEmailVerificationRepo(EmailVerificationRepo emailVerificationRepo) {this.emailVerificationRepo = emailVerificationRepo;}

    public String addEmailVerification(EmailVerification emailVerification) {
        emailVerificationRepo.save(emailVerification);
        return emailVerification.toString();

    };


    public EmailVerification getEmailVerification(User user, String token) {
        return emailVerificationRepo.findOne(user, token);
    }

    public void deleteEmailVerification(EmailVerification ev) {
        emailVerificationRepo.delete(ev);
    }
}
