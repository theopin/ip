package duke.exception;

/**
 * Error exception that arises when commands cannot be parsed
 * into date and/or time variables.
 */
public class InvalidTimeException extends DukeException{

    private final String faultySegment;

    /**
     * Constructs a new InvalidTimeException Object.
     *
     * @param faultySegment Parameter of the action that has invalid input.
     */
    public InvalidTimeException(String faultySegment) {
        super();
        this.faultySegment = faultySegment;
    }

    /**
     * Informs user that the given parameters of the command cannot
     * be parsed.
     */
    @Override
    public void alertException() {
        System.out.println("\tError Code 5: " + faultySegment + " cannot be parsed!");
    }
}
