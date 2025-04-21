package com.github.fiap.smartcity_trafego.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RegistroOcorrenciaCreateDto {
    private String tipoOcorrencia;
    private String descricao;
    private LocalDateTime dataHora;
    private String localizacao;
    private String gravidade;
}
