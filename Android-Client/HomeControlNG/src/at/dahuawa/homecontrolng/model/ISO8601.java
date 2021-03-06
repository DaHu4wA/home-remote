package at.dahuawa.homecontrolng.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Helper class for handling ISO 8601 strings of the following format:
 * "2008-03-01T13:00:00+01:00". It also supports parsing the "Z" timezone.
 */
public final class ISO8601 {
    /** Transform Calendar to ISO 8601 string. */
    public static String fromCalendar(final Calendar calendar) {
        Date date = calendar.getTime();
        String formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .format(date);
        return formatted.substring(0, 22) + ":" + formatted.substring(22);
    }

    /** Get current date and time formatted as ISO 8601 string. */
    public static String now() {
        return fromCalendar(GregorianCalendar.getInstance());
    }

    /** Transform ISO 8601 string to Calendar. */
    public static Date toDate(final String iso8601string){
        String s = iso8601string.replace("Z", "+00:00");
        try {
            s = s.substring(0, 19) + s.substring(23);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        try {
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
}