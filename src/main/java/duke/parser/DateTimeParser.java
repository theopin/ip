package duke.parser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeParser {

    public static final String monthDayYearFormat = "MMM dd yyyy";
    public static final String xPmFormat = "h:mm a";

    public String parseDate(String givenDateFormat) {
        String newDateFormat = "";
        try {
            LocalDate dateGiven = LocalDate.parse(givenDateFormat);
            newDateFormat = dateGiven.format(DateTimeFormatter.ofPattern(monthDayYearFormat));
        } catch (DateTimeParseException d) {
            System.out.println("\tError encountered: " + d.getMessage());
        }

        return newDateFormat;
    }

    public String parseTime(String givenTimeFormat) {
        String newTimeFormat = "";
        try {
            LocalTime timeGiven = LocalTime.parse(givenTimeFormat);
            newTimeFormat = timeGiven.format(DateTimeFormatter.ofPattern(xPmFormat));
        } catch (DateTimeParseException d) {
            System.out.println("\tError encountered: " + d.getMessage());
        }

        return newTimeFormat;
    }
}
