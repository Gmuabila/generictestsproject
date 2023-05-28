package genericclasses.wrapperclassesdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WrapperClassesTests {
    //****** Wrapper Classes ******
   // A Wrapper class wraps the value of the primitive data type in an object.
    // They provide a way to use primitive data types (int, boolean, etc..) as objects.

    // Using parseDouble() Method of Double Class to convert a String to double.
    // The parseDouble() method of Java Double class is a built-in method in Java that returns a
    // new double initialized to the value represented by the specified String.
    // Double class is a wrapper class for the primitive type double which contains several methods to
    // effectively deal with a double value like converting it to a string representation, and vice-versa.
    // An object of Double class can hold a single double value.

    @Test
    public void wrapperTestOne() {
        try {
            String str = null;
            double d = Double.parseDouble(str);
            System.out.println(d);
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e);
        }
    }

    @Test
    public void wrapperTestTwo(){
        //Converting primitive data type to its corresponding wrapper class.
        //Wrapper classes provide a way to use primitive data types as objects.

        //Basic Wrapper class tests
        Double db = 100.2;   //Same if you declare: Double db = 100.2D, or Double db = 100.2d
        double d = db;
        double m = db.doubleValue();
        double e = 115d;
        System.out.println("Converted Double to double using doubleValue(): " + m);
        System.out.println("Converted Double to double: " + d);
        Double dx = e;
        System.out.println("\nConverted double to Double: " + dx);

        Integer i = 188;
        int x = i;
        int y = 102;
        Integer t = y;

        System.out.println("\nPrinting Integer value 188 as double: " + i.doubleValue());
        System.out.println("\nPrinting Integer value 188 as float: " + i.floatValue());
        System.out.println("\nPrinting Double value 100.2 as int: " + db.intValue());
    }

    @Test
    public void wrapperTestThree(){
        //Using valueOf() method of the Double class to convert a String to double.
        //The java.lang.Double.valueOf(String s) method returns a Double object holding the double value represented by
        //the argument string s.  If the String s is null, then a NullPointerException is thrown,
        //and it returns a NumberFormatException if the string does not contain a parsable number.

        String s = "100";
        double d = Double.valueOf(s);
        System.out.println("String " + "\"" + "100" + "\"" + " converted to double: " + d);
    }

    @Test
    public void wrapperTestFour(){
        //Using the constructor of Double class to convert a String to double
        String s = "10227.34955";
        Double d = new Double(s);    //Note that this has been marked as deprecated.
        System.out.println("String converted to Double: " + d);
    }

    @Test
    public void wrapperTestFive(){
        //The java String valueOf() method converts different types of values into String.
        //You can use String valueOf() method to convert int to string, long to string, boolean to string,
        //character to string, float to string, double to string, object to string and char array to string.
        //It is a static method that is overloaded within string for all of Java’s build-in types,
        //so that each type can be converted properly into a string.
        //We can also convert a part of a char array to a String by passing:
        //•	offset – the index of the character to start converting from
        //•	count – the number of characters to convert
        //
        //***Available Signatures***
        //static String valueOf(int i)
        //static String valueOf(float f)
        //static String valueOf(boolean b)
        //static String valueOf(double d)
        //static String valueOf(char[] data, int offset, int count)
        //static String valueOf(long l)
        //static String valueOf(Object ob)
        //static String valueOf(char [] data)
        //The valueOf() method of the String class returns a string representation of the given value

        int i = 123;
        String str1 = String.valueOf(i);
        String str2 = String.valueOf(124l);
        String str3 = String.valueOf(125f);
        double d = 126.7551;
        String str4 = String.valueOf(d);
        boolean b = true;
        String str5 = String.valueOf(b);

        System.out.println("String for int: " + str1);
        System.out.println("String for long: " + str2);
        System.out.println("String for float: " + str3);
        System.out.println("String for double: " + str4);
        System.out.println("String for boolean: " + str5);
        //Concatenating Strings
        System.out.println("Concatenated Strings: " + str1 + str4);
    }

    @Test
    public void wrapperTestSix(){
        //Convert int to Integer with valueOf() method of the Integer class.
        //The first variant of valueOf() accepts an int as a parameter and returns the wrapper class Integer.
        //The java.lang.Integer.valueOf(int i) returns an Integer instance holding the integer value represented by
        //the argument int i.
        //In addition to int to Integer conversion, this method can also accept a char as a parameter and returns its Unicode value.
        Integer expectedNumber = 10;
        Integer expectedNegativeNumber = -10;
        Integer expectedUnicode = 65;
        assertEquals(expectedNumber, Integer.valueOf(10));
        assertEquals(expectedNumber, Integer.valueOf(+10));
        assertEquals(expectedNegativeNumber, Integer.valueOf(-10));
        assertEquals(expectedUnicode, Integer.valueOf('A'));  //Note that the method returns the Unicode value of charaters
        System.out.println("Unicode for char 'B' is: " + Integer.valueOf('B'));
        System.out.println("Unicode for char 'b' is: " + Integer.valueOf('b'));

        // Unicode is an international character encoding standard that provides a unique number for every
        // character across languages and scripts, making almost all characters accessible across platforms, programs, and devices.
        // The Unicode Standard is the universal character representation standard for text in computer processing.
        // The Unicode Standard provides a unique number for every character, no matter what platform, device, application or language.
        // It has been adopted by all modern software providers and now allows data to be transported through many different platforms,
        // devices and applications. Support of Unicode forms the foundation for the representation of languages and symbols in all
        // major operating systems, search engines, browsers, laptops, and smart phones—plus the Internet and
        // World Wide Web (URLs, HTML, XML, CSS, JSON, etc.). Supporting Unicode is the best way to implement ISO/IEC 10646.
    }

    @Test
    public void wrapperTestSeven(){
        //Convert String to Integer with valueOf() method of the Integer class.
        //The second variant of the valueOf(String s) method of java.lang.Integer accepts a String as a parameter and
        //returns the wrapper class Integer. It returns an Integer object holding the integer value represented by the argument String s.
        //If any non-numeric string is passed, it throws NumberFormatException.
        Integer expectedNumber = 10;
        Integer expectedNegativeNumber = -10;
        assertEquals(expectedNumber, Integer.valueOf("10"));
        assertEquals(expectedNumber, Integer.valueOf("+10"));
        assertEquals(expectedNegativeNumber, Integer.valueOf("-10"));
    }

    @Test
    public void wrapperTestHeight(){
        //Specifying Radix
        //The third variant of valueOf() accepts a String and an int as parameters and returns the wrapper class Integer.
        //Also, like all the other variants we've seen, it also throws NumberFormatException when it cannot convert the
        //given string to Integer type.  This method also uses parseInt(String s, int radix) in its implementation.
        //By default, the valueOf() method assumes that the given String represents a base-10 integer.
        //Additionally, this method accepts another argument to change the default radix.
        //Syntax
        //static Integer valueOf(String s, int radix)

        Integer expectedNumber1 = 10;
        Integer expectedNumber2 = 12;
        Integer expectedNumber3 = 15;
        assertEquals(expectedNumber1, Integer.valueOf("A", 16));
        assertEquals(expectedNumber2, Integer.valueOf("C", 16));
        assertEquals(expectedNumber3, Integer.valueOf("F", 16));
        System.out.println(Integer.valueOf("B", 16));  //Note that the return Integer object is base 10.
    }

    @Test
    public void wrapperTestNine(){
        //Adding primitive type values into the list instead of Integer objects and
        //see Autoboxing in action as the code compile successfully.
        //It does not generate a compile-time error as the Java compiler creates an
        //Integer wrapper Object from primitive int and adds it to the list
        List<Integer> integerList = new ArrayList<>();
        //Adding the int primitives type values.  Autoboxing in action.
        integerList.add(1);
        integerList.add(12);
        integerList.add(15);
        integerList.add(20);
        System.out.println("Printing the List after adding primitive type values: " + integerList);

        List<Integer> integerList1 = new ArrayList<>();
        //Adding Integer object directly to the list instead of primitive type values
        //Integers 1 - 10 will be added to the list
        for(int i = 1; i <= 10; i++){
            integerList1.add(Integer.valueOf(i));   //Adding Integer objects to the list
            //System.out.println(integerList1.add(Integer.valueOf(i)));  //add method will return true when an element's added but won't display elements.
        }
        System.out.println("\nPrinting the list added with Integer objects: " + integerList1);
    }

    //sumOfOdds method to use in the Test below.
    public static int sumOfOdds(List<Integer> list){
        int sumOdd = 0;
        for(Integer i : list){
//            if(i.intValue() % 2 != 0)     //This works but unnecessary unboxing
//                sumOdd += i.intValue();
            if(i % 2 != 0) {
                sumOdd += i;
            }
        }
        return sumOdd;
    }

    @Test
    public void wrapperTestTen(){
        //Another example of autoboxing and unboxing is to find the sum of odd numbers in a list. An important point in
        //the program is that the operators remainder ( % ) and unary plus ( += ) operators do not apply to Integer objects.
        //But still, code compiles successfully because the unboxing of Integer Object to primitive int value is taking
        //place by invoking intValue() method at runtime.
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            list.add(Integer.valueOf(i));
        }
        int sum = sumOfOdds(list);
        System.out.println("The sum of off numbers is: " + sum);
    }

    @Test
    public void wrapperTestEleven(){
        //Character class
        //Java provides a wrapper class Character in java.lang package. An object of type Character contains a single field,
        //whose type is char. The Character class offers a number of useful class (i.e., static) methods for manipulating characters.
        // You can create a Character object with the Character constructor.
        //A Wrapper class wraps the value of the primitive data type in an object.
        // They provide a way to use primitive data types (int, boolean, etc.) as objects.
        // When we create an object of a wrapper class, it contains a field and in this field,
        // we can store primitive data types. In other words, we can wrap a primitive value into a wrapper class object.

        Character ch = 'A';
        String str = "Monday";
        System.out.println("Is the character ch Uppercase? : " + Character.isUpperCase(ch));
        System.out.println();
        System.out.println("Is the first letter in string str uppercase? : " + Character.isUpperCase(str.charAt(0)));
        System.out.println();
        Character ch2 = 'W';
        System.out.println("Is the character ch2 a letter? : " + Character.isLetter(ch2));
        System.out.println();
        Character str3 = '5';
        System.out.println("Is the Character str3 a digit? : " + Character.isDigit(str3));
        System.out.println();
        Character ch3 = ' ';
        Character ch4 = '\t';
        Character ch5 = '\n';
        System.out.println("Is ch3 a Whitespace? : " + Character.isWhitespace(ch3));
        System.out.println("Is ch4 a Whitespace? : " + Character.isWhitespace(ch4));
        System.out.println("Is ch5 a Whitespace? : " + Character.isWhitespace(ch5));
        System.out.println();
        System.out.println("Is the third letter of str lowercase? : " + Character.isLowerCase(str.charAt(2)));
        System.out.println();
        char charResult = Character.toUpperCase(str.charAt(3));
        System.out.println("4th character of str to Uppercase is: " + charResult);
        System.out.println();
        char charResult2 = Character.toLowerCase(str.charAt(0));
        System.out.println("First character of str to lowercase: " + charResult2);
        System.out.println();
        System.out.println("toString representation of ch2: " + Character.toString(ch2));  //Unecessary Character.toString() call, use the below instead.
        System.out.println("toString representation of ch2: " + ch2);
    }
}
