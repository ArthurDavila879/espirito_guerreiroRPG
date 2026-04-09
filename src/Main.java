import domain.*;

public class Main {
    public static void main(String[] args) {
        String nome = InOut.leString("INSIRA SEU NOME");
        Guerreiro warrior = new Guerreiro();
        Oraculo oraculo = new Oraculo();
        Bolsa bolsa = new Bolsa();

        warrior.setNome(nome);
        oraculo.definirNome("Aethryon");

        oraculo.setwarrior(warrior);
        warrior.setMyBolsa(bolsa);

        oraculo.prologoIntroducao();

        if (!oraculo.loadLevel01()) {
            oraculo.prologoPerdedor();
            return;
        }
        warrior.ganharItem();

        if (!oraculo.loadLevel02()) {
            oraculo.prologoPerdedor();
            return;
        }
        warrior.ganharItem();

        if (!oraculo.loadLevel03()) {
            oraculo.prologoPerdedor();
            return;
        }

        oraculo.prologoVencedor();
    }
}
