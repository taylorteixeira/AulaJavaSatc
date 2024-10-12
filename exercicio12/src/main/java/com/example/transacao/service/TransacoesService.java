package com.example.transacao.service;

import com.example.transacao.dto.TransacaoRequestDTO;
import com.example.transacao.model.Conta;
import com.example.transacao.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {

    private final List<Conta> contas = new ArrayList<>();

    public TransacoesService() {
        contas.add(new Conta("500-1", "Fulano", 1000.0));
        contas.add(new Conta("320-2", "Ciclano", 2000.0));
    }

    public Conta buscarContaPorCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public Transacao gerarTransacao(TransacaoRequestDTO transacaoRequest) {
        Conta origem = buscarContaPorCodigo(transacaoRequest.origem());
        Conta destino = buscarContaPorCodigo(transacaoRequest.destino());

        if (origem.getSaldo() < transacaoRequest.valor()) {
            throw new RuntimeException("Saldo insuficiente");
        }

        origem.setSaldo(origem.getSaldo() - transacaoRequest.valor());
        destino.setSaldo(destino.getSaldo() + transacaoRequest.valor());

        return new Transacao(origem, destino, transacaoRequest.valor());
    }
}
