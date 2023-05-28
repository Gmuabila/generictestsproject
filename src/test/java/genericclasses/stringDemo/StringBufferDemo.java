package genericclasses.stringDemo;

import org.junit.Test;

public class StringBufferDemo {
    /*Since String is immutable in Java, whenever we do String manipulation like concatenation,
    substring, etc, it generates a new String and discards the older String for garbage collection.
    These are heavy operations and generate a lot of garbage in the heap.
    So, Java has provided StringBuffer and StringBuilder classes that should be used for String manipulation.
    StringBuffer class is used to create mutable (modifiable) string.
    The StringBuffer class in java is the same as String class except it is mutable i.e., it can be changed.
StringBuffer is a peer class of String that provides much of the functionality of strings.
The string represents a fixed-length, immutable character sequences while StringBuffer represents a growable and writable character sequences.
StringBuffer and StringBuilder are mutable objects in Java, and they provide methods to manipulate strings.
StringBuffer may have characters and substrings inserted in the middle or appended to the end.
It will automatically grow to make room for such additions and often has more characters preallocated than are actually needed,
to allow room for growth.  StringBuffer was the only choice for String manipulation until Java 1.4. But,
it has one disadvantage that all of its public methods are synchronized.  StringBuffer provides Thread safety but at a performance cost.
  */

    @Test
    public void testStringBuffer(){
        StringBuffer stringBuffer = new StringBuffer("Hello ");
        stringBuffer.insert(2, "Java");    //Inserting the String "Java" at index 2 of the String "Hello".
        System.out.println("The String \"Hello\" becomes as follow after the String \"Java\" is inserted at index 2:");
        System.out.println(stringBuffer);
    }

}
