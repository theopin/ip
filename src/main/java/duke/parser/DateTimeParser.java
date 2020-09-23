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

    /**
     * Parses the date given by the user in the form (Day/Month/Year) and
     * returns it in another format (Month Day Year).
     *
     * @param givenDateFormat A String containing the date given by the user.
     */
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

    /**
     * Parses the time given by the user in the form (HH:MM) and
     * returns it in another format (H:MM AM) or (H:MM PM).
     *
     * @param givenTimeFormat A String containing the time given by the user.
     */
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
