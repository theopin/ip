public class IllegalCommandException extends DukeException {

    @Override
    public void alertException() {
        System.out.println("\tCommand Not Understood! Please Try Again!");
        Message.printHorizontalLine();
    }
}
