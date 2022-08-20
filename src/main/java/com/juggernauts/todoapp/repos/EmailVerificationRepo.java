package com.juggernauts.todoapp.repos;

import com.juggernauts.todoapp.models.EmailVerification;
import com.juggernauts.todoapp.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailVerificationRepo extends JpaRepository<EmailVerification, Integer> {
    @Query("SELECT e FROM EmailVerification e WHERE e.user = ?1 AND e.token = ?2")
    EmailVerification findOne(User user, String token);
}
