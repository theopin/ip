package duke.data;

import duke.task.Task;
import duke.task.Todo;
import duke.task.Deadline;
import duke.task.Event;

import static duke.task.TaskHandler.tasks;

import java.io.IOException;
import java.io.FileWriter;

/**
 * Allows the user to write data based on the tasks currently present in the
 * list of tasks into duke.txt.
 */
public class WriteDataFile extends DataFile {
    protected String textContent;

    public WriteDataFile() {
        executeFunction();
    }

    /**
     * Converts the tasks present in the list of tasks into
     * a string. This string is then saved in a form of .txt file
     * into duke.txt.
     */
    @Override
    public void executeFunction() {
        try {
            setTextContent();
            writeToFile();
        } catch (IOException e) {
            System.out.println("\tSomething went wrong: " + e.getMessage());
        }
    }
    /**
     * Converts the tasks present in the list of tasks into
     * a string.
     */
    private void setTextContent() {
        StringBuilder textBuild = new StringBuilder();
        for(Task task : tasks) {
            convertTaskToText(textBuild, task);
        }
        this.textContent = textBuild.toString();
    }

    /**
     * Sets the string for the .txt file based on a specified
     * format.
     *
     * @param textBuild A stringBuilder object that takes in multiple
     *                  string inputs regading various features of the task.
     * @param task The task that is currently being converted into a string.
     *
     */
    private void convertTaskToText(StringBuilder textBuild, Task task) {
        extractClass(textBuild, task);
        textBuild.append(" | ");

        extractIsDone(textBuild, task);
        textBuild.append(" | ");
        textBuild.append(task.getDescription());

        if (!(task instanceof Todo)) {
            extractDate(textBuild, task);
            textBuild.append(" | ");
            extractTime(textBuild, task);
        }
        textBuild.append(System.lineSeparator());
    }

    /**
     * Appends the type of task into the stringBuilder.
     *
     * @param textBuild A stringBuilder object that takes in multiple
     *                  string inputs regading various features of the task.
     * @param task The task that is currently being converted into a string.
     *
     */
    public void extractClass(StringBuilder textBuild, Task task) {
        if(task instanceof Event) {

            textBuild.append("E");
        } else if(task instanceof Deadline) {
            textBuild.append("D");
        } else {
            textBuild.append("T");
        }
    }

    /**
     * Appends the status of completion of the task into the stringBuilder.
     *
     * @param textBuild A stringBuilder object that takes in multiple
     *                  string inputs regading various features of the task.
     * @param task The task that is currently being converted into a string.
     *
     */
    private void extractIsDone(StringBuilder textBuild, Task task) {
        if(task.getStatusIcon().equals("\u2713")) {
            textBuild.append(1);
        } else {
            textBuild.append(0);
        }
    }


    /**
     * Appends the time of the task into the stringBuilder.
     *
     * @param textBuild A stringBuilder object that takes in multiple
     *                  string inputs regading various features of the task.
     * @param task The task that is currently being converted into a string.
     *
     */
    public void extractTime(StringBuilder textBuild, Task task) {
        if(task instanceof Event) {
            textBuild.append(((Event) task).getAllocatedTime());
        } else if(task instanceof Deadline) {
            textBuild.append(((Deadline) task).getDueTime());
        }
    }

    private void extractDate(StringBuilder textBuild, Task task) {
        if(task instanceof Event) {
            textBuild.append(" | ");
            textBuild.append(((Event) task).getAllocatedDate());
        } else if(task instanceof Deadline) {
            textBuild.append(" | ");
            textBuild.append(((Deadline) task).getDueDate());
        }
    }
    
    /**
     * Writes the values of textContent into duke.txt
     *
     * @throws IOException Thrown if there are issues with writing the string
     *                     into duke.txt
     */
    public void writeToFile() throws IOException {

        FileWriter fileEditor = new FileWriter(String.valueOf(TXT_FILE_DIR));
        fileEditor.write(textContent);
        fileEditor.close();
    }

}
