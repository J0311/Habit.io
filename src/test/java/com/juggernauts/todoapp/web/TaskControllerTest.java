package com.juggernauts.todoapp.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juggernauts.todoapp.services.ReminderService;
import com.juggernauts.todoapp.models.Category;
import com.juggernauts.todoapp.models.Reminder;
import com.juggernauts.todoapp.models.Task;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.ReminderRepo;

import java.sql.Date;
import java.util.ArrayList;

import com.juggernauts.todoapp.services.ReminderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ReminderController.class, ReminderService.class})
@ActiveProfiles({"josh"})
@ExtendWith(SpringExtension.class)
class TaskControllerTest {
    @Autowired
    private ReminderController reminderController;

    @MockBean
    private ReminderRepo reminderRepo;

    /**
     * Method under test: {@link ReminderController#createNewReminder(Reminder)}
     */
    @Test
    void testCreateNewReminder() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);

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
        task.setCompleteBy(null);
        task.setDescription("The characteristics of someone or something");
        task.setDone(true);
        task.setName("Name");
        task.setReminders(new ArrayList<>());
       // task.setRepeatEvery(1);
        task.setTaskId(123);
        task.setUser(user1);

        Reminder reminder = new Reminder();
        reminder.setRemindBy(date);
        reminder.setReminderId(123);
        reminder.setRepeatEvery(1);
        reminder.setTask(task);
        String content = (new ObjectMapper()).writeValueAsString(reminder);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/reminder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(reminderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}
