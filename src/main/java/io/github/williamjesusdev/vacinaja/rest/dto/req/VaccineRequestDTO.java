package io.github.williamjesusdev.vacinaja.rest.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.williamjesusdev.vacinaja.domain.entity.User;
import io.github.williamjesusdev.vacinaja.domain.entity.Vaccine;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VaccineRequestDTO {
    @ApiModelProperty(value = "Nome da vacina", example = "Sarampo")
    private String nome;

    @ApiModelProperty(value = "E-mail do usuário", example = "usuario@email.com")
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "Data de aplicação da vacina", example = "2021-03-19")
    private LocalDate dataAplicacao;

    public VaccineRequestDTO() {
    }

    public VaccineRequestDTO(String nome, String email, LocalDate dataAplicacao) {
        this.nome = nome;
        this.email = email;
        this.dataAplicacao = dataAplicacao;
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

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public Vaccine toModel(Vaccine vaccine, User user){
        vaccine.setNome(nome);
        vaccine.setDataAplicacao(dataAplicacao);
        vaccine.setUser(user);
        return vaccine;
    }
}
