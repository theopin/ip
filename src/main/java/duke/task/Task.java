package duke.task;

import duke.exception.InvalidTimeException;

import static duke.parser.DateTimeParser.parseDate;
import static duke.parser.DateTimeParser.parseTime;

import static duke.task.TaskHandler.WHITESPACE;

/**
 * Represents a general Task. The methods here are generic and can be
 * used by its subclasses.
 */
public class Task {
    private static final String END_OF_DAY = "11:59 PM";
    protected String description;
    protected boolean isDone = false;
    protected static int numberOfTasks = 0;

    /**
     * Constructs a new Task Object.
     *
     * @param description Details of the Task.
     */
    public Task(String description) {
        this.description = description;
        numberOfTasks++;
    }

    /**
     * Obtains the description of the task.
     *
     * @return isDone A string containing the description of the task.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Returns a symbol indicating the status of completion of the task.
     *
     * @return isDone A Symbol that indicates if the task is done or not.
     */
    public String getStatusIcon() {
        return (isDone ? "/" : "X");
    }

    /**
     * Sets the completion status of the task.
     *
     * @param isDone A boolean indicating if the task is done.
     */
    public void markAsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns the number of tasks in the taskList.
     *
     * @return An integer containing the number of tasks in the taskList.
     */
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Updates the number of tasks in the taskList when a task is removed.
     */
    public static void updateTaskCount() {
        numberOfTasks--;
    }

    /**
     * Converts the Task into a string.
     *
     * @param summary StringBuilder that builds the string equivalent of the task.
     * @param dueDate Date that the task is set at.
     * @param dueTime Time that the task is set at.
     */
    public static String modifyString(StringBuilder summary, String dueDate, String dueTime) {
        String parsedDate, parsedTime;
        boolean isDateParsed = true;

        try {
            parsedDate = parseDate(dueDate);
            summary.append(parsedDate);
        } catch (InvalidTimeException e) {
            isDateParsed = false;
        }

        try {
            if(isDateParsed) {
                summary.append(WHITESPACE);
            }
            parsedTime = parseTime(dueTime);
            summary.append(parsedTime);
        } catch (InvalidTimeException e) {
            summary.append(END_OF_DAY);
        }

        summary.append(")");
        return summary.toString();
    }

    /**
     * Converts the Task into a string.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }


}
