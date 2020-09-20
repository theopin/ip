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
        StringBuilder deadlineSummary = new StringBuilder();
        deadlineSummary.append("[D]").append(super.toString()).append(" (by: ");
        if(!dueDate.equals("")) {
            deadlineSummary.append(dueDate).append(WHITESPACE);
        }
        if(!dueTime.equals("")) {
            deadlineSummary.append(dueTime);
        }
        deadlineSummary.append(")");

        return deadlineSummary.toString();
        
    }
}
