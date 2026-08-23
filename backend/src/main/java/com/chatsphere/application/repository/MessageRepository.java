package com.chatsphere.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatsphere.application.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
    
}
