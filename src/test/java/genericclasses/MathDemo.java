package genericclasses;

import org.junit.Test;

public class MathDemo {
    /** Math class  ****
    Math Class methods are used to perform the numeric operations like square,
    square root, cube, cube root, exponential, and trigonometric operations.
     */

    @Test
    public void absoluteValue(){
        /** abs() method
        Absolute values
        The Absolute value of a number describes the distance from zero that a number is on the number line,
        without considering direction. The absolute value of a number is never negative.
        The absolute value of a number is equal to the number if the number is positive.
        if the number is negative, the absolute value of the number is the positive value of this number
        Example: The absolute number of 5 is 5, The absolute number of -3 is 3.
        And The absolute number of 0 is 0 (This is why we don't say that the absolute value of a number is positive.
        Zero is neither negative nor positive).
         */
        int i = 7;
        int j = -9;
        double x = 72.3;
        double y = 0.34;
        int z = 0;
        System.out.println("The absolute value of " + i + " is: " + Math.abs(i));
        System.out.println("The absolute value of " + j + " is: " + Math.abs(j));
        System.out.println("The absolute value of " + x + " is: " + Math.abs(x));
        System.out.println("The absolute value of " + y + " is: " + Math.abs(y));
        System.out.println("The absolute value of " + z + " is: " + Math.abs(z));
    }

    @Test
    public void truncatingAndRoundingFunctions(){
        /** round() method
        Truncating and Rounding functions
        The round() method is used to round off a floating point number to the nearest integer.
         */
        int i = 7;
        int j = -9;
        double x = 72.3;
        double y = 0.34;
        double v = 33.8;
        double r = 75.50;
        System.out.println(x + " is approximately " + Math.round(x));
        System.out.println(y + " is approximately " + Math.round(y));
        System.out.println(v + " is approximately " + Math.round(v));
        System.out.println(r + " is approximately " + Math.round(r));
    }

    @Test
    public void ceiling(){
        /** ceiling() Method
        The "ceiling" of a number is the smallest integer greater than or equal to the number.
        Every integer is its own ceiling.
         */
        int i = 7;
        int j = -9;
        double x = 72.3;
        double y = 0.34;
        float r = 1.15f;
        float w = 0.99f;
        float t = 2.78f;
        System.out.println("The ceiling of " + i + " is " + Math.ceil(i));
        System.out.println("The ceiling of " + j + " is " + Math.ceil(j));
        System.out.println("The ceiling of " + x + " is " + Math.ceil(x));
        System.out.println("The ceiling of " + y + " is " + Math.ceil(y));
        System.out.println("The ceiling of " + r + " is " + Math.ceil(r));
        System.out.println("The ceiling of " + w + " is " + Math.ceil(w));
        System.out.println("The ceiling of " + t + " is " + Math.ceil(t));
    }

    @Test
    public void floor(){
        /** floor() method
        The "floor" of a number is the largest integer less than or equal to the number.
        Every integer is its own floor.
         */
        int i = 7;
        int j = -9;
        double x = 72.3;
        double y = 0.34;
        float r = 0.25f;
        float w = 1.15f;
        double z = 2.78d;
        double t = 0.99d;

        System.out.println("The floor of " + i + " is " + Math.floor(i));
        System.out.println("The floor of " + j + " is " + Math.floor(j));
        System.out.println("The floor of " + x + " is " + Math.floor(x));
        System.out.println("The floor of " + y + " is " + Math.floor(y));
        System.out.println("The floor of " + r + " is " + Math.floor(r));
        System.out.println("The floor of " + w + " is " + Math.floor(w));
        System.out.println("The floor of " + z + " is " + Math.floor(z));
        System.out.println("The floor of " + t + " is " + Math.floor(t));
    }

    @Test
    public void power(){
        /** pow(x, y) method
         The pow(x, y) method returns the x raised to the yth power.
         */
        int x = 2;
        int y = 5;
        int r = 3;
        System.out.println("pow(2.0, 2.0) is "  + Math.pow(2.0,2.0));
        System.out.println("pow(10.0, 3.5) is " + Math.pow(10.0,3.5));
        System.out.println("pow(8, -1) is "     + Math.pow(8,-1));
        System.out.println("pow(" + x + "," + r + ") is: " + Math.pow(x, r));
        System.out.println("pow(" + y + "," + r + ") is: " + Math.pow(y, r));
    }

    @Test
    public void squareRoot(){
        /** sqrt() method
         * The sqrt() method returns the Square root of the number passed as an argument.
         */
        int x = 9;
        int y = 16;
        int z = 25;
        int w = 64;
        // sqrt(x) returns the square root of x.
        System.out.println("The square root of " + x + " is: " + Math.sqrt(x));
        System.out.println("The square root of " + y + " is: " + Math.sqrt(y));
        System.out.println("The square root of " + z + " is: " + Math.sqrt(z));
        System.out.println("The square root of " + w + " is: " + Math.sqrt(w));
    }

