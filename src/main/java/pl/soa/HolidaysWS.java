package pl.soa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HolidaysWS {
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }

  public long daysToHolidays() throws ParseException {
    SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    if(month>7)
      year++;
    String startHolidays = "01 07 "+year;
    Date startHolidaysDate = myFormat.parse(startHolidays);
    long diff = startHolidaysDate.getTime() - date.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

}
