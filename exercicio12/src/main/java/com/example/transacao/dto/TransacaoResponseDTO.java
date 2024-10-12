package com.example.transacao.dto;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {}
