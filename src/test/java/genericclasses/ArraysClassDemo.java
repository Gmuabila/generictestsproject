package genericclasses;

import genericclasses.collectionframeworkdemo.SortByRollNumber;
import genericclasses.collectionframeworkdemo.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysClassDemo {
    //Arrays class
    // The Arrays class is a part of the Java Collection Framework. The class provides static methods to dynamically create and access arrays.
    // It consists of only static methods and the methods of Object class. The methods of this class can be used by the class name itself.
    // The Arrays class can be found in the java.util package.
    //The methods of the Arrays class help programmers expand horizons with arrays, for instance there are often times when loops are used to
    // perform tasks on arrays such as:
    // •	Fill an array with a particular value.
    // •	Sort an Array.
    // •	Search in an Array.
    // •	And many more.
    // The Arrays class provides several static methods that can be used to perform these tasks directly without the use of loops,
    // hence making our code super short and optimized.
    @Test
    public void arraysClassTest(){
        //asList() method
        // The asList() method of the Arrays class is used to return a fixed-size list backed by the specified array.
        // This method acts as a bridge between array-based and collection-based APIs, in combination with Collection.toArray().
        // The returned list is serializable and implements RandomAccess.
        //Syntax
        // public static List asList(T... a)
        // Parameters: This method takes an array a which is required to be converted into a List.
        //Special Note: The type of array must be a Wrapper Class(Integer, Float, etc), in case of primitive data types(int, float, etc) ,
        // i.e you can’t pass int a[] but you can pass Integer a[]. If you pass int a[], this function will return a  List <int a[]> and
        // not List <Integer> , as “autoboxing” doesn’t happen in this case and int a[] is itself identified as an object and a List of
        // int array is returned, instead of list of integers , which will give error in various Collection functions .
        //Return Value: This method returns a list view of the specified array.
        // Try block to check for exceptions
        try {
            // Creating Arrays of String type
            String a[] = new String[] { "A", "B", "C", "D" };
            // Getting the list view of Array
            List<String> list = Arrays.asList(a);
            // Printing all the elements in list object
            System.out.println("The list is: " + list);
        }
        // Catch block to handle exceptions
        catch (NullPointerException e) {
            // Print statement
            System.out.println("Exception thrown : " + e);
        }

    }

    @Test
    public void arraysClassTestTwo(){
        // Java Program to demonstrate asList() method Which returns fixed size list and throws
        // UnsupportedOperationException if any element is added using add() method
        // Try block to check for exceptions
        try {
            // Creating Arrays of Integer type
            Integer a[] = new Integer[] { 10, 20, 30, 40 };
            // Getting the list view of Array
            List<Integer> list = Arrays.asList(a);
            // Adding another int to the list
            // As Arrays.asList() returns fixed size
            // list, we'll get
            // java.lang.UnsupportedOperationException
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
    public void arraysCompareMethod(){
        //compare() method
        // The Arrays compare() method comes under the Arrays class and java.util package. This method compares two arrays
        // lexicographically (Dictionary order). There are two different versions of different overloads for Boolean, byte, char, double,
        // float, int, long, short, and Object arrays. This method returns values as per the below-mentioned cases.
        // •	It returns 0 if the array is equal to the other array.
        // •	It returns a value less than 0 if the array is lexicographically  less than the other array in
        // •	It returns a value greater than 0 if the array is lexicographically greater than the other array (more characters).
        //A null array is lexicographically less than a non-null array, and the two arrays are considered equal if
        // both are null so that it will print 0 in this case.
        //Initialized two integer array
        int[] array1 ={6, 7, 8, 11, 18, 8, 2, 5};
        int[] array2 ={3, 5, 9, 13, 28, 6, 8, 9};
        //compare both integer array using compare method and finally print result
        System.out.println("Result is "+ Arrays.compare(array1,array2));
        //Hence the desired output is 1 because array1 is lexicographically greater than array2.
    }

    @Test
    public void arraysCopyOfMethod(){
        //copyOf() method
        // The copyOf() Method copies the specified array, truncating or
        // padding with false (if necessary) so the copy has the specified length. The copyOf() method is in java.util.Arrays class.
        //Syntax
        // copyOf(int[] original, int newLength)
        // •	original – original array
        // •	newLength – length of the new copy array
        //initializing an array original
        int[] org = new int[] {1, 2 ,3};
        System.out.println("Original Array");
        for (int i = 0; i < org.length; i++)
            System.out.print(org[i] + " ");
        // copying array org to copy
        int[] copy = Arrays.copyOf(org, 5);  //Will pad the extra spaces with zeros for int values.
        // Changing some elements of copy
        copy[3] = 11;
        copy[4] = 55;
        System.out.println("\nNew array copy after modifications:");
        for (int i = 0; i < copy.length; i++)
            System.out.print(copy[i] + " ");
    }

    @Test
    public void arraysCopyOfMethodTwo(){
        //Program to illustrate copyOf() method when the elements are String and
        //the new copied array length is greater than original array.
        String[] arrString = new String[]{"Hello", "Mr", "GTech"};
        System.out.println("Printing original Array:");
        for (int i = 0; i < arrString.length; i++){
            System.out.print(arrString[i] + " ");
        }
        String[] copy = Arrays.copyOf(arrString, 6);  //The extra space will have null value as for String type.
        System.out.println("Printing the Array copy: ");
        for (int i = 0; i < copy.length; i++){
            System.out.print(copy[i] + " ");
        }
    }

    @Test
    public void copyOfRangeMethod(){
        //copyOfRange() method
        // This method creates a copy of elements, within a specified range of the original array.
        // Syntax
        // public static int[] copyOfRange(int[] original_array, int from_index, int to_index)
        // original_array : Array to be copied from
        // from_index : Starting index of range to be copied.
        // to_end : the final index of the range to be copied, exclusive. (This index may lie outside the array.)
        int arr[] = { 12, 13, 14, 15, 16, 17, 18 };
        // to index is within the range
        int[] copy = Arrays.copyOfRange(arr, 2, 6);
        for (int i : copy)
            System.out.print(i + "  ");
        System.out.println();
        // to_index is out of range
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
    public void arraysEqualsMethod(){
        //Equals() method
        // Two arrays are considered equal if both arrays contain the same number of elements, and all corresponding pairs of
        // elements in the two arrays are equal. In other words, two arrays are equal if they contain the same elements in the same order.
        // Also, two array references are considered equal if both are null. Arrays class in java provide the method Arrays.equals() to
        // check whether two arrays are equal or not.
        //Syntax
        // public static boolean equals(int[] a, int[] a2)
        //Parameters :
        // a - one array to be tested for equality
        // a2 - the other array to be tested for equality.
        //Returns : true if the two arrays are equal.
        //We can also use Arrays.equals() for checking equality of array of objects of user defined class.  In case of arrays of Objects,
        // you must override equals method to provide your own definition of equality, otherwise you will get output depends on
        // what equals() method of Object class returns.
        Student[] students = new Student[]{
                new Student(3455, "John", "London"),
                new Student(2991, "Carl", "Sydney"),
                new Student(7718, "Micheal", "California"),
                new Student(6223, "Paul", "Chicago")
        };
        Student[] students2 = new Student[]{
                new Student(3455, "John", "London"),
                new Student(2991, "Carl", "Sydney"),
                new Student(7718, "Micheal", "California"),
                new Student(6223, "Paul", "Chicago")
        };
        Student[] students3 = new Student[]{
                new Student(7718, "Micheal", "California"),
                new Student(6223, "Paul", "Chicago")
        };
        System.out.println("Is students Array equal students2 Array?: " + Arrays.equals(students, students2));
        System.out.println("Is students Array equal students3 Array?: " + Arrays.equals(students, students3));
    }

    @Test
    public void arraysSortMethod(){
        //sort() method
        // The Arrays class contains static methods that are used with arrays in order to search, sort, compare, insert elements, or
        // return a string representation of an array.
        //The Arrays.sort() method consists of two variations, one in which we do not pass any arguments where it sorts down the complete array,
        // but if we want to sort a specific part of the array then we overload the method and pass the starting and last index to the array.
        int[] arr = { 5, -2, 23, 7, 87, -42, 509 };
        System.out.println("The original array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        Arrays.sort(arr);
        System.out.println("\nThe sorted array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void arraySortMethodTestTwo(){
        //Java program to Sort a Subarray in Array Using Arrays.sort() method
        // Custom input array
        // It contains 8 elements as follows
        int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
        System.out.println("Original array: " + Arrays.toString(arr));
        // Sort subarray from index 1 to 4, i.e.,
        // only sort subarray {7, 6, 45, 21} and
        // keep other elements as it is.
        Arrays.sort(arr, 1, 5);
        // Printing the updated array which is
        // sorted after 2 index inclusive till 5th index
        System.out.println("Modified arr[] : "
                + Arrays.toString(arr));
    }

    @Test
    public void arraySortMethodTestThree(){
        // Java program to Sort array in Descending order Using Arrays.sort()
            // Note that we have Integer object here instead of
            // int[] as Collections.reverseOrder doesn't
            // work for primitive types.
            Integer[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
        System.out.println("Original array: " + Arrays.toString(arr));
            // Sorts arr[] in descending order using
            // reverseOrder() method of Collections class
            // in Array.sort() as an argument to it
            Arrays.sort(arr, Collections.reverseOrder());
            // Printing the array as generated above
            System.out.println("Modified arr[] : "
                    + Arrays.toString(arr));
        }

    @Test
    public void arraySortMethodTestFour() {
        // Java program to sort an array of strings in ascending and descending alphabetical order
        // Using Arrays.sort()
        String arr[] = {"practice.geeksforgeeks.org",
                "www.geeksforgeeks.org",
                "code.geeksforgeeks.org"};
        System.out.println("Original array: "
                + Arrays.toString(arr));
        // Sorts arr[] in ascending order
        Arrays.sort(arr);
        System.out.println("arr[] in ascending order: "
                + Arrays.toString(arr));
        // Sorts arr[] in descending order
        Arrays.sort(arr, Collections.reverseOrder());
        // Lastly printing the above array
        System.out.println("arr[] in descending order: "
                + Arrays.toString(arr));
    }

    @Test
    public void arraySortMethodTestFive(){
        // Java program to demonstrate Working of Comparator interface
        Student[] students1 = new Student[]{
                new Student(121, "Carlos","Southwark"),
                new Student(101, "Benoit", "Peckham"),
                new Student(273, "Holly", "Islington"),
                new Student(192, "Peter", "Lewisham")
        };
        System.out.println("Original array: " + Arrays.toString(students1));
        //Sorting array based on roll number using the Comparator interface
        Arrays.sort(students1, new SortByRollNumber());
        System.out.println("Sorted array: " + Arrays.toString(students1));
        System.out.println();
        Arrays.sort(students1, new SortByRollNumber().reversed());
        System.out.println("Reversed order: " + Arrays.toString(students1));
        Arrays.sort(students1, 1, 4, new SortByRollNumber());  //Sorting a part of array using Comparator.  Sorting subarray.
        System.out.println("Part of array sorted: " + Arrays.toString(students1));
    }

    @Test
    public void arrayStreamMethod(){
        //Stream() method
        // The stream(T[] array) method of Arrays class is used to get a sequential stream from the array passed as the parameter with its elements.
        // It returns a sequential stream with the elements of the array, passed as parameter, as its source.
        //Syntax
        // public static <T> Stream<T> stream(T[] array)
        //Parameters: This method accepts a mandatory parameter array which is the array of whose elements are to be converted into a sequential stream.
        //Return Value: This method returns a sequential stream from the array passed as a parameter.
        // Creating a String array
        String[] arr = { "Geeks", "for", "Geeks" };
        // Using Arrays.stream() to convert array into Stream
        Stream<String> stream = Arrays.stream(arr);
        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
    }

    @Test
    public void arrayStreamMethodTestTwo(){
        // Java program to demonstrate Arrays.stream() method to convert int array to stream
        // Creating an integer array
        int arr[] = { 1, 2, 3, 4, 5 };
        // Using Arrays.stream() to convert array into Stream
        IntStream stream = Arrays.stream(arr);
        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
    }

    @Test
    public void arrayStreamMethodTestThree() {
        //stream(T[] array, int startInclusive, int endExclusive) method
        // The stream(T[] array, int startInclusive, int endExclusive) method of Arrays class is used to get a sequential stream from
        // the array passed as the parameter with only specific elements taken from a range of indexes passed as the parameters to this method.
        // It returns a sequential stream with the specified range of the specified array as its source.
        // Java program to demonstrate Arrays.stream() method
        // Creating a String array
        String[] arr = {"Geeks", "for", "Geeks",
                "A", "Computer", "Portal"};
        // Using Arrays.stream() to convert array into Stream
        Stream<String> stream = Arrays.stream(arr, 3, 6);
        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
    }

    @Test
    public void arrayStreamMethodTestFour() {
        // Java program to demonstrate Arrays.stream() method
        // Creating an integer array
        int arr[] = {1, 2, 3, 4, 5};
        // Using Arrays.stream() to convert
        // array into Stream
        IntStream stream = Arrays.stream(arr, 1, 3);
        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
    }

    @Test
    public void arrayToStringMethod() {
        //toString() method
        // The Arrays.toString() method returns a string representation of the contents of the specified array.
        // The string representation consists of a list of the array’s elements, enclosed in square brackets (“[]”).
        // Adjacent elements are separated by the characters “,” (a comma followed by a space). Returns “null” if the array is null.
        // In case of an Object Array, if the array contains other arrays as elements, they are converted to string by
        // the Object.toString() method inherited from Object, which describes their identities rather than their contents.
        // Java program to demonstrate working of Arrays.toString()
        // Let us create different types of arrays and print their contents using Arrays.toString()
        boolean[] boolArr = new boolean[]{true, true, false, true};
        byte[] byteArr = new byte[]{10, 20, 30};
        char[] charArr = new char[]{'g', 'e', 'e', 'k', 's'};
        double[] dblArr = new double[]{1, 2, 3, 4};
        float[] floatArr = new float[]{1, 2, 3, 4};
        int[] intArr = new int[]{1, 2, 3, 4};
        long[] longArr = new long[]{1, 2, 3, 4};
        Object[] objArr = new Object[]{1, 2, 3, 4};
        short[] shortArr = new short[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(boolArr));
        System.out.println(Arrays.toString(byteArr));
        System.out.println(Arrays.toString(charArr));
        System.out.println(Arrays.toString(dblArr));
        System.out.println(Arrays.toString(floatArr));
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(longArr));
        System.out.println(Arrays.toString(objArr));
        System.out.println(Arrays.toString(shortArr));
    }

    @Test
    public void arrayToStringMethodTwo() {
        //We can also use Arrays.toString() for objects of user defined class. Since Arrays.toString() is overloaded for array of
        // Object class (there exist a method Arrays.toString(Object[])) and Object is the ancestor of
        // all classes, and we can call it for an array of any type of object.
        Student[] students = new Student[]{
                new Student(111, "bbbb", "london"),
                new Student(131, "aaaa", "nyc"),
                new Student(121, "cccc", "jaipur")
        };
        System.out.println(Arrays.toString(students));  //Ensure the object class Student has a toString method overridden.
    }
}
