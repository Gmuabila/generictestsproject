package genericclasses.stringDemo;

import org.junit.Test;

public class StringBuilderDemo {
    /*Since String is immutable in Java, whenever we do String manipulation like concatenation, substring, etc,
    it generates a new String and discards the older String for garbage collection. These are heavy operations and
    generate a lot of garbage in the heap. So, Java has provided StringBuffer and StringBuilder classes that should be used for String manipulation.
    Like StringBuffer class, StringBuilder is used to create mutable (modifiable) string. The StringBuilder class in java is
    the same as String class except it is mutable i.e., it can be changed.  StringBuilder is a peer class of String that provides much of
    the functionality of strings. The string represents a fixed-length, immutable character sequences while StringBuilder represents a
    growable and writable character sequences. StringBuilder in Java represents a mutable sequence of characters.
    Since the String Class in Java creates an immutable sequence of characters, the StringBuilder class provides an alternative to String Class,
    as it creates a mutable sequence of characters. The function of StringBuilder is very much similar to the StringBuffer class,
    as both of them provide an alternative to String Class by making a mutable sequence of characters.

    However, the StringBuilder class differs from the StringBuffer class on the basis of synchronization.
    The StringBuilder class provides no guarantee of synchronization whereas the StringBuffer class does.  Instances of StringBuilder are not safe for
    use by multiple threads. If such synchronization is required then it is recommended that StringBuffer be used.
    StringBuilder is not thread-safe and high in performance compared to StringBuffer.
     */

    @Test
    public void testStringBuilder(){

        // Create a StringBuilder object
        // using StringBuilder() constructor
        StringBuilder str = new StringBuilder();
        str.append("GFG");
        // print string
        System.out.println("String str = " + str.toString());  //toString() not required.
        // create a StringBuilder object
        // using StringBuilder(CharSequence) constructor
        StringBuilder str1 = new StringBuilder("AAAABBBCCCC");
        // print string
        System.out.println("String str1 = " + str1);
        // create a StringBuilder object
        // using StringBuilder(capacity) constructor
        StringBuilder str2 = new StringBuilder(5);  //Capacity is growable.  See below
        str2.append("I am ok here I will be good");
        // print string
        System.out.println("String str2 is: " + str2);
        System.out.println("String str2 capacity = " + str2.capacity());
        // create a StringBuilder object
        // using StringBuilder(String) constructor
        StringBuilder str3 = new StringBuilder(str1.toString());  //Using toString to convert a StringBuilder to a String works but not required.
        // It works even if the StringBuilder is not converted to a String with a toString method.
        // print string
        System.out.println("String str3 = " + str3);

        str3.append(".Java");
        System.out.println("\nThe String str3 appended with \".Java\" is: " + str3);

        //Inserting the String "java" at index position 3.
        str3.insert(3, "java");
        System.out.println("\nString str3 becomes as follow after inserting the String \"java\" at index 3: ");
        System.out.println(str3);

    }

    @Test
    public void testStringBuilderTwo(){

        String text = "This is a text used for testing StringBuilder class.  StringBuilder helps create a mutable sequence of characters.";
        StringBuilder string1 = new StringBuilder();

        System.out.println("String Capacity is : " + string1.capacity());

        string1.append(text);
//      System.out.println("String is: " + string1.toString());  //Compiler complains that this is an unnecessary toString call and suggested the below
        System.out.println("The String string1 is: " + string1);  //toString removed as suggested by the compiler, it works.
    }

    @Test
    public void testStringBuilderThree(){

        String word = "level";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word);

        StringBuilder reverseStr = stringBuilder.reverse();

        System.out.println("The string is: " + word);
        System.out.println("The reverse string is: " + reverseStr);

        String reverseString = reverseStr.toString();  //Converting a StringBuilder to String to evaluate if they are equals.  Solving Palindrome.

        System.out.println(word.equals(reverseString));
    }

    @Test
    public void testStringBuilderFour(){
        String word = "Yes I can do it ";
        StringBuilder strB = new StringBuilder();
        strB.append(word);
        System.out.println("The StringBuilder strB is: " + strB);
        strB.appendCodePoint(65);  //Unicode U+0041 represent the uppercase character A.  41 hex in decimal is: 65.
        System.out.println("The StringBuilder strB is now: " + strB);
    }

    @Test
    public void testStringBuilderFive(){
        String word = "Camel";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(word);
        stringBuilder.reverse();   //With StringBuilder or StringBuffer we do not need to assign the reversed string to another variable as done here.
        System.out.println("Printing original string: " + word);
        System.out.println("The reversed string: " + stringBuilder);
    }
}
