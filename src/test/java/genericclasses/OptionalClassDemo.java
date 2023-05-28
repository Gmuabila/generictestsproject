package genericclasses;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalClassDemo {
    //Optional Class
    //Optional can help in writing a neat code without using too many null checks.
    //This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’
    //instead of checking null values.  A Container Object can store instances of any Java class.
    //For example, you can store a String , a Date , and an Integer in the same container.
    //When you retrieve an object, you must cast the object back to
    //the required type before applying a type-specific method.

    @Test
    public void testOptionalClass() {
        String[] Words = new String[10];
        String word = Words[5].toLowerCase();  //Will throw a NullPointerException.  Words[5] is Null.
        System.out.println(word);

    }

    //ofNullable(T value)
    //ofNullable(T value) method returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional.

    @Test
    public void testOptionalClassTwo() {
        //To avoid abnormal termination of our program, we use the Optional class.
        //In this example, we are using Optional. So, our program can execute without crashing.
        String[] words = new String[10];
        words[1] = "12";
        words[0] = "45";
        Optional<String> nullCheck = Optional.ofNullable(words[5]);
        if (nullCheck.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
        } else {
            System.out.println("The word is Null");
        }
        //The findFirst() method (of the Stream class) returns an Optional describing the first element of this stream,
        //or an empty Optional if the stream is empty. If the stream has no encounter order, then any element may be returned.
        //It throws a NullPointerException if the element selected is null.
        Optional<String> wordCheck = Stream.of(words).findFirst();
        System.out.println("Trying to print an optional: " + wordCheck.toString());
        String wordResult = wordCheck.get();  //Getting a String value from Optional.  When casting to String is used, the compiler complains.
        System.out.println();
        System.out.println("Optional is converted to String: " + wordResult);
    }

    @Test
    public void testOptionalClassThree() {
        // Java program to demonstrate
        // Optional.isPresent() method
        Optional<Integer> optionalInteger = Optional.of(345);
        Optional<String> stringOptional = Optional.of("Monday");
        Optional<Integer> integerOpt = Optional.of(null);
        Optional<String> strOptional = Optional.ofNullable("Sunday");

        System.out.println("Is there a value in this Optional: " + optionalInteger.isPresent());
        System.out.println("\nThe Optional value is: " + optionalInteger);
        Integer integerValue = optionalInteger.get();  //No need to type cast, get() method alone is enough
        System.out.println("\nPrinting the new Integer value: " + integerValue);
        try {
            System.out.println("\nPrinting a null Optional: " + integerOpt); //Trying to access a null Optional throws an NullPointerException
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testOptionalClassFour(){
        Optional<Integer> optionalInt = Optional.empty();
        System.out.println("Printing an Empty Optional: " + optionalInt);
        try {
            System.out.println("Checking if Optional is Empty: " + optionalInt.isPresent());  //Should return false and no throw an exception
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testOptionalClassFive(){
        // creating a string array
        String[] str = new String[5];

        // Setting value for 2nd index
        str[2] = "Geeks Classes are coming soon";

        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[2]);

        // It returns value of an Optional.
        System.out.println(value.get());

        try {
            // If value is not present, it throws
            // an NoSuchElementException (it throws a NullPointerException instead)
            Optional<String> valueTwo = Optional.of(str[0]);
            System.out.println("valueTwo is: " + valueTwo.get());  //Throws a NullPointerException.
        }catch (Exception e){
            System.out.println(e);
        }
        // It returns hashCode of the value
        System.out.println(value.hashCode());

        // It returns true if value is present,
        // otherwise false
        System.out.println(value.isPresent());
    }
}
