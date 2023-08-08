package genericclasses.streamdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class IntStreamAndIntStreamOfDemo {
    //Stream of Primitives
    //Java 8 offers the possibility to create streams out of three primitive types: int, long and double.
    // As Stream<T> is a generic interface, and there is no way to use primitives as a type parameter with generics,
    // three new special interfaces were created:
    //> IntStream
    //> LongStream
    //> DoubleStream

    @Test
    public void testingIntstreamOne(){
        //range(int startInclusive, int endExclusive)
        //The range(int startInclusive, int endExclusive) method creates an ordered stream from the first parameter to
        //the second parameter. It increments the value of subsequent elements with the step equal to 1.
        //The result doesn't include the last parameter, it is just an upper bound of the sequence.
        IntStream intStream = IntStream.range(500, 550);
        int[] intArr = intStream.limit(10).toArray();
        for (int i = 0; i < intArr.length; i++){
            System.out.println(intArr[i]);
        }
    }

    @Test
    public void testingIntstreamTwo() {
        //rangeClosed(int startInclusive, int endInclusive)
        //The rangeClosed(int startInclusive, int endInclusive) method does the same thing with only one difference,
        //the second element is included. We can use these two methods to generate any of the three types of streams of primitives.
        //Creating an Array from IntStream
        int[] integerArray = IntStream.rangeClosed(5, 20).toArray();
        //You should not attempt to create a list from IntStream, as Primitive values cannot be added to a List.
        //To add them to the List, loop through the elements of the array and add to the List as follows:
        List<Integer> listOne = new ArrayList<>();
        for (int i = 0; i < integerArray.length; i++) {
            listOne.add(integerArray[i]);
        }
    }


    @Test
    public void intStreamAnIntStreamOfMethodTest() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream stream = IntStream.of(10, 11, 12, 13, 14, 15);
        IntStream intStream = Arrays.stream(arr);

        System.out.println("Printing all elements of the Stream intStream: ");
        intStream.forEach(System.out::println);
        System.out.println();

        System.out.println("\nPrinting the Sum of elements in the Stream (10, 11, 12, 13, 14, 15): " + stream.sum());
        System.out.println();;
        //Next I tried the count (stream.count();) method of the above stream and the following Exception was thrown:
        //java.lang.IllegalStateException: stream has already been operated upon or closed.
        //Tried closing the stream with (stream.close()), no success.  To be investigated.
        //Answer: A stream cannot be used once a terminal operation has been executed on the stream.  You will have to
        //initialise the stream once more before using it again.  In this case the sum() method has been invoked on the
        //Stream and sum() method is a terminal operation.
    }

    @Test
    public void intStreamAndIntStreamOfMethodTest(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream stream2 = IntStream.of(10, 11, 12, 13, 14, 15);
        IntStream intStream2 = Arrays.stream(arr);
        IntStream singleElement = IntStream.of(-20);

        // Storing the count of elements in IntStream
        System.out.println("The count for all elements in the Stream (10, 11, 12, 13, 14, 15) is: ");
        long count = stream2.count();
        System.out.println(count);
        System.out.println();

        System.out.println("Printing a Stream of a single element: ");
        singleElement.forEach(System.out::println);
    }

    @Test
    public void primitiveStreamFromRandomClass(){
        //Since Java 8, the Random class provides a wide range of methods for generating streams of primitives.

        //Creating a DoubleStream which has 5 elements:
        Random rdm = new Random();
        DoubleStream dbStream = rdm.doubles(5);
        dbStream.forEach(System.out::println);
        System.out.println();
        //The following creates an IntStream, which has four elements:
        IntStream intStr = rdm.ints(10, 100, 300);
        System.out.println("Printing random Instream from 100 to 300: ");
        intStr.forEach(System.out::println);
    }
}
