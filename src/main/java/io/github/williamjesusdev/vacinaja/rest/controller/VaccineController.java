package io.github.williamjesusdev.vacinaja.rest.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import io.github.williamjesusdev.vacinaja.domain.entity.Vaccine;
import io.github.williamjesusdev.vacinaja.domain.service.impl.VaccineServiceImpl;
import io.github.williamjesusdev.vacinaja.rest.dto.req.VaccineRequestDTO;
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
@RequestMapping("/v1/vacinas")
@Api(tags = "API de Vacinação")
public class VaccineController {

    @Autowired
    private VaccineServiceImpl vaccineService;

    @GetMapping
    @ApiOperation(value = "Buscar todos as vacinas aplicadas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200 Success"), @ApiResponse(code = 404, message = "404 Not Found")
    })
    public ResponseEntity<List<Vaccine>> getAllVaccines() {
        List<Vaccine> vaccines = vaccineService.getAllVaccines();

        return ResponseEntity.ok(vaccines);
    }

    @PostMapping
    @ApiOperation(value = "Adicionar uma aplicação de vacina")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "201 Created"), @ApiResponse(code = 400, message = "400 Bad Request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public ResponseEntity<Void> createVaccineAplication(@Valid @RequestBody VaccineRequestDTO vaccine) {
        vaccineService.createVaccineAplication(vaccine);

        return ResponseEntity.status(201).build();
    }
}
