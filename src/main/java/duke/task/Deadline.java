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

    /**
     * Returns the due date of the particular Deadline task
     *
     * @return A date that the Deadline task is due by.
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Returns the due time of the particular Deadline task
     *
     * @return A time that the Deadline task is due by.
     */
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
