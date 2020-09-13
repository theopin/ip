package duke.data;

import duke.UserSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ReadDataFile extends DataFile {

    public ReadDataFile(){
        executeFunction();
    }

    @Override
    public void executeFunction() {
        try {
            implementFileContents();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private void implementFileContents() throws FileNotFoundException {
        File userFile = new File(filePath); // create a File for the given file path
        Scanner dataScanner = new Scanner(userFile);
        while (dataScanner.hasNext()) {
            convertStringToTask(dataScanner.next());
        }
    }

    private void convertStringToTask(String newTask) {
        String[] formattedTask = newTask.split(" \\| ");

        boolean isTaskDone = formattedTask[1].equals("1");

        switch(formattedTask[0]){
        case "T":
            formattedTask[0] = "todo";
            formattedTask[1] = "";
        case "D":
            formattedTask[0] = "deadline";
            formattedTask[1] = "/by";
        case "W":
            formattedTask[0] = "event";
            formattedTask[1] = "/at";
        }
        String action = formattedTask[0];
        UserSession.createNewTask(formattedTask, action);

    }
}
