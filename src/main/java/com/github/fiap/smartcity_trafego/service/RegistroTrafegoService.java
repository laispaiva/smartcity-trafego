package com.github.fiap.smartcity_trafego.service;

import com.github.fiap.smartcity_trafego.dto.RegistroTrafegoCreateDto;
import com.github.fiap.smartcity_trafego.dto.RegistroTrafegoResponseDto;
import com.github.fiap.smartcity_trafego.dto.RegistroTrafegoUpdateDto;
import com.github.fiap.smartcity_trafego.model.RegistroTrafego;
import com.github.fiap.smartcity_trafego.model.Sensor;
import com.github.fiap.smartcity_trafego.model.Veiculo;
import com.github.fiap.smartcity_trafego.repository.RegistroTrafegoRepository;
import com.github.fiap.smartcity_trafego.repository.SensorRepository;
import com.github.fiap.smartcity_trafego.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistroTrafegoService {

    private final RegistroTrafegoRepository registroTrafegoRepository;
    private final SensorRepository sensorRepository;
    private final VeiculoRepository veiculoRepository;

    public RegistroTrafegoResponseDto cadastrar(RegistroTrafegoCreateDto dto) {
        Sensor sensor = sensorRepository.findById(dto.getSensorId()).orElseThrow();
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId()).orElseThrow();

        RegistroTrafego registro = RegistroTrafego.builder()
                .dataHora(dto.getDataHora())
                .velocidade(dto.getVelocidade())
                .sensor(sensor)
                .veiculo(veiculo)
                .build();

        registro = registroTrafegoRepository.save(registro);

        return toResponseDto(registro);
    }

    public List<RegistroTrafegoResponseDto> listar() {
        return registroTrafegoRepository.findAll().stream().map(this::toResponseDto).toList();
    }

    public Optional<RegistroTrafegoResponseDto> buscarPorId(Long id) {
        return registroTrafegoRepository.findById(id).map(this::toResponseDto);
    }

    public Optional<RegistroTrafegoResponseDto> atualizar(Long id, RegistroTrafegoUpdateDto dto) {
        return registroTrafegoRepository.findById(id).map(registro -> {
            registro.setDataHora(dto.getDataHora());
            registro.setVelocidade(dto.getVelocidade());
            registro = registroTrafegoRepository.save(registro);
            return toResponseDto(registro);
        });
    }

    public void deletar(Long id) {
        registroTrafegoRepository.deleteById(id);
    }

    private RegistroTrafegoResponseDto toResponseDto(RegistroTrafego registro) {
        RegistroTrafegoResponseDto dto = new RegistroTrafegoResponseDto();
        dto.setId(registro.getId());
        dto.setDataHora(registro.getDataHora());
        dto.setVelocidade(registro.getVelocidade());
        dto.setSensorId(registro.getSensor().getId());
        dto.setVeiculoId(registro.getVeiculo().getId());
        return dto;
    }
}
