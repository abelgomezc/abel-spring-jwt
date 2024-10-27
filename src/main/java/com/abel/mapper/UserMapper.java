package com.abel.mapper;


import com.abel.model.User;
import com.abel.model.dto.RegisteredUser;

import com.abel.model.dto.RegisteredUserDTO;

import com.abel.model.dto.UserDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles",ignore = true)
    @Mapping(target = "password",ignore = true)
    User registeredUserToUser(RegisteredUser registeredUser);
    @Mapping(target = "token", ignore = true)
    RegisteredUserDTO userToRegisteredUserDTO(User user);
    UserDTO userToUserDTO(User user);


}
