package org.example;

import java.util.Scanner;

public class Recommendation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que ambientação você prefere?");
        System.out.println("1. Sci-fi");
        System.out.println("2. Medieval");

        int ambientacao = scanner.nextInt();

        System.out.println("Que gênero você prefere?");
        System.out.println("1. Comédia");
        System.out.println("2. Drama");

        int genero = scanner.nextInt();

        if (ambientacao == 1 && genero == 1) {
            System.out.println("Recomendamos a série 'Arrival'.");
        } else if (ambientacao == 1 && genero == 2) {
            System.out.println("Recomendamos o filme 'Gladiator'.");
        } else if (ambientacao == 2 && genero == 1) {
            System.out.println("Recomendamos o filme 'Shrek'.");
        } else if (ambientacao == 2 && genero == 2) {
            System.out.println("Recomendamos o filme 'Homens de Preto'.");
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}