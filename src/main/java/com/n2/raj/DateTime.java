package com.n2.raj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateTime {

  public static void main(String[] args) {
    String datetimeInput = "2019-06-11T09:55:03.387+0000";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
    df.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date result;
    try {
      ZonedDateTime zonedDateTime = ZonedDateTime.parse(datetimeInput);
      result = df.parse(datetimeInput);
      System.out.println("date:"+result); //prints date in current locale
      SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
      System.out.println(sdf1.format(result)); //prints date in the format sdf1
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM yyyy hh:mm");
      System.out.println(sdf2.format(result));
    }catch (Exception e) {
      e.printStackTrace();
    }


  }
}
