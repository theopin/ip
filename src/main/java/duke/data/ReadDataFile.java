package duke.data;

import duke.task.TaskHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

import static duke.task.TaskHandler.tasks;

/**
 * Allows the user to read data from duke.txt and add them
 * to the list of tasks.
 */
public class ReadDataFile extends DataFile {

    public ReadDataFile() {
        executeFunction();
    }

    /**
     * Converts the file contents into tasks that can be added into
     * the list of tasks. Also handles an exception arising
     * from missing file and/or directory at the specified location.
     */
    @Override
    public void executeFunction() {
        try {
            implementFileContents();
        } catch (FileNotFoundException e) {
            handleMissingFile();
        }
    }

    /**
     * Handles the case where the file is not found in the
     * user directory.
     */
    private void handleMissingFile() {
        System.out.println("\tFile not found! Creating new file!");
        try {
            createNewFile();
        } catch (IOException i) {
            System.out.println("\tFile cannot be created! Data will not be stored!");
        }
    }

    /**
     * Converts the data obtained from duke.txt into tasks and adds them
     * to the list of tasks.
     *
     * @throws FileNotFoundException Thrown if the file is not found in
     *                               the user directory.
     */
    private void implementFileContents() throws FileNotFoundException {
        // create a File for the given file path
        File userFile = new File(String.valueOf(TXT_FILE_DIR));
        Scanner dataScanner = new Scanner(userFile);
        int taskIndex = 0;
        while (dataScanner.hasNextLine()) {
            convertStringToTask(dataScanner.nextLine(), taskIndex);
            taskIndex++;
        }
    }
    /**
     * Converts the data obtained from duke.txt into a task.
     *
     * @param newTask Details regarding the new task.
     * @param taskIndex Index of the task in duke.txt.
     */
    private void convertStringToTask(String newTask, int taskIndex) {
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

        TaskHandler.insertNewTask(action, newTaskDescription, newTaskTimeline);
        if(isTaskDone) {
            tasks.get(taskIndex).markAsDone(true);
        }

    }

    /**
     * Extracts the type of task based on the given symbol.
     *
     * @param dataInput Symbol indicating the type of task stored.
     */
    private String getAction(String dataInput) {
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

    /**
     * Creates a new  directory and file at the specified location
     * if it currently does not exist
     *
     * @throws IOException Thrown if errors arise when creating the directory
     * and/or file.
     */
    private void createNewFile() throws IOException {
        if(!Files.exists(DATA_DIR)) {
            Files.createDirectories(DATA_DIR);
        }
        if(!Files.exists(TXT_FILE_DIR)) {
            Files.createFile(TXT_FILE_DIR);
        }
    }
}
