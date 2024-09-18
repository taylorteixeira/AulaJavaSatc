package org.example;

public class Main {
    public static void main(String[] args) {
        // Criar barcos
        Barco barco1 = new Barco("Barco 1", 2);
        Barco barco2 = new Barco("Barco 2", 5);
        Barco barco3 = new Barco("Barco 3", 7);
        Barco barco4 = new Barco("Barco 4", 12);
        Barco barco5 = new Barco("Barco 5", 20);

        // Criar portos
        PortoPequeno portoPequeno = new PortoPequeno("porto pequeno");
        PortoGrande portoGrande = new PortoGrande("porto grande");

        // Tentar atracar os barcos no porto pequeno primeiro
        portoPequeno.atracarBarco(barco1);
        portoPequeno.atracarBarco(barco2);
        portoPequeno.atracarBarco(barco3);
        portoPequeno.atracarBarco(barco4);
        portoPequeno.atracarBarco(barco5);

        // Se não couberem no porto pequeno, tentar no porto grande
        portoGrande.atracarBarco(barco4);
        portoGrande.atracarBarco(barco5);
    }
}