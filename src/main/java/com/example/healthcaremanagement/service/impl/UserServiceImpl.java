package com.example.healthcaremanagement.service.impl;

import com.example.healthcaremanagement.entity.User;
import com.example.healthcaremanagement.entity.UserType;
import com.example.healthcaremanagement.repository.UserRepository;
import com.example.healthcaremanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final PasswordEncoder passwordEncoder;


    private final UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB.isEmpty()) {
            String password = user.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            user.setUserType(UserType.USER);
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }

    }
}
