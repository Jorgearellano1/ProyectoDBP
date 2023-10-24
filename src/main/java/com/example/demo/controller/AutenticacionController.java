package com.example.demo.controller;

import com.example.demo.model.Autenticacion;
import com.example.demo.service.AutenticacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    @PostMapping("/login")
    public Autenticacion login(@RequestBody Autenticacion autenticacion) {
        return autenticacionService.authenticateUser(autenticacion);
    }

    @PostMapping("/register")
    public Autenticacion register(@RequestBody Autenticacion autenticacion) {
        return autenticacionService.registerUser(autenticacion);
    }
}
