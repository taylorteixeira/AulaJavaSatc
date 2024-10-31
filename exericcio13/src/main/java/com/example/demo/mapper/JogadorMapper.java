package com.example.demo.mapper;

import com.example.demo.dto.JogadorDTO;
import com.example.demo.model.Jogador;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {
    public Jogador toEntity(JogadorDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setNome(dto.getNome());
        jogador.setApelido(dto.getApelido());
        jogador.setHabilidade(100); // Valor fixo
        return jogador;
    }

    public JogadorDTO toDTO(Jogador jogador) {
        JogadorDTO dto = new JogadorDTO();
        dto.setNome(jogador.getNome());
        dto.setApelido(jogador.getApelido());
        return dto;
    }
}
