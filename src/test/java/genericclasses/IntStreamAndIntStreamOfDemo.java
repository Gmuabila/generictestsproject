package genericclasses;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamAndIntStreamOfDemo {

    @Test
    public void intStreamAnIntStreamOfMethodTest() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream stream = IntStream.of(10, 11, 12, 13, 14, 15);
        IntStream intStream = Arrays.stream(arr);

        System.out.println("Printing all elements of the Stream intStream: ");
        intStream.forEach(System.out::print);
        System.out.println();

        System.out.println("\nPrinting the Sum of elements in the Stream (10, 11, 12, 13, 14, 15): " + stream.sum());
        System.out.println();;
        //Next I tried the count (stream.count();) method of the above stream and the following Exception was thrown:
        //java.lang.IllegalStateException: stream has already been operated upon or closed.
        //Tried closing the stream with (stream.close()), no success.  To be investigated.
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
}
