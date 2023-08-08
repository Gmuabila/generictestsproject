package genericclasses.collectionframeworkdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsClassDemo {
    //Collections class
    // The Collections class is one of the utility classes in Java Collections Framework.
    // Java Collections class is used with the static methods that operate on the collections or return the collection.
    // It defines several utility methods like sorting and searching that are used to operate on collection.
    // These methods provide much-needed convenience to developers, allowing them to effectively work with Collection Framework.
    // For example, It has a method sort() to sort the collection elements according to default sorting order, and it has a method min(),
    // and max() to find the minimum and maximum value respectively in the collection elements.  The Collections class contains only static methods.
    // All the methods of this class throw the NullPointerException if the collection or object passed to the methods is null.
    // The java.util package contains the Collections class in Java.

    @Test
    public void collectionsClassTest(){
        //addAll() method
        // The addAll() method of java.util.Collections class is used to add all the specified elements to the specified collection.
        // Elements to be added may be specified individually or as an array.
        List<String> stringList = new ArrayList<>();
        // Adding elements to stringList
        stringList.add("geeks");
        stringList.add("for");
        stringList.add("geeks");
        // Printing the elements of stringList before operations
        System.out.println("Elements of stringList before the operations:");
        System.out.println(stringList);
        System.out.println("Elements of stringList after the operations:");
        // Adding all the specified elements to the specified collection
        Collections.addAll(stringList, "web", "site");
        // Printing the stringList after performing addAll() method
        System.out.println(stringList);
        // Sorting all the elements of the specified collection according to
        // default sorting order
        Collections.sort(stringList);
        // Printing the stringList after performing sort() method
        System.out.println(stringList);
    }

    @Test
    public void collectionSort(){
        //Collections.sort() method
        // The sort() method is used to sort the elements present in the specified list of Collection in ascending order.
        // It works similar to java.util.Arrays.sort() method but it is better than as it can sort the elements of Array as well as linked list,
        // queue and many more present in it.  The sort() method is present in java.util.Collections class.
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new SortByRollNumber());

        System.out.println("\nSorted by rollno");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
    }
}
