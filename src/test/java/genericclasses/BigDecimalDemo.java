package genericclasses;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BigDecimalDemo {

    @Test
    public void testingBigDecimal(){
        //For ease of initialization BigDecimal class has some pre-defined constants:
        //BigDecimal.ONE, BigDecimal.ZERO and BigDecimal.TEN
        BigDecimal bd1 = BigDecimal.ONE;
        BigDecimal bd2 = BigDecimal.ZERO;
        BigDecimal bd3 = BigDecimal.TEN;
        BigDecimal bd4 = new BigDecimal("11");

        //Negate convert the number to a negative value
        BigDecimal bd5 = bd4.negate();

        System.out.println(bd1);  //Output: 1
        System.out.println(bd2);  //Output: 0
        System.out.println(bd3);  //Output: 10
        System.out.println(bd4);  //Output: 11
        System.out.println(bd5);  //Output: -11
    }
    @Test
    public void testingBigDecimal2() {
        //BigDecimal has methods to extract various attributes, such as precision, scale, and sign.
        BigDecimal bd6 = BigDecimal.valueOf(-1288798.229907);

        System.out.println("BigDecimal precision number  for -1288798.229907 is: " + bd6.precision());
        System.out.println("And the Scale is: " + bd6.scale());
        System.out.println("The number sign is: " + bd6.signum());
        System.out.println();
    }


        @Test
        public void whenEqualsCalled_thenSizeAndScaleMatched() {
            //The equals method considers two BigDecimal objects as equal only if they are equal in value and scale.
            // Thus, BigDecimals 1.0 and 1.00 are not equal when compared by this method.
            BigDecimal bd1 = new BigDecimal("1.0");
            BigDecimal bd2 = new BigDecimal("1.00");

            assertFalse(bd1.equals(bd2));
        }

        @Test
        public void comparingBigDecimals(){
            //We compare the value of two BigDecimals using the compareTo method.
            // The compareTo returns -1(less than), 0(Equal), 1(greater than) according to values.
            BigDecimal bd = BigDecimal.valueOf(11.5);
            BigDecimal bd1 = BigDecimal.valueOf(5.2);
            BigDecimal bd3 = BigDecimal.valueOf(5.21);
            BigDecimal bd4 = BigDecimal.valueOf(5.2);

            assertTrue(bd.compareTo(bd1) > 0);
            assertTrue(bd1.compareTo(bd) < 0);
            //The compareTo method does not seem to ignore the scale while comparing.
            // More testing to follow.  See page 112 Java Notes.
            assertFalse(bd3.compareTo(bd4) == 0);
        }


    }

