package com.juggernauts.todoapp.services;

import static org.mockito.Mockito.mock;

import com.juggernauts.todoapp.repos.EmailVerificationRepo;
import org.junit.jupiter.api.Test;

class EmailVerificationServiceTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link EmailVerificationService}
     *   <li>{@link EmailVerificationService#setEmailVerificationRepo(EmailVerificationRepo)}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EmailVerificationService.emailVerificationRepo

        (new EmailVerificationService()).setEmailVerificationRepo(mock(EmailVerificationRepo.class));
    }
}

