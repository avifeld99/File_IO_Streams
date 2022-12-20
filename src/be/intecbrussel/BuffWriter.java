package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BuffWriter {

    public static void writeWithBuff() {

        try {
            Path path = Path.of("myfolder/innerfolder/myfile.txt");
            Files.createDirectories(path.getParent());
        }
        catch (IOException ioe) {
            throw new RuntimeException();
        }

        try (FileWriter fileWriter = new FileWriter("myfolder/innerfolder/myfile.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("Hi, It's me!\n");
            bufferedWriter.write("Bonjour!");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
