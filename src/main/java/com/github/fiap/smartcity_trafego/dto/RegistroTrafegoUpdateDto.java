package com.github.fiap.smartcity_trafego.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistroTrafegoUpdateDto {
    private LocalDateTime dataHora;
    private String velocidade;
}
