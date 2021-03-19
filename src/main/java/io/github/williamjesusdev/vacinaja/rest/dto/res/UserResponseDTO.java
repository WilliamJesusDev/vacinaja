package io.github.williamjesusdev.vacinaja.rest.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    private List<VaccineResponseDTO> vacinas;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String nome, String email, String cpf, LocalDate dataNascimento, List<VaccineResponseDTO> vacinas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.vacinas = vacinas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<VaccineResponseDTO> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<VaccineResponseDTO> vacinas) {
        this.vacinas = vacinas;
    }
}
