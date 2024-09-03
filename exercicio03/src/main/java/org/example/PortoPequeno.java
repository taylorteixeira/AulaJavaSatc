package org.example;

class PortoPequeno extends BasePorto {
    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println("Barco " + barco.nome + " muito grande para o porto pequeno.");
        }
    }
}