package com.chatsphere.application.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private java.time.LocalDateTime createdAt;

    private java.time.LocalDateTime lastSeen;

    @OneToMany(mappedBy = "user")
    private List<Conversations_Participant> conversationsParticipants = new ArrayList<>();
    
    @OneToMany(mappedBy = "sender")
    private List<Message> messages = new ArrayList<>();

}