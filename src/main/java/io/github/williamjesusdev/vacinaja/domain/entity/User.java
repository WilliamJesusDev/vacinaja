package io.github.williamjesusdev.vacinaja.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.williamjesusdev.vacinaja.domain.annotation.CpfCnpj;
import io.github.williamjesusdev.vacinaja.rest.dto.res.UserResponseDTO;
import io.github.williamjesusdev.vacinaja.rest.dto.res.VaccineResponseDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Código de identificação do usuário", example = "1")
    private Long id;

    @Size(max = 60)
    @NotBlank(message = "Nome do usuário é obrigatório")
    @ApiModelProperty(value = "Nome do usuário", example = "Meu Nome")
    private String nome;

    @Email
    @Column(unique = true)
    @NotBlank(message = "E-mail é obrigatório")
    @ApiModelProperty(value = "E-mail do usuário", example = "usuario@email.com")
    private String email;

    @CpfCnpj
    @Column(unique = true)
    @NotBlank(message = "CPF é obrigatório")
    @ApiModelProperty(value = "CPF do usuário", example = "123.456.789-10")
    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_nascimento")
    @NotNull(message = "Data de nascimento é obrigatória")
    @ApiModelProperty(value = "Data de nascimento do usuário", example = "2000-03-19")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vaccine> vacinas;

    public User() {
    }

    public User(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public void setDataNascimento(LocalDate data_nascimento) {
        this.dataNascimento = data_nascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return Objects.equals(id, users.id) && Objects.equals(nome, users.nome) && Objects.equals(email, users.email) && Objects.equals(cpf, users.cpf) && Objects.equals(dataNascimento, users.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, cpf, dataNascimento);
    }

    public UserResponseDTO toDTO() {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(id);
        dto.setNome(nome);
        dto.setEmail(email);
        dto.setCpf(cpf);
        dto.setDataNascimento(dataNascimento);
        dto.setVacinas(vacinas.stream().map(vacina ->
                new VaccineResponseDTO(vacina.getNome(), vacina.getDataAplicacao()))
                .collect(Collectors.toList())
        );

        return dto;
    }
}
