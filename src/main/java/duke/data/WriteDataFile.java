package duke.data;

import java.io.IOException;
import java.io.FileWriter;

public class WriteDataFile extends DataFile {

    @Override
    public void executeFunction() {
        try {
            writeToFile("first line" + System.lineSeparator() + "second line");
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static void writeToFile(String textToAdd) throws IOException {
        FileWriter fileEditor = new FileWriter(filePath);
        fileEditor.write(textToAdd);
        fileEditor.close();
    }

}
