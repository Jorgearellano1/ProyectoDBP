package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    private String username;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String password;


    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
