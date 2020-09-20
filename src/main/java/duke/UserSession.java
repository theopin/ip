package duke;

import duke.data.ReadDataFile;
import duke.message.Message;
import duke.parser.CommandParser;

import static duke.task.TaskHandler.ACTION_EXIT;

public class UserSession {

    public UserSession() {
        new ReadDataFile();
        runProgramSequence();
    }

    // Overall structure of a user session
    public void runProgramSequence() {
        String action = "";
        CommandParser newUserCommand;
        Message.printWelcomeText();

        // Ask for new user input until user types an exit command
        do {
            newUserCommand = new CommandParser();
            action = newUserCommand.getActionCommand();

        } while (!action.equals(ACTION_EXIT));
        Message.printExitText();
    }

}
