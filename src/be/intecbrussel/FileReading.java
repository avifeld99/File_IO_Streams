package be.intecbrussel;

import java.io.FileReader;
import java.io.IOException;

public class FileReading {

    public static void ReadTheFile() {

        FileReader fileReader = null;

        try {
            fileReader = new FileReader("myfolder/innerfolder/text.txt");
            int position;
            while ((position = fileReader.read()) != -1) {
                System.out.println((char) position);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
