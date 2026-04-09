package domain;

import java.util.Random;

public class Oraculo {
    private String nome;
    private Guerreiro warrior;


    public void definirNome(String nome){
        this.nome = nome;
    }

    public void prologoIntroducao(){
       String mensagem = "Ola guerreiro "+warrior.getNome();
        InOut.MsgDeInformacao("Introdução", mensagem);
        InOut.MsgDeInformacao("Introdução","Sou o oraculo "+this.nome);
        InOut.MsgDeInformacao("Introdução","Sua vida atual é "+warrior.getQtdVida());
    }
    public void prologoPerdedor(){
        InOut.MsgDeInformacao("PÁRABENS ", warrior.getNome() + "Ao ser derrotado pelo Oráculo, você provou que não é digno de se tornar meu sucessor como Oráculo Master");
    }
    public void prologoVencedor(){
        InOut.MsgDeInformacao("PÁRABENS ", warrior.getNome() + "Ao derrotar o Oráculo, provaste teu valor e és digno de tomar meu lugar como o novo Oráculo Master");
    }

    public boolean loadLevel01(){
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


        return true;
    }
    public boolean loadLevel02(){
    String charada1 = "nuvem";
    InOut.MsgDeInformacao("Charada",warrior.getNome()+"Agora você ira tentar advinhar uma charada");
    String resposta1 = "";
    
    while(!(charada1.equals(resposta1))) {
        resposta1 = InOut.leString("Oque é oque é, anda sem pernas e chora sem olhos?");
        if (charada1.equals(resposta1)) {
            InOut.MsgDeInformacao("Charada", "Parabens você acertou a primeira charada");
        } else {
            InOut.MsgDeAviso("Charada", "Errou");
            warrior.setQtdVida(warrior.getQtdVida() - 1);
        }
    }
    return true;
    }
    public boolean decidirVidaExtra(String frase){
        if(warrior.vidaExtra().length() < 5){
            return false;
        }
        return true;
    }
    public boolean loadLevel03(){
        String nomeBoss;
        int vidaBoss;
        int danoBoss;
        danoBoss = 37;
        vidaBoss = 30;
        nomeBoss = "Cryptoros, o Oráculo das Respostas Impossíveis";
        InOut.MsgDeInformacao("BOSS FIGHT", "O boss: Cryptoros, o Oráculo das Respostas Impossíveis ressurgiu\n" + danoBoss + " De dano\n" + vidaBoss + " De vida");
        if(warrior.getQtdVida() < danoBoss){
            InOut.MsgDeAviso("DERROTA", "Você perdeu para o verdadeiro Oráculo");
            return false;
        }
        else if(warrior.getQtdVida() == danoBoss && warrior.getDanoWarrior() == vidaBoss) {
            InOut.MsgDeAviso("EMPATE", "Os dois oráculos previram o mesmo fim — e, ao fazê-lo, anularam seus destinos em um empate inevitável.");
            return true;
        }
        else{
            InOut.MsgDeAviso("VITÓRIA", "Ao transcender todas as previsões, você supera o impossível e ascende como o Oráculo Master, soberano absoluto do destino.");
            return true;
        }
    }

    public void setwarrior(Guerreiro warrior) {
        this.warrior = warrior;
    }
}

