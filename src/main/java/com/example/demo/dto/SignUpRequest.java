package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4, max = 40, message = "El nombre de usuario debe tener entre 4 y 40 caracteres")
    private String username;

    @NotBlank(message = "La dirección de correo electrónico es obligatoria")
    @Size(max = 40, message = "La dirección de correo electrónico no debe exceder los 40 caracteres")
    @Email(message = "Debe proporcionar una dirección de correo electrónico válida")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 20, message = "La contraseña debe tener entre 6 y 20 caracteres")
    private String password;


    public SignUpRequest() {
    }

    public SignUpRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
