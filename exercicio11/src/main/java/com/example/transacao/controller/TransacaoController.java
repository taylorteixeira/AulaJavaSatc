package com.example.transacao.controller;

import com.example.transacao.dto.ContaDTO;
import com.example.transacao.dto.TransacaoRequestDTO;
import com.example.transacao.dto.TransacaoResponseDTO;
import com.example.transacao.mapper.ContaMapper;
import com.example.transacao.model.Transacao;
import com.example.transacao.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO transacaoRequest) {
        Transacao transacao = transacoesService.gerarTransacao(transacaoRequest);

        ContaDTO origemDTO = ContaMapper.toContaDTO(transacao.getOrigem());
        ContaDTO destinoDTO = ContaMapper.toContaDTO(transacao.getDestino());

        return new TransacaoResponseDTO(origemDTO, destinoDTO, transacao.getValor());
    }
}
