package com.chatsphere.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatsphere.application.dto.ConversationResponse;
import com.chatsphere.application.dto.CreateConversationRequest;
import com.chatsphere.application.entity.Conversation;
import com.chatsphere.application.entity.Conversations_Participant;
import com.chatsphere.application.entity.User;
import com.chatsphere.application.repository.ConversationRepository;
import com.chatsphere.application.repository.ConversationsParticipantRepository;
import com.chatsphere.application.repository.UserRepository;

@Service
public class ConversationService {
        private final ConversationRepository conversationRepository;
        private final ConversationsParticipantRepository conversationsParticipantRepository;
        private final UserRepository userRepository;


        public ConversationService(ConversationRepository conversationRepository, 
                ConversationsParticipantRepository conversationsParticipantRepository, UserRepository userRepository) {
                this.conversationsParticipantRepository = conversationsParticipantRepository;
                this.userRepository = userRepository;
                this.conversationRepository = conversationRepository;
        }

        public void validateUsers(CreateConversationRequest request) {
            User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.getUserId()));
            User participant = userRepository.findById(request.getParticipantId()).orElseThrow(() -> new IllegalArgumentException("Participant not found with id: " + request.getParticipantId()));
        }

        @Transactional
        public ConversationResponse createConversation(CreateConversationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        User participant = userRepository.findById(request.getParticipantId())
                .orElseThrow(()-> new IllegalArgumentException("Participant not found"));

        Conversation conversation = new Conversation();
        Conversation savedConversation = conversationRepository.save(conversation);

        Conversations_Participant participant1 = new Conversations_Participant();
        participant1.setConversation(savedConversation);
        participant1.setUser(user);

        Conversations_Participant participant2 = new Conversations_Participant();
        participant2.setConversation(savedConversation);
        participant2.setUser(participant);

        conversationsParticipantRepository.save(participant1);
        conversationsParticipantRepository.save(participant2);

        ConversationResponse response = new ConversationResponse();
        response.setId(savedConversation.getId());
        response.setCreatedAt(savedConversation.getCreatedAt());
        return response;
        }
}


