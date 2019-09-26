package clock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {
    private int theYear = 2000;
    private int theMonth = 1;
    private int theDay = 1;

    public String dateSet(int year, int month, int day) {

        if( (year <= 2100 && year >= 2000) && (month <= 12 && month >= 1) && (day <= 31 && day >= 1) ) {
            theYear = year;
            theMonth = month;
            theDay = day;
        } else {
            return Clock.BOUNDARY_OUT_OF_RANGE;
        }
        return showDate();
    }

    public String showDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String unformatedTime = theYear + "-" + theMonth + "-" + theDay;
        try {
            return dateFormat.format(dateFormat.parse(unformatedTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Clock.DEFAULT_DATE;
    }
}
