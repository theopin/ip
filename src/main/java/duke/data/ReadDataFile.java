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
            System.out.println("\tFile not found! Creating new file!");
            new WriteDataFile();
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

        String action = "";
        String newTaskDescription = formattedTask[2];
        String newTaskTimeline = "";

        boolean isTaskDone = formattedTask[1].equals("1");

        if(!formattedTask[0].equals("T")) {
            newTaskTimeline = formattedTask[3];
        }
        switch(formattedTask[0]) {
        case "T":
            action = UserSession.ACTION_TODO;
            formattedTask[2] = "";
            break;
        case "D":
            action = UserSession.ACTION_DEADLINE;
            break;
        case "E":
            action = UserSession.ACTION_EVENT;
            break;
        default:
            return;
        }

        UserSession.insertNewTask(action, newTaskDescription, newTaskTimeline);

        if(isTaskDone) {
            tasks.get(taskIndex).markAsDone(true);
        }

    }
}
