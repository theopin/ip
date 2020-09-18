package duke;

import duke.data.ReadDataFile;

import duke.exception.IllegalCommandException;
import duke.exception.PartialCommandException;
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
            try {
                newUserCommand = new CommandParser();
                action = newUserCommand.getActionCommand();
            } catch (IllegalCommandException e) {
                e.alertException();
            } catch (PartialCommandException p) {
                p.alertException();
            }

        } while (!action.equals(ACTION_EXIT));
        Message.printExitText();
    }

}
