package be.intecbrussel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuffReader {

    public static void readWithBuff() {

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("myfolder/innerfolder/myfile.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
