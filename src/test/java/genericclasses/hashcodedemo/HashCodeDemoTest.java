package genericclasses.hashcodedemo;

import lombok.Builder;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HashCodeDemoTest {

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
    }

    //When hashCode() is called on two separate objects (which are equal according to the equals() method) it
    // returns the same hash code value. However, if it is called on two unequal objects,
    // it will not necessarily return different integer values.
    @Test
    public void testingHashCodeTwo() {

        String a = "200";
        String b = "200";
        String e = "Micheal";
        String f = "Micheal";

        if (a.equals(b)) {
            System.out.println("Equal variables:");
            System.out.println(a.hashCode() + "\n" + b.hashCode());
        }
        String c = "10";
        String d = "50";
        if (!c.equals(d)) {
            System.out.println("\nUn-equal variables:");
            System.out.println(c.hashCode() + "\n" + d.hashCode());
        }

        if(e.equals(f)){
            System.out.println("String e = \"Micheal\" and String f = \"Micheal\"");
            System.out.println("\nString e is equal to f");
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
}
