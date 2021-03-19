package io.github.williamjesusdev.vacinaja.domain.service.impl;

import io.github.williamjesusdev.vacinaja.domain.entity.User;
import io.github.williamjesusdev.vacinaja.domain.entity.Vaccine;
import io.github.williamjesusdev.vacinaja.domain.repository.UsersRepository;
import io.github.williamjesusdev.vacinaja.domain.repository.VaccinesRepository;
import io.github.williamjesusdev.vacinaja.domain.service.VaccineService;
import io.github.williamjesusdev.vacinaja.exception.ResourceNotFoundException;
import io.github.williamjesusdev.vacinaja.rest.dto.req.VaccineRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    private VaccinesRepository vaccinesRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void createVaccineAplication(VaccineRequestDTO vaccine) {
        Optional<User> user = usersRepository.findByEmail(vaccine.getEmail());

        if (user.isEmpty()) {
            throw new ResourceNotFoundException("O e-mail: " + vaccine.getEmail() + " não foi localizado");
        } else {
            vaccinesRepository.save(vaccine.toModel(new Vaccine(), user.get()));
        }
    }

    @Override
    public List<Vaccine> getAllVaccines() {
        List<Vaccine> vaccines = vaccinesRepository.findAll();
        if(vaccines.isEmpty()){
            throw new ResourceNotFoundException("Ainda não foi aplicada nenhuma vacina");
        }else {
            return vaccines;
        }
    }
}
