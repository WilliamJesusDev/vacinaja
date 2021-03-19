package io.github.williamjesusdev.vacinaja.domain.service;

import io.github.williamjesusdev.vacinaja.domain.entity.User;
import io.github.williamjesusdev.vacinaja.rest.dto.req.UserRequestDTO;
import io.github.williamjesusdev.vacinaja.rest.dto.res.UserResponseDTO;

import java.util.List;

public interface UserService {
    void createUser(UserRequestDTO user);

    List<User> getAllUsers();

    UserResponseDTO getUserById(Long id);
}
