package com.github.fiap.smartcity_trafego.controller;

import com.github.fiap.smartcity_trafego.dto.RegistroTrafegoCreateDto;
import com.github.fiap.smartcity_trafego.dto.RegistroTrafegoResponseDto;
import com.github.fiap.smartcity_trafego.dto.RegistroTrafegoUpdateDto;
import com.github.fiap.smartcity_trafego.service.RegistroTrafegoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro-trafego")
@RequiredArgsConstructor
public class RegistroTrafegoController {

    private final RegistroTrafegoService service;

    @PostMapping
    public ResponseEntity<RegistroTrafegoResponseDto> cadastrar(@RequestBody @Valid RegistroTrafegoCreateDto dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<RegistroTrafegoResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroTrafegoResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroTrafegoResponseDto> atualizar(@PathVariable Long id, @RequestBody RegistroTrafegoUpdateDto dto) {
        return service.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
