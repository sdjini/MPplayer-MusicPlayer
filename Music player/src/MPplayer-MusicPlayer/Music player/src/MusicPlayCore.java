import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayCore {
    public static void play(int currentMusic) throws IOException {
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(Main.files[currentMusic]));
            Main.player = AudioSystem.getClip();
            Main.player.open(audioStream);
            Main.isPlaying = true;
            Main.player.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
    }
}
