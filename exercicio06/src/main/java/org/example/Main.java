package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();

        // Adicionando filmes disponíveis
        cinema.adicionarFilme(new Filme("Homen Aranha", 20.0, 12));
        cinema.adicionarFilme(new Filme("Duna", 25.0, 16));
        cinema.adicionarFilme(new Filme("Matrix", 18.0, 14));
        cinema.adicionarFilme(new Filme("Encanto", 15.0, 0));
        cinema.adicionarFilme(new Filme("O Poderoso Chefão", 22.0, 18));

        // Loop para vender ingressos
        while (true) {
            System.out.print("Que filme você deseja assistir? ");
            String nomeFilme = scanner.nextLine();

            Filme filmeEscolhido = null;
            for (Filme filme : cinema.filmesDisponiveis) {
                if (filme.nome.equalsIgnoreCase(nomeFilme)) {
                    filmeEscolhido = filme;
                    break;
                }
            }

            if (filmeEscolhido == null) {
                System.out.println("Filme não encontrado.");
                continue;
            }

            System.out.print("Qual assento você deseja? (Ex: A1) ");
            String assento = scanner.nextLine().toUpperCase();

            System.out.print("Qual o seu nome? ");
            String nomeCliente = scanner.nextLine();

            int idadeCliente = 0;
            while (true) {
                try {
                    System.out.print("Qual a sua idade? ");
                    idadeCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    break;
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Idade inválida. Digite um número inteiro.");
                }
            }

            Cliente cliente = new Cliente(nomeCliente, idadeCliente);
            Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);

            try {
                cinema.venderIngresso(ingresso);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}