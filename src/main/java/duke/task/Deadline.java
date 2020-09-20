package duke.task;

import static duke.task.TaskHandler.WHITESPACE;

public class Deadline extends Task {
    protected String dueDate;
    protected String dueTime;

    // duke.task.Deadline Constructor
    public Deadline(String description, String dueDate, String dueTime) {
        super(description);
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("[D]").append(super.toString()).append(" (by: ");
        if(!dueDate.equals("")) {
            stringRepresentation.append(dueDate).append(WHITESPACE);
        }
        if(!dueTime.equals("")) {
            stringRepresentation.append(dueTime);
        }
        stringRepresentation.append(")");

        return stringRepresentation.toString();
        //return "[D]" + super.toString() + " (by: " + dueDate + ")";
    }
}
