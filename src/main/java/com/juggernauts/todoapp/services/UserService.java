package com.juggernauts.todoapp.services;

import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.UserRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String addUser(User user) {
        userRepo.save(user);
        return user.toString();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(String email) {
        return userRepo.findOne(email);
    }

    public User getUser(int id) {
        return userRepo.getReferenceById(id);
    }

    public Optional<User> getUser(User user) {
        return userRepo.findOne(Example.of(user));
    }

    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepo.save(user);
    }
}