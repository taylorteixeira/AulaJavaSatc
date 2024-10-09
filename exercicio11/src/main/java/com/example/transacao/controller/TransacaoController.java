package com.example.transacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.transacao.dto.ContaDTO;
import com.example.transacao.dto.TransacaoRequestDTO;
import com.example.transacao.dto.TransacaoResponseDTO;
import com.example.transacao.mapper.ContaMapper;
import com.example.transacao.modelo.Conta;
import com.example.transacao.modelo.Transacao;
import com.example.transacao.servico.TransacoesService;

@RestController
public class TransacaoController {
    @Autowired
    private TransacoesService transacoesService;

    @PostMapping("/transacao")
    public ResponseEntity<TransacaoResponseDTO> realizarTransacao(@RequestBody TransacaoRequestDTO request) {
        Conta origem = transacoesService.getContaByCodigo(request.getOrigem());
        Conta destino = transacoesService.getContaByCodigo(request.getDestino());

        if (origem == null || destino == null) {
            return ResponseEntity.badRequest().build();
        }

        Transacao transacao = new Transacao(origem, destino, request.getValor());
        origem.setSaldo(origem.getSaldo() - request.getValor());
        destino.setSaldo(destino.getSaldo() + request.getValor());

        ContaDTO origemDTO = ContaMapper.toDTO(origem);
        ContaDTO destinoDTO = ContaMapper.toDTO(destino);

        TransacaoResponseDTO response = new TransacaoResponseDTO(origemDTO, destinoDTO, request.getValor());

        return ResponseEntity.ok(response);
    }
}