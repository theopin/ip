package duke.data;

import java.io.IOException;
import java.io.FileWriter;

public class WriteDataFile extends DataFile {
    protected String textContent;

    public WriteDataFile(String textContent) {
        super();
        this.textContent = textContent;
    }

    @Override
    public void executeFunction() {
        try {
            writeToFile();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private void writeToFile() throws IOException {
        FileWriter fileEditor = new FileWriter(filePath);
        fileEditor.write(textContent);
        fileEditor.close();
    }

}
