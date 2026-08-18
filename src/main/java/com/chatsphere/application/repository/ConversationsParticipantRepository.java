package com.chatsphere.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatsphere.application.entity.Conversations_Participant;

public interface ConversationsParticipantRepository extends JpaRepository<Conversations_Participant,Long> {
    
}
