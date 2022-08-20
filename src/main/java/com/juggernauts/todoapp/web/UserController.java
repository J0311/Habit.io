package com.juggernauts.todoapp.web;

import com.juggernauts.todoapp.models.Task;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.services.TaskService;
import com.juggernauts.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
    User testuser = new User(1, "testpassword", "testemail");

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(user.getEmail()+ "added successfully!");
    };
}