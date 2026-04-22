import domain.*;

public class Main {
    public static void main(String[] args) {
        Oraculo oraculo = new Oraculo();
        new Thread(() -> SoundUtils.play("resources/audio/som.wav")).start();
        oraculo.game();
        oraculo.game();
    }
}