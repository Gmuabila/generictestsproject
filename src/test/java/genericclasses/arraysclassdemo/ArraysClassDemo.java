package genericclasses.arraysclassdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArraysClassDemo {
    //Arrays class
    //java.util.Arrays, is a utility class that has been part of Java since Java 1.2.
    //The Arrays class is a part of the Java Collections framework and provides methods to create,
    //access and manipulate Java arrays dynamically. The class provides static methods to dynamically create and access Java arrays.
    //Using Arrays class, we can create, compare, sort, search, stream, and transform arrays.
    //It consists of only static methods and the methods of Object class.
    //The methods of this class can be used by the class name itself. This class also contains a static factory that
    //allows arrays to be viewed as lists.  The methods in this class all throw a NullPointerException,
    //if the specified array reference is null, except where noted.

    @Test
    public void arraysClassTestOne(){
        //asList()
        //Returns a fixed-size list backed by the specified Arrays.
        String[] strArr = new String[]{"January", "February", "March", "April", "May"};
        System.out.println("Printing the original array: ");
        System.out.println(Arrays.toString(strArr));
        System.out.println();
        List<String> strList = Arrays.asList(strArr);
        System.out.println("Printing the converted list: " + strList);

        //The above program demonstrates the usage of the ‘asList’ method of Arrays class.
        //Here, we have declared a string array and passed it to asList method to obtain a list.
    }

    @Test
    public void arraysClassTestTwo(){
        //Fill()
        //Fills the array with the specified value.
        //static void fill(int[] a, int val)
        //Parameters
        //a : array to be filled
        //val : value to be filled in all places in array
        //Return Value: None

        // define the array
        int[] intArray = { 1, 3, 5, 7 };
        //print original array
        System.out.println("The original array: " + Arrays.toString(intArray));
        //call fill method to fill the array with all zeros
        Arrays.fill(intArray, 0);  //fills the array with all zeros.
        //print altered array
        System.out.println("Array after call to fill:" + Arrays.toString(intArray));

        //The above program shows the basic version of the fill method. Here, we just fill the entire
        //array by another value. In this case, we have filled the array with all zeros.
    }

    @Test
    public void arraysClassTestThree(){
        //fill(int[] a, int fromIndex, int toIndex, int val)
        //Fills the specified range from fromIndex to toIndex in the array ‘a’ with the specified value.
        //If fromIndex = toIndex, then the range to be filled is empty.
        //static void fill(int[] a, int fromIndex, int toIndex, int val)
        //Parameters
        //a : array whose range is to be filled
        //fromIndex : start index of the range
        //toIndex : end index of the range
        //val : value with which the elements in the range is to be filled

        // define the array
        int[] intArray = { 1, 3, 5, 7, 9, 11, 13, 15,17};
        //print original array
        System.out.println("The original array: " + Arrays.toString(intArray));
        //call fill method to fill the range (2,6) in the array with zeros
        Arrays.fill(intArray, 6, 6, 0);
        //print altered array
        System.out.println("Array after call to fill the range(2,6):" + Arrays.toString(intArray));

        //This is another version of the fill method wherein, we specify the particular range in the array which is to
        //be filled with a different value. In the above program, we have specified the range [2, 6] to be filled with zeros.
        //The other elements remain the same as shown in the output.
    }

    @Test
    public void arraysClassTestFour(){
        //equals()
        //This method checks if both the arrays are equal and return the results.
        //The two arrays are said to be equal if both the arrays have an equal number of elements and
        //the corresponding elements in both arrays are equal.
        //static boolean equals (int[] a, int[] a2)
        //Parameters:
        //a : first array to be tested for equality
        //a2 : second array to be tested for equality
        //Return Value: Returns true if both arrays are equal.

        // define two arrays, array_One and array_Two
        int[] array_One = { 1, 3, 5, 7 };
        int[] array_Two = { 1, 3, 5, 7 };
        //print the arrays
        System.out.println("array_One = " + Arrays.toString(array_One));
        System.out.println("array_Two = " + Arrays.toString(array_Two));
        //use equals method to check for equality of arrays
        boolean array_equal = Arrays.equals(array_One, array_Two);
        //print the results
        if (array_equal) {
            System.out.println("equals method returns " + array_equal +
                    ", hence array_One and array_Two are equal\n");
        }else {
            System.out.println("equals method returns " + array_equal +
                    ", hence array_One and array_Two are not equal\n");
        }
    }

    @Test
    public void arraysClassTestFive(){
        //Sort()
        //This method sorts the array in ascending order.
        //static void sort(int[] a)
        //Parameters:
        //a : array to be sorted
        //Return Value: None

        // define the array
        int[] intArray = {10,4,25,63,21,51,73,24,87,18};
        //print original array
        System.out.println("The original array: " + Arrays.toString(intArray));
        //call sort method to sort the given array in ascending order
        Arrays.sort(intArray);
        //print altered array
        System.out.println("Sorted array:" + Arrays.toString(intArray));

        //The above program sorts an array of integers using the sort method of Arrays class and prints the sorted array.
    }

    @Test
    public void arraysClassTestSix(){
        //static void sort(int[] a, int fromIndex, int toIndex)
        //Sorts the range specified from fromIndex to toIndex in ascending order.
        //If fromIndex=toIndex, then range to be sorted is empty.
        //static void sort(int[] a, int fromIndex, int toIndex)
        //Parameters:
        //a : array from which a range is to be sorted
        //fromIndex : start index for the range
        //toIndex : end index for the range
        //Return Value: none.

        // define the array
        int[] intArray = {10,4,25,63,21,51,73,24,87,18};
        //print original array
        System.out.println("The original array: " + Arrays.toString(intArray));
        //call sort method to sort the given range in the array in ascending order
        Arrays.sort(intArray, 2, 7);
        //print altered array
        System.out.println("Sorted range(2,7) in the array:" + Arrays.toString(intArray));

        //The above program demonstrates the variation of sort method. In this, we can specify a range over
        //which the array is to be sorted. The elements out of this range are not sorted. In the above program,
        //the range [2,7] in the given array is specified to be sorted in the sort method.
    }

    @Test
    public void arraysClassTestSeven(){
        //Hashcode()
        //The method returns the hashcode of a given array.
        //The hashcode of a Java Object is actually a 32-bit number (signed int). Using hashcode you can manage an
        //object using hash-based structure. Hashcode is allocated by JVM to an object and is usually unique unless the
        //two objects are equal to each other in which case both the objects will have the same hashcode.
        //static int hashCode(int[] a)
        //Parameters:
        //a : array whose hashcode is to be computed.
        //Return Value: int hashcode computed

        //declare arrays of type int
        int[] intArray = {10,20,30,40,50};
        //print the input array
        System.out.println("The input Array: " + Arrays.toString(intArray));
        //get hashcode of the array using 'hashCode' method of array
        int hashCde = Arrays.hashCode(intArray);
        //print the hashCode
        System.out.println("The hashCode for input array: " + hashCde);
    }

    @Test
    public void arraysClassTestEight(){
        //copyOf()
        //Copies the array original into a new array and pads or truncates it with zeros depending on the length specified.
        //static int[] copyOf(int[] original, int newLength)
        //Parameters:
        //original : array to be copied
        //newLength : length of the copied array.
        //Return Value: A new array copied from the original and padded or truncated with zeros depending on a specified length.

        //Defining the array to copy
        String[] originalArr = new String[]{"Java", "Python", "C++", "JavaScript", "Perl"};
        System.out.println("This is the original Array: " + Arrays.toString(originalArr));
        System.out.println();
        System.out.println("The new copied Array: " + Arrays.toString(Arrays.copyOf(originalArr, 3)));
        System.out.println();
        String[] cpiedArray = Arrays.copyOf(originalArr, 8);
        System.out.println("A new copied Array of 8 element: " + Arrays.toString(cpiedArray));
        System.out.println("***************************************************************");
        System.out.println();
        //Defining an int array
        int[] arrInts = new int[]{3, 25, 46, 2, 7, 23, 33, 30, 56, 90};
        System.out.println("The int array is: " + Arrays.toString(arrInts));
        int[] cpIntsArr = Arrays.copyOf(arrInts, 15);
        System.out.println("Copied array of ints length 15: " + Arrays.toString(cpIntsArr));

        //The above program demonstrates the use of the ‘copyOf’ method of Arrays class that
        //copies the given array into a new one. The above program copies the original string array into a new array.
    }

    @Test
    public void arraysClassTestNine(){
        //copyOfRange()
        //Copies the range specified from a given array into a new array. The started index of
        //the array should be inclusive between 0 to original.length(). The end index can be exclusive.
        //static int[] copyOfRange(int[] original, int from, int to)
        //Parameters:
        //original : array from which values in the range are to be copied
        //from : first index of the range
        //to : last index of the range
        //Return Value: New array with values from the specified range with zeros truncated or padded to obtain the desired length.

        String[] originalArr = new String[]{"Java", "Python", "C++", "Perl", "DotNet", "JavaScript"};
        System.out.println("The original Array: " + Arrays.toString(originalArr));
        System.out.println();
        System.out.println("The copied Array: " + Arrays.toString(Arrays.copyOfRange(originalArr, 2, 5)));
        System.out.println();
        String[] cpArrRange = Arrays.copyOfRange(originalArr, 2, 5);
        assertArrayEquals(new String[]{"C++", "Perl", "DotNet"}, cpArrRange);
        assertFalse(Arrays.equals(originalArr, cpArrRange));

        //The ‘copyOfRange()’ method copies a specific range from the array and forms a new array.
        //In the above program, we have specified the range like 2, 5. Hence, the output shows a new array of 3 elements.
    }

    @Test
    public void arraysClassTestTen(){
        String[] intro = new String[]{"once", "upon", "a", "time"};
        String[] ccopyOne = Arrays.copyOf(intro, 3);
        String[] ccopyTwo = Arrays.copyOf(intro, 5);

        assertArrayEquals(Arrays.copyOfRange(intro, 0, 3), ccopyOne);
        assertNull(ccopyTwo[4]);
    }
}


