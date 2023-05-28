package genericclasses.stringDemo;

import org.junit.Test;

public class SubstringDemo {

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
}
