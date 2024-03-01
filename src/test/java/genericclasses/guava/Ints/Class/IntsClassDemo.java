package genericclasses.guava.Ints.Class;

import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IntsClassDemo {
    /** Guava Ints class
     The com.google.common.primitives’package by Guava provides utility classes for all primitive types such as Ints, Longs, Chars, Doubles, etc.
     The Ints class is a utility class that provides static utility methods to work with primitive int values,
     which are not already present in Java’s Integer or Arrays classes, such as conversion between arrays and lists,
     finding the minimum or maximum value, checking if an element is present, and more. It is a utility class for primitive type int.
     It provides Static utility methods pertaining to int primitives, that are not already found in either Integer or Arrays.
     */

    @Test
    public void intsClassTestOne() {
        /** asList() method
         The Guava Ints.asList() method wraps the specified primitive integer array as a list of the Integer type,
         unlike Arrays.asList(), which takes a non-primitive array.
         Note:
         The Arrays.asList() method does not accept the array of primitive type to convert to a list. see below:
         */
        // int[] intsArr = new int[]{34, 1, 10, 7};
        // List<Integer> IntegerList = Arrays.asList(intsArr);  // Error: Required type: List<Integer>, provided List<int[]>.
        //List<Integer> myList = Arrays.asList(1, 4, 5);  //Accepts values provided like this.

        int arr[] = {5, 10, 15, 20, 25};
        // Using Ints.asList() method which wraps the primitive integer array as List of
        // integer Type
        List<Integer> myList = Ints.asList(arr);
        // Displaying the elements
        System.out.println(myList);
    }

    @Test
    public void intsClassTestTwo() {
        /** toArray() method
         The Guava Ints.toArray() method can be used to convert a list (or set) of Integer to a primitive integer array.
         */
         List<Integer> myList = Arrays.asList(5, 10, 15, 20, 25);
        // Using Ints.toArray() method which
        // converts a List of Integer to an
        // array of int
        int[] arr = Ints.toArray(myList);
        // Displaying the elements
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void intsClassTestThree(){
        /** Concat() method
         The Guava Ints.concat() method combines elements from specified arrays into a single array.
         */
        int[] first = { 1, 2, 3 };
        int[] second = { 4, 5 };
        int[] third = { 6, 7, 8 };
        int[] firstThirdArr = Ints.concat(first, third);
        System.out.println("First and Third arrays combined: ");
        System.out.println(Arrays.toString(firstThirdArr));
        System.out.println();
        int[] firstSecondThirdArr = Ints.concat(first, second, third);
        System.out.println(" All 3 arrays combined: \n" + Arrays.toString(firstSecondThirdArr));
    }

    @Test
    public void intsClassTestFour(){
        /** contains() method
         The Guava Ints.contains() method search for an element in the array and returns true if the element is found or
         return false otherwise.  It checks if an element is present in the array or not and returns true or false.
         */
        int[] arr = { 5, 10, 15, 20 };
        // Using Ints.contains() method which
        // checks if element is present in array or not
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Element 10 present: " + Ints.contains(arr, 10));
        System.out.println("Element 17 present: " + Ints.contains(arr, 17));
    }

    @Test
    public void intsClassTestFive(){
        /** Ints.min() and Ints.max() methods
         The Guava Ints.min() method returns the minimum value present in array and the Ints.max() method returns the maximum value.
         */
        int[] arr = { 3, 1, 5, 2, 4 };
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("The minimum value is " + Ints.min(arr));
        System.out.println("The maximum value is " + Ints.max(arr));
    }

    @Test
    public void intsClassTestSix(){
        /** Ints.indexOf() and Ints.lastIndexOf() method
         The Guava Ints.indexOf() method returns the index of the first appearance of the given element in an array and
         returns -1 if the element is not found in the array.
         The Ints.lastIndexOf() method works similarly but returns the index of the last appearance.
         */
        int[] arr = { 1, 2, 3, 2, 4 };
        System.out.println(Ints.indexOf(arr, 2));
        System.out.println(Ints.indexOf(arr, 5));
        System.out.println(Ints.lastIndexOf(arr, 2));
        System.out.println(Ints.lastIndexOf(arr, 5));
    }

    @Test
    public void intsClassTestSeven(){
        /** Ints.join() method
         The Guava Ints.join() method returns a string containing the array elements, separated by a separator.
         */
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Ints.join("--", arr));
    }

}
