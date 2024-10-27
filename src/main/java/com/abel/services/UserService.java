package com.abel.services;



import com.abel.model.User;
import com.abel.model.dto.RegisteredUser;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String name);
    User registerUser(RegisteredUser registeredUser);
}
