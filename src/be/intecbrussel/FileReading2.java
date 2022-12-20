package be.intecbrussel;

import java.io.FileReader;
import java.io.IOException;

public class FileReading2 {

    public static void ReadTheFile() {

        // try with resources, no finally needed to close with fileReader.close
        try (FileReader fileReader = new FileReader("myfolder/innerfolder/text.txt")) {
            int position;
            while ((position = fileReader.read()) != -1) {
                System.out.println((char) position);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
