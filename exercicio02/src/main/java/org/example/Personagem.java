package org.example;

class Personagem {
    private String nome;
    private int vida;
    private int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida <= 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }

    public void atacar(Personagem alvo) {
        if (alvo.getVida() > 0) {
            System.out.println(this.nome + " atacou " + alvo.getNome());
            alvo.receberDano(this.ataque);
        } else {
            System.out.println(this.nome + " tentou atacar " + alvo.getNome() + ", mas ele já estava derrotado.");
        }
    }
}