package io.github.williamjesusdev.vacinaja.rest.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.williamjesusdev.vacinaja.domain.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class UserRequestDTO {
    private String nome;
    private String email;
    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public User toModel(User user){
        user.setNome(nome);
        user.setCpf(cpf);
        user.setEmail(email);
        user.setDataNascimento(dataNascimento);
        return user;
    }
}
