package genericclasses;

import org.junit.jupiter.api.Test;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormattingDemo {

    @Test
    public void testStringToDateFormatting() {
        //Given a string representing a date in american format.  Change format to British format.
        String strDate = "2022-07-06";
//       DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("DD-MM-YYYY");
//       LocalDate localDate1 = LocalDate.parse(strDate, dateTimeFormatter1);

        //Using split() method to split the string and reconstruct the string to match the formatting we want.
        String[] splitString = strDate.split("-");
        System.out.println(splitString[0]);
        System.out.println(splitString[1]);
        System.out.println(splitString[2]);
        String year = splitString[0];
        String month = splitString[1];
        String day = splitString[2];
        String reconstructDate = day + "-" + month + "-" + year;

        System.out.println(reconstructDate);

    }

    @Test
    public void testFormatDateObject() {

        LocalDate date = LocalDate.now();
        System.out.println("Date before formatting: " + date);
        System.out.println();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        //LocalDate parsedDate = LocalDate.parse(text, formatter);

        System.out.println("Date after formatting: " + formattedDate);
        System.out.println();
        LocalDate date2 = LocalDate.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        String formattedDate2 = date2.format(formatter2);
        System.out.println("Date format \"dd/MM/yyyy\": " + formattedDate2);
        System.out.println();

        LocalDate date3 = LocalDate.now();
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate3 = date3.format(formatter3);
        System.out.println("Date format \"dd-MMM-yyyy\": " + formattedDate3);
        System.out.println();

        LocalDate date4 = LocalDate.now();
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate4 = date4.format(formatter4);
        System.out.println("Date format \"dd/MM/yyyy\": " + formattedDate4);
        System.out.println();

        LocalDate date5 = LocalDate.now();
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        String formattedDate5 = date5.format(formatter5);
        System.out.println("Date format \"E, MMM dd yyyy\": " + formattedDate5);
        System.out.println();
    }

    @Test
    public void testLocalTime() {
        //Display Local Time
        LocalTime timeNow = LocalTime.now();
        System.out.println(" The Time now is: " + timeNow);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String formattedTime = timeNow.format(formatter);
        System.out.println("Time in format \"hh:mm:ss\" is: " + formattedTime);
        System.out.println();

        LocalTime timeNow2 = LocalTime.now();
        System.out.println(" The Time now is: " + timeNow);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime2 = timeNow.format(formatter2);
        System.out.println("Time in format \"HH:mm:ss\" is: " + formattedTime2);
        System.out.println();

        LocalTime timeNow3 = LocalTime.now();
        System.out.println(" The Time now is: " + timeNow3);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime3 = timeNow.format(formatter3);
        System.out.println("Time in format \"HH:mm\" is: " + formattedTime3);
    }

    @Test
    public void testConvertStringToLocalDate() {
        //Converting a String to a Date
        LocalDate date = LocalDate.parse("2018-05-05");
        System.out.println("String converted to Date: " + date);
        System.out.println();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedStringDate = date.format(formatter);
        System.out.println("The String \"2018-05-05\" Converted and formatted in Date is: " + formattedStringDate);
    }

    @Test
    public void testConvertStringLocalDateTime() {

        LocalDateTime localDateTime = LocalDateTime.parse("2020-03-29T13:28:11");
        System.out.println("String \"2020-03-29T13:28:11\" converted to LocalDateTime is: " + localDateTime);
        System.out.println();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm");
        String formattedStringDateTime = localDateTime.format(formatter);
        System.out.println("The above String after formatting to \"dd/MMM/yyyy HH:mm\" is: " + formattedStringDateTime);

        System.out.println("After formatting, the LocalDatetime object is: " + localDateTime);
        System.out.println();
        //Notice the localDateTime object remains unformatted.  After formatting the localDateTime, only the returning
        //String is formatted not the object itself.

        //Note, To convert String objects to LocalDate and LocalDateTime objects, the String must represent a
        // valid date or time according to ISO_LOCAL_DATE or ISO_LOCAL_DATE_TIME.
        // Otherwise, a DateTimeParseException will be thrown at runtime.

//        System.out.println();
//        LocalDate localDate = LocalDate.parse("07-07-2022"); //This will through DateTimeParseException as Date should be American format (2022-07-07)
//        System.out.println(localDate);

        //Exception: java.time.format.DateTimeParseException: Text '07-07-2022' could not be parsed at index 0
        //Note index 0 in American format is reserved for the year, and for UK index 0 is reserved for the Day.

    }

    @Test
    public void parsingFormatStringSameTime() {

//        String strTime = "2022-07-05";
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate localDate = LocalDate.parse("2022/07/05", formatter1);
//        System.out.println(localDate);

        String str = "2016-03-04T11:30";
        LocalDateTime localDateTime = LocalDateTime.parse(str);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDate = localDateTime.format(formatter);
        //LocalDateTime dateTime = LocalDateTime.parse(str, formatter);  //Does not work.
        System.out.println("String converted to LocalDateTime object: " + localDateTime);
        System.out.println("Formatted Date Time: " + formattedDate);


        String strTime = "2022-07-05";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(strTime);
        String formattedDate2 = localDate.format(formatter1);
        System.out.println(localDate);
        System.out.println(formattedDate2);
    }

    @Test
    public void parsingZonedDateTime() {
//        String zonedDateTimeStr = "2022-07-07T21:08:11 z";   //Doesn't work.  To be investigated.
//
//        DateTimeFormatter zonedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
//        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2022-07-07 22:06:11 europe/paris");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2015-05-05 10:15:30 Europe/Paris", formatter);

        System.out.println(zonedDateTime2);
    }
}

