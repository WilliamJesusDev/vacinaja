package io.github.williamjesusdev.vacinaja.domain.service;

import io.github.williamjesusdev.vacinaja.domain.entity.Vaccine;
import io.github.williamjesusdev.vacinaja.rest.dto.req.VaccineRequestDTO;

import java.util.List;

public interface VaccineService {
    void createVaccineAplication(VaccineRequestDTO vaccine);

    List<Vaccine> getAllVaccines();
}
