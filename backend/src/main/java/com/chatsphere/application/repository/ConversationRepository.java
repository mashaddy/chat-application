package com.chatsphere.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatsphere.application.entity.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation,Long> {
    
}
