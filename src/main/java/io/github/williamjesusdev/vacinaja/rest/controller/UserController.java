package io.github.williamjesusdev.vacinaja.rest.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import io.github.williamjesusdev.vacinaja.domain.entity.User;
import io.github.williamjesusdev.vacinaja.domain.service.impl.UserServiceImpl;
import io.github.williamjesusdev.vacinaja.rest.dto.req.UserRequestDTO;
import io.github.williamjesusdev.vacinaja.rest.dto.res.UserResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@Api(value = "Usuário API REST")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    @ApiOperation(value = "Criar um usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "201 Created"), @ApiResponse(code = 400, message = "400 Bad Request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDTO user) {
        userService.createUser(user);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    @ApiOperation(value = "Buscar todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200 Success"), @ApiResponse(code = 404, message = "404 Not Found")
    })
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar um usuário pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200 Success"), @ApiResponse(code = 404, message = "404 Not Found")
    })
    public ResponseEntity<UserResponseDTO> getUser(@Valid @PathVariable("id") String id) {
        UserResponseDTO user = userService.getUserById(Long.parseLong(id));

        return ResponseEntity.ok(user);
    }
}
