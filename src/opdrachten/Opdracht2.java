package opdrachten;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Opdracht2 {

    // Maak de buffreader/ writer dynamischer met een scanner.

    public static void writeWithScan() {

        Path path = Path.of("myfolder/innerfolder/mytry.txt");

        try {
            Files.createDirectories(path.getParent());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(path.toFile());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("please enter your 2 text for the file: ");
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            bufferedWriter.write(line1 + "\n");
            bufferedWriter.write(line2);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void readWithScan() {

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("myfolder/innerfolder/mytry.txt"));

            System.out.println("The input of text you entered in the file is: ");
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
