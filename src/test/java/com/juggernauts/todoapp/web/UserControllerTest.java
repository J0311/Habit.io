package com.juggernauts.todoapp.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.TaskRepo;
import com.juggernauts.todoapp.repos.UserRepo;
import com.juggernauts.todoapp.services.TaskService;
import com.juggernauts.todoapp.services.UserService;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {UserController.class, TaskService.class, UserService.class})
@ActiveProfiles({"josh"})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @MockBean
    private TaskRepo taskRepo;

    @Autowired
    private UserController userController;

    @MockBean
    private UserRepo userRepo;

    /**
     * Method under test: {@link UserController#createNewUser(User)}
     */
    @Test
    void testCreateNewUser() throws Exception {
        User user = new User();
        user.setCategories(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setEmailVerified(true);
        user.setId(1);
        user.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

