package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        return mapToUserDTO(user);
    }

    @Transactional
    public User registerUser(SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("El correo electrónico ya está registrado.");
        }

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    @Transactional
    public void updateUserByUsername(String username, UserUpdateRequest updateRequest) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        updateUserData(user, updateRequest);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Transactional
    public void changeUserPasswordByUsername(String username, String newPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    private UserDTO mapToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRoles());
    }


    private void updateUserData(User user, UserUpdateRequest updateRequest) {
        user.setEmail(updateRequest.getEmail());
        user.setPassword(passwordEncoder.encode(updateRequest.getPassword()));
    }
}

