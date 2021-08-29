package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private static Date date = new Date();
    private static Calendar calendar;

    public static String getFutureDay(int dayAhead) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dayAhead);
        String futureDateTime = dateFormat.format(calendar.getTime());
        return futureDateTime;
    }
}
