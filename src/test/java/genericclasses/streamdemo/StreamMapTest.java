package genericclasses.streamdemo;

import org.junit.Test;
import storm.TaxCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMapTest {

    @Test
    public void mapTesting(){
        /*Map in Java 8 is a function defined in java.util.stream.Streams class,
        which is used to transform each element of the stream by applying a function to each element.
        The map function is also an intermediate operation, and it returns a stream of the transformed element.
        Stream map(Function mapper) returns a stream consisting of the results of applying the given function to the elements of this stream.
         */
        List<Integer> numbers = Arrays.asList(2,3,4,5,6,6,8,9);

        List<Integer> returnedMap = numbers.stream().map(num -> num * 2).collect(Collectors.toList());  //Find out .collect(Collectors.toList())
        System.out.println(returnedMap);
    }

    @Test
    public void mapTestingTwo(){
        final String sample = "To God be the Glory";
        // converting to Ascii
        IntStream intstreams = sample.chars();
        // All match to check if all Ascii value greater than 100
        boolean answer = intstreams.allMatch(asciiCode -> asciiCode > 100);
        System.out.println("Ascii codes greater than 100: " + answer);
        System.out.println();
        // Need to initialize the stream again
        // to avoid runtime exception
        intstreams = sample.chars();
        // All match to check if all Ascii value greater than 31
        answer = intstreams.allMatch(asciiCode -> asciiCode > 31);
        System.out.println("Ascii codes greater than 31: " + answer);

    }
}
