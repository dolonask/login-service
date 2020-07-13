package kg.easy.loginservice.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date AddMinutesToDate(Date date, int minutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE , minutes);
        return calendar.getTime();
    }
}
