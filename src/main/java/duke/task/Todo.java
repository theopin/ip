package duke.task;

public class Todo extends Task {

    // duke.task.Todo Constructor
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
