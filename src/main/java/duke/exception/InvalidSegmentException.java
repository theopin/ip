package duke.exception;

public class InvalidSegmentException extends DukeException{

    private final String faultySegment;

    public InvalidSegmentException(String faultySegment) {
        super();
        this.faultySegment = faultySegment;
    }


    @Override
    public void alertException() {
        System.out.println("\t" + faultySegment + " cannot be incomplete! Please Try Again!");
    }
}
