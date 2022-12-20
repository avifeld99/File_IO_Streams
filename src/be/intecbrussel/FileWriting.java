package be.intecbrussel;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriting {

    public static void writeToFile() {

        FileWriter fileWriter = null;

        try {
            Path path = Path.of("myfolder/innerfolder/text.txt");

            Files.createDirectories(path.getParent());

            fileWriter = new FileWriter(path.toString());
            fileWriter.write("Hi my name is Avi \n");
            fileWriter.write("bye");
        }
        catch (IOException ioe) {
            throw new RuntimeException();
        }
        finally {
            if (fileWriter != null) {

                try {
                    fileWriter.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }



















    /*public static void main(String[] args) {

        FileWriter fileWriter = null;
        try {
            Path path = Path.of("myfolder/innerfolder/myfile.txt");
            fileWriter = new FileWriter(path.toString());
            fileWriter.write("Hi\n");
            fileWriter.write("Hallo\n");
            fileWriter.write("Bonjour\n");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }*/


}
