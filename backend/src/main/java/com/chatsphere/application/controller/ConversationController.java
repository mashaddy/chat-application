package com.chatsphere.application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatsphere.application.dto.ConversationResponse;
import com.chatsphere.application.dto.CreateConversationRequest;
import com.chatsphere.application.service.ConversationService;

@RestController
@RequestMapping("/api/conversation")
public class ConversationController {
    private final ConversationService conversationService;
    
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping
    public ConversationResponse createConversation(@RequestBody CreateConversationRequest request) {
        return conversationService.createConversation(request);

    } 
}
