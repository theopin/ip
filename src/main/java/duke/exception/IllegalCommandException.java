package duke.exception;

import duke.message.Message;

/**
 * Error exception that arises when unrecognized commands are
 * entered in the command line.
 */
public class IllegalCommandException extends DukeException {

    /**
     * Informs user that an invalid command has been entered.
     */
    @Override
    public void alertException() {
        System.out.println("\tError Code 0: Invalid Command Entered!");
        Message.printHorizontalLine();
    }
}
