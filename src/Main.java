import domain.*;

public class Main {
    public static void main(String[] args) {
        String nome = InOut.leString("INSIRA SEU NOME");
        Guerreiro warrior = new Guerreiro();
        Oraculo oraculo = new Oraculo();
        Bolsa bolsa = new Bolsa();
        Item item = new Item();

        warrior.setNome(nome);
        oraculo.definirNome("Aethryon");

        oraculo.setwarrior(warrior);
        warrior.setMyBolsa(bolsa);




        oraculo.prologoIntroducao();
        if(oraculo.loadLevel01()){
            warrior.ganharItem();
        }

        else if (warrior.getQtdVida()==0){
            oraculo.prologoPerdedor();
        }

        if (oraculo.loadLevel02()) {
            warrior.ganharItem();
        }
        oraculo.loadLevel03();
        if (!oraculo.loadLevel03()) {
            oraculo.prologoPerdedor();
        }
        else if (warrior.getQtdVida()==0){
            oraculo.prologoPerdedor();
        }
        else {
            oraculo.prologoVencedor();
        }
    }
}