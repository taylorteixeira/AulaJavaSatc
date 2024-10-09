package com.example.transacao.mapper;

import com.example.transacao.dto.ContaDTO;
import com.example.transacao.modelo.Conta;

public class ContaMapper {
    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }

    public static Conta toEntity(ContaDTO contaDTO) {
        return new Conta(contaDTO.getCodigo(), contaDTO.getCliente(), 0.0);
    }
}