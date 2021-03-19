package io.github.williamjesusdev.vacinaja.rest.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class UserResponseDTO {
    @ApiModelProperty(value = "Código de identificação do usuário", example = "1")
    private Long id;

    @ApiModelProperty(value = "Nome do usuário", example = "Meu Nome")
    private String nome;

    @ApiModelProperty(value = "E-mail do usuário", example = "usuario@email.com")
    private String email;

    @ApiModelProperty(value = "CPF do usuário", example = "123.456.789-10")
    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "Data de nascimento do usuário", example = "2000-03-19")
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
