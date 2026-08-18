package com.chatsphere.application.service;

import org.springframework.stereotype.Service;

import com.chatsphere.application.entity.User;
import com.chatsphere.application.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
}
