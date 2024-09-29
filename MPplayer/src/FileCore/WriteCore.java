package FileCore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class WriteCore{
    public static void fileWrite(String path,String content) throws IOException {
        URL url = WriteCore.class.getResource(path);
        assert url != null;
        File file = new File(url.getPath().toUpperCase());
        if (!file.exists()) file.createNewFile();
        file.setWritable(true);
        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.close();
    }
}