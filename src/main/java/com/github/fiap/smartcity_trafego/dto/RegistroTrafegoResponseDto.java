package com.github.fiap.smartcity_trafego.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistroTrafegoResponseDto {
    private Long id;
    private LocalDateTime dataHora;
    private String velocidade;
    private Long sensorId;
    private Long veiculoId;
}
