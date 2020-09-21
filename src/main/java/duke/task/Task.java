package duke.task;

import static duke.parser.DateTimeParser.parseDate;
import static duke.parser.DateTimeParser.parseTime;
import static duke.task.TaskHandler.EMPTY;
import static duke.task.TaskHandler.WHITESPACE;

public class Task {
    protected String description;
    protected boolean isDone = false;
    protected static int numberOfTasks = 0;

    // duke.task.Task Constructor
    public Task(String description) {
        this.description = description;
        numberOfTasks++;
    }

    // Returns description of tasks
    public String getDescription() {
        return description;
    }

    // Returns tick or X symbols based on the value of isDone
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    // Sets the isDone variable of the task
    public void markAsDone(boolean isDone) {
        this.isDone = isDone;
    }

    // Returns the number of Tasks created so far
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    public static void taskRemoved() {
        numberOfTasks--;
    }

    public static String modifyString(StringBuilder summary, String dueDate, String dueTime) {
        if(!dueDate.equals(EMPTY)) {
            summary.append(parseDate(dueDate));
            if(!dueTime.equals(EMPTY)) {
                summary.append(WHITESPACE).append(parseTime(dueTime));
            }
        } else if(!dueTime.equals(EMPTY)) {
            summary.append(parseTime(dueTime));
        }
        summary.append(")");

        return summary.toString();
    }
    
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }


}
