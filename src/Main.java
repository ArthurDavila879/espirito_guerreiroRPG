import domain.Guerreiro;
import domain.InOut;
import domain.Oraculo;

public class Main {
    public static void main(String[] args) {
        String nome = InOut.leString("INSIRA SEU NOME");
        Guerreiro warrior = new Guerreiro();
        warrior.setNome(nome);
        Oraculo oraculo = new Oraculo();
        oraculo.setwarrior(warrior);
        oraculo.definirNome("Aethryon");
        oraculo.prologoIntroducao();
        oraculo.loadLevel01();
        if (oraculo.loadLevel01()) {
            warrior.ganharItem();
        }
        oraculo.loadLevel02();
        if (oraculo.loadLevel02()) {
            warrior.ganharItem();
        }
        oraculo.loadLevel03();
        if (!oraculo.loadLevel03()) {
            oraculo.prologoPerdedor();
        } else {
            oraculo.prologoVencedor();
        }
    }
}