package io.github.williamjesusdev.vacinaja.domain.repository;

import io.github.williamjesusdev.vacinaja.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByCpf(String cpf);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.vacinas v WHERE u.id = :id")
    Optional<User> findByIdFetch(@Param("id") Long id);
}
