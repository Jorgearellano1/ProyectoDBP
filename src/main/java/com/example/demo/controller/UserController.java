package com.example.demo.controller;

import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserDTO> getCurrentUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
        UserDTO userDTO = userService.getUserByUsername(userDetails.getUsername());
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateUserProfile(@Valid @RequestBody UserUpdateRequest updateRequest,
                                               @AuthenticationPrincipal UserDetails userDetails) {
        userService.updateUserByUsername(userDetails.getUsername(), updateRequest);
        return ResponseEntity.ok("Perfil de usuario actualizado con éxito.");
    }

    @PostMapping("/change-password")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> changePassword(@RequestParam("newPassword") String newPassword,
                                            @AuthenticationPrincipal UserDetails userDetails) {
        userService.changeUserPasswordByUsername(userDetails.getUsername(), newPassword);
        return ResponseEntity.ok("Contraseña cambiada con éxito.");
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
        userService.deleteUserByUsername(userDetails.getUsername());
        return ResponseEntity.ok("Perfil de usuario eliminado con éxito.");
    }
}
