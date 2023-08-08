package genericclasses.streamdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StreamReduceMethodDemoTests {
    //Stream reduce()
    //Reducing is the repeated process of combining all elements.
    //reduce operation applies a binary operator to each element in the stream where the first argument to the operator is
    //the return value of the previous application and second argument is the current stream element.
    //In Java 8, the Stream.reduce() combine elements of a stream and produces a single value.
    //A reduction is a terminal operation that aggregates a stream into a type or a primitive.
    //The Java 8 Stream API contains a set of predefined reduction operations, such as average(),
    //sum(), min(), max(), and count(), which return one value by combining the elements of a stream.
    //
    //The accumulator function takes two parameters: a partial result of the
    //reduction and the next element of the stream. It returns a new partial result.

    @Test
    public void streamReduceMethodTest(){

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //List<String> stringsList = Arrays.asList("Monday", "Tuesday", "Wednesda", "Thursday", "Friday", "Saturday", "Sunday");

        int result = integerList.stream().reduce(0, (a, b) -> (a + b));
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
        List<Integer> result4 = integerList.stream().filter(number -> number % 2 == 0).limit(3).collect(Collectors.toList());
        System.out.println("Even numbers in the List are....limit result to 3 numbers: " + result4);
        System.out.println();

        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        List<Integer> result5 = integerList.stream().skip(2).filter(number -> number % 2 == 1).collect(Collectors.toList());
        System.out.println("Uneven numbers in the List are....skip 2 numbers: " + result5);
        System.out.println();

        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        List<Integer> result6 = integerList.stream().filter(number -> number % 2 == 0).map(number -> number * 2).collect(Collectors.toList());
        System.out.println("Each even number times 2 is: " + result6);
        System.out.println();

        //int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);
        int sum4 = integerList.stream().reduce(0, (Integer::sum));
        System.out.println("List (1, 2, 3, 4, 5, 6, 7, 8, 9)");
        System.out.println("The Sum of all elements using :: is: " + sum4);
    }

    @Test
    public void streamReduceMethodTestTwo(){
        // Implementation of reduce() method
        // to get the longest String
        //
        // creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");

        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> longestString = words.stream()
                .reduce((word1, word2)
                        -> word1.length() > word2.length()
                        ? word1 : word2);
        // Displaying the longest String
        longestString.ifPresent(System.out::println);
    }

    @Test
    public void streamReduceMethodTestThree(){
        // Implementation of reduce method
        // to get the combined String
        //
        // String array
        String[] array = { "Geeks", "for", "Geeks" };
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> String_combine = Arrays.stream(array)
                .reduce((str1, str2)
                        -> str1 + "-" + str2);

        // Displaying the combined String
        if (String_combine.isPresent()) {
            System.out.println(String_combine.get());
        }
    }

    @Test
    public void streamReduceMethodTestFour(){
        // Implementation of reduce method
        // to get the product of all numbers
        // in given range.

        // To get the product of all elements
        // in given range excluding the
        // rightmost element.  Rightmost number is 8, and is not included cos range method excludes the second argument.
        int product = IntStream.range(2, 8)
                .reduce((num1, num2) -> num1 * num2)
                .orElse(-1);
        // Displaying the product
        System.out.println("The product is : " + product);
        System.out.println();

        //orElse method of the Optional class will return -1 if the stream is empty.
        int product2 = IntStream.empty()
                .reduce((num1, num2) -> num1 * num2)
                .orElse(-1);
        System.out.println("With Instream empty, Product2 is: " + product2);
    }

    int counter;
    private void tracking(){
       counter++;
    }

    @Test
    public void streamReduceMethodTestFive() {
        counter = 0;
        //In this below code, the combiner isn't called and the result is 16.
        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    //log.info("combiner was called");
                    tracking();
                    return a + b;
                });
        System.out.println("The result is: " + reducedParams);
        System.out.println("And the counter is: " + counter);
    }

    @Test
    public void streamReduceMethodTestSix(){
        //To make a combiner work, a stream should be parallel
        counter = 0;
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    // log.info("combiner was called");
                    tracking();
                    return a + b;
                });
        System.out.println("The result is: " + reducedParallel);
        System.out.println("And the counter is: " + counter);
        //The result here is different (36), and the combiner was called twice.
        //Here the reduction works by the following algorithm: the accumulator ran three times by
        //adding every element of the stream to identity. These actions are being done in parallel.
        //As a result, they have (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;).
        //Now the combiner can merge these three results. It needs two iterations for that (12 + 13 = 25; 25 + 11 = 36).
    }

    @Test
    public void streamReduceMethodTestSeven(){
        //In this case, the Integer value 0 is the identity. It stores the initial value of the
        //reduction operation and also the default result when the stream of Integer values is empty.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);

        assertEquals(21, result);
    }

    @Test
    public void streamReduceMethodTestEight(){
        //Using reduce() on an array of String elements and join them into a single result
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        assertEquals("abcde", result);

        //This code can also be written without the Identity as below:
        Optional<String> result2 = letters
                .stream()
                .reduce((partialString, element) -> partialString + element);
        assertEquals("abcde", result2.get());

        //Similarly, we can switch to the version that uses a method reference:
        String result3 = letters.stream().reduce("", String::concat);
        assertEquals("abcde", result3);

        //Or without the Identity as follow:
        Optional<String> result4 = letters.stream().reduce(String::concat);
        assertEquals("abcde", result4.get());
    }

    @Test
    public void streamReduceMethodTestNine(){
       //We can use reduce() in a parallelized stream:
        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
        int computedAges = ages.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
        System.out.println("Result is: " + computedAges);
    }

    @Test
    public void streamReduceMethodTestTen(){
        //this code won't compile:
        //In this case, we have a stream of User objects, and the types of the accumulator arguments are Integer and User.
        //However, the accumulator implementation is a sum of Integers, so the compiler just can't infer the type of the user parameter.
//        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
//        int computedAges =
//                users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge());

        //We can fix this issue by using a combiner:
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        int result = users.stream()
                .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
        assertEquals(65, result);
        //To put it simply, if we use sequential streams and the types of the accumulator arguments and
        //the types of its implementation match, we don't need to use a combiner.
    }

    @Test
    public void streamReduceMethodTestEleven(){
        //Attempting to rewrite the above program that does not compile
//        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
//        int computedAges =
//                users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge());

        //Another way of resolving this issue is to user map() method first to get to the User's age then reduce the ages.
                List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        int computedAges =
                users.stream().map(user -> user.getAge()).reduce(0, (ageSum, age) -> ageSum + age);
        assertEquals(65, computedAges);
    }







}
