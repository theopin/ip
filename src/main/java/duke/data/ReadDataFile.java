package duke.data;

import duke.UserSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static duke.UserSession.tasks;


public class ReadDataFile extends DataFile {

    public ReadDataFile() {
        executeFunction();
    }

    @Override
    public void executeFunction() {
        try {
            implementFileContents();
        } catch (FileNotFoundException e) {
            System.out.println("\tFile not found");
        }
    }

    public void implementFileContents() throws FileNotFoundException {
        File userFile = new File(filePath); // create a File for the given file path
        Scanner dataScanner = new Scanner(userFile);
        int taskIndex = 0;
        while (dataScanner.hasNextLine()) {
            convertStringToTask(dataScanner.nextLine(), taskIndex);
            taskIndex++;
        }
    }

    public void convertStringToTask(String newTask, int taskIndex) {
        String[] formattedTask = newTask.split(" \\| ");

        boolean isTaskDone = formattedTask[2].equals("1");


        switch(formattedTask[0]){
        case "T":
            formattedTask[0] = "todo";
            formattedTask[2] = "";
            break;
        case "D":
            formattedTask[0] = "deadline";
            formattedTask[2] = "/by";
            break;
        case "E":
            formattedTask[0] = "event";
            formattedTask[2] = "/at";
            break;
        }
        String action = formattedTask[0];
        UserSession.createNewTask(formattedTask, action);

        if(isTaskDone) {
            tasks.get(taskIndex).markAsDone(true);
        }

    }
}
