package br.senac.sp.batalha;

import java.util.Random;

public class Jogador {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;

    public Jogador(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String atacar(Jogador inimigo) {
        Random rand = new Random();
        int dano = ataque - inimigo.defesa;
        if (dano < 0) dano = 0;

        String msg;
        if (rand.nextInt(100) < 10) {
            dano *= 2;
            msg = "ATAQUE CRÍTICO! " + nome + " atacou " + inimigo.nome + " e causou " + dano + " de dano.";
        } else {
            msg = nome + " atacou " + inimigo.nome + " e causou " + dano + " de dano.";
        }
        inimigo.receberDano(dano);
        return msg;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public int getVida() {
        return this.vida;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getDefesa() {
        return this.defesa;
    }
}
