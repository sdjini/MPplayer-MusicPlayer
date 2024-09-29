import FileCore.ReaderCore;
import FileCore.musicFile;

import javax.sound.sampled.Clip;
import java.io.File;

public class Main {
    public static Clip player;
    public static int currentMusicNumber = 0;
    public static File currentMusicFile;
    public static boolean isPlaying = false;
    public static String path;
    public static String[] allFiles;
    public static void main(String[] args) {
        mainWindow.window();
        path = ReaderCore.getPath();
        allFiles = ReaderCore.getFiles(path, musicFile.WAV);
        currentMusicFile = new File(allFiles[currentMusicNumber]);
    }
}