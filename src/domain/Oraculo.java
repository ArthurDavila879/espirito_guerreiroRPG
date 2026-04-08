package domain;

import java.util.Random;

public class Oraculo {
    private String nome;
    private Guerreiro warrior;


    public void definirNome(String nome){
        this.nome = nome;
    }

    public String prologoIntroducao(){

        Random random = new Random();
        int segredo = random.nextInt(101);
        boolean acertou = false;
        InOut.MsgDeInformacao("Oráculo","Um número secreto foi definido (1 a 100), acerte ou perca vida");
        do {
            int palpite = InOut.leInt("Insira seu palpite");
            if (palpite > segredo) {
                InOut.MsgDeAviso("Aviso","Palpite é maior que o segredo");
                warrior.setQtdVida(warrior.getQtdVida()-1);
            }
            else if (palpite <segredo) {
                InOut.MsgDeAviso("Aviso","Palpite é menor que o segredo");
                warrior.setQtdVida(warrior.getQtdVida()-1);
            }
            else if (palpite == segredo){
                acertou = true;

            }
        }while (!acertou);

        return "Número secreto "+segredo+ " foi acertado, parabens. Sua vida atual é "+warrior.getQtdVida();
    }
    public String prologoPerdedor(){}
    public String prologoVencedor(){}
    public boolean loadLevel01(){}
    public boolean loadLevel02(){}
    public boolean decidirVidaExtra(String frase){}
}
