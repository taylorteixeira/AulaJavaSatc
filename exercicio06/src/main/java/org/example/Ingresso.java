package org.example;

class Ingresso {
    Cliente cliente;
    Filme filme;
    String assento;

    public Ingresso(Cliente cliente, Filme filme, String assento) {
        this.cliente = cliente;
        this.filme = filme;
        this.assento = assento;
    }
}