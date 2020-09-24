package duke.exception;

/**
 * Error exception that arises when commands cannot be parsed
 * into date and/or time variables.
 */
public class InvalidTimeException extends DukeException{

    private final String faultySegment;

    public InvalidTimeException(String faultySegment) {
        super();
        this.faultySegment = faultySegment;
    }


    @Override
    public void alertException() {
        System.out.println("\tError Code 5: " + faultySegment + " cannot be parsed!");
    }
}
