package duke.parser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static duke.task.TaskHandler.EMPTY;

public class DateTimeParser {

    public static final String MONTH_DAY_YEAR_FORMAT = "MMM dd yyyy";
    public static final String DAY_MONTH_YEAR_FORMAT = "dd/MM/yyyy";
    public static final String X_AM_PM_FORMAT = "h:mm a";

    public static String parseDate(String givenDateFormat) {
        String newDateFormat = "";
        try {
            LocalDate dateGiven = LocalDate.parse(givenDateFormat,
                    DateTimeFormatter.ofPattern(DAY_MONTH_YEAR_FORMAT));

            newDateFormat = dateGiven.format(DateTimeFormatter.ofPattern(MONTH_DAY_YEAR_FORMAT));
        } catch (DateTimeParseException d) {
            System.out.println("\tError encountered: " + d.getMessage());
        }

        return newDateFormat;
    }

    public static String parseTime(String givenTimeFormat) {
        String newTimeFormat = "";
        try {
            LocalTime timeGiven = LocalTime.parse(givenTimeFormat);
            newTimeFormat = timeGiven.format(DateTimeFormatter.ofPattern(X_AM_PM_FORMAT));
        } catch (DateTimeParseException d) {
            System.out.println("\tError encountered: " + d.getMessage());
            return EMPTY;
        }

        return newTimeFormat;
    }
}
