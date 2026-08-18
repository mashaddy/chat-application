package com.chatsphere.application.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="conversations")
public class Conversations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "conversation")
    private List<Conversations_Participant> participants = new ArrayList<>();
    
    @OneToMany(mappedBy = "conversation")
    private List<Message> messages = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;
}
