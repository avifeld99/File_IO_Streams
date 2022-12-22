package objects_read_write.opdracht;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainApp {
    public static void main(String[] args) {

        MessageFile.createFiles();

        //------------------------------------------------------------

        Panda panda01 = new Panda("Harry", false);
        Panda panda02 = new Panda("Barry", false);
        Panda panda03 = new Panda("Sally", false);

        Path path = Path.of("./FromAviToJoey/animal.txt");

        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("./FromAviToJoey/animal.txt"))) {
            objectOutputStream.writeObject(panda01);
            objectOutputStream.writeObject(panda02);
            objectOutputStream.writeObject(panda03);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("./FromAviToJoey/animal.txt"))) {

            Panda panda;
            while ((panda = (Panda) objectInputStream.readObject()) != null) {
                System.out.println(panda);
            }
        }
        catch (EOFException eofe) {
            System.out.println("end of file reached");
        }
        catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }


    }
}
