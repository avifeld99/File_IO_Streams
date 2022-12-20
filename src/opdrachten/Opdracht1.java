package opdrachten;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Opdracht1 {

    /*
    Maak een programma dat een stukje tekst wegschrijft naar een bestand.
    Gebruik hierbij de `try-with-resources` om het correct af te sluiten.
    Schrijf daarna een programma dat het bestand kan lezen.
    */

    public static void writeInFile() {

        Path path = Path.of("myfolder/innerfolder/mytry.txt");

        try {
            Files.createDirectories(path.getParent());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(path.toFile());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("how are you? \n");
            bufferedWriter.write("thnx, reasonable");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void readInFile() {

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("myfolder/innerfolder/mytry.txt"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
