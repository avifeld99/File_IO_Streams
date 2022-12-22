package objects_read_write.opdracht;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MessageFile {

    public static void createFiles() {

        Path path = Path.of("./FromAviToJoey/message.txt");

        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(path.toFile());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("hou je van water?");
            bufferedWriter.write("\nleuk, dan hou je al van 70% van mij");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(path.toFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                System.out.println(lines);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
