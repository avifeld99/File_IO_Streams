package opdrachten;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OpdrachtSecret {

    public static void writeSecretFile() {

        Path path = Path.of("../../Secret_Folder/Secret_Message.txt");

        try {
            Files.createDirectories(path.getParent());
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            bufferedWriter.write("The wolf is in the pig pen. I repeat: the wolf is in the pig pen.");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        /*try {
            BufferedImage image;
            image = ImageIO.read(new File("https://worldstories.org.uk/content/book/262/__picture_9352.jpg"));
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }*/

    }

    public static void addSecretImage() {

        Path path = Path.of("../../Secret_Folder/Secret_Picture.jpg");

        try {
            Files.createDirectories(path.getParent());
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        BufferedImage image;
        File file;
        try {
            file = new File("https://worldstories.org.uk/content/book/262/__picture_9352.jpg");
            image = ImageIO.read(file);
            ImageIO.write(image, "jpg", file);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }




}
