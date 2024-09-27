import fileReaderCore.*;
import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class Main {

    public static int currentMusic = 0;
    public static String path;
    public static String[] files;
    static boolean isPlaying;
    static Clip player;
    public static void main(String[] Args) throws IOException {
        path = fileReaderCore.getPath();
        files = fileReaderCore.getFiles(path, musicFile.WAV);

        JFrame root1 = new JFrame("超级牛逼无敌宇宙霹雳金刚不坏音乐播放器");
        root1.setVisible(true);
        root1.setSize(400, 200);
        root1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root1.setLayout(new GridLayout(2,4));
        //root1

        JPanel root2 = new JPanel();
        root1.add(root2);
        root2.setLayout(new GridLayout(1, 1));
        JLabel r2Text = new JLabel("r2Text:Name");
        root2.add(r2Text);
        //root2

        JPanel root3 = new JPanel();
        root1.add(root3);
        root3.setLayout(new GridLayout(1,4));
        root3.setSize(root3.getWidth(), 50);

        MyMusicControlButton BLast = new MyMusicControlButton("");
        BLast.setImage("C:\\Users\\lyxyz5223\\Desktop\\MPplayer-MusicPlayer-main\\Music player\\src\\src\\music_beginning_button.png");
        MyMusicControlButton BControl = new MyMusicControlButton("");
        BControl.setImage("C:\\Users\\lyxyz5223\\Desktop\\MPplayer-MusicPlayer-main\\Music player\\src\\src\\music_play_button.png");
        BControl.setSquareEdgeLength(100);
        MyMusicControlButton BNext = new MyMusicControlButton("");
        BNext.setImage("C:\\Users\\lyxyz5223\\Desktop\\MPplayer-MusicPlayer-main\\Music player\\src\\src\\music_end_button.png");
        MyMusicControlButton BSetting = new MyMusicControlButton("");
        BSetting.setImage("C:\\Users\\lyxyz5223\\Desktop\\MPplayer-MusicPlayer-main\\Music player\\src\\src\\music_mixer.png");
        root3.add(BLast);
        root3.add(BControl);
        root3.add(BNext);
        root3.add(BSetting);
        //buttons
        BLast.addActionListener(_ -> {
            try {
                BLast();
                labelSet(r2Text, files[currentMusic]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        BNext.addActionListener(_ -> {
            try {
                BNext();
                labelSet(r2Text, files[currentMusic]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        BControl.addActionListener(_ -> {
            try {
                BControl(isPlaying);
                labelSet(r2Text, files[currentMusic]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        BSetting.addActionListener(_ -> {
            try {
                BSetting();
                labelSet(r2Text, files[currentMusic]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //ActionListener

        //root3
        //UI
        isPlaying = true;
        try{
            MusicPlayCore.play(currentMusic);
            labelSet(r2Text,files[currentMusic]);
        } catch (ArrayIndexOutOfBoundsException e) {
            labelSet(r2Text,"Error: No music file.");
            isPlaying = false;
        }

    }


    static void BLast() throws IOException {

        player.close();
        currentMusic--;
        if (currentMusic < 0) currentMusic = files.length - 1;
        MusicPlayCore.play(currentMusic);
    }

    static void BNext() throws IOException {
        player.close();
        currentMusic++;
        if (currentMusic >= files.length) currentMusic = 0;
        MusicPlayCore.play((currentMusic));
    }

    static void BControl(boolean isPlaying) throws IOException {
        if (isPlaying) {
            Main.isPlaying = false;
            player.stop();
            System.out.println("Try stop");
        } else {
            Main.isPlaying = true;
            player.start();
            System.out.println("Try start");
        }
    }

    static void BSetting() throws IOException {
        Main.path = fileReaderCore.getPath();
        Main.files = fileReaderCore.getFiles(Main.path, musicFile.WAV);
        MusicPlayCore.play(currentMusic);
    }

    static void labelSet(JLabel label,String text){
        label.setText(text);
    }
}
