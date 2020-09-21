package duke.exception;

import duke.message.Message;

/**
 * Error exception that arises when unrecognized commands are
 * entered in the command line.
 */
public class IllegalCommandException extends DukeException {

    @Override
    public void alertException() {
        System.out.println("\tCommand Not Understood! Please Try Again!");
        Message.printHorizontalLine();
    }
}
