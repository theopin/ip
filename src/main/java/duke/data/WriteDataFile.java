package duke.data;

import duke.task.Task;
import duke.task.Todo;
import duke.task.Deadline;
import duke.task.Event;

import static duke.task.TaskHandler.tasks;

import java.io.IOException;
import java.io.FileWriter;

public class WriteDataFile extends DataFile {
    protected String textContent;

    public WriteDataFile() {
        executeFunction();
    }

    @Override
    public void executeFunction() {
        try {
            setTextContent();
            writeToFile();
        } catch (IOException e) {
            System.out.println("\tSomething went wrong: " + e.getMessage());
        }
    }

    public void setTextContent() {
        StringBuilder textBuild = new StringBuilder();
        for(Task task : tasks) {
            convertTaskToText(textBuild, task);
        }
        this.textContent = textBuild.toString();
    }

    public void convertTaskToText(StringBuilder textBuild, Task task) {
        extractClass(textBuild, task);
        textBuild.append(" | ");

        extractIsDone(textBuild, task);
        textBuild.append(" | ");
        textBuild.append(task.getDescription());

        if (task.getClass() != Todo.class) {
            extractTime(textBuild, task);
        }
        textBuild.append(System.lineSeparator());
    }

    public void extractClass(StringBuilder textBuild, Task task) {
        if(task.getClass() == Event.class) {
            textBuild.append("E");
        } else if(task.getClass() == Deadline.class) {
            textBuild.append("D");
        } else {
            textBuild.append("T");
        }
    }

    public void extractIsDone(StringBuilder textBuild, Task task) {
        if(task.getStatusIcon().equals("\u2713")) {
            textBuild.append(1);
        } else {
            textBuild.append(0);
        }
    }

    public void extractTime(StringBuilder textBuild, Task task) {
        if(task.getClass() == Event.class) {
            textBuild.append(" | ");
            textBuild.append(((Event) task).getAllocatedTime());
        } else if(task.getClass() == Deadline.class) {
            textBuild.append(" | ");
            textBuild.append(((Deadline) task).getDueDate());
        }
    }

    public void writeToFile() throws IOException {
        FileWriter fileEditor = new FileWriter(String.valueOf(TXT_FILE_DIR));
        fileEditor.write(textContent);
        fileEditor.close();
    }

}
