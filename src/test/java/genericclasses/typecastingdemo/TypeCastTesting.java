package genericclasses.typecastingdemo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypeCastTesting {

    @Test
    public void typeCastTesting() {
        //Narrowing or Explicit Casting: Manual Type conversion
        //Narrowing or explicit casting must be done manually by placing the type in parentheses in front of the value
        double myDouble = 9.78d;
        int myInt = (int) myDouble; // Manual casting: double to int
        System.out.println(myDouble);   // Outputs 9.78
        System.out.println(myInt);      // Outputs 9

        int x = (int) 155.46;
        System.out.println("\nDouble converted to Integer: " + x);

        //Convert String to Double.
        String str = "129";
        double d = Double.parseDouble(str);
        System.out.println("\nString '123' converted to Double is: .\n" + d);

        str = String.valueOf(d);
        System.out.println("\nDouble reconverted back to String:\n" + str);

        //Widening or Implicit Casting: Automatic Type conversion
        int i = 150;
        //automatic type conversion
        long l = i;
        //automatic type conversion
        float f = l;
        System.out.println("\nInt value: " + i);
        System.out.println("Long value: " + l);
        System.out.println("Float value: " + f);

        int number = 9;
        double t = number; // Automatic casting: int to double
        System.out.println("\nvalue of Integer: " + number);      // Outputs 9
        System.out.println("Integer to Double: " + t);   // Outputs 9.0
    }

    // The parseDouble() method of Java Double class is a built-in method in Java that
    // returns a new double initialized to the value represented by the specified String.
    //It accepts a single mandatory parameter which specifies the string to be parsed.
    //and returns a double value represented by the string argument.
    //The method throws two exceptions:
    //NullPointerException– when the string parsed is null
    //NumberFormatException– when the string parsed does not contain a parsable float
    @Test
    public void typeCastTestingTwo() {
        //To show NumberFormatException
        // Java Code to implement parseDouble() method of Double class
        try {
            String str = "";
            // returns the double value
            // represented by the string argument
            double val = Double.parseDouble(str);
            // prints the double value
            System.out.println("Value = " + val);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void typeCastTestingThree() {
        //To show NullPointerException
        // Java Code to implement parseDouble() method of Double class
        try {
            String str = null;
            // returns the double value
            // represented by the string argument
            double val = Double.parseDouble(str);
            // prints the double value
            System.out.println("Value = " + val);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void typeCastTestingFour() {
        String str = "100";
        //Converting a String to double
        double d = Double.valueOf(str);
        System.out.println("Convert String to double: " + d);
        //Converting a String to int
        int i = Integer.valueOf(str);
        System.out.println("\nConvert String to int: " + i);
        //Converting a String to float
        float f = Float.valueOf(str);
        System.out.println("\nConvert String to Float: " + f);
        //Converting String to long
        long l = Long.valueOf(str);
        System.out.println("\nConvert String to long: " + l);
    }

    @Test
    public void typeCastTestingFive() {
        //  valueOf() Method of String class
        //The java String valueOf() method converts different types of values into String.
        // You can use String valueOf() method to convert int to string, long to string,
        // boolean to string, character to string, float to string, double to string,
        // object to string and char array to string. It is a static method that is
        // overloaded within string for all of Java’s build-in types, so that each type can
        // be converted properly into a string.   It is called when a string representation of
        // some other type data is needed, for example during concatenation operation,
        // you can call this method with any data type and get a reasonable String representation of the data type value.

        // boolean b = true;
        int iNum = 30;
        double fNum = 4.56789;
        String s = "91";
        //Converting boolean to String
        String str4 = String.valueOf(true);
        System.out.println(str4);

        // Returns the string representation of int iNum.
        String sample = String.valueOf(iNum);
        System.out.println(sample);
        // concatenating string with iNum
        System.out.println(sample + s);
        // Returns the string representation of the float
        // fnum.
        String sample2 = String.valueOf(fNum);
        System.out.println(sample2);
        // concatenating string with fNum
        System.out.println(s + sample2);

        System.out.println();
        //Converting long to String
        String str1 = String.valueOf(123l);
        System.out.println(str1);
        System.out.println();
        //Converting an int to String
        String str2 = String.valueOf(123);
        System.out.println(str2);
        System.out.println();
        //Converting float to String
        String str3 = String.valueOf(123f);
        System.out.println(str3);
    }

    @Test
    public void typeCastTestingSix() {
        char[] data
                = {'G', 'E', 'E', 'K', 'S', ' ', 'F', 'O',
                'R', ' ', 'G', 'E', 'E', 'K', 'S'};
        String sample;
        String sample2;
        // Returns the string representation
        // of a specific subarray of the chararray argument
        sample = String.valueOf(data, 0, 15);   //offset is the start index.  count starts from 1 not 0.
        System.out.println(sample);
        // Returns the string of charArray 0 to 5
        sample2 = String.valueOf(data, 0, 5);
        System.out.println(sample2);
        // Returns the string of charArray starting
        // index 6 and total count from 6 is 8
        sample = String.valueOf(data, 6, 8);
        System.out.println(sample);
    }

    @Test
    public void typeCastTestingSeven() {
        Integer expectedNumber = 11;
        Integer expectedNegativeNumber = -11;
        assertEquals(expectedNumber, Integer.valueOf("11"));
        assertEquals(expectedNumber, Integer.valueOf("+11"));
        assertEquals(expectedNegativeNumber, Integer.valueOf("-11"));
    }

    @Test
    public void typeCastTestingEight() {
        // The following example shows the
        // usage of <strong>valueOf(boolean sta)</strong method.
        // declare a String
        String text = "Geeks for Geeks";
        // check if String value contains a specific string
        boolean bool = text.contains("Geeks");
        // print the string equivalent of our boolean check
        System.out.println(String.valueOf(bool));
    }
}

