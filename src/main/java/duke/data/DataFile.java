package duke.data;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A general class that stores certain constants regarding the
 * file location of duke.txt, as well as a method that can be
 * executed based on the type of class that is a child of this class.
 */
public abstract class DataFile {
    protected static final String USER_DIR =  System.getProperty("user.dir");
    protected static final Path DATA_DIR =  Paths.get(USER_DIR, "data");
    protected static final Path TXT_FILE_DIR =  Paths.get(USER_DIR, "data", "duke.txt");

    /**
     * A method that is to be run when its subclass is created.
     */
    public abstract void executeFunction();

}
