package com.abel.controller;


import com.abel.model.Cliente;
import com.abel.model.User;
import com.abel.model.dto.RegisteredUser;
import com.abel.model.dto.RegisteredUserDTO;
import com.abel.model.dto.UserDTO;
import com.abel.services.AuthenticationService;
import com.abel.services.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private AuthenticationService authenticationService;
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/registereUser")
    public ResponseEntity<RegisteredUserDTO> registerUser(@RequestBody @Valid RegisteredUser registeredUser){
        RegisteredUserDTO response = authenticationService.registerUser(registeredUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/demo")
    public String prueba(){
        return "El orejitas es el mejor";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listUsuarios")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>( userService.findAllUsers(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listUsuariosfacturas")
    public ResponseEntity<List<User>> listUsersFac() {
        return new ResponseEntity<>( userService.findAllUsersFacturas(), HttpStatus.OK);
    }

}
