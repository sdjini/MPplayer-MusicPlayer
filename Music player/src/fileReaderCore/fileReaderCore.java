package fileReaderCore;

import java.io.File;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class fileReaderCore{
    public static String getPath(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int _ = fileChooser.showOpenDialog(null);
        String path = fileChooser.getSelectedFile().getPath();
        System.out.println(path);
        return path;
    }
    public static File getFile(String path){
        return new File(path);
    }
    public static String[] getFiles(String path,String endsName) {
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) return new String[0];
        File[] files = directory.listFiles();
        if (files == null) return new String[0];
        List<String> filesPath = new ArrayList<>();
        for (File file : files) if (file.isFile() && file.getName().toLowerCase().endsWith(endsName)) filesPath.add(file.getAbsolutePath());
        String[] All = filesPath.toArray(new String[0]);
        System.out.println(Arrays.toString(All));
        return All;
    }
}