package genericclasses.streamdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAllMatch {
    //Stream AllMatch(Predicate<T> predicate)
    //Stream allMatch(Predicate predicate) returns whether all elements of this stream match the provided predicate.
    //It returns true if all elements of the stream satisfy the given predicate, else it returns false, and may not
    //evaluate the predicate on all elements if not necessary for determining the result. This is a
    //short-circuiting terminal operation, It returns 'false' on finding the first mismatch hence
    //short-circuiting (just like boolean && operator). A terminal operation is short-circuiting if,
    //when presented with infinite input, it may terminate in finite time.

    @Test
    public void allMatchTestOne(){
        //allMatch() function to check whether all elements are divisible by 3.
        List<Integer> integerList = List.of(9, 3, 6, 12, 15, 30, 60, 45);
        boolean result = integerList.stream().allMatch(num -> num % 3 == 0);
        System.out.println("All item divisible by 3 ? : " + result);
    }

    @Test
    public void allMatchTestTwo(){
        //allMatch() function to check whether strings have length greater than 2.
        Stream<String> stringStream = Stream.of("Geeks", "for", "GeeksQuix", "GeeksForGeeks");
        // Check if all elements of stream
        // have length greater than 2 using
        // Stream allMatch(Predicate predicate)
        boolean result = stringStream.allMatch(str -> str.length() > 2);
        System.out.println("Are all Strings length greater than 2 ?: " + result);
    }

    @Test
    public void allMatchTestThree(){
        //allMatch() function to check whether all strings have Uppercase character at 1st index.
        Stream<String> stringStream = Stream.of("Geeks", "For", "GeeksQuix", "GeeksForGeeks");
        boolean result = stringStream.allMatch(str -> Character.isUpperCase(str.charAt(0)));
        if(result){
            System.out.println("All strings start with Uppercase Character at 1st index");
        }
        else {
            System.out.println("All strings do not have Uppercase Characters at 1st index");
        }
    }

    @Test
    public void allMatchTestFour(){
        //Multiple function done using same stream.
        final String sample = "To God be the Glory";
        IntStream intStream = sample.chars();   // Getting Ascii value for each character
        intStream.forEach(System.out::println);
        //Java String chars() method returns an IntStream that contains the integer code point values of the characters in given String
    }

    @Test
    public void allMatchTestFive(){
        Stream<String> stream = Stream.of("one", "two", "Three", "four");
        boolean match = stream.allMatch(s -> s.length() > 0 &&
                Character.isLowerCase(s.charAt(0)));
        System.out.println(match);
    }

    @Test
    public void allMatchTestSix(){
        //An Empty stream will return true
        boolean b = new ArrayList<>().stream()
                .allMatch(e -> false);  //May also try:  .allMatch(e -> e != null);
        System.out.println(b);
    }

    @Test
    public void allMatchTestSeven(){
        //Java String chars() Method
        //Java String chars() method returns an IntStream.
        //The stream contains the integer code point values of the characters in the string object.
        //This method was added to the String class in Java 9 release.
        String str = "Hello World";

        str.chars().forEach(System.out::println);
    }

    @Test
    public void noneMatchTestOne(){
        //Stream noneMatch() Method
        //noneMatch() of Stream class returns whether no elements of this stream match the provided predicate.
        //It may not evaluate the predicate on all elements if not necessary for determining the result.
        //This is a short-circuiting terminal operation.
        List<String> stringList = List.of("One", "Two", "Three", "Four");
        boolean result = stringList.stream().noneMatch(item -> item.length() < 2 && Character.isLowerCase(item.charAt(0)));
        System.out.println(result);
    }

    @Test
    public void noneMatchTestTwo(){
        // Creating a Stream of Strings using of() method
        // by creating object of Stream of string type
        Stream<String> stream
                = Stream.of("Geeks", "fOr", "GEEKSQUIZ",
                "GeeksforGeeks", "CSe");

        // Using Stream noneMatch(Predicate predicate)
        // and storing the boolean value
        boolean answer = stream.noneMatch(str -> Character.isUpperCase(str.charAt(1))
                        && Character.isLowerCase(str.charAt(2))
                        && str.charAt(0) == 'f');

        // Printing the above boolean value on console
        System.out.println(answer);
    }

    @Test
    public void anyMatchTestOne(){
        //Stream anyMatch() method
        //Stream anyMatch(Predicate predicate) returns whether any elements of this stream match the provided predicate.
        //It may not evaluate the predicate on all elements if not necessary for determining the result.
        //This is a short-circuiting terminal operation.

        Stream<String> stream
                = Stream.of("Geeks", "fOr", "GEEKSQUIZ",
                "GeeksforGeeks", "CSe");
        boolean answer = stream.anyMatch(str -> Character.isUpperCase(str.charAt(1))
                && Character.isLowerCase(str.charAt(2))
                && str.charAt(0) == 'f');
        System.out.println(answer);
    }
}
