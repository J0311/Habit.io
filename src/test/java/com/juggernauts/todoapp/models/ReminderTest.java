package com.juggernauts.todoapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ReminderTest {
    
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Reminder#Reminder()}
     *   <li>{@link Reminder#setRemindBy(Date)}
     *   <li>{@link Reminder#setReminderId(int)}
     *   <li>{@link Reminder#setRepeatEvery(Integer)}
     *   <li>{@link Reminder#setTask(Task)}
     *   <li>{@link Reminder#toString()}
     *   <li>{@link Reminder#getRemindBy()}
     *   <li>{@link Reminder#getReminderId()}
     *   <li>{@link Reminder#getRepeatEvery()}
     *   <li>{@link Reminder#getTask()}
     * </ul>
     */
    
    @Test
    void testConstructor() {
        Reminder actualReminder = new Reminder();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualReminder.setRemindBy(fromResult);
        actualReminder.setReminderId(123);
        actualReminder.setRepeatEvery(1);
        User user = new User();
        user.setCategories(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setEmailVerified(true);
        user.setId(1);
        user.setPassword("iloveyou");
        Category category = new Category();
        category.setCategoryId(123);
        category.setCategoryName("Category Name");
        category.setTasks(new ArrayList<>());
        category.setUser(user);
        User user1 = new User();
        user1.setCategories(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setEmailVerified(true);
        user1.setId(1);
        user1.setPassword("iloveyou");
        Task task = new Task();
        task.setCategory(category);
        //task.setCompleteBy(LocalDate.ofEpochDay(1L));
        task.setDescription("The characteristics of someone or something");
        task.setDone(true);
        task.setName("Name");
        task.setReminders(new ArrayList<>());
        //task.setRepeatEvery(1);
        task.setTaskId(123);
        task.setUser(user1);
        actualReminder.setTask(task);
        actualReminder.toString();
        assertSame(fromResult, actualReminder.getRemindBy());
        assertEquals(123, actualReminder.getReminderId());
        assertEquals(1, actualReminder.getRepeatEvery().intValue());
        assertSame(task, actualReminder.getTask());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Reminder#Reminder(int, Date, Integer, Task)}
     *   <li>{@link Reminder#setRemindBy(Date)}
     *   <li>{@link Reminder#setReminderId(int)}
     *   <li>{@link Reminder#setRepeatEvery(Integer)}
     *   <li>{@link Reminder#setTask(Task)}
     *   <li>{@link Reminder#toString()}
     *   <li>{@link Reminder#getRemindBy()}
     *   <li>{@link Reminder#getReminderId()}
     *   <li>{@link Reminder#getRepeatEvery()}
     *   <li>{@link Reminder#getTask()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date remindBy = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());

        User user = new User();
        user.setCategories(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setEmailVerified(true);
        user.setId(1);
        user.setPassword("iloveyou");

        Category category = new Category();
        category.setCategoryId(123);
        category.setCategoryName("Category Name");
        category.setTasks(new ArrayList<>());
        category.setUser(user);

        User user1 = new User();
        user1.setCategories(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setEmailVerified(true);
        user1.setId(1);
        user1.setPassword("iloveyou");

        Task task = new Task();
        task.setCategory(category);
       // task.setCompleteBy(LocalDate.ofEpochDay(1L));
        task.setDescription("The characteristics of someone or something");
        task.setDone(true);
        task.setName("Name");
        task.setReminders(new ArrayList<>());
       // task.setRepeatEvery(1);
        task.setTaskId(123);
        task.setUser(user1);
        Reminder actualReminder = new Reminder(123, remindBy, 1, task);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualReminder.setRemindBy(fromResult);
        actualReminder.setReminderId(123);
        actualReminder.setRepeatEvery(1);
        User user2 = new User();
        user2.setCategories(new ArrayList<>());
        user2.setEmail("jane.doe@example.org");
        user2.setEmailVerified(true);
        user2.setId(1);
        user2.setPassword("iloveyou");
        Category category1 = new Category();
        category1.setCategoryId(123);
        category1.setCategoryName("Category Name");
        category1.setTasks(new ArrayList<>());
        category1.setUser(user2);
        User user3 = new User();
        user3.setCategories(new ArrayList<>());
        user3.setEmail("jane.doe@example.org");
        user3.setEmailVerified(true);
        user3.setId(1);
        user3.setPassword("iloveyou");
        Task task1 = new Task();
        task1.setCategory(category1);
       // task1.setCompleteBy(LocalDate.ofEpochDay(1L));
        task1.setDescription("The characteristics of someone or something");
        task1.setDone(true);
        task1.setName("Name");
        task1.setReminders(new ArrayList<>());
      //  task1.setRepeatEvery(1);
        task1.setTaskId(123);
        task1.setUser(user3);
        actualReminder.setTask(task1);
        actualReminder.toString();
        assertSame(fromResult, actualReminder.getRemindBy());
        assertEquals(123, actualReminder.getReminderId());
        assertEquals(1, actualReminder.getRepeatEvery().intValue());
        assertSame(task1, actualReminder.getTask());
    }
}

