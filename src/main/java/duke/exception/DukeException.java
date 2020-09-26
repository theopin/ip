package duke.exception;

/**
 * A general error exception that arises from running the Duke Program.
 */
public abstract class DukeException extends Exception {

    /**
     * A method that is to be run when an exception has been detected.
     */
    public abstract void alertException();
}
