package com.github.fiap.smartcity_trafego.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class RegistroOcorrenciaUpdateDto {
    private String tipoOcorrencia;
    private String descricao;
    private LocalDateTime dataHora;
    private String localizacao;
    private String gravidade;
}
