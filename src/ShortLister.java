// ShortLister.java
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();

        if (selectedFile != null) {
            try {
                List<String> words = Arrays.asList(
                        new String(Files.readAllBytes(selectedFile.toPath())).split("\\s+")
                );

                Filter shortWordFilter = new ShortWordFilter();
                List<Object> shortWords = collectAll(words.toArray(), shortWordFilter);

                System.out.println("Short words: " + shortWords);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Object> collectAll(Object[] objects, Filter filter) {
        return Arrays.asList(objects).stream()
                .filter(filter::accept)
                .toList();
    }
}
