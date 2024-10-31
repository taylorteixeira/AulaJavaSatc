package com.example.demo.controller;

import com.example.demo.dto.JogadorDTO;
import com.example.demo.mapper.JogadorMapper;
import com.example.demo.model.Jogador;
import com.example.demo.repository.JogadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorMapper jogadorMapper;

    @PostMapping
    public ResponseEntity<JogadorDTO> criarJogador(@Valid @RequestBody JogadorDTO jogadorDTO) {
        Jogador jogador = jogadorMapper.toEntity(jogadorDTO);
        jogador = jogadorRepository.save(jogador);
        return ResponseEntity.ok(jogadorMapper.toDTO(jogador));
    }

    @GetMapping
    public ResponseEntity<List<JogadorDTO>> listarJogadores() {
        List<JogadorDTO> jogadores = jogadorRepository.findAll()
                .stream()
                .map(jogadorMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(jogadores);
    }
}
