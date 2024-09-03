package org.example;

class PortoGrande extends BasePorto {
    public PortoGrande(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.tamanho >= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println("Barco " + barco.nome + " muito pequeno para o porto grande.");
        }
    }
}