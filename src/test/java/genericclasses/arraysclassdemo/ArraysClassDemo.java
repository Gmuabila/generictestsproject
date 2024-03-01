package genericclasses.arraysclassdemo;

import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ArraysClassDemo {
    /** Arrays class
    java.util.Arrays, is a utility class that has been part of Java since Java 1.2.
    The Arrays class is a part of the Java Collections framework and provides methods to create,
    access and manipulate Java arrays dynamically. The class provides static methods to dynamically create and access Java arrays.
    Using Arrays class, we can create, compare, sort, search, stream, and transform arrays.
    It consists of only static methods and the methods of Object class.
    The methods of this class can be used by the class name itself. This class also contains a static factory that
    allows arrays to be viewed as lists.  The methods in this class all throw a NullPointerException,
    if the specified array reference is null, except where noted.
     Special Note:
     The type of array must be a Wrapper Class(Integer, Float, etc.) in case of primitive data types(int, float, etc.) i.e.
     you can’t pass int a[] but you can pass Integer a[]. If you pass int a[], this function will return a  List <int a[]> and
     not List <Integer> , as “autoboxing” does not happen in this case and int a[] is itself identified as an object and a
     List of int array is returned, instead of list of integers , which will give error in various Collection functions .
     */

    @Test
    public void arraysClassTestOne(){
        /** asList()
         The asList() method of Arrays class is used to return a fixed-size list backed by the specified array.
         This method acts as a bridge between array-based and collection-based APIs, in combination with Collection.toArray().
         The returned list is serializable and implements RandomAccess.
         */
        String[] strArr = new String[]{"January", "February", "March", "April", "May"};
        System.out.println("Printing the original array: ");
        System.out.println(Arrays.toString(strArr));
        System.out.println();
        List<String> strList = Arrays.asList(strArr);
        System.out.println("Printing the converted list: \n" + strList);
        System.out.println();

        int[] arrInts = new int[]{1, 2, 3, 8};
        System.out.println("Array: " + Arrays.toString(arrInts));
        List<int[]> intsList = Arrays.asList(arrInts);  //As mentioned above, if you pass an array of primitive int, the method returns a List<int[]>.
        System.out.println();
        Integer[] integersArr = new Integer[]{11, 3, 120, 9};
        List<Integer> integerList = Arrays.asList(integersArr);  //As mentioned above, the array of wrapper class returns List<Integer>.
    }

    @Test
    public void arraysClassTestOneB(){
        /** Java Program to demonstrate asList() method Which returns fixed size list and
            throws UnsupportedOperationException if any element is added using add() method
         */
         // Try block to check for exceptions
        try {
            // Creating Arrays of Integer type
            Integer a[] = new Integer[] { 10, 20, 30, 40 };
            // Getting the list view of Array
            List<Integer> list = Arrays.asList(a);
            // Adding another int to the list
            // As Arrays.asList() returns fixed size
            // list, we'll get java.lang.UnsupportedOperationException
            list.add(50);
            // Printing all the elements of list
            System.out.println("The list is: " + list);
        }
        // Catch block to handle exceptions
        catch (UnsupportedOperationException e) {
            // Display message when exception occurs
            System.out.println("Exception thrown : " + e);
        }
    }

    @Test
    public void arraysClassTestOneC(){
        /** binarySearch()
         The binarySearch() method searches the specified array of the given data type for the specified value using the binary search algorithm.
         The array must be sorted as by the Arrays.sort() method prior to making this call. If it is not sorted, the results are undefined.
         If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
         Let us glide through the illustration provided below as follows.
         Syntax:
         public static int binarySearch(data_type arr, data_type key)
         Remember: Here datatype can be any of the primitive data types such as byte, char, double, int, float, short, long, and even object as well.
         Parameters:
         •	The array to be searched
         •	The value to be searched for
         Return Type: index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1).
         The insertion point is defined as the point at which the key would be inserted into the array: the index of the
         first element greater than the key, or a.length if all elements in the array are less than the specified key.
         Note that this guarantees that the return value will be >= 0 if and only if the key is found.
         There are certain important points to be kept in mind as follows:
         •	If the input list is not sorted, the results are undefined.
         •	If there are duplicates, there is no guarantee which one will be found.
         */
        byte byteArr[] = { 10, 20, 15, 22, 35 };
        char charArr[] = { 'g', 'p', 'q', 'c', 'i' };
        int intArr[] = { 10, 20, 15, 22, 35 };
        double doubleArr[] = { 10.2, 15.1, 2.2, 3.5 };
        float floatArr[] = { 10.2f, 15.1f, 2.2f, 3.5f };
        short shortArr[] = { 10, 20, 15, 22, 35 };
        // Using sort() method of Arrays class
        // and passing arrays to be sorted as in arguments
        Arrays.sort(byteArr);
        Arrays.sort(charArr);
        Arrays.sort(intArr);
        Arrays.sort(doubleArr);
        Arrays.sort(floatArr);
        Arrays.sort(shortArr);
        // Primitive datatype
        byte byteKey = 35;
        char charKey = 'g';
        int intKey = 22;
        double doubleKey = 1.5;
        float floatKey = 35;
        short shortKey = 5;
        // Now in sorted array we will fetch and return elements/indices accessing indexes to show
        // array is really sorted
        // Print commands where we are implementing
        System.out.println(
                byteKey + " found at index = "
                        + Arrays.binarySearch(byteArr, byteKey));
        System.out.println(
                charKey + " found at index = "
                        + Arrays.binarySearch(charArr, charKey));
        System.out.println(
                intKey + " found at index = "
                        + Arrays.binarySearch(intArr, intKey));
        System.out.println(
                doubleKey + " found at index = "
                        + Arrays.binarySearch(doubleArr, doubleKey));
        System.out.println(
                floatKey + " found at index = "
                        + Arrays.binarySearch(floatArr, floatKey));
        System.out.println(
                shortKey + " found at index = "
                        + Arrays.binarySearch(shortArr, shortKey));
    }

    @Test
    public void arrayClassTestOneD(){
        // Creating empty List
        List<Integer> al = new ArrayList();
        // Adding elements to the List
        al.add(12);
        al.add(53);
        al.add(23);
        al.add(46);
        al.add(54);
        Collections.sort(al);  //12, 23, 46, 53, 54 sorted list will be this.  Sorting the list first gives correct results.
        // Using binarySearch() method of Collections class
        // over random inserted element and storing the
        // index
        int index = Collections.binarySearch(al, 54);
        // Print and display the index
        System.out.print(index);
    }

    @Test
    public void arrayClassTestOneE(){
        /** binarySearch(array, fromIndex, toIndex, key, Comparator)
         This method searches a range of the specified array for the specified object using the binary search algorithm.
         The range within which the specified key to be searched must be sorted (as by the Arrays.sort() method) prior to making this call.
         Otherwise, the result would be undefined. If the specified array contains multiple values same as the specified key,
         there is no guarantee which one will be found.
         Syntax:
         public static int binarySearch(data_type[] arr, int fromIndex, int toIndex, data_type key)
         Parameters :
         arr – the array to be searched.
         fromIndex – the index of the first element (inclusive) to be searched.
         toIndex – the index of the last element (exclusive) to be searched.
         key  – the value to be searched for
         Returns :
         Index of the specified key is found within the specified range in the specified array, Otherwise (-(insertion point) – 1).
         */
        // Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };
        Arrays.sort(intArr);
        int intKey = 22;
        System.out.println(intKey
                        + " found at index = "
                        + Arrays
                        .binarySearch(intArr, 1, 3, intKey));
    }

    @Test
    public void arrayClassTestOneF(){
        byte byteArr[] = { 10, 20, 15, 22, 35 };
        char charArr[] = { 'g', 'p', 'q', 'c', 'i' };
        int intArr[] = { 1, 2, 3, 4, 5, 6 };
        double doubleArr[] = { 10.2, 15.1, 2.2, 3.5 };
        float floatArr[] = { 10.2f, 15.1f, 2.2f, 3.5f };
        short shortArr[] = { 10, 20, 15, 22, 35 };

        Arrays.sort(byteArr);    //Sorted: 10, 15, 20, 22, 35
        Arrays.sort(charArr);    //Sorted: c, g, i, p, q
        Arrays.sort(intArr);     //Sorted: 1, 2, 3, 4, 5, 6
        Arrays.sort(doubleArr);  //Sorted: 2.2, 3.5, 10.2, 15.1
        Arrays.sort(floatArr);   //Sorted: 2.2f, 3.5f, 10.2f, 15.1f
        Arrays.sort(shortArr);   //Sorted: 10, 15, 20, 22, 35

        byte byteKey = 22;
        char charKey = 'p';
        int intKey = 3;
        double doubleKey = 1.5;
        float floatKey = 35;
        short shortKey = 5;

        System.out.println(
                byteKey + " found at index = "
                        + Arrays.binarySearch(byteArr, 2, 4, byteKey));
        System.out.println(
                charKey + " found at index = "
                        + Arrays.binarySearch(charArr, 1, 4, charKey));
        System.out.println(
                intKey + " found at index = "
                        + Arrays.binarySearch(intArr, 1, 4, intKey));
        System.out.println(doubleKey + " found at index = "
                + Arrays.binarySearch(
                doubleArr, 1, 4, doubleKey));
        System.out.println(floatKey + " found at index = "
                + Arrays.binarySearch(
                floatArr, 1, 4, floatKey));
        System.out.println(shortKey + " found at index = "
                + Arrays.binarySearch(
                shortArr, 0, 4, shortKey));
    }

    @Test
    public void arrayClassTestOneG(){
        /** equals()
         This method checks if both the arrays are equal and return the results. Two arrays are considered equal if both arrays contain the
         same number of elements, and all corresponding pairs of elements in the two arrays are equal.
         In other words, two arrays are equal if they contain the same elements in the same order. Also, two array references are
         considered equal if both are null. Arrays class in java provide the method Arrays.equals() to check whether two arrays are equal or not.
         Syntax:
         static Boolean equals (int[] a, int[] a2)
         Parameters:
         a : first array to be tested for equality
         a2 : second array to be tested for equality
         Return Value: Returns true if both arrays are equal.
         Other Variants:
         public static boolean equals(byte[] a, byte[] a2)
         public static boolean equals(short[] a, short[] a2)
         public static boolean equals(long[] a, long[] a2)
         public static boolean equals(float[] a, float[] a2)
         public static boolean equals(double[] a, double[] a2)
         public static boolean equals(char[] a, char[] a2)
         public static boolean equals(boolean[] a, boolean[] a2)
         public static boolean equals(Object[] a, Object[] a2)
         */
        // Let us create different integers arrays
        int[] arr1 = new int [] {1, 2, 3, 4};
        int[] arr2 = new int [] {1, 2, 3, 4};
        int[] arr3 = new int [] {1, 2, 4, 3};
        System.out.println("is arr1 equals to arr2 : " +
                Arrays.equals(arr1, arr2));
        System.out.println("is arr1 equals to arr3 : " +
                Arrays.equals(arr1, arr3));
    }

    @Test
    public void arrayClassTestOneH(){
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
    public void arrayClassTestOneI(){
        /** We can also use Arrays.equals() for checking equality of array of objects of user defined classes.
         Note : In case of arrays of Objects, you must override equals method to provide your own definition of equality,
         otherwise you will get output depends on what equals() method of Object class returns.
         In the program below, we are checking equality of rollno, name, and address for a student
         */
        Student [] arr1 = {
                new Student(111, "bbbb", "london"),
                new Student(131, "aaaa", "nyc"),
                new Student(121, "cccc", "jaipur")};
        Student [] arr2 = {
                new Student(111, "bbbb", "london"),
                new Student(131, "aaaa", "nyc"),
                new Student(121, "cccc", "jaipur")};
        Student [] arr3 = {
                new Student(111, "bbbb", "london"),
                new Student(121, "dddd", "jaipur"),
                new Student(131, "aaaa", "nyc"),
        };
        System.out.println("is arr1 equals to arr2 : " +
                Arrays.equals(arr1, arr2));
        System.out.println("is arr1 equals to arr3 : " +
                Arrays.equals(arr1, arr3));
    }

    @Test
    public void arrayClassTestOneJ(){
        /** copyOf()
         The copyOf() method of Arrays class copies the specified array, truncating or
         padding with false (if necessary) so the copy has the specified length.
         Syntax: static int[] copyOf(int[] original, int newLength)
         Parameters:
         original : array to be copied
         newLength : length of the copied array.
         Return Value: A new array copied from the original and padded or truncated with zeros depending on a specified length.
         Note that copyOf() pads the array with nulls if our target size is bigger than the original size.
         The two arrays will have same values for all the indices that are valid in original array and new array.
         However, the indices missing in original will have zero in copy in case the copied array length is more than the original array.
         */
        // initializing an array original
        int[] org = new int[] {1, 2 ,3};
        System.out.println("Original Array");
        for (int i = 0; i < org.length; i++)
            System.out.print(org[i] + " ");
        // copying array org to copy
        int[] copy = Arrays.copyOf(org, 5);
        // Changing some elements of copy
        copy[3] = 11;
        copy[4] = 55;
        System.out.println("\nNew array copy after modifications:");
        for (int i = 0; i < copy.length; i++)
            System.out.print(copy[i] + " ");
        System.out.println();
        System.out.println();
        // initializing an array original
        int[] orgT = new int[]{1, 2, 3};
        System.out.println("Original Array :");
        for (int i = 0; i < orgT.length; i++)
            System.out.print(orgT[i] + " ");
        // copying array org to copy
        // Here, new array has 5 elements - two
        // elements more than the original array
        int[] copyT = Arrays.copyOf(orgT, 5);
        System.out.print("\nNew array copy (of higher length):\n");
        for (int i = 0; i < copyT.length; i++)
            System.out.print(copyT[i] + " ");
    }

    @Test
    public void arrayClassTestOneK() {
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
    public void arrayClassTestOneK2(){
            String[] intro = new String[]{"once", "upon", "a", "time"};
            String[] ccopyOne = Arrays.copyOf(intro, 3);
            String[] ccopyTwo = Arrays.copyOf(intro, 5);

            assertArrayEquals(Arrays.copyOfRange(intro, 0, 3), ccopyOne);
            assertNull(ccopyTwo[4]);
    }

    @Test
    public void arrayClassTestOneL(){
        /** copyOfRange()
         The copyOfRange() method creates a copy of elements, within a specified range of the original array.
         It copies the range specified from a given array into a new array. The started index of the array should be
         inclusive between 0 to original.length(). The end index can be exclusive.
         Syntax:
         public static int[] copyOfRange(int[] original_array, int from_index, int to_index)
         Parameters:
         original_array : Array to be copied from
         from_index : Starting index of range to be copied, inclusive.
         to_end : the final index of the range to be copied, exclusive. (This index may lie outside the array.)
         Return Value: New array with values from the specified range with zeros truncated or padded to obtain the desired length.
         */
        int arr[] = { 12, 13, 14, 15, 16, 17, 18 };
        // to index is within the range
        int[] copy = Arrays.copyOfRange(arr, 2, 6);
        for (int i : copy)
            System.out.print(i + "  ");
        System.out.println();
        // to index is out of range
        // It assigns Zero to all the index out of range
        int[] copy1 = Arrays.copyOfRange(arr, 4, arr.length + 3);
        for (int i : copy1)
            System.out.print(i + "  ");
        // It throws IllegalArgumentException
        // int[] copy2 = Arrays.copyOfRange(arr, 5, 3);
        // It throws ArrayIndexOutOfBoundsException
        // int[] copy2 = Arrays.copyOfRange(arr, 10, arr.length + 5);
    }

    @Test
    public void arrayClassTestOneM(){
        String[] originalArr = new String[]{"Java", "Python", "C++", "Perl", "DotNet", "JavaScript"};
        System.out.println("The original Array: " + Arrays.toString(originalArr));
        System.out.println();
        System.out.println("The copied Array: " + Arrays.toString(Arrays.copyOfRange(originalArr, 2, 5)));
        System.out.println();
        String[] cpArrRange = Arrays.copyOfRange(originalArr, 2, 5);
        assertArrayEquals(new String[]{"C++", "Perl", "DotNet"}, cpArrRange);
        assertFalse(Arrays.equals(originalArr, cpArrRange));
    }

    @Test
    public void arrayClassTestOneN(){
         //Let's see an Example for copyOfRange(T[] original, int from, int to) and
        // copyOfRange(U[] original, int from, int to, Class newType)
        Employee[] empArr = {
                new Employee(10, "geek1"),
                new Employee(20, "geek2"),
                new Employee(30, "geek3"),
                new Employee(40, "geek4"),
                new Employee(50, "geek5") };
        // Illustration of copyOfRange(T[] original, int from, int to)
        // Working with user defined class
        Employee[] getCopy_EmpArr = Arrays.copyOfRange(empArr, 3, 5);
        for (Employee emp : getCopy_EmpArr)
            System.out.println(emp.toString());  //No need to use toString().
        System.out.println();
        // Illustration of copyOfRange(U[] original, int from, int to, Class newType)
        // In this we store the user defined class Employee into Object class
        // It Throws ArrayStoreException when we try to copy it in a class
        // That is not correct
        Object[] getCopy = Arrays.copyOfRange(empArr, 1, 3, Object[].class);
        // The below throws an exception: java.lang.ArrayStoreException: arraycopy: type mismatch: can not copy...Employee[] into java.lang.Number[]
        // Number getCopy[] = Arrays.copyOfRange(e, 1, 3, Number[].class);
        for (Object empObj : getCopy) {
            System.out.println(empObj);
        }

    }

    @Test
    public void arraysClassTestTwo() {
        /** fill()
         The fill(int[] a, int val) method of the Arrays class fills the array with the specified value.
         The fill(int[] a, int from_Index, int to_Index, int val) assigns the specified data type value to each element of
         the specified range of the specified array.
         This is another way we can create a fixed-length array, which is useful when we want an array where all elements are the same.
         Syntax:
         static void fill(int[] a, int val)
         Makes all elements of a[] equal to "val”.
         Syntax:
         public static void fill(int[] a, int from_Index, int to_Index, int val)
         Makes elements from from_Index (inclusive) to to_Index (exclusive) equal to "val".
         Return value: This method doesn't return any value.
         Parameters:
         a : array to be filled
         val : value to be filled in all places in array
         Exceptions it Throws:
         IllegalArgumentException - if from_Index > to_Index
         ArrayIndexOutOfBoundsException - if from_Index > a.length
         */
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
        System.out.println();
        int ar[] = {2, 2, 1, 8, 3, 2, 2, 4, 2};
        // To fill complete array with a particular
        // value
        Arrays.fill(ar, 10);
        System.out.println("Array completely filled" +
                " with 10\n" + Arrays.toString(ar));
        System.out.println();
        int arTwo[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        // Fill from index 1 to index 4.
        Arrays.fill(arTwo, 1, 5, 10);
        System.out.println(Arrays.toString(arTwo));
    }

    @Test
    public void arraysClassTestThree(){
        // define the array
        int[] intArray = { 1, 3, 5, 7, 9, 11, 13, 15,17};
        //print original array
        System.out.println("The original array: " + Arrays.toString(intArray));
        //call fill method to fill the range (2,6) in the array with zeros
        Arrays.fill(intArray, 5, 6, 0);  //May use this to change an element in an array.
        //print altered array
        System.out.println("Array after call to fill the range(5,6):" + Arrays.toString(intArray));
        System.out.println();
    }

    @Test
    public void arraysClassTestFour(){
        /** mismatch()
         The mismatch() method of the Arrays class returns the index at which two arrays passed as parameters have the first unequal element.
         It is quite useful to check whether two arrays contain the same corresponding elements or not. This responds when a mismatch occurs.
         If both arrays have corresponding elements same then this function returns -1.
         Syntax
         Arrays.mismatch(first_array, second_array);
         Parameters:
         1. first_array: An array (first array name) of a particular data type.
         2. second_array: Another array (second array name) of the same type.
         Return value:
         1. -1: If both the arrays have same elements at all the corresponding positions.
         2. non-negative integer: The index at which both the arrays have first unequal elements.
         Note: The data type of both arrays must be the same, and this method follows zero-based indexing.
         */
        // Initializing an integer array
        int array1[] = { 2, 7, 11, 22, 37 };
        // Initializing another array
        int array2[] = { 2, 7, 11, 22, 37 };
        // Initializing another array
        int array3[] = { 2, 7, 19, 31, 39, 56 };
        // Return the first index at which array1
        // array2 have the different element
        int index1 = Arrays.mismatch(array1, array2);
        // Return the first index at which array1
        // array3 have the different element
        int index2 = Arrays.mismatch(array1, array3);
        // Return the first index at which array2
        // array3 have the different element
        int index3 = Arrays.mismatch(array2, array3);
        // Print the first index at which array1
        // array2 have the different element
        System.out.println(
                "The index at which array1 and array2 have first unequal element: "
                        + index1);
        // Print the first index at which array1
        // array3 have the different element
        System.out.println(
                "The index at which array1 and array3 have first unequal element: "
                        + index2);
        // Print the first index at which array2
        // array3 have the different element
        System.out.println(
                "The index at which array2 and array3 have first unequal element: "
                        + index3);
        System.out.println();
        System.out.println("Mismatch values are: " + "Array1: " + array1[index2] + " - " + "Array3: " + array3[index2]);
        System.out.println("Mismatch values are: " + "Array2: " + array2[index3] + " - " + "Array3: " + array3[index3]);
    }

    @Test
    public void arrayClassTestFourB(){
        /** mismatch() method */
        // Initializing a character array
        char array1[] = { 'g', 'e', 'e', 'k', 's' };
        // Initializing another array
        char array2[] = { 'g', 'e', 'e', 'k', 's' };
        // Initializing another array
        char array3[] = { 'g', 'e', 'e', 'k' };
        // Return the first index at which array1 and array2 have different element
        int index1 = Arrays.mismatch(array1, array2);
        // Return the first index at which array1 and array3 have different element
        int index2 = Arrays.mismatch(array1, array3);
        // Return the first index at which array2 and array3 have different element
        int index3 = Arrays.mismatch(array2, array3);
        // Print the first index at which array1 and array2 have different element
        System.out.println(
                "The index at which array1 and array2 have first unequal element: "
                        + index1);
        // Print the first index at which array1 and array3 have different element
        System.out.println(
                "The index at which array1 and array3 have first unequal element: "
                        + index2);
        // Print the first index at which array2 and array3 have the different element
        System.out.println(
                "The index at which array2 and array3 have first unequal element: "
                        + index3);
        System.out.println();
        System.out.println("Mismatch elements: " + "array1 value: " + array1[index2] + " - " + "But array3 value is: " + "null");
        System.out.println("Mismatch elements: " + "array2 value: " + array2[index3] + " - " + "But array3 value is: " + "null");
        //Unable to access the value for array3[index3], the array3 does not have any element at index 4, its length is 4.  But this is where the
        //mismatch occurred.  It is at index 4 that array1, array2 differ from array3 as array3 does not have index 4, and therefore you
        //get an ArrayOutOfBoundException if you try accessing the value at this index.  This is why I've hardcoded hard, a good practice ? No.
    }

    @Test
    public void arraysClassTestFourC(){
        /** mismatch() method */
        // Initializing a boolean array
        boolean array1[] = { true, false, true, false };
        // Initializing another array
        boolean array2[] = { true, false, true, false };
        // Initializing another array
        boolean array3[] = { true, false, false, true };
        // Return the first index at which array1 and array2 have different element
        int index1 = Arrays.mismatch(array1, array2);
        // Return the first index at which array1 and array3 have different element
        int index2 = Arrays.mismatch(array1, array3);
        // Return the first index at which array2 and array3 have different element
        int index3 = Arrays.mismatch(array2, array3);
        // Print the first index at which array1 and array2 have different element
        System.out.println(
                "The index at which array1 and array2 have first unequal element: "
                        + index1);
        // Print the first index at which array1 and array3 have different element
        System.out.println(
                "The index at which array1 and array3 have first unequal element: "
                        + index2);
        // Print the first index at which array2 and array3 have different element
        System.out.println(
                "The index at which array2 and array3 have first unequal element: "
                        + index3);
    }

    @Test
    public void arraysClassTestFourD(){
        /** toString()
         The toString() method of the Arrays class returns a string representation of the contents of the specified array.
         The string representation consists of a list of the array’s elements, enclosed in square brackets (“[ ]”).
         Adjacent elements are separated by the characters “, ” (a comma followed by a space).
         In case of an Object Array, if the array contains other arrays as elements, they are converted to strings by the
         Object.toString() method inherited from Object, which describes their identities rather than their contents.
         Elements are converted to string as by String.valueOf() function.
         Syntax:
         static String toString(int[] a)
         Parameters:
         a : array whose string representation is required
         Return Value:
         The string representation of the array.  The method returns “null” if a is null.
         */
        // Let us create different types of arrays and
        // print their contents using Arrays.toString()
        boolean[] boolArr = new boolean[] { true, true, false, true };
        byte[] byteArr = new byte[] { 10, 20, 30 };
        char[] charArr = new char[] { 'g', 'e', 'e', 'k', 's' };
        double[] dblArr = new double[] { 1, 2, 3, 4 };
        float[] floatArr = new float[] { 1, 2, 3, 4 };
        int[] intArr = new int[] { 1, 2, 3, 4 };
        long[] lomgArr = new long[] { 1, 2, 3, 4 };
        Object[] objArr = new Object[] { 1, 2, 3, 4 };
        short[] shortArr = new short[] { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(boolArr));
        System.out.println(Arrays.toString(byteArr));
        System.out.println(Arrays.toString(charArr));
        System.out.println(Arrays.toString(dblArr));
        System.out.println(Arrays.toString(floatArr));
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(lomgArr));
        System.out.println(Arrays.toString(objArr));
        System.out.println(Arrays.toString(shortArr));
    }

    @Test
    public void arrayClassTestFourE(){
        /** We can also use Arrays.toString() for objects of user defined class.
         Since Arrays.toString() is overloaded for array of Object class (there exist a method Arrays.toString(Object [])) and
         Object is ancestor of all classes, we can call it for an array of any type of object.
         */
        Student[] arr = {
                new Student(111, "bbbb", "london"),
                new Student(131, "aaaa", "nyc"),
                new Student(121, "cccc", "jaipur") };
        System.out.println(Arrays.toString(arr));   //Note: Although we are using the toString method of the Arrays class to return the String
                                                    //representation of the array, the contents of this array are objects and this object class
                                                    //need to have its own toString method defined for the objects, otherwise only memory address
                                                    //of the object will be displayed as without the toString method the Object ancestor of all classes
                                                    //toString method will be called.
    }

    @Test
    public void arraysClassTestFive(){
        /** sort() method
         The sort() method of the Arrays class is used to sort the elements of the array in ascending order. It  consists of two variations,
         one of which we do not pass any arguments which sorts the complete array and the other is used to sort a specific part of the array.
         This is the overloaded method of Arrays class that we pass the starting and last index to the array.
         Syntax: sort() method
         public static void sort(int[] arr);
         Syntax: Overloaded sort() Method
         public static void sort(int[] arr, int from_Index, int to_Index);
         Parameters:
         •	arr:  array to be sorted.
         •	from_Index: the index of the first element, inclusive, to be sorted.
         •	to_Index: the index of the last element, exclusive, to be sorted.
         Return Value: None
         */
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
        //static void sort(int[] arr, int fromIndex, int toIndex)
        //Sorts the range specified from fromIndex to toIndex in ascending order.
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
    public void arrayClassTestSixB(){
        // Java program to sort a Subarray in Descending order using Arrays.sort()
        // Note that we have Integer here instead of int[], as Collections.reverseOrder doesn't
        // work for primitive types.
        Integer[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
        Arrays.sort(arr);
        System.out.println("Array in ascending order: " + Arrays.toString(arr));
        System.out.println();
        // Sorts arr[] in descending order using
        // reverseOrder() method of Collections class
        // in Array.sort() as an argument to it
        Arrays.sort(arr, Collections.reverseOrder());
        // Printing the array as generated above
        System.out.println("Array in Descending order: "
                + Arrays.toString(arr));
    }

    @Test
    public void arrayClassTestSixC() {
        // Custom input string
        String arr[] = {"practice.geeksforgeeks.org",
                "www.geeksforgeeks.org",
                "code.geeksforgeeks.org"};
        // Sorts arr[] in ascending order
        Arrays.sort(arr);
        System.out.println("Modified arr[] : "
                + Arrays.toString(arr));
        // Sorts arr[] in descending order
        Arrays.sort(arr, Collections.reverseOrder());
        // Lastly printing the above array
        System.out.println("Modified arr[] :"
                + Arrays.toString(arr));
    }

    @Test
    public void arrayClassTestSixD(){
        Student[] arr
                = { new Student(111, "bbbb", "london"),
                new Student(131, "aaaa", "nyc"),
                new Student(121, "cccc", "jaipur") };
        System.out.println("Unsorted");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        // Sorting on basic as per class 1 created (user-defined)
        Arrays.sort(arr, new SortByRoll());
        System.out.println("\nSorted by rollno");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    @Test
    public void arrayClassTestSixD2(){
        /** Arrays.sort(int[] arr, int from_index, int to_index, Comparator comparator)
         * We can also use the Arrays.sort() method to only sort a part of the array using the Comparator.
         */
        Student[] arr = { new Student(111, "bbbb", "london"),
                new Student(131, "rrrr", "nyc"),
                new Student(110, "aaaa", "islington"),
                new Student(299, "ffff", "pecham"),
                new Student(121, "cccc", "bermonsey") };

        System.out.println("Unsorted");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        Arrays.sort(arr, 1, 4, new SortByRoll());
        System.out.println("\nSorted by rollno");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    @Test
    public void arrayClassTestSixE(){
        /** Remember: There is a slight difference between Arrays.sort() vs Collections.sort().
        Arrays.sort() works for arrays which can be of primitive data type also.
         Collections.sort() works for objects Collections like ArrayList,LinkedList, etc.
         Using the reverseOrder() method:
         This method will sort the array in the descending order. The Java Collections class also provides the
         reverseOrder() method to sort the array in reverse-lexicographic order.  It does not parse any parameter, so we can
         invoke it directly by using the class name. it will sort the arrays in the ascending order by the sort() method after that
         the reverseOrder() method will give us the natural ordering and we will get the sorted array in the descending order.
         */
        Integer[] array
                = { 99, 12, -8, 12, 34, 110, 0, 121, 66, -110 };
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(
                "Array in descending order: "
                        + Arrays.toString(array));
         }

    @Test
    public void arraysClassTestSeven(){
        /** hashCode()
         The hashCode() method of the Arrays class returns the hashcode of a given array.  The method returns a hash code based on the
         contents of the specified array. If the array contains other arrays as elements, the hash code is based on their
         identities rather than their contents. For any two arrays a and b such that Arrays.equals(a, b), it is also the
         case that Arrays.hashCode(a) == Arrays.hashCode(b).
         The hashcode of a Java Object is actually a 32-bit number (signed int). Using hashcode you can manage an object using hash-based structure.
         Hashcode is allocated by JVM to an object and is usually unique unless the two objects are equal to each other in which case both the
         objects will have the same hashcode.
         Syntax:
         static int hashCode(int[] a)
         Parameters:
         a : array whose hashcode is to be computed.
         Return Value: int hashcode computed
         */
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
        /** stream() method
         The stream(T[] array) method of Arrays class is used to get a Sequential Stream from the array passed as the parameter with its elements.
         It returns a sequential Stream with the elements of the array, passed as parameter, as its source.
         Syntax:
         public static <T> Stream<T> stream(T[] array)
         Parameters:
         This method accepts a mandatory parameter array which is the array whose elements are to be converted into a sequential stream.
         Return Value:
         This method returns a Sequential Stream from the array passed as the parameter.
         */
        // Creating a String array
        String[] arr = { "Geeks", "for", "Geeks" };
        // Using Arrays.stream() to convert
        // array into Stream
        Stream<String> stream = Arrays.stream(arr);
        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
        System.out.println();
        System.out.println();
        // Creating an integer array
        int[] arrInts = { 1, 2, 3, 4, 5 };
        // Using Arrays.stream() to convert
        // array into Stream
        IntStream streamInts = Arrays.stream(arrInts);
        // Displaying elements in Stream
        streamInts.forEach(System.out::println);
        System.out.println();
        System.out.println();
        Integer[] arrInteger = new Integer[]{4, 89, 1, 100};
        Stream<Integer> integerStream = Arrays.stream(arrInteger);
        integerStream.forEach(System.out::println);
    }

    @Test
    public void arraysClassTestNine(){
        /** stream(T[] array, int startInclusive, int endExclusive)
         The stream(T[] array, int startInclusive, int endExclusive) method of the Arrays class is used to get a Sequential Stream from
         the array passed as the parameter with only some of its specific elements. These specific elements are taken from a range of
         index passed as the parameter to this method. It Returns a sequential Stream with the specified range of the specified array as its source.
         Syntax:
         public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive)
         Parameters: This method accepts three mandatory parameters:
         •	array which is the array of whose elements are to be converted into a sequential stream.
         •	startInclusive which is the first index to cover, inclusive.
         •	endExclusive which is the index immediately past the last index to cover.
         Return Value: This method returns a Sequential Stream formed from the range of elements of array passed as the parameter.
         */
        // Creating a String array
        String[] arr = { "Geeks", "for", "Geeks",
                "A", "Computer", "Portal" };
        // Using Arrays.stream() to convert
        // array into Stream
        Stream<String> stream = Arrays.stream(arr, 3, 6);
        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
        System.out.println();
        System.out.println();
        // Creating an integer array
        int arrInts[] = { 1, 2, 3, 4, 5 };
        // Using Arrays.stream() to convert
        // array into Stream
        IntStream streamTwo = Arrays.stream(arrInts, 1, 3);
        // Displaying elements in Stream
        streamTwo.forEach(str -> System.out.print(str + " "));
    }

    @Test
    public void arraysClassTestTen(){
        /** Difference between Arrays.stream() and Stream.of()
         The stream(T[] array) method of Arrays class is used to get a Sequential Stream from the array passed as the parameter with its elements.
         It returns a sequential Stream with the elements of the array, passed as parameter, as its source.
         The Stream of(T… values) method of the Stream class returns a sequential ordered stream whose elements are the specified values.
         Stream.of() method simply calls the Arrays.stream() method for non-primitive types.
         Different return types:
         For primitives arrays (like int[], long[] etc.), Arrays.stream() and Stream.of() have different return types. Example: Passing an
         Integer array, the Stream.of() method returns a Stream and the Arrays.stream() also returns a Stream.   Passing an int array,
         the Arrays.stream() returns an IntStream whereas the Stream.of() does not work with primitives and returns a Stream of int array and
         does not return the elements of the array.  Its return type is Stream<int[]>.  Also note that the Arrays.stream() method does not
         work with Arrays of other primitive types excepts the array of int[], long[], and double[].  It does not work with Arrays of
         other primitive types such as float[].
         Stream.of() is generic:
         Arrays.stream() method works with Arrays of objects and also works for primitive arrays of int[], long[], and double[] type,
         and returns IntStream, LongStream and DoubleStream respectively. For other primitive types, Arrays.stream() won’t work.
         On the other hand, Stream.of() returns a generic Stream of type T (Stream). Hence, it can be used with any type.
         */
        int[] arr = new int[]{ 3, 5, 19, 1};
        Integer[] arrInteger = new Integer[]{30, 2, 55, 9, 10};
        Stream<int[]> arrIntegerStream = Stream.of(arr);
        arrIntegerStream.forEach(item -> System.out.println(Arrays.toString(item)));  //Arrays are the items in this steam.
        System.out.println();
        Stream<Integer> arrIntegerStreamTwo = Stream.of(arrInteger);  //Stream.of is generic and does not support primitive types.
        arrIntegerStreamTwo.forEach(item -> System.out.print(item + " "));
        System.out.println();
        Stream<Character> characterStream = Stream.of('A', 'C', 'F'); //Can create stream from specified values as well as from collection and arrays.
        List<Character> characterList = characterStream.collect(Collectors.toList());
        Stream.of(characterList).forEach(item -> System.out.println(item + " "));  //Stream.of() accepting a list as argument.  No need to do this as
        //we can create a Stream from the collection but this is to show that Stream.of can accept a collection as argument.
        System.out.println();
        Stream<Integer> streamInteger = Arrays.stream(arrInteger);//Arrays.stream() accepts both Integer class and primitive types(Ints, Long, Double).
        streamInteger.forEach(item -> System.out.print(item + " "));
        System.out.println();
        IntStream intStream = Arrays.stream(arr);
        intStream.forEach(item -> System.out.print(item + " "));
        //IntStream intStream1 = Arrays.stream(3, 11, 44, 6);  //Cannot create a stream with specified values using Arrays.stream(), it accepts arrays.

    }

    @Test
    public void arraysClassTestTenB(){
        /** Difference between Arrays.stream() and Stream.of()
         Stream.of() needs flattening whereas Arrays.stream() does not
         As the ideal class used for processing of Streams of primitive types are their primitive Stream types (like IntStream, LongStream, etc).
         Therefore, Stream.of() needs to be explicitly flattened into its primitive Stream before consuming.
         */
        // Creating an integer array
        int arr[] = { 1, 2, 3, 4, 5 };
        // --------- Using Arrays.stream() ---------
        // to convert int array into Stream
        IntStream intStream = Arrays.stream(arr);
        // Displaying elements in Stream
        intStream.forEach(str -> System.out.print(str + " "));
        System.out.println();
        // --------- Using Stream.of() ---------
        // to convert int array into Stream
        Stream<int[]> stream = Stream.of(arr);
        // ***** Flattening of Stream<int[]> into IntStream *****
        // flattening Stream<int[]> into IntStream
        // using flatMapToInt()
        //IntStream intStreamNew = stream.flatMapToInt(item -> Arrays.stream(item)); //Same effect as the line below.
        IntStream intStreamNew = stream.flatMapToInt(Arrays::stream);
        // Displaying elements in IntStream
        intStreamNew.forEach(str -> System.out.print(str + " "));
    }
}


