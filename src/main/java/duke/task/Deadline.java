package duke.task;

/**
 * Represents a deadline type of tasks. Mainly used to mark a future
 * deadline that the user has to accomplish a task by.
 */
public class Deadline extends Task {
    protected String dueDate;

    // Deadline Constructor
    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }
    /**
     * Converts the Deadline Task into a string.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDate + ")";
    }
}
