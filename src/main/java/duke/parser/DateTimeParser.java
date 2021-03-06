package duke.parser;

import duke.exception.InvalidTimeException;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Class that contains methods to parse dates and times given
 * by the user's command.
 */
public class DateTimeParser {

    private static final String TIME = "time";
    private static final String DATE = "date";

    private static final String MONTH_DAY_YEAR_FORMAT = "MMM dd yyyy";
    private static final String DAY_MONTH_YEAR_FORMAT = "dd/MM/yyyy";
    private static final String X_AM_PM_FORMAT = "h:mm a";

    /**
     * Parses the date given by the user in the form (Day/Month/Year) and
     * returns it in another format (Month Day Year).
     *
     * @param givenDateFormat A String containing the date given by the user.
     * @return a string of the date in the new format.
     * @throws InvalidTimeException Thrown when the date entered does not match
     *                              the given format.
     */
    public static String parseDate(String givenDateFormat) throws InvalidTimeException {
        String newDateFormat;
        try {
            LocalDate dateGiven = LocalDate.parse(givenDateFormat,
                    DateTimeFormatter.ofPattern(DAY_MONTH_YEAR_FORMAT));

            newDateFormat = dateGiven.format(DateTimeFormatter.ofPattern(MONTH_DAY_YEAR_FORMAT));
        } catch (DateTimeParseException d) {
            throw new InvalidTimeException(DATE);
        }

        return newDateFormat;
    }

    /**
     * Parses the time given by the user in the form (HH:MM) and
     * returns it in another format (H:MM AM) or (H:MM PM).
     *
     * @param givenTimeFormat A String containing the time given by the user.
     * @return a string of the time in the new format.
     * @throws InvalidTimeException Thrown when the date entered does not match
     *                              the given format.
     */
    public static String parseTime(String givenTimeFormat) throws InvalidTimeException {
        String newTimeFormat;
        try {
            LocalTime timeGiven = LocalTime.parse(givenTimeFormat);
            newTimeFormat = timeGiven.format(DateTimeFormatter.ofPattern(X_AM_PM_FORMAT));
        } catch (DateTimeParseException d) {
            throw new InvalidTimeException(TIME);
        }

        return newTimeFormat;
    }
}
