package duke.exception;

/**
 * A general error exception that arises from running the Duke Program.
 */
public abstract class DukeException extends Exception {

    public abstract void alertException();
}
