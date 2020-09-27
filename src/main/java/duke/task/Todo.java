package duke.task;

/**
 * Represents a todo type of tasks. Mainly used to mark a task
 * that the user has to finish.
 */
public class Todo extends Task {

    /**
     * Constructs a new Todo Object.
     *
     * @param description Details of the todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts the Todo Task into a string.
     *
     * @return a string that contains information of the todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
