package com.juggernauts.todoapp.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "email_verification_tokens")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id", columnDefinition = "INTEGER")
    private int tokenId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String token;

    // used in a previous version
//    @Column(name = "user_id",nullable = false, columnDefinition = "INTEGER")
//    private int userId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User user;

    public EmailVerification(String token, User user) {
        this.token = token;
        this.user = user;
    }
}