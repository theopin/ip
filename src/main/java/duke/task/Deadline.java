package duke.task;
import duke.parser.DateTimeParser;

/**
 * Represents a deadline type of tasks. Mainly used to mark a future
 * deadline that the user has to accomplish a task by.
 */

public class Deadline extends Task {
    protected String dueDate;
    protected String dueTime;


    // Deadline Constructor

    public Deadline(String description, String dueDate, String dueTime) {
        super(description);
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    /**
     * Converts the Deadline Task into a string.
     */
    @Override
    public String toString() {
        StringBuilder deadlineSummary = new StringBuilder();
        deadlineSummary.append("[D]").append(super.toString()).append(" (by: ");
        return modifyString(deadlineSummary, dueDate, dueTime);

    }


}
