package genericclasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//    FizzBuzz
//    Using TDD, create a function called fizzbuzz that accepts an Int and returns a String
//    When the input is divisible by 3, return “fizz”
//    When the input is divisible by 5, return “buzz”
//    When the input is divisible by 3 and 5, return “fizzbuzz”
//    Otherwise, returns the input as a String
public class FizzBuzz {

    public String fizzbuzz(int x) {
        String result;

        if (x % 3 == 0 && x % 5 == 0) {
            result = "fizzbuzz";
        } else if (x % 3 == 0) {
            result = "fizz";
        } else if (x % 5 == 0) {
            result = "buzz";
        } else {
            result = String.valueOf(x);
        }
        return result;
    }

    @Test
    public void testFizzbuzzOne() {

        assertEquals("fizz", fizzbuzz(3));
        assertEquals("buzz", fizzbuzz(5));
        assertEquals("fizzbuzz", fizzbuzz(15));
        assertEquals("22", fizzbuzz(22));
    }

    @Test
    public void testFizzbuzzFour() {
        String result = fizzbuzz(15);

        System.out.println(result);
    }


    // Write a program that prints the numbers from 1 to 100 and for multiples of ‘3’ print “Fizz” instead of
    // the number and for the multiples of ‘5’ print “Buzz”.
    public void fizzbuzzTwo() {
        int n = 100;

        // loop for 100 times
        for (int i = 1; i <= n; i++) {
            //number divisible by 15(divisible by
            // both 3 & 5), print 'FizzBuzz' in
            // place of the number
            if (i % 15 == 0)
                System.out.println("FizzBuzz");
                // number divisible by 5, print 'Buzz'
                // in place of the number
            else if (i % 5 == 0)
                System.out.println("Buzz");

                // number divisible by 3, print 'Fizz'
                // in place of the number
            else if (i % 3 == 0)
                System.out.println("Fizz");

            else // print the numbers
                System.out.println(i);
        }

        /* Output:
        1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz
        28 29 FizzBuzz 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz 41 Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz Fizz 52 53
        Fizz Buzz 56 Fizz 58 59 FizzBuzz 61 62 Fizz 64 Buzz Fizz 67 68 Fizz Buzz 71 Fizz 73 74 FizzBuzz 76 77 Fizz 79
        Buzz Fizz 82 83 Fizz Buzz 86 Fizz 88 89 FizzBuzz 91 92 Fizz 94 Buzz Fizz 97 98 Fizz Buzz
         */

    }


    @Test
    public void testFizzbuzzTwo(){
        fizzbuzzTwo();

    }


    //Using Switch
//    public String fizzbuzzTwo(int num) {
//        String result;
//Note: The type of the Expression must be char, byte, short, int, Character, Byte,
// Short, Integer, String, or an enum type, or a compile-time error occurs.
//        switch (num) {
//            case (num % 3 == 0 && num % 5 == 0):
//                result = "fizzbuzz";
//                break;
//            case num % 3 == 0:
//                result = "fizz";
//                break;
//            case num % 5 == 0:
//                result = "buzz";
//                break;
//            default:
//                result = String.valueOf(num);
//        }
//        return result;
//
//    }
}