package com.github.fiap.smartcity_trafego.controller;

import com.github.fiap.smartcity_trafego.dto.RegistroOcorrenciaCreateDto;
import com.github.fiap.smartcity_trafego.dto.RegistroOcorrenciaResponseDto;
import com.github.fiap.smartcity_trafego.dto.RegistroOcorrenciaUpdateDto;
import com.github.fiap.smartcity_trafego.service.RegistroOcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro-ocorrencia")
public class RegistroOcorrenciaController {

    @Autowired
    private RegistroOcorrenciaService service;

    @PostMapping
    public RegistroOcorrenciaResponseDto cadastrar(@RequestBody RegistroOcorrenciaCreateDto dto) {
        return service.cadastrar(dto);
    }

    @GetMapping
    public List<RegistroOcorrenciaResponseDto> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public RegistroOcorrenciaResponseDto atualizar(@PathVariable Long id, @RequestBody RegistroOcorrenciaUpdateDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
