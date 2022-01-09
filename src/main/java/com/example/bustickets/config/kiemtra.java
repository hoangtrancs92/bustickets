package com.example.bustickets.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class kiemtra {
   public static void main(String arg[]){
       String time = "07:30";
       String gio = "";
       String phut = "";
       String khongduoctra = "";
       gio = time.substring(0,2);
       phut = time.substring(3);
       if (Integer.parseInt(phut) == 30){
           khongduoctra = gio+":00";
       }
       if (Integer.parseInt(phut) ==0){
          int clone = (Integer.parseInt(gio)-1);
          gio = Integer.toString(clone);
          khongduoctra = gio + phut;
       }

       LocalTime t2 = LocalTime.parse(time);
       LocalTime t3 = LocalTime.parse(khongduoctra);
       LocalTime t1 = java.time.LocalTime.now();
//       System.out.println(LocalTime.parse());
       boolean meetsDeadline = t2.isBefore(t1) ;
       System.out.println(t3);
       System.out.println(phut);
       System.out.println(gio);
       System.out.println("gio phai tra ve truoc" + khongduoctra);
       LocalTime localTime = LocalTime.now();

       Instant instant = localTime.atDate(LocalDate.of(2015, 11, 11)).
               atZone(ZoneId.systemDefault()).toInstant();
       Date oldDate = Date.from(instant);
       System.out.println(oldDate);
       System.out.println(localTime);
//       SimpleDateFormat format = new SimpleDateFormat("hh:mm a"); //if 24 hour format
//       Date date = null;
//       try {
//           date = format.parse(time);
//       } catch (ParseException e) {
//           e.printStackTrace();
//       }
//       String formattedTime = format.format(date);
//       System.out.println(formattedTime);

   }
}
