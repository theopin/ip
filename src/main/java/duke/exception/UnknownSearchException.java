package duke.exception;

/**
 * Error exception that arises when the search filter specified
 * does not exist in the current list of tasks.
 */
public class UnknownSearchException extends DukeException {

    @Override
    public void alertException() {
        System.out.println("\tError Code 3: Search parameters do not match any task!");
    }
}
