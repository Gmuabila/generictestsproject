package genericclasses.hashcodedemo;

import lombok.Builder;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashCodeDemoTest {
    //Use of hashCode() method
    //Hashcode() Method returns a hash value that is used to search objects in a collection.
    //JVM(Java Virtual Machine) uses the hashcode method while saving objects into hashing-related data structures like HashSet,
    //HashMap, Hashtable, etc. The main advantage of saving objects based on hash code is that searching becomes easy.

    @Test
    public void testingHashCode() {

        Pupils s = new Pupils();
        Pupils t = new Pupils();
        Pupils v = new Pupils();
        Pupils m = new Pupils();
        Pupils k = new Pupils();

        // Below two statements are equivalent
        System.out.println(s);
        System.out.println(s.toString());

        System.out.println("Roll number for Pupil t is : " + t);
        System.out.println("Roll number for Pupil v is : " + v);
        System.out.println("Roll number for Pupil m is : " + m);
        System.out.println("Roll number for Pupil k is : " + k);
        System.out.println();

        //When we attempt to print the value of a reference variable,
        //the output contains the type of the variable and an identifier (reference or memory reference) created for
        //it by Java: the string Name@4aa298b7 tells us that the given variable is of
        //type "Name" and its identifier(Reference) is "4aa298b7".  Please note this value is not the hash code of the object.
        System.out.println("Printing the Reference Variable s: " + s);
        System.out.println("Printing the Reference Variable t: " + t);
        System.out.println();
        System.out.println("s hascode is: " + s.hashCode());
        System.out.println("t hascode is: " + t.hashCode());
    }

    //When hashCode() is called on two separate objects (which are equal according to the equals() method) it
    //returns the same hash code value. However, if it is called on two unequal objects,
    //it will not necessarily return different integer values.
    @Test
    public void testingHashCodeTwo() {

        String a = "200";
        String b = "200";
        String e = "Micheal";
        String f = "Micheal";

        if (a.equals(b)) {
            System.out.println("String a and string b are equal: " + a.equals(b));
            System.out.println(a.hashCode() + "\n" + b.hashCode());
        }
        String c = "10";
        String d = "50";
        if (!c.equals(d)) {
            System.out.println("\nString c and string d are Un-equal variables: " + !c.equals(d));
            System.out.println(c.hashCode() + "\n" + d.hashCode());
            System.out.println();
        }

        if(e.equals(f)){
            System.out.println("String e = " + e + " and String f = " + f);
            System.out.println("\nString e and string f are equal: " + e.equals(f));
            System.out.println("e hashcode = " + e.hashCode() + "\nf hashcode = " + f.hashCode());
        }else {
            System.out.println("\nStrings e and f are not equal");
        }
    }

    @Test
    public void noHashCodeDefinedTest(){

        Book b1 = new Book("55555999660", "JMary", "Walking in the Moon");
        Book b2 = new Book("22277786677", "Martin Clark", "Who is this");
        Book b3 = new Book("22277786677", "Martin Clark", "Who is this");

        System.out.println("Book b2 and b3 have the same values");
        System.out.println("Book b2 hashCode is: " + b2.hashCode());
        System.out.println("Book b3 hashCode is: " + b3.hashCode());
        /* Output below before hashCode method was implemented:
        Book b2 and b3 have the same values
        Book b2 hashCode is: 97730845
        Book b3 hashCode is: 225493257 */

        /* Output below after hashCode method has been implemented in the Book Class:
        Book b2 and b3 have the same values
        Book b2 hashCode is: -801039661
        Book b3 hashCode is: -801039661 */

        boolean response = b2.equals(b3);
        System.out.println("Checking equality before equals method is defined");
        System.out.println("The result of equality between b2 and b3 is: " + response);
        System.out.println("\nPrinting object with now toString method defined");
        System.out.println(b2);
        System.out.println(b3);

       /* Output after toString method is defined:
        Printing object with now toString method defined
        ["Book ISBN":"22277786677",  "Author":"Martin Clark",  "Book Title":"Who is this"]
        ["Book ISBN":"22277786677",  "Author":"Martin Clark",  "Book Title":"Who is this"]
        */

    }

    @Test
    public void testingHashCodeFour(){
        // creating two Objects with same state
        Geek g1 = new Geek("aditya", 1);
        Geek g2 = new Geek("aditya", 1);

        Map<Geek, String> map = new HashMap<>();
        map.put(g1, "CSE");
        map.put(g2, "IT");  //Same key with the previous record, g2 will override g1 and map will remain with only one item g2.

        //Set<Geek> theKeys = map.keySet();  //No need to collect set of Map keys in a separate line of code. Best do as below.
        for(Geek item : map.keySet()) {  //for each Geek item in map.keySet().
            System.out.println(map.get(item).toString());   //Getting data associated with each key and print.  Only one output as the keys a duplicates.
        }
        //In this case we override both methods properly.  When we call map.put(g1, “CSE”);
        // it will hash to some bucket location and when we call map.put(g2, “IT”);,
        // it will generate same hashcode value (same as g1) and replace first value by second value because
        // while iterating over same bucket it found a k such that k.equals(g2) is true, means searching key already exist.
        // So, it replaces old value of that key by new value.
    }

    @Test
    public void testingHashCodeFive(){
        Geek g1 = new Geek("aditya", 1);
        Geek g2 = new Geek("aditya", 1);

        System.out.println("g1 hascode: " + g1.hashCode());
        System.out.println("g2 hascode: " + g2.hashCode());
    }


}
