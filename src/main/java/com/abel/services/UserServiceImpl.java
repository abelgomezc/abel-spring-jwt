package com.abel.services;

//import com.chris.loginsecurity.api.exceptions.InvalidPasswordException;
//import com.chris.loginsecurity.api.exceptions.ResourceNotFoundException;
//import com.chris.loginsecurity.api.mapper.UserMapper;
//import com.chris.loginsecurity.api.models.dto.RegisteredUser;
//import com.chris.loginsecurity.api.models.entity.Role;
//import com.chris.loginsecurity.api.models.entity.User;
//import com.chris.loginsecurity.api.repositories.RoleRepository;
//import com.chris.loginsecurity.api.repositories.UserRepository;
import com.abel.exceptions.InvalidPasswordException;
import com.abel.exceptions.ResourceNotFoundException;
import com.abel.mapper.UserMapper;
import com.abel.model.Cliente;
import com.abel.model.Role;
import com.abel.model.User;
import com.abel.model.dto.RegisteredUser;
import com.abel.model.dto.UserDTO;
import com.abel.repository.RoleRepository;
import com.abel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${default.role}")
    private String defaultRole;

    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Transactional
    public User registerUser(RegisteredUser registeredUser){
        validatePassword(registeredUser);
        User user = userMapper.registeredUserToUser(registeredUser);
        user.setPassword(passwordEncoder.encode(registeredUser.getPassword()));
        Role role = roleRepository.findByName(defaultRole)
                .orElseThrow(() -> new ResourceNotFoundException("role","customer",defaultRole));
        user.setRoles(Collections.singleton(role));
        return userRepository.save(user);
    }

    private void validatePassword(RegisteredUser registeredUser) {
        if(!registeredUser.getPassword().equals(registeredUser.getRepeatedPassword())){
            throw  new InvalidPasswordException("Las contrasenas no coinciden,Intentalo de nuevo");
        }
    }

//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }

    // Listar usuarios devolviendo solo los campos de UserDTO
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

//
        public List<User> findAllUsersFacturas() {
        return userRepository.findAll();
    }


}



