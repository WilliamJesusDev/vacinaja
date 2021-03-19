package io.github.williamjesusdev.vacinaja.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vacinas")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 60)
    @NotBlank(message = "Nome da vacina é obrigatório")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "E-mail do usuário é obrigatório")
    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_aplicacao")
    @NotNull(message = "Data da aplicação da vacina é obrigatória")
    private LocalDate dataAplicacao;

    @CreatedDate
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public Vaccine() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Vaccine(String nome, User user, LocalDate dataAplicacao) {
        this.nome = nome;
        this.user = user;
        this.dataAplicacao = dataAplicacao;
        this.dataCriacao = LocalDateTime.now();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate data_aplicacao) {
        this.dataAplicacao = data_aplicacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime data_criacao) {
        this.dataCriacao = data_criacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Objects.equals(id, vaccine.id) && Objects.equals(nome, vaccine.nome) && Objects.equals(user, vaccine.user) && Objects.equals(dataAplicacao, vaccine.dataAplicacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, user, dataAplicacao);
    }
}
