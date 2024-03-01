package genericclasses.stringDemo;

import com.gettingstarted.domain.modernanimal.ModernCat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


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
        //String Concat()
        //The Java String concat() method combines a specific string at the end of another string and
        //ultimately returns a combined string. It is like appending another string.
        //Returns a String object that represents a character sequence that is the concatenation of
        //the character sequence represented by this String object and the character sequence represented by the argument string.
        String str = "Hello";
        System.out.println("The string str hashcode is: " + str.hashCode());

        str = str.concat(" how are you");
        System.out.println("\nString str value after concat is : " + str);
        System.out.println("Hashcode is: " + str.hashCode());
        System.out.println();
        String str2 = "Welcome";
        System.out.println("String str2 is: " + str2);
        System.out.println("str2 hashcode: " + str2.hashCode());
        System.out.println("Using concat and assigning the result to str2Concat....");
        String str2Concat = str2.concat(" Home G.");
        System.out.println("After concat str2Concat is: ");
        System.out.println(str2Concat);
        System.out.println("And the hashcode is: ");
        System.out.println(str2Concat.hashCode());
        System.out.println();
        String result = "Hello ".concat("Mr G ").concat("How are you").concat(" today?");
        System.out.println(result);

    }

    @Test
    public void stringTrimTest(){
        //String Trim()
        //The java string trim() method removes the leading and trailing spaces.
        //It checks the Unicode value of space character (‘u0020’) before and after the string.
        //If it exists, then it removes the spaces and returns the omitted string.
        //
        //Omit: leave out or exclude (someone or something), either intentionally or forgetfully. "he was omitted from
        //the second Test"  to leave out or leave unmentioned.
        String s1 = " Hello ";
        System.out.println("String s1 without trim(): " + s1 + "how are you?");
        System.out.println("String s1 hashcode: " + s1.hashCode());
        System.out.println("String s1 with trim(): " + s1.trim() + "how are you?");  //Returns a String with leading and trailing spaces removed.
        System.out.println("String s1 hashcode after trim(): " + s1.hashCode());
        System.out.println("Printing String s1 again: " + s1);
        System.out.println();
        String s2 = s1.trim();
        System.out.println("String s2 is: " + s2);
        System.out.println("String s2 hashcode is: " + s2.hashCode());


    }

    @Test
    public void stringValueOfMehodTest(){
        //String valueOf()
        //The valueOf() method converts different types of values into string. Using this method, you can convert int to string,
        //long to string, Boolean to string, character to string, float to string, double to string, object to string and char array to string.
        //The signature or syntax of string valueOf() method is given below:
        //public static String valueOf(boolean b)
        //public static String valueOf(char c)
        //public static String valueOf(char[] c)
        //public static String valueOf(int i)
        //public static String valueOf(long l)
        //public static String valueOf(float f)
        //public static String valueOf(double d)
        //public static String valueOf(Object o)
        int intValue = 20;
        String s1 = String.valueOf(intValue);
        System.out.println("String value is: " + s1);
        System.out.println("Concatenating the string with 17: " + s1+17);
        System.out.println();
        char[] arrChar = {'a', 'l', 'b', 'e', 'r', 't', 'o'};
        String charString = String.valueOf(arrChar);
        System.out.println("Char Array converted to String: " + charString);
        System.out.println();
        double db = 123.50;
        String stringDb = String.valueOf(db);
        System.out.println("Double value db: " + db);
        System.out.println("Double 123.50 converted to String: " + stringDb);
        System.out.println();
        boolean boo = true;
        System.out.println("Boolean value true: " + boo);
        System.out.println();
        char ch = 'c';
        System.out.println("The char value is: " + ch);
        String stringCh = String.valueOf(ch);
        System.out.println("The char value converted to String: " + stringCh);
    }

    @Test
    public void stringReplaceMethodTest(){
        //String replace() method
        //The Java String replace() method returns a string, replacing all the old characters or CharSequence to new characters.
        //This method returns a new string resulting from replacing all occurrences of old characters in the string with new characters.
        //There are two types of replace() methods in a Java String.
        //Syntax:
        //public String replace(char oldch, char newch)
        //Parameters:
        //oldch: the old character.
        //newch: the new character.
        //Return Value:
        //It returns a string derived from this string by replacing every occurrence of oldch with newch.
        // Initialising String
        String str = new String("Welcome to geeksforgeeks");
        System.out.println("Original String: " + str);
        System.out.println("Original String hashcode: " + str.hashCode());
        System.out.print("After replacing all 'o' with 'a' : ");
        // Using replace to replace characters
        System.out.println(str.replace('o', 'a'));  //Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.
        System.out.println("Hashcode after replacing 'o' with 'a': " + str.hashCode());
        System.out.println();
        // Using replace to replace characters
        System.out.print("After replacing all 'o' with 'i' : ");
        System.out.println(str.replace('o', 'i'));
        System.out.println("Hashcode after replacing 'o' with 'i': " + str.hashCode());

        //Java String replace(CharSequence target, CharSequence replacement) method.
        //As the name suggest, the method returns a string resulting from replacing all
        //occurrences of old CharSequence to the new CharSequence
        String str1 = "Welcome to GeeksForGeeks and Compton";
        String str3 = str1.replace("Geeks", "Roots");
        System.out.println("String str3: " + str3);
        System.out.println();
        String str4 = str1.replace("Compton", "London City");
        System.out.println("String str4: " + str4);
    }

    @Test
    public void stringReplaceAllTest(){
        //string replaceAll() method
        //The method replaceAll() replaces all occurrences of a String in another String matched by regex.
        //This is similar to the replace() function, the only difference is that in replaceAll() the String to
        //be replaced is a regex while in replace() it is a String.
        //replaceAll() method throws a PatternSyntaxException – if regex is invalid
        String s = "my url with spaces";
        assertEquals("my-url-with-spaces", s.replaceAll("\\s+", "-"));
        assertEquals("your url with spaces", s.replaceAll("my", "your"));
        //Comparing to replace() method
        String str = "my url with spaces";
        assertEquals("my-url-with-spaces", s.replace("\\s+", "-"));  //replace() does not support regex.
    }

    @Test
    public void stringReplaceFirstMethod(){
        //String replaceFirst()
        //Just like replace() method the replaceFirst() method replaces the first substring of this string that matches the
        //given regular expression with the given 'replacement'.
        //Syntax:
        //public String replaceFirst(String regex, String replacement)
        //Parameters:
        //regex: the regular expression to which this string is to be matched.
        //replacement: the string which would replace found expression.
        //Return Value: This method returns a resulting String.
        String str = new String("Welcome to geeksforgeeks");
        System.out.println("Original String : " + str);
        // Using replaceFirst to replace regex with 'replace_str' Replaces 1st occurrence of geeks with Gold
        System.out.println("After replacing 1st occurrence of regex with replacement : ");
        System.out.println(str.replaceFirst("geeks", "Gold"));
        System.out.println();
        String str1 = "Welcome back Mr G is back and back again";
        System.out.println("Original String: " + str1);
        String str2 = str1.replaceFirst("back", "home");
        System.out.println("String after replaceFirst: " + str2);
    }

    @Test
    public void stringContainsMethod(){
        //String contains()
        //The string contains() method searches the sequence of characters in the string.
        //If the sequences of characters are found, then it returns true otherwise returns false.
        String name = "hello how are you doing";
        System.out.println(name.contains("how are you"));  // returns true
        System.out.println(name.contains("hello"));        // returns true
        System.out.println(name.contains("fine"));         // returns false
    }

    @Test
    public void stringToCharArrayTest(){
        //String toCharArray()
        //The toCharArray() method converts a String into a character array i.e., first it will calculate the
        //length of the given String including spaces and then create an array of char type with the same content.
        String str = "This is a string to convert to an array of characters";
        System.out.println("Original String: " + "\"" + str + "\"");
        char[] strArray = str.toCharArray();
        //System.out.println(strArray);  //This line prints the array as well.
        System.out.println("Array length: " + strArray.length);
        for(int i = 0; i < strArray.length; i++){
            System.out.print(strArray[i]);
        }
    }

    @Test
    public void stringGetBytesMethodTest() {
        //String getBytes()
        //The string getBytes() method returns the sequence of bytes or you can say the byte array of the string.
        String s1 = "ABC";
        byte[] b = s1.getBytes();  //Create an array of Unicode values of the strings characters.
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "\t");
        }
        System.out.println();
        IntStream intStream = s1.chars();
        intStream.forEach(item -> System.out.print((char) item + "\t"));
    }

    @Test
    public void stringSplitMethod(){
        //split() method
        //The split() method splits a String into multiple Strings given the delimiter that separates them.
        // The returned object is an array which contains the split Strings.  We can also pass a limit to the number of
        // elements in the returned array. If we pass 0 as a limit, then the method will behave as if we didn't pass any limit,
        // returning an array containing all elements that can be split using the passed delimiter.
        //The string split() method breaks a given string around matches of the given regular expression.
        // After splitting against the given regular expression, this method returns a String array.
        // The Split() method throws a PatternSyntaxException – if the provided regular expression’s syntax is invalid.
        //
        //Available Signatures:
        //public String[] split(String regex, int limit)
        //public String[] split(String regex)
        //When we pass the split limit as a second argument to this function, it does limit the number of split strings.
        String str = "Javatpointtt";
        System.out.println("Returning words:");
        String[] arr = str.split("t");
        for (String w : arr) {
            System.out.println(w);
        }
        System.out.println("Split array length: " + arr.length);
    }

    @Test
    public void stringSplitMethodTwo() {
        //This program returns the total number of words in a string excluding space only. It also includes special characters.
        String s1 = "java string split method by javatpoint";
        String[] words = s1.split("\\s");//splits the string based on whitespace
        //using java foreach loop to print elements of string array
        for (String w : words) {
            System.out.println(w);
        }
    }

    @Test
    public void stringSplitMethodThree(){
        //String split() method with regex and length example
        String s1="welcome to split world";
        System.out.println("Split 1 returning words:");
        for(String w:s1.split("\\s",0)){
            System.out.println(w);
        }
        System.out.println();
        System.out.println("Split 2 returning words:");
        for(String w:s1.split("\\s",1)){
            System.out.println(w);
        }
        System.out.println();
        System.out.println("Split 3 returning words:");
        for(String w:s1.split("\\s",2)){
            System.out.println(w);
        }
    }

    @Test
    public void stringSplitMerhodFour(){
        //split() method throws a PatternSyntaxException – if the pattern of the delimiter is invalid.
        String s = "Welcome*to Baeldung";
        String[] result = s.split(" ");
        for (String item: result){
            System.out.println(item);
        }
    }

    @Test
    public void findCharacterCodePoint() {
        String s1 = "M";
        IntStream intStream = s1.chars();
        intStream.forEach(System.out::println);
        System.out.println();

        int codePoint = s1.codePointAt(0);
        System.out.println("Code point for M: " + codePoint);
        System.out.println();

        int codePoint1 = (int) 'M';  //No need to typecast
        //int codePoint1 = 'M';  // This also works
        System.out.println("Code point for M: " + codePoint1);

        char ch = (char) 65;  // No need to typecast
        // char ch = 65;  //This also works
        System.out.println("Character for code point 65: " + ch);
        System.out.println();

        int cp = 67;
        char[] ch1 = Character.toChars(cp);
        System.out.print("The char array according to UTF-16: ");
        for (int i = 0; i < ch1.length; i++) {
            System.out.print(ch1[i]);
        }
        System.out.println();
    }

    @Test
    public void substringTest(){
        //substring() method
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
        //The chars() method is an instance method of the String class that returns an IntStream that consists of
        //the code point values of the characters in a given string.
        //This method was added to the String class in Java 9.
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
        str.chars().forEach(num -> System.out.print(" " + (char)num));
    }

    @Test
    public void convertStringToCharactersUsingCharsMethod(){
        //Converting String to List of Characters
        //We can use chars() method to get the character stream and process them one at a time.
        //Here is an example to convert a string to list of characters while adding 1 to their code points.
        //chars() method returns a stream of int zero-extending the char values from this sequence.
        // Any char which maps to a surrogate code point is passed through uninterpreted.
        //Returns: an IntStream of char values from this sequence
        String str = "Hello World";
        List<Character> charStr = new ArrayList<>();
        str.chars().forEach(y -> charStr.add((char) y));
        System.out.println(charStr);
    }

    @Test
    public void testCreatingNewString(){
        /** String Pool
         String Pool is a storage area in the heap memory where string literals are stored. String Pool in java is a pool of Strings stored in
         Java Heap Memory.  The Java string constant pool is an area in the heap memory where Java stores literal string values. The heap is an
         area of memory used for run-time operations.  Java String Pool refers to the collection of Strings which are stored in heap memory.
         String Pool is a place in the HEAP memory of Java to store string literal.  In this, whenever a new object is created,
         String pool first checks whether the object is already present in the pool or not. If it is present, then same reference is returned to
         the variable else a new object will be created in the String pool and the respective reference will be returned.
         The String pool is created to decrease the number of string objects created in the memory.  It allows caching of string objects.
         This saves a lot of memory for JVM that can be used by other objects. Java String Pool helps in better performance of the
         application because of reusability. It saves time to create a new string if there is already a string present in the pool with the
         same value.
         ** String literal:
         A String literal is a sequence of characters between quotation marks, such as "string" or "literal". A string literal in Java is
         basically a sequence of characters from the source character set used by Java programmers to populate string objects or to display text to
         a user. These characters could be anything like letters, numbers or symbols which are enclosed within two quotation marks.
         When you use a string literal the string can be interned, but when you use new String (“…”) you get a new string object.
         In general, you should use the string literal notation when possible as it is easier to read, and it gives the compiler a chance to
         optimize your code. A string literal should be enclosed in double quotes. Whenever in your code a string literal is assigned to a
         variable as in String str = “string literal”; , the compiler will create a String object with its value.
         ** String Pool is a Design Pattern:
         String Pool is possible only because String is immutable in Java and its implementation of String interning concept. String pool is
         also an example of Flyweight design pattern. String pool helps in saving a lot of space for Java Runtime, although it takes more time to
         create the String.
         //Note: If you want to compare the value of two String variables, you can’t use ==. This is due to the fact that the == operator will
        //compare the references of the variables (compares memory locations) and not the values that are linked to them.
        //To compare the stored values of the Strings you use the method equals.
         */
        String str1 = "Badinengani";
        String str2 = new String("Badinengani");
        String str3 = "Badinengani";
        String str4 = new String("Badinengani");
        System.out.println(str1 == str3); //returns true as both variable points to the same object in the String pool. Both have the same variable reference.
        System.out.println(str2 == str3);//The == operator compares the references of the variables. This returns false as new() creates a new object.
        System.out.println(str2 == str4); //Returns false as both reference variables are created with new() keyword,will create two different objects in Heap.

        System.out.println();
        String s1 = new String("Hello");
        String s2 = new String("Hellow");
        System.out.println(s1 = s2);
        //What happens here is the assignment operator(right to left associative), so the value of s2 is assigned to s1, and s1 is printed.
    }

    @Test
    public void testStringInterning(){
        //String Interning
        //String Interning is a process of storing only one copy of each distinct String value in the String pool, which must be immutable.
        //Applying String.intern() on strings will ensure that all strings having the same contents share the same memory.
        //When we create a String variable and assign a value to it, the JVM searches the pool for a String of equal value.
        //If found, the Java compiler will simply return a reference to its memory address, without allocating additional memory.
        //If not found, it'll be added to the pool (interned) and its reference will be returned.
        //Manual Interning
        //We can manually intern a String in the Java String Pool by calling the intern() method on the object we want to intern.
        //Manually interning the String will store its reference in the pool, and the JVM will return this reference when needed.
        String str1 = new String("Nkulu");
        String str1InPool = str1.intern();  //A copy of the String str1 is interned in the pool.
        String str2 = "Nkulu";  //str2 will have the same reference as str1InPool variable.
        System.out.println(str1 == str1InPool); //Returns false
        System.out.println(str1InPool == str2); //Returns true.
        System.out.println();

        String str3 = new String("Javier");
        String str3Intern = str3.intern();
        String str4 = "Javier";
        System.out.print("str3 == str3Intern: ");
        System.out.println(str3 == str3Intern);  // returns false
        System.out.print("str3Intern == str4: ");
        System.out.println(str3Intern == str4);   // returns true
        System.out.println("str3 hashcode: " + str3.hashCode());
        System.out.println("str4 hashcode: " + str4.hashCode());
        System.out.println("str3Intern value: " + str3Intern);
        System.out.println("str3Intern hashcode: " + str3Intern.hashCode());
        System.out.println();

        String str6 = new String("Melanie");
        String str6InPool = str6.intern();
        String str7 = "Melanie";
        System.out.print("str6 == str6InPool: ");
        System.out.println(str6 == str6InPool);  // returns false
        System.out.print("str6InPool == str7: ");
        System.out.println(str6InPool == str7); // returns true
        //System.out.println("str6InPool == str7 is: " + str6InPool == str7); //Compiler does not allow this statement and only accepts the line above.
        //The error is as follow: Condition '"str6InPool == str7 is: " + str6InPool == str7' is always 'false'.
    }

    @Test
    public void testStringCharsMethod(){
        /** String chars() Method
         The String chars() method returns an IntStream that contains the integer code point values (Unicode or ASCII code) of
         the characters in the string object. It returns an IntStream that contains the Unicode values of the characters in the String object.
         This method was added to the String class in Java 9 release.                                                          */
        String str = "Hello World";
        str.chars().forEach(System.out::println);
    }

    @Test
    public void testStringInterningB(){
        String str = "Breva";
        String str2 = new String("Breva").intern();  //Creating a string in heap and at the same time adding to the String pool.
        System.out.println(str == str2); //returns true.
    }

    @Test
    public void testCompareStrings(){
        String x = "Mars";
        String y = "Marston";
        System.out.println(x.compareTo(y));
    }

}

