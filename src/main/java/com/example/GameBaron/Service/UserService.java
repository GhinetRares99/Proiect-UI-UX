package com.example.GameBaron.Service;

import com.example.GameBaron.Entity.User;
import com.example.GameBaron.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
