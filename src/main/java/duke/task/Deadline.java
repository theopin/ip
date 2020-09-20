package duke.task;


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
        return getString(deadlineSummary, dueDate, dueTime);

    }


}
