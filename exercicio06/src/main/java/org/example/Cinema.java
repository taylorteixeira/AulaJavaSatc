package org.example;

import java.util.ArrayList;
import java.util.List;

class Cinema {
    List<Filme> filmesDisponiveis = new ArrayList<>();
    List<Ingresso> ingressosVendidos = new ArrayList<>();

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public void venderIngresso(Ingresso ingresso) throws Exception {
        // Verifica se o assento já está ocupado
        for (Ingresso ingressoVendido : ingressosVendidos) {
            if (ingressoVendido.filme.equals(ingresso.filme) &&
                    ingressoVendido.assento.equals(ingresso.assento)) {
                throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
            }
        }

        // Verifica se a idade do cliente atende à restrição do filme
        if (ingresso.cliente.idade < ingresso.filme.idadeMinima) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        ingressosVendidos.add(ingresso);
        System.out.println("Ingresso vendido com sucesso! " + ingresso.filme.nome + " - " +
                ingresso.assento + " - " + ingresso.cliente.nome);
    }
}