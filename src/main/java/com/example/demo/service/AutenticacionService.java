package com.example.demo.service;

import com.example.demo.model.Autenticacion;
import com.example.demo.repository.AutenticacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    @Autowired
    private AutenticacionRepository autenticacionRepository;

    public Autenticacion authenticateUser(Autenticacion autenticacion) {
        Autenticacion existingUser = autenticacionRepository.findByUsername(autenticacion.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(autenticacion.getPassword())) {
            return existingUser;
        }
        return null;
    }

    public Autenticacion registerUser(Autenticacion autenticacion) {
        if (autenticacionRepository.findByUsername(autenticacion.getUsername()) == null) {
            return autenticacionRepository.save(autenticacion);
        }
        return null;
    }
}
