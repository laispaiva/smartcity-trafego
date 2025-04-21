package com.github.fiap.smartcity_trafego.service;

import com.github.fiap.smartcity_trafego.dto.VeiculoCreateDto;
import com.github.fiap.smartcity_trafego.dto.VeiculoResponseDto;
import com.github.fiap.smartcity_trafego.dto.VeiculoUpdateDto;
import com.github.fiap.smartcity_trafego.model.Veiculo;
import com.github.fiap.smartcity_trafego.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public List<VeiculoResponseDto> listar() {
        return repository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public VeiculoResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toResponseDto)
                .orElseThrow();
    }

    public VeiculoResponseDto cadastrar(VeiculoCreateDto dto) {
        Veiculo novo = Veiculo.builder()
                .placa(dto.getPlaca())
                .tipo(dto.getTipo())
                .cor(dto.getCor())
                .velocidadeRegistrada(dto.getVelocidadeRegistrada())
                .build();

        return toResponseDto(repository.save(novo));
    }

    public VeiculoResponseDto atualizar(Long id, VeiculoUpdateDto dto) {
        Veiculo veiculo = repository.findById(id).orElseThrow();

        veiculo.setTipo(dto.getTipo());
        veiculo.setCor(dto.getCor());
        veiculo.setVelocidadeRegistrada(dto.getVelocidadeRegistrada());

        return toResponseDto(repository.save(veiculo));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private VeiculoResponseDto toResponseDto(Veiculo veiculo) {
        VeiculoResponseDto dto = new VeiculoResponseDto();
        dto.setId(veiculo.getId());
        dto.setPlaca(veiculo.getPlaca());
        dto.setTipo(veiculo.getTipo());
        dto.setCor(veiculo.getCor());
        dto.setVelocidadeRegistrada(veiculo.getVelocidadeRegistrada());
        return dto;
    }
}
