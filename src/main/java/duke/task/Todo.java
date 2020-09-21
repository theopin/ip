package duke.task;

/**
 * Represents a todo type of tasks. Mainly used to mark a task
 * that the user has to finish.
 */
public class Todo extends Task {

    // Todo Constructor
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts the Todo Task into a string.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
