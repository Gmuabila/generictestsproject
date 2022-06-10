package genericclasses;

import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/*The aim here is to display the String to use for
searching Mongo DB using the _id field and its value in JSON format.
This can be applied in expression such as (String referralQuery = "{\"_id\":\"" + referralId + "\"}";)
The Output result is : {"_id":"5509911"} */
public class BackSlashUseDemo {

    @Test
    public void testBackSlashUse() {
        String referralId = "5509911";

        System.out.println("{\"_id\":\"" + referralId + "\"}");
        System.out.println("{_id:" + referralId + "}");
    }
    //Found that \ allows you to display quotes if needed.
    //Here we need to display the string {"_id":"5509911"}
    //But the quotes in _id and the quotes between the value have to be displayed as well
    //To do this, the quotes between these should be preceded by the \ for it to display.

    @Test
    public void testBigDecimal() {
        double a = 0.03;
        double b = 0.04;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.03");
        BigDecimal _b = new BigDecimal("0.04");
        BigDecimal _c = _b.subtract(_a);
        System.out.println("BigDecimal.....");
        System.out.println(_c);
        System.out.println("\n");

        System.out.println("BigDecimal... Setting scale....");
        BigDecimal r = new BigDecimal("9.2239678");
        BigDecimal roundedR = r.setScale(3, RoundingMode.HALF_EVEN);
        System.out.println(roundedR);
        System.out.println("");

//We can create a BigDecimal object from String, character array, int, long, and BigInteger:
        System.out.println("Creating a BigDecimal from an array");
        BigDecimal bdFromCharArray = new BigDecimal(new char[] {'3','.','1','6','1','5'});
        System.out.println(bdFromCharArray);

        System.out.println("Creating BigDecimal from Long number...");
        BigDecimal bdFromLong = new BigDecimal(123412345678901L);
        System.out.println(bdFromLong);

        System.out.println("");
        System.out.println("Creating BigDecimal from BigInteger.......");
        System.out.println("Creating BigDecimal from BigInteger.ONE.......");
        BigDecimal bigIntergerOne = BigDecimal.ONE;
        System.out.println(bigIntergerOne);
        System.out.println("");
        System.out.println("Creating BigDecimal from BigInteger.Random......");
        BigInteger bigIntegerRandom = BigInteger.probablePrime(8, new Random());
        BigDecimal bdFromBigInteger = new BigDecimal(bigIntegerRandom);
        System.out.println(bdFromBigInteger);

        assertEquals(3.1615d,Double.parseDouble(bdFromCharArray.toString()), 2);
        assertEquals(bigIntegerRandom.toString(),bdFromBigInteger.toString());

        // We should use the String constructor instead of the double constructor.
        // In addition, we can convert double and long to BigDecimal using the valueOf static method:
        BigDecimal bdFromLong1 = BigDecimal.valueOf(123412345678901L);
        BigDecimal bdFromLong2 = BigDecimal.valueOf(123412345678901L, 2);
        BigDecimal bdFromDouble = BigDecimal.valueOf(0.1d);

        assertEquals("123412345678901", bdFromLong1.toString());
        assertEquals("1234123456789.01", bdFromLong2.toString());
        assertEquals("0.1", bdFromDouble.toString());

    }

