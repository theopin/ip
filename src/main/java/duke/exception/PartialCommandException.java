package duke.exception;

import duke.message.Message;

public class PartialCommandException extends DukeException {

    protected String faultyAction;

    public PartialCommandException(String faultyAction) {
        super();
        this.faultyAction = faultyAction;
    }

    @Override
    public void alertException() {
        System.out.println("\t" + faultyAction + " cannot be incomplete! Please Try Again!");
        Message.printHorizontalLine();
    }
}
