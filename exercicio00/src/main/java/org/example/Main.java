package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                while(true) {
                        //String[] elementos = {"Água", "Fogo", "Ar", "Terra",...}
                        String[] vetorElementos = new String[4];
                        vetorElementos[0] = "Água";
                        vetorElementos[1] = "Fogo";
                        vetorElementos[2] = "Ar";
                        vetorElementos[3] = "Terra";

                        Scanner leitor = new Scanner(System.in);

                        System.out.println("Digite o Primeiro Nome: ");
                        String firstName = leitor.nextLine();

                        if(firstName == "") return;

                        System.out.println("Digite o Segundo Nome: ");
                        String secondName = leitor.nextLine();

                        Random geradorAleatorio = new Random();
                        Integer numAleatorio = geradorAleatorio.nextInt(100);
                        Integer indiceAleatorio = geradorAleatorio.nextInt(4);
                        String elemento = vetorElementos[indiceAleatorio];

                        System.out.println(elemento + firstName + secondName + numAleatorio);
                }
        }
}