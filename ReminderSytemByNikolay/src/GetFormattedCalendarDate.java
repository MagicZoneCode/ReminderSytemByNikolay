import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetFormattedCalendarDate {
    public static String beautifulDate(Calendar expiration) {
        SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date =expiration.getTime();
        return s1.format(date);
    }
}