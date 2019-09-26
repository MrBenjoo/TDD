package clock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Time {
    private int theHour = 0;
    private int theMinute = 0;
    private int theSecond = 0;


    public String timeSet(int hour, int minute, int second) {
        if( (hour <= 23 && hour >= 0) && (minute <= 59 && minute >= 0) && (second <= 59 && second >= 0) ) {
            theHour = hour;
            theMinute = minute;
            theSecond = second;
        } else {
            return Clock.BOUNDARY_OUT_OF_RANGE;
        }
        return showTime();
    }

    public String showTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String unformatedTime = theHour + ":" + theMinute + ":" + theSecond;
        try {
            return dateFormat.format(dateFormat.parse(unformatedTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Clock.DEFAULT_TIME;
    }

}