    @Test
    public void testBigDecimalTest2(){

        // Create two new BigDecimals
        BigDecimal bd1 = new BigDecimal("22.01");
        BigDecimal bd2 = new BigDecimal("13.11");

        // Addition of two BigDecimals
        bd1 = bd1.add(bd2);
        System.out.println("Adding the two BigDecimals = " + bd1);

        // Multiplication of two BigDecimals
        bd1 = bd1.multiply(bd2);
        System.out.println("Multiply the two BigDecimals = " + bd1);

        // Subtraction of two BigDecimals
        bd1 = bd1.subtract(bd2);
        System.out.println("Substruction of the two BigDecimals = " + bd1);

        // Division of two BigDecimals
        bd1 = bd1.divide(bd2);
        System.out.println("Dividing the two BigDecimals = " + bd1);

        // BigDecima1 raised to the power of 2
        bd1 = bd1.pow(2);
        System.out.println("BigDecimal raised to the power of two = " + bd1);

        // Negate value of BigDecimal1
        bd1 = bd1.negate();
        System.out.println("Negative value of BigDecimal = " + bd1);

//        // Substract a big value from a smaller value
//        bd2 = bd2.subtract(bd1); // Gives inaccurate result of 1177.2844
//        System.out.println("BigDecimal 13.11 - 22.01 = " + bd2);
//
//        // Divide a big value from a smaller value
//        bd2 = bd2.divide(bd1);  // Throws ArithmethicException
//        System.out.println("BigDecimal 13.11 / 22.01 = " + bd2);

        //BigDecimal has methods to extract various attributes, such as precision, scale, and sign:
        BigDecimal bd = new BigDecimal("-12345.6789");

        System.out.println("");
        System.out.println("Precision is : " + bd.precision());
        System.out.println("The scale is: " + bd.scale());
        System.out.println("The signum is: " + bd.signum());

        assertEquals(9, bd.precision());
        assertEquals(4, bd.scale());
        assertEquals(-1, bd.signum());
    }

    @Test
    public void roundindBigDecimalsTest1(){

        BigDecimal bd = new BigDecimal("2.501233");
        // Round to 1 digit using HALF_EVEN
        BigDecimal rounded = bd.round(new MathContext(4, RoundingMode.HALF_EVEN));
        System.out.println("Rounded 2.501233 BigDecimal number: " + rounded);

        assertEquals("2.501", rounded.toString());


    }

    //Let's write a method to calculate the total amount to be paid for an item given a quantity and unit price.
    // Let's also apply a discount rate and sales tax rate.
    // We round the final result to cents by using the setScale method:
    public static BigDecimal calculateTotalAmount(BigDecimal quantity,
                                                  BigDecimal unitPrice, BigDecimal discountRate, BigDecimal taxRate) {
        BigDecimal amount = quantity.multiply(unitPrice);
        BigDecimal discount = amount.multiply(discountRate);
        BigDecimal discountedAmount = amount.subtract(discount);
        BigDecimal tax = discountedAmount.multiply(taxRate);
        BigDecimal total = discountedAmount.add(tax);
        // round to 2 decimal places using HALF_EVEN
        BigDecimal roundedTotal = total.setScale(2, RoundingMode.HALF_EVEN);
        return roundedTotal;
    }
    @Test
    public void givenPurchaseTxn_whenCalculatingTotalAmount_thenExpectedResult() throws ParseException {
        BigDecimal quantity = new BigDecimal("4.5");
        BigDecimal unitPrice = new BigDecimal("2.69");
        BigDecimal discountRate = new BigDecimal("0.10");
        BigDecimal taxRate = new BigDecimal("0.0725");
        BigDecimal amountToBePaid = calculateTotalAmount(quantity, unitPrice, discountRate, taxRate);

        assertEquals("11.68", amountToBePaid.toString());

        int x = 3413;
        BigInteger c = BigInteger.valueOf(x);
        BigInteger a = new BigInteger("3556");
        System.out.println(x);
        System.out.println(a);
        assertEquals(new BigInteger("3413"), c);
        assertEquals(new BigInteger("3556"), a);

        // Extraction of value from BigInteger is as follows
        int valueInBigInteger = a.intValue();
        System.out.println("Extracted int value from BigInteger is: " + valueInBigInteger);
        String strInBigInt = a.toString();
        System.out.println("Extracted String value from BigInteger is: " + strInBigInt);

        BigInteger biFromByteArray = new BigInteger(new byte[]{64, 64, 64, 64, 64, 64});
        BigInteger biFromSignMagnitude = new BigInteger(-1, new byte[]{64, 64, 64, 64, 64, 64});
        System.out.println(biFromByteArray);
        System.out.println(biFromSignMagnitude);

    }

