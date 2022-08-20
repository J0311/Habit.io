package com.juggernauts.todoapp.repos;

import com.juggernauts.todoapp.models.Reminder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepo extends JpaRepository<Reminder, Integer> {
    @Query("SELECT r FROM Reminder r WHERE r.remindBy <= current_date")
    List<Reminder> getOutdatedReminders();
}
