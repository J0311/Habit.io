package com.juggernauts.todoapp.web;

//import com.juggernauts.todoapp.models.Group;
import com.juggernauts.todoapp.models.Reminder;
import com.juggernauts.todoapp.services.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("reminder")
public class ReminderController {

    @Autowired
    ReminderService reminderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewReminder(@RequestBody Reminder reminder) {
        reminderService.addReminder(reminder);
        return ResponseEntity.ok(reminder);
    };
}
