package genericclasses.stringDemo;

import com.gettingstarted.domain.modernanimal.ModernCat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StringsDemo {

    @Test
    public void stringImmutableDemo(){
        String str = "Welcome Home";
        System.out.println("The String str is: " + str);
        System.out.println("Hash Code for str is: " + str.hashCode());

        String str1 = "Welcome Home";
        System.out.println("The String str1 is: " + str1);
        System.out.println("Hash Code for str1 is: " + str1.hashCode());
        System.out.println();
        System.out.println("Changing str value");

        str = "Calm Down";
        System.out.println("The String str is: " + str);
        System.out.println("Hash Code for str is: " + str.hashCode());
        System.out.println();
        System.out.println("Checking str1 value again");
        System.out.println("The String str1 is: " + str1);
        System.out.println("Hash Code for str1 is: " + str1.hashCode());
    }

    @Test
    public void stringConcatMethod(){
        String str = "Hello";
        System.out.println("The string str hashcode is: " + str.hashCode());

        str.concat(" how are you");
        System.out.println("\nString str value after concat is : " + str);
        System.out.println("Hashcode is: " + str.hashCode());
        System.out.println();
        System.out.println("Using concat and assigning the result to str....");
        str = str.concat(" how are you");
        System.out.println("After concat the string becomes: ");
        System.out.println(str);
        System.out.println("And the hashcode is: ");
        System.out.println(str.hashCode());
    }

    @Test
    public void substringTest(){
        //A part of String is called substring. In other words, substring is a subset of
        // another String.  Java String class provides the built-in substring() method that extract a
        // substring from the given string by using the index values passed as an argument.
        // In case of substring() method startIndex is inclusive and endIndex is exclusive.

        String str = "hello";
        System.out.println(str.substring(0,5));

        String time = "05:37 AM";
        String substringTime = time.substring(0, 5);
        System.out.println();
        System.out.println("\nString time: " + time);
        System.out.println("Substring time: " + substringTime);
    }

    @Test
    public void substringTestTwo(){
        String s ="IamthemanInTheHouse";
        System.out.println("Original String: " + s);
        System.out.println("Substring starting from index 6: " +s.substring(6));  //Should print: manIntTheHouse
        System.out.println("Substring starting from index 0 to 9: "+s.substring(0,9)); //Should print: Iamtheman
        System.out.println("Extracting Substring from index 7 to 11: " + s.substring(6, 11)); //Should print: manIn
    }

    @Test
    public void stringCharsMethod() {
        //Java String chars()
        //The chars() method is an instance method of the String class.
        //It returns an IntStream that consists of the code point values of the characters in the given string.
        //This method was added to the String class in Java 9.
        // Define a string
        String str = "In God we trust";
        // use the chars method to get a stream of char values
        IntStream codePointStream = str.chars();  //Using chars() method to get the stream of Code point values of the characters in the string str.
        codePointStream.forEach(System.out::println);  //Printing the code point values of each character in the Intstream.
        System.out.println();
        codePointStream = str.chars();  //Re-initialising the stream
        // convert the code points back to characters and print the output
        codePointStream.mapToObj(Character::toChars).forEach(System.out::print);
        System.out.println();
        System.out.println();
        str.chars().forEach(num -> System.out.print(" " + num));
    }

    @Test
    public void convertStringToCharactersUsingCharsMethod(){
        //Converting String to List of Characters
        //We can use chars() method to get the character stream and process them one at a time.
        //Here is an example to convert a string to list of characters while adding 1 to their code points.
        String str = "Hello World";
        List<Character> charStr = new ArrayList<>();
        str.chars().forEach(y -> charStr.add(Character.valueOf((char) y)));
        System.out.println(charStr);
    }
}

