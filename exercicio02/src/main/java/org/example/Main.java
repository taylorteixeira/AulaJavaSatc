package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Criando a lista de inimigos
        List<Personagem> inimigos = new ArrayList<>();
        inimigos.add(new Personagem("Orc", 100, 10));
        inimigos.add(new Personagem("Goblin", 50, 5));
        inimigos.add(new Personagem("Lobo", 75, 15));

        Personagem jogador = new Personagem("Steve", 100, 20);

        Random random = new Random();
        while (jogador.getVida() > 0 && !inimigos.isEmpty()) {
            // Jogador ataca um inimigo aleatório
            int indiceInimigo = random.nextInt(inimigos.size());
            Personagem inimigo = inimigos.get(indiceInimigo);
            if (inimigo.getVida() > 0) {
                jogador.atacar(inimigo);
                if (inimigo.getVida() <= 0) {
                    System.out.println(inimigo.getNome() + " foi derrotado!");
                    inimigos.remove(indiceInimigo);
                }
            }

            // Inimigos atacam o jogador
            for (int i = 0; i < inimigos.size(); i++) {
                Personagem inimigoAtual = inimigos.get(i);
                if (inimigoAtual.getVida() > 0) {
                    inimigoAtual.atacar(jogador);
                }
            }
        }

        // Imprime o resultado final
        if (jogador.getVida() <= 0) {
            System.out.println(jogador.getNome() + " foi derrotado!");
        } else {
            System.out.println("Você venceu! Todos os inimigos foram derrotados.");
        }
    }
}