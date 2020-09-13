package duke.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDataFile extends DataFile {

    @Override
    public void executeFunction() {
        try {
            printFileContents();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private void printFileContents() throws FileNotFoundException {
        File userFile = new File(filePath); // create a File for the given file path
        Scanner dataScanner = new Scanner(userFile);
        while (dataScanner.hasNext()) {
            System.out.println(dataScanner.nextLine());
        }
    }
}
