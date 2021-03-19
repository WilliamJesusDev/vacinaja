package io.github.williamjesusdev.vacinaja.rest.dto.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VaccineResponseDTO {
    @ApiModelProperty(value = "Nome da vacina", example = "Sarampo")
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "Data de aplicação da vacina", example = "2021-03-19")
    private LocalDate dataAplicacao;

    public VaccineResponseDTO() {
    }

    public VaccineResponseDTO(String nome, LocalDate dataAplicacao) {
        this.nome = nome;
        this.dataAplicacao = dataAplicacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
