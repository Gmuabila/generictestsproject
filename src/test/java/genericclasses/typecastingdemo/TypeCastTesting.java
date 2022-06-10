package genericclasses.typecastingdemo;

import org.junit.Test;

public class TypeCastTesting {

    @Test
     public void typeCastTesting(){
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
    }
