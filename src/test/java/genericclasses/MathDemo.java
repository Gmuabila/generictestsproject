package genericclasses;

import org.junit.Test;

public class MathDemo {
    //Math class  ****
    //Math Class methods help to perform the numeric operations like square,
    //square root, cube, cube root, exponential and trigonometric operations.
    int i = 7;
    int j = -9;
    double x = 72.3;
    double y = 0.34;

    @Test
    public void displayFieldsValues(){
        System.out.println("i is " + i);
        System.out.println("j is " + j);
        System.out.println("x is " + x);
        System.out.println("y is " + y);
    }

    @Test
    public void absoluteValue(){
        //Absolute value
        //The absolute value of a number is equal to the number if the number is
        //positive or zero and equal to the negative of the number if the number is negative.
        int z = 0;
        System.out.println("The absolute value of " + i + " is: " + Math.abs(i));
        System.out.println("The absolute value of " + j + " is: " + Math.abs(j));
        System.out.println("The absolute value of " + x + " is: " + Math.abs(x));
        System.out.println("The absolute value of " + y + " is: " + Math.abs(y));
        System.out.println("The absolute value of " + z + " is: " + Math.abs(z));
    }

    @Test
    public void truncatingAndRoundingFunctions(){
        // Truncating and Rounding functions
        // You can round off a floating point number to the nearest integer with the round() method.
        double v = 33.8;
        double r = 75.50;
        System.out.println(x + " is approximately " + Math.round(x));
        System.out.println(y + " is approximately " + Math.round(y));
        System.out.println(v + " is approximately " + Math.round(v));
        System.out.println(r + " is approximately " + Math.round(r));
    }

    @Test
    public void ceiling(){
        // The "ceiling" of a number is the smallest integer greater than or equal to the number.
        // Every integer is its own ceiling.
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
        // The "floor" of a number is the largest integer less than or equal to the number.
        // Every integer is its own floor.
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
    public void comparisonOperatorMin(){
        // Comparison operators
        // min() returns the smaller of the two arguments you pass it
        System.out.println("min(" + i + "," + j + ") is " + Math.min(i,j));
        System.out.println("min(" + x + "," + y + ") is " + Math.min(x,y));
        System.out.println("min(" + i + "," + x + ") is " + Math.min(i,x));
        System.out.println("min(" + y + "," + j + ") is " + Math.min(y,j));
    }

    @Test
    public void comparisonOperatorMax(){
        // There's a corresponding max() method
        // that returns the larger of two numbers
        System.out.println("max(" + i + "," + j + ") is " + Math.max(i,j));
        System.out.println("max(" + x + "," + y + ") is " + Math.max(x,y));
        System.out.println("max(" + i + "," + x + ") is " + Math.max(i,x));
        System.out.println("max(" + y + "," + j + ") is " + Math.max(y,j));
    }

    @Test
    public void power(){
        // pow(x, y) returns the x raised
        // to the yth power.
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

    @Test
    public void squareRoot(){
        // sqrt(x) returns the square root of x.
        for (i=0; i < 10; i++) {
            System.out.println(
                    "The square root of " + i + " is " + Math.sqrt(i));
        }
    }

    @Test
    public void random(){
        // Random method ****
        // Random method of the Math class returns a pseudo-random number
        // between 0.0 and 1.0;
        System.out.println("Here's one random number: " + Math.random());
        System.out.println("Here's another random number: " + Math.random());
    }
}
