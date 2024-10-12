package com.example.transacao.mapper;

import com.example.transacao.dto.ContaDTO;
import com.example.transacao.model.Conta;

public class ContaMapper {

    public static ContaDTO toContaDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