    @Test
    public void timeDiff(){

//        Time fromTime = new Time(12,15, 00);
//        Time toTime = new Time(13,00, 00);
//        Time numberOfHours;
//        numberOfHours = difference
//
//        DateTime startTime = new DateTime();
//        DateTime endTime = new DateTime();
//        Period p = new Period(startTime, endTime);
//        int hours = p.getHours();
//        int minutes = p.getMinutes();


// Dates to be parsed
        String time1 = "19:00:00";
        String time2 = "01:30:50";

        // Creating a SimpleDateFormat object
        // to parse time in the format HH:MM:SS
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            // Parsing the Time Period
            Date date1 = simpleDateFormat.parse(time1);
            Date date2 = simpleDateFormat.parse(time2);
        // Calculating the difference in milliseconds
        long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());

        // Calculating the difference in Hours
        long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000))
                % 24;

        // Calculating the difference in Minutes
        long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;

        // Calculating the difference in Seconds
        long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;

        // Printing the answer
        System.out.println("Difference is " + differenceInHours + " hours " + differenceInMinutes + " minutes "
                        + differenceInSeconds + " Seconds. ");
        }
        catch (Exception e) {
            System.out.println(".........");

        }
    }

    @Test
    public void timeDiffTwo(){

        // Parsing Time Period in the format HH:MM:SS
        LocalTime time1 = LocalTime.of(23, 00, 00);
        LocalTime time2 = LocalTime.of(01, 00, 00);

        // Calculating the difference in Hours
        long hours = ChronoUnit.HOURS.between(time1, time2);

        // Calculating the difference in Minutes
        long minutes = ChronoUnit.MINUTES.between(time1, time2) % 60;

        // Calculating the difference in Seconds
        long seconds = ChronoUnit.SECONDS.between(time1, time2) % 60;

        // Printing the difference
        System.out.println("Difference is " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");

    }

    @Test
    public void timeDiffThree(){
       String start_date = "10-01-2022 05:00:00";
       String end_date = "11-01-2022 16:00:00";
        // Function to print difference in
        // time start_date and end_date
            // SimpleDateFormat converts the
            // string format to date object
            SimpleDateFormat sdf
                    = new SimpleDateFormat(
                    "dd-MM-yyyy HH:mm:ss");

            // Try Class
            try {

                // parse method is used to parse
                // the text from a string to
                // produce the date
                Date d1 = sdf.parse(start_date);
                Date d2 = sdf.parse(end_date);

                // Calucalte time difference
                // in milliseconds
                long difference_In_Time
                        = d2.getTime() - d1.getTime();

                // Calucalte time difference in seconds,
                // minutes, hours, years, and days
                long difference_In_Seconds
                        = TimeUnit.MILLISECONDS
                        .toSeconds(difference_In_Time)
                        % 60;

                long difference_In_Minutes
                        = TimeUnit
                        .MILLISECONDS
                        .toMinutes(difference_In_Time)
                        % 60;

                long difference_In_Hours
                        = TimeUnit
                        .MILLISECONDS
                        .toHours(difference_In_Time)
                        % 24;

                long difference_In_Days
                        = TimeUnit
                        .MILLISECONDS
                        .toDays(difference_In_Time)
                        % 365;

                long difference_In_Years
                        = TimeUnit
                        .MILLISECONDS
                        .toDays(difference_In_Time)
                        / 365l;

                // Print the date difference in
                // years, in days, in hours, in
                // minutes, and in seconds
                System.out.print(
                        "Difference"
                                + " between two dates is: ");

                // Print result
                System.out.println(
                        difference_In_Years
                                + " years, "
                                + difference_In_Days
                                + " days, "
                                + difference_In_Hours
                                + " hours, "
                                + difference_In_Minutes
                                + " minutes, "
                                + difference_In_Seconds
                                + " seconds");
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

    }

    @Test
    public void trimMethodDemo(){

        String myStr = "       Hello World!       ";
        System.out.println(myStr);
        System.out.println(myStr.trim());
    }

}





