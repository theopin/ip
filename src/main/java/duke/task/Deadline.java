package duke.task;


import duke.parser.DateTimeParser;

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

    public String getDueTime() {
        return dueTime;
    }

    @Override
    public String toString() {
        StringBuilder deadlineSummary = new StringBuilder();
        deadlineSummary.append("[D]").append(super.toString()).append(" (by: ");
        return modifyString(deadlineSummary, dueDate, dueTime);

    }


}
