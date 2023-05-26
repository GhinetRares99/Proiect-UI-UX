package com.example.GameBaron.Security;

import com.example.GameBaron.Entity.User;
import com.example.GameBaron.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user;
        Optional<User> userFound = userRepository.findUserByUsername(username);

        if(userFound.isPresent()) {
            user = userFound.get();
            System.out.println(user);
        }
        else {
            throw new UsernameNotFoundException("The user does not exist!");
        }

        return new CustomUserDetails(user);
    }
}
