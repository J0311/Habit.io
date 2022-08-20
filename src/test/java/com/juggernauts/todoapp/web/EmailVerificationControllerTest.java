package com.juggernauts.todoapp.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juggernauts.todoapp.models.EmailVerification;
import com.juggernauts.todoapp.models.User;
import com.juggernauts.todoapp.repos.EmailVerificationRepo;
import com.juggernauts.todoapp.repos.UserRepo;
import com.juggernauts.todoapp.services.EmailVerificationService;
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

@ContextConfiguration(classes = {EmailVerificationController.class, EmailVerificationService.class, UserService.class})
@ActiveProfiles({"josh"})
@ExtendWith(SpringExtension.class)
class EmailVerificationControllerTest {
    @Autowired
    private EmailVerificationController emailVerificationController;

    @MockBean
    private EmailVerificationRepo emailVerificationRepo;

    @MockBean
    private UserRepo userRepo;

    /**
     * Method under test: {@link EmailVerificationController#createNewEmailVerification(EmailVerification)}
     */
    @Test
    void testCreateNewEmailVerification() throws Exception {
        User user = new User();
        user.setCategories(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setEmailVerified(true);
        user.setId(1);
        user.setPassword("iloveyou");

        EmailVerification emailVerification = new EmailVerification();
        emailVerification.setToken("ABC123");
        emailVerification.setTokenId(123);
        emailVerification.setUser(user);
        String content = (new ObjectMapper()).writeValueAsString(emailVerification);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/verify")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(emailVerificationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

