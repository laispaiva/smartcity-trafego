package com.github.fiap.smartcity_trafego.service;

import com.github.fiap.smartcity_trafego.dto.RegistroOcorrenciaCreateDto;
import com.github.fiap.smartcity_trafego.dto.RegistroOcorrenciaResponseDto;
import com.github.fiap.smartcity_trafego.dto.RegistroOcorrenciaUpdateDto;
import com.github.fiap.smartcity_trafego.model.RegistroOcorrencia;
import com.github.fiap.smartcity_trafego.repository.RegistroOcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RegistroOcorrenciaService {

    @Autowired
    private RegistroOcorrenciaRepository repository;

    public RegistroOcorrenciaResponseDto cadastrar(RegistroOcorrenciaCreateDto dto) {
        RegistroOcorrencia ocorrencia = RegistroOcorrencia.builder()
            .tipoOcorrencia(dto.getTipoOcorrencia())
            .descricao(dto.getDescricao())
            .dataHora(dto.getDataHora())
            .localizacao(dto.getLocalizacao())
            .gravidade(dto.getGravidade())
            .build();
    
        repository.save(ocorrencia);
        return new RegistroOcorrenciaResponseDto(ocorrencia);
    }
    

    public List<RegistroOcorrenciaResponseDto> listar() {
        return repository.findAll().stream()
                .map(RegistroOcorrenciaResponseDto::new)
                .collect(Collectors.toList());
    }

    public RegistroOcorrenciaResponseDto atualizar(Long id, RegistroOcorrenciaUpdateDto dto) {
        RegistroOcorrencia ocorrencia = repository.findById(id).orElseThrow();
        ocorrencia.setTipoOcorrencia(dto.getTipoOcorrencia());
        ocorrencia.setDescricao(dto.getDescricao());
        ocorrencia.setDataHora(dto.getDataHora());
        ocorrencia.setLocalizacao(dto.getLocalizacao());
        ocorrencia.setGravidade(dto.getGravidade());
        repository.save(ocorrencia);
        return new RegistroOcorrenciaResponseDto(ocorrencia);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
