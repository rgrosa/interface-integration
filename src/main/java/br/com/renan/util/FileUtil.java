package br.com.renan.util;


import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

@Component
public class FileUtil {

    public static String readFile(File file) throws FileNotFoundException {

        FileInputStream stream = new FileInputStream(file);
        String fileResult = null;
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            fileResult = Charset.defaultCharset().decode(bb).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileResult;
    }

}
