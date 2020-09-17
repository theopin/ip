package duke.data;

import duke.UserSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
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

        String action = "";
        String newTaskDescription = formattedTask[2];
        String newTaskTimeline = "";

        boolean isTaskDone = formattedTask[1].equals("1");

        // Task is a deadline or event
        if(!formattedTask[0].equals("T")) {
            newTaskTimeline = formattedTask[3];
        }
        action = getAction(formattedTask[0]);
        if (action == null) {
            return;
        }

        UserSession.insertNewTask(action, newTaskDescription, newTaskTimeline);
        if(isTaskDone) {
            tasks.get(taskIndex).markAsDone(true);
        }

    }

    public String getAction(String dataInput) {
        String action;
        switch(dataInput) {
        case "T":
            action = UserSession.ACTION_TODO;
            break;
        case "D":
            action = UserSession.ACTION_DEADLINE;
            break;
        case "E":
            action = UserSession.ACTION_EVENT;
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
