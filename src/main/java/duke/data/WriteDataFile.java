package duke.data;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.IOException;
import java.io.FileWriter;

import static duke.UserSession.tasks;

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
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public void setTextContent() {
        StringBuilder textBuild = new StringBuilder();
        for(Task task : tasks) {

            if(task.getClass() == Event.class) {
                textBuild.append("E");
            } else if(task.getClass() == Deadline.class) {
                textBuild.append("D");
            } else {
                textBuild.append("T");
            }

            textBuild.append(" | ");
            textBuild.append(task.getDescription());

            textBuild.append(" | ");
            if(task.getStatusIcon().equals("\u2713")) {
                textBuild.append(1);
            } else {
                textBuild.append(0);
            }

            textBuild.append(" | ");
            if(task.getClass() == Event.class) {
                textBuild.append(((Event)task).getAllocatedTime());
                textBuild.append(" | ");
            } else if(task.getClass() == Deadline.class) {
                textBuild.append(((Deadline)task).getDueDate());
                textBuild.append(" | ");
            }

            textBuild.append("S");
            textBuild.append(System.lineSeparator());
        }
        this.textContent = textBuild.toString();
    }

    public void writeToFile() throws IOException {
        FileWriter fileEditor = new FileWriter(filePath);
        fileEditor.write(textContent);
        fileEditor.close();
    }

}
