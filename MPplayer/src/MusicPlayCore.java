import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayCore {
    public static Clip play(File currentMusic) throws IOException {
        try{
            AudioInputStream AIS = AudioSystem.getAudioInputStream(currentMusic);
            Clip clip = AudioSystem.getClip();
            clip.open(AIS);
            return clip;
        } catch (LineUnavailableException | UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }
    }
}