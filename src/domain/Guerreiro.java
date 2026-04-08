package domain;

import java.util.Random;

public class Guerreiro {
    private String nome;
    private int qtdVida;
    private Bolsa myBolsa;


    public Guerreiro(){}
    public Guerreiro(String nome, int qtdVida, Bolsa myBolsa) {
        this.nome = nome;
        this.qtdVida = qtdVida;
        this.myBolsa = myBolsa;
    }

    public int sortearVidas(){
        Random random = new Random();
        this.qtdVida = random.nextInt(4) + 9;
        return this.qtdVida;
    }
    public String vidaExtra(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdVida() {
        return qtdVida;
    }

    public void setQtdVida(int qtdVida) {
        this.qtdVida = qtdVida;
    }

    public Bolsa getMyBolsa() {
        return myBolsa;
    }

    public void setMyBolsa(Bolsa myBolsa) {
        this.myBolsa = myBolsa;
    }
}