    @Test
    public void cubeRoot(){
        /** cbrt() method
         The cbrt() method returns the cube root of the number passed to it as an argument.
         */
        int x = 8;
        int y = 27;
        int w = 64;
        int z = 125;
        //cbrt(x) returns the cube root of x.
        System.out.println("The cube root of " + x + " is: " + Math.cbrt(x));
        System.out.println("The cube root of " + y + " is: " + Math.cbrt(y));
        System.out.println("The cube root of " + w + " is: " + Math.cbrt(w));
        System.out.println("The cube root of " + z + " is: " + Math.cbrt(z));
    }

    @Test
    public void comparisonOperatorMin(){
        /** Comparison operators
         min() method returns the smaller number of the two arguments you pass it.
         max() method returns the largest number of the two arguments passed to it.
         */
        int i = 7;
        int j = -9;
        double x = 72.3;
        double y = 0.34;
        System.out.println("min() method:");
        System.out.println("min(" + i + "," + j + ") is " + Math.min(i,j));
        System.out.println("min(" + x + "," + y + ") is " + Math.min(x,y));
        System.out.println("min(" + i + "," + x + ") is " + Math.min(i,x));
        System.out.println("min(" + y + "," + j + ") is " + Math.min(y,j));
        System.out.println();
        System.out.println("max() method:");
        System.out.println("max(" + i + "," + j + ") is " + Math.max(i,j));
        System.out.println("max(" + x + "," + y + ") is " + Math.max(x,y));
        System.out.println("max(" + i + "," + x + ") is " + Math.max(i,x));
        System.out.println("max(" + y + "," + j + ") is " + Math.max(y,j));
    }


    @Test
    public void random(){
        /** Random() method
        The random() method returns a pseudorandom double type number greater than or equal to 0.0 and less than 1.0.
        When this method is first called, it creates a single new pseudorandom-number generator, exactly as if by
        the expression new java.util.Random.
        ** Pseudorandom number:
        Software-generated random numbers only are pseudorandom. They are not truly random because the computer uses an
        algorithm based on a distribution, and are not secure because they rely on deterministic, predictable algorithms.
        Any pseudorandom number generator eventually has to repeat or cycle since there are a finite number of internal states.
        One would like the cycle length to be longer than a typical run.  It may be pointed out that the number returned by
        random() method is a pseudo-random number as no computer can generate a truly random number,
        that exhibits randomness over all scales and over all sizes of data sets.
         */
        System.out.println("Here's one random number: " + Math.random());
        System.out.println("Here's another random number: " + Math.random());
        System.out.println();
        // Generate random number
        double rand = Math.random();
        // Output is different everytime this code is executed
        System.out.println("Random Number:" + rand);
    }

    @Test
    public void randomTwo(){
        //Now to get random integer numbers from a given fixed range, we take a min and max variable to define the
        //range for our random numbers, both min and max are inclusive in the range.
        // define the range
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        // generate random numbers within 1 to 10
        for (int i = 0; i < 10; i++) {
            int rand = (int)(Math.random() * range) + min;
            // Output is different everytime this code is executed
            System.out.println(rand);
        }
    }

    @Test
    public void comparisonOperatorMax(){
        // There's a corresponding max() method
        // that returns the larger of two numbers
        int i = 7;
        int j = -9;
        double x = 72.3;
        double y = 0.34;
        System.out.println("max(" + i + "," + j + ") is " + Math.max(i,j));
        System.out.println("max(" + x + "," + y + ") is " + Math.max(x,y));
        System.out.println("max(" + i + "," + x + ") is " + Math.max(i,x));
        System.out.println("max(" + y + "," + j + ") is " + Math.max(y,j));
    }

    @Test
    public void mathConstants(){
        // The Math library defines a couple of useful constants:
        System.out.println("Pi is " + Math.PI);
        System.out.println("e is " + Math.E);
    }

    @Test
    public void trigonometricMethods(){
        // Trigonometric methods.
        // All arguments are given in radians.  Convert a 45 degree angle to radians
        double angle = 45.0 * 2.0 * Math.PI/360.0;
        System.out.println("cos(" + angle + ") is " + Math.cos(angle));
        System.out.println("sin(" + angle + ") is " + Math.sin(angle));
    }

    @Test
    public void inverseTrigonometricMethods(){
        // Inverse Trigonometric methods. All values are returned as radians
        double value = 0.707;
        System.out.println("acos(" + value + ") is " + Math.acos(value));
        System.out.println("asin(" + value + ") is " + Math.asin(value));
        System.out.println("atan(" + value + ") is " + Math.atan(value));
    }

    @Test
    public void exponentialAndLogarithmicMethod(){
        // Exponential and Logarithmic Methods
        // exp(a) returns e (2.71828...) raised
        // to the power of a.
        int x = 2;
        int y = 5;
        System.out.println("exp(1.0) is "  + Math.exp(1.0));
        System.out.println("exp(10.0) is " + Math.exp(10.0));
        System.out.println("exp(0.0) is "  +  Math.exp(0.0));
        System.out.println("exp(" + x + ") is " + Math.exp(x));
        System.out.println("exp(" + y + ") is " + Math.exp(y));
    }

    @Test
    public void logarithm(){
        // log(a) returns  the natural
        // logarithm (base e) of a.
        System.out.println("log(1.0) is "    + Math.log(1.0));
        System.out.println("log(10.0) is "   + Math.log(10.0));
        System.out.println("log(Math.E) is " + Math.log(Math.E));
    }
}
