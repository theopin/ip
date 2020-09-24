package duke.exception;

/**
 * Error exception that arises when some essential parameters
 * are not indicated in the user input.
 */

public class PartialCommandException extends DukeException {

    private final String faultyAction;

    public PartialCommandException(String faultyAction) {
        super();
        this.faultyAction = faultyAction;
    }

    /**
     * Informs user of the incomplete command
     */
    @Override
    public void alertException() {
        System.out.println("\tError Code 1: " + faultyAction + " parameters are invalid!");
    }
}
