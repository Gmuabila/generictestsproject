package genericclasses;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamReduceMethodDemoTests {

    @Test
    public void streamReduceMethodTest(){

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int result = integerList.stream().reduce(1, (a, b) -> (a + b));
        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        System.out.println("Sum of all numbers in the List is: " + result);
        System.out.println();

        int result2 = integerList.stream().reduce(0, (a, b) -> (a - b));
        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        System.out.println("stream reduce() with substraction of all elements: " + result2);
        System.out.println();

        int result3 = integerList.stream().reduce(1, (a, b) -> (a * b));
        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        System.out.println("stream reduce() with Multiplication of all elements: " + result3);
        System.out.println();

        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        List<Integer> result4 = integerList.stream().filter(number -> number % 2 == 0).limit(2).collect(Collectors.toList());
        System.out.println("Even numbers in the List are....limit result to 2 numbers: " + result4);
        System.out.println();

        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        List<Integer> result5 = integerList.stream().filter(number -> number % 2 == 1).skip(2).collect(Collectors.toList());
        System.out.println("Uneven numbers in the List are....skip 2 numbers: " + result5);
        System.out.println();

        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        List<Integer> result6 = integerList.stream().filter(number -> number % 2 == 0).map(number -> number * 2).collect(Collectors.toList());
        System.out.println("Each even number times 2 is: " + result6);


    }
}
