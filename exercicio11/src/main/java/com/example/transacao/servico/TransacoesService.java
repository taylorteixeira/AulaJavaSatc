package com.example.transacao.servico;

import java.util.ArrayList;
import java.util.List;

import com.example.transacao.modelo.Conta;

public class TransacoesService {
    private List<Conta> contas = new ArrayList<>();

    public void init() {
        Conta conta1 = new Conta("500-1", "Fulano", 1000.0);
        Conta conta2 = new Conta("320-2", "Ciclano", 500.0);
        contas.add(conta1);
        contas.add(conta2);
    }

    public Conta getContaByCodigo(String codigo) {
        for (Conta conta : contas) {
            if (conta.getCodigo().equals(codigo)) {
                return conta;
            }
        }
        return null;
    }
}