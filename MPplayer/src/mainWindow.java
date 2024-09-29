import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import FileCore.*;

public class mainWindow {
    private JButton Last;
    private JButton SC;
    private JButton Next;
    private JPanel root1;
    private JLabel title;
    private JButton path;

    public static void window(){
        JFrame frame = new JFrame("MP-player");
        mainWindow mainWindow = new mainWindow();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,120);
        frame.setContentPane(mainWindow.root1);
        frame.setVisible(true);
        mainWindow.root1.setPreferredSize(new Dimension(200,400));
        //事件
        mainWindow.Last.addActionListener(_->{
            try {
                Main.player.close();
                Main.currentMusicNumber--;
                if (Main.currentMusicNumber < 0) Main.currentMusicNumber += Main.allFiles.length;
                Main.currentMusicFile = new File(Main.allFiles[Main.currentMusicNumber]);
                Main.player = MusicPlayCore.play(Main.currentMusicFile);
                Main.player.start();
                mainWindow.title.setText(Main.currentMusicFile.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mainWindow.Next.addActionListener(_->{
            try {
                Main.player.close();
                Main.currentMusicNumber++;
                if (Main.currentMusicNumber >= Main.allFiles.length) Main.currentMusicNumber = 0;
                Main.currentMusicFile = new File(Main.allFiles[Main.currentMusicNumber]);
                Main.player = MusicPlayCore.play(Main.currentMusicFile);
                Main.player.start();
                mainWindow.title.setText(Main.currentMusicFile.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mainWindow.SC.addActionListener(_->{
            mainWindow.title.setText(Main.currentMusicFile.getName());
            if (Main.isPlaying) {
                Main.player.stop();
                Main.isPlaying = false;
            } else {
                Main.player.start();
                Main.isPlaying = true;
            }
        });
        mainWindow.path.addActionListener(_-> {
            try {
                Main.player.close();
                Main.path = ReaderCore.getPath();
                Main.allFiles = ReaderCore.getFiles(Main.path, musicFile.WAV);
                Main.currentMusicNumber = 0;
                Main.currentMusicFile = new File(Main.allFiles[Main.currentMusicNumber]);
                Main.player = MusicPlayCore.play(Main.currentMusicFile);
                Main.player.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ArrayIndexOutOfBoundsException e){
                mainWindow.title.setText("No music here");
            }
        });
    }
}
