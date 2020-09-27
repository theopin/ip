package duke.task;

/**
 * Represents a deadline type of tasks. Mainly used to mark a future
 * deadline that the user has to accomplish a task by.
 */

public class Deadline extends Task {
    protected String dueDate;
    protected String dueTime;


    /**
     * Constructs a new Deadline Object.
     *
     * @param description Details of the Deadline task.
     */
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
     *
     * @return a string that contains information of the deadline task.
     */
    @Override
    public String toString() {
        StringBuilder deadlineSummary = new StringBuilder();
        deadlineSummary.append("[D]").append(super.toString()).append(" (by: ");
        return modifyString(deadlineSummary, dueDate, dueTime);

    }


}
