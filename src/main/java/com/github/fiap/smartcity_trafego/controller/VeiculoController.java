package com.github.fiap.smartcity_trafego.controller;

import com.github.fiap.smartcity_trafego.dto.VeiculoCreateDto;
import com.github.fiap.smartcity_trafego.dto.VeiculoResponseDto;
import com.github.fiap.smartcity_trafego.dto.VeiculoUpdateDto;
import com.github.fiap.smartcity_trafego.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<VeiculoResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public VeiculoResponseDto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public VeiculoResponseDto cadastrar(@RequestBody VeiculoCreateDto dto) {
        return service.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public VeiculoResponseDto atualizar(@PathVariable Long id, @RequestBody VeiculoUpdateDto dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
