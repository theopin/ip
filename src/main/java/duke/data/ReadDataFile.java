package duke.data;

import duke.exception.PartialCommandException;
import duke.task.TaskHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import static duke.task.TaskHandler.EMPTY;
import static duke.task.TaskHandler.tasks;

public class ReadDataFile extends DataFile {

    public ReadDataFile() {
        executeFunction();
    }

    @Override
    public void executeFunction() {
        try {
            implementFileContents();
        } catch (FileNotFoundException e) {
            handleMissingFile();
        }
    }

    public void handleMissingFile() {
        System.out.println("\tFile not found! Creating new file!");
        try {
            createNewFile();
        } catch (IOException i) {
            System.out.println("\tFile cannot be created! Data will not be stored!");
        }
    }

    public void implementFileContents() throws FileNotFoundException {
        File userFile = new File(String.valueOf(TXT_FILE_DIR)); // create a File for the given file path
        Scanner dataScanner = new Scanner(userFile);
        int taskIndex = 0;
        while (dataScanner.hasNextLine()) {
            convertStringToTask(dataScanner.nextLine(), taskIndex);
            taskIndex++;
        }
    }

    public void convertStringToTask(String newTask, int taskIndex) {
        String[] formattedTask = newTask.split(" \\| ");

        String action;
        String newTaskDescription = formattedTask[2];
        String newTaskDate = "";
        String newTaskTime = "";

        boolean isTaskDone = formattedTask[1].equals("1");

        // Task is a deadline or event
        if(!newTask.equals("") && !formattedTask[0].equals("T")) {
            newTaskDate = formattedTask[3];
            newTaskTime = (formattedTask.length == 5) ? formattedTask[4] : EMPTY;
        }
        action = getAction(formattedTask[0]);
        if (action == null) {
            return;
        }

        try {
            TaskHandler.insertNewTask(action, newTaskDescription, newTaskDate, newTaskTime);
        } catch (PartialCommandException e) {
            e.alertException();
        }
        if(isTaskDone) {
            tasks.get(taskIndex).markAsDone(true);
        }

    }

    public String getAction(String dataInput) {
        String action;
        switch(dataInput) {
        case "T":
            action = TaskHandler.ACTION_TODO;
            break;
        case "D":
            action = TaskHandler.ACTION_DEADLINE;
            break;
        case "E":
            action = TaskHandler.ACTION_EVENT;
            break;
        default:
            return null;
        }
        return action;
    }

    public void createNewFile() throws IOException {
        if(!Files.exists(DATA_DIR)) {
            Files.createDirectories(DATA_DIR);
        }
        if(!Files.exists(TXT_FILE_DIR)) {
            Files.createFile(TXT_FILE_DIR);
        }
    }
}
