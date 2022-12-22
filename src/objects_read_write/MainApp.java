package objects_read_write;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainApp {
    public static void main(String[] args) {

        Person person1 = new Person("Avi", 33);
        Person person2 = new Person("Harry", 7);
        Person person3 = new Person("Mia", 18);

        Path path = Paths.get("myfolder/innerfolder/myfile.txt");
        // File file = path.toFile(); //niet nodig om file aan te maken

        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        // Niet nodig, de writer doet het al
        /*
        try {
            file.createNewFile();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        */



        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("myfolder/innerfolder/myfile.txt"))) {
            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(person2);
            objectOutputStream.writeObject(person3);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("myfolder/innerfolder/myfile.txt"))) {

            Person someone = (Person) objectInputStream.readObject();
            System.out.println(someone);

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();

        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("myfolder/innerfolder/myfile.txt"))) {

            //Files.walk(path, )???

            Person someone;
            while ((someone = (Person) objectInputStream.readObject()) != null) {
                System.out.println(someone);
            }
        } catch (EOFException eofException) {
            System.out.println("Reached the end of the file.");
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
