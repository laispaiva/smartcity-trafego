package com.github.fiap.smartcity_trafego.dto;

import lombok.Data;

@Data
public class VeiculoResponseDto {
    private Long id;
    private String placa;
    private String tipo;
    private String cor;
    private String velocidadeRegistrada;
}
