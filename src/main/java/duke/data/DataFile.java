package duke.data;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class DataFile {
    protected static final String USER_DIR =  System.getProperty("user.dir");
    protected static final Path DATA_DIR =  Paths.get(USER_DIR, "data");
    protected static final Path TXT_FILE_DIR =  Paths.get(USER_DIR, "data", "duke.txt");

    public abstract void executeFunction();

}
