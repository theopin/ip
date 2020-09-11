package duke.exception;

public class RangeExceedException extends DukeException {

    @Override
    public void alertException() {
        System.out.println("\tTask specified does not exist! Please try again!");
    }
}
