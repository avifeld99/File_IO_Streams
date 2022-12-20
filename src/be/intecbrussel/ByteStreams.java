package be.intecbrussel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class ByteStreams {

    public static void WriteWithByte() {

        Path path = Path.of("myfolder/innerfolder/myfile.txt");
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream
                (new FileInputStream(path.toString()))){
            int c;
            while ((c = bufferedInputStream.read()) != -1) {
                System.out.println(c);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
