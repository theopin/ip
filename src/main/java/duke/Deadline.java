package duke;

public class Deadline extends Task {
    protected String dueDate;

    // duke.Deadline Constructor
    public Deadline(String description, String dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + dueDate + ")";
    }
}
