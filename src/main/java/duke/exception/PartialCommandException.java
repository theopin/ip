package duke.exception;

import duke.message.Message;

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
        System.out.println("\t" + faultyAction + " cannot be incomplete! Please Try Again!");
        Message.printHorizontalLine();
    }
}
