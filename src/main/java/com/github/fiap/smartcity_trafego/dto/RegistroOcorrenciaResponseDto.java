package com.github.fiap.smartcity_trafego.dto;

import java.time.LocalDateTime;

import com.github.fiap.smartcity_trafego.model.RegistroOcorrencia;

import lombok.Data;

@Data
public class RegistroOcorrenciaResponseDto {
    private String id;
    private String tipoOcorrencia;
    private String descricao;
    private LocalDateTime dataHora;
    private String localizacao;
    private String gravidade;

    public RegistroOcorrenciaResponseDto(RegistroOcorrencia ocorrencia) {
        this.id = ocorrencia.getId();
        this.tipoOcorrencia = ocorrencia.getTipoOcorrencia();
        this.descricao = ocorrencia.getDescricao();
        this.dataHora = ocorrencia.getDataHora();
        this.localizacao = ocorrencia.getLocalizacao();
        this.gravidade = ocorrencia.getGravidade();
    }

}


