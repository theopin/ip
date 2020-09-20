package duke.parser;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;



public class DateTimeParser {

    public static final String monthDayYearFormat = "MMM dd yyyy";

    public String parseDate(String givenDateFormat) {
        String newDateFormat = "";
        try {
            LocalDate dateGiven = LocalDate.parse(givenDateFormat);
            newDateFormat = dateGiven.format(DateTimeFormatter.ofPattern(monthDayYearFormat));
        } catch (DateTimeException d) {
            System.out.println("\tError encountered: " + d.getMessage());
        }

        return newDateFormat;
    }

    public String parseTime(String givenDateFormat) {
        String newDateFormat = "";
        try {
            LocalDate dateGiven = LocalDate.parse(givenDateFormat);
            newDateFormat = dateGiven.format(DateTimeFormatter.ofPattern(monthDayYearFormat));
        } catch (DateTimeException d) {
            System.out.println("\tError encountered: " + d.getMessage());
        }

        return newDateFormat;
    }
}
