package org.example;

import java.util.ArrayList;

class BasePorto {
    String nome;
    ArrayList<Barco> barcosAtracados = new ArrayList<>();

    public BasePorto(String nome) {
        this.nome = nome;
    }

    public void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println("Barco " + barco.nome + " atracado no " + this.nome);
    }

    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
        System.out.println("Barco " + barco.nome + " desatracado do " + this.nome);
    }
}