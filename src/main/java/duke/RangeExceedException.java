package duke;

public class RangeExceedException extends DukeException {

    @Override
    public void alertException() {
        System.out.println("\tduke.task.Task specified does not exist! Please try again!");
    }
}
