package com.producio.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.producio.backend.model.User;
import com.producio.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void registerUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        repository.save(newUser);
    }

    public boolean validateUser(User user) {
        User fetchUser = repository.findByEmail(user.getEmail());
        
        if(fetchUser == null) {
            System.out.println("User not found");
            return false;
        }

        // if(passwordEncoder.matches(user.getPassword(), fetchUser.getPassword())) return true;
        return false;
    }

    public User getUser(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }
}
