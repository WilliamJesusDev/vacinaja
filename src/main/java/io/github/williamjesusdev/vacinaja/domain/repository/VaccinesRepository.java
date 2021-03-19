package io.github.williamjesusdev.vacinaja.domain.repository;

import io.github.williamjesusdev.vacinaja.domain.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinesRepository extends JpaRepository<Vaccine, Long> {
}
