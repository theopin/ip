package duke.exception;

/**
 * Error exception that arises when the task index specified
 * does not exist in the current list of tasks.
 */
public class RangeExceedException extends DukeException {

    @Override
    public void alertException() {
        System.out.println("\t Error Code 2: Task number specified does not exist!");
    }
}
