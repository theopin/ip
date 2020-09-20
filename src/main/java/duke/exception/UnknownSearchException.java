package duke.exception;

public class UnknownSearchException extends DukeException {

    @Override
    public void alertException() {
        System.out.println("\tTask requested does not exist! Please try again!");
    }
}
