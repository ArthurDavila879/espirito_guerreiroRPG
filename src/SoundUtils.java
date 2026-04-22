import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundUtils {
    public static void play(String path) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    SoundUtils.class.getResource(path)
            );
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}