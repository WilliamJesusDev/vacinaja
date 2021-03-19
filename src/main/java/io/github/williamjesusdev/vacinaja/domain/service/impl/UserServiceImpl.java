package io.github.williamjesusdev.vacinaja.domain.service.impl;

import io.github.williamjesusdev.vacinaja.domain.entity.User;
import io.github.williamjesusdev.vacinaja.domain.repository.UsersRepository;
import io.github.williamjesusdev.vacinaja.domain.service.UserService;
import io.github.williamjesusdev.vacinaja.exception.DuplicateKeyException;
import io.github.williamjesusdev.vacinaja.exception.ResourceNotFoundException;
import io.github.williamjesusdev.vacinaja.rest.dto.req.UserRequestDTO;
import io.github.williamjesusdev.vacinaja.rest.dto.res.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void createUser(UserRequestDTO user) {
        if (usersRepository.findByCpf(user.getCpf()).isPresent()) {

            throw new DuplicateKeyException("O CPF: " + user.getCpf() + " já foi utilizado");

        } else if (usersRepository.findByEmail(user.getEmail()).isPresent()) {

            throw new DuplicateKeyException("O e-mail: " + user.getEmail() + " já foi utilizado");

        } else {
            User userToSave = user.toModel(new User());
            usersRepository.save(userToSave);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = usersRepository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("Ainda não foi cadastrado nenhum usuário");
        } else {
            return users;
        }
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        Optional<User> user = usersRepository.findByIdFetch(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("O id de usuário: " + id + " não foi localizado");
        } else {
            return user.get().toDTO();
        }
    }
}
