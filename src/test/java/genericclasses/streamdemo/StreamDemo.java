package genericclasses.streamdemo;

import org.junit.Test;

import java.util.*;
import java.util.stream.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class StreamDemo {

    @Test
    public void testingStreams(){
        /** map() method
         The map method is used to return a stream consisting of the results of applying a given function to the elements of this stream.
         To convert the elements of a Stream by applying a special function to them and to collect these new elements into a new Stream,
         we use the map() method.  Stream map(Function mapper) is an intermediate operation. These operations are always lazy.
         Intermediate operations are invoked on a Stream instance and after they finish their processing, they give a Stream instance as output.
         */
        List<Integer> integerList = Arrays.asList(6, 8, 9, 10, 11);
        List<Integer> integerList1 = Arrays.asList(2, 4, 6, 7, 9);
        List<Integer> squareIntegerList = integerList.stream().map(x -> x * x).collect(Collectors.toList());
        Set<Integer> integerSet = integerList1.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println("The integerList is: \n" + integerList);
        System.out.println("\nThe squareIntegerList is: \n" + squareIntegerList);
        System.out.println("\nThe integerSet is: \n" + integerSet);
        System.out.println();
        System.out.println("The stream after applying "
                + "the function is : ");
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);
        // Using Stream map(Function mapper) and
        // displaying the corresponding new stream
        list.stream().map(number -> number * 3).forEach(System.out::println);
    }

    @Test
    public void testingStreamsB(){
        System.out.println("The stream after applying "
                + "the function is : ");
        // Creating a list of Strings
        List<String> list = Arrays.asList("geeks", "gfg", "g",
                "e", "e", "k", "s");
        // Using Stream map(Function mapper) to
        // convert the Strings in stream to UpperCase form
        List<String> answer = list.stream().map(String::toUpperCase).
                collect(Collectors.toList());
        // displaying the new stream of UpperCase Strings
        System.out.println("Strings converted to Uppercase: " + answer);
        System.out.println();

        System.out.println("The stream after applying "
                + "the function is : ");
        // Creating a list of Strings
        List<String> listStr = Arrays.asList("Geeks", "FOR", "GEEKSQUIZ",
                "Computer", "Science", "gfg");
        // Using Stream map(Function mapper) and
        // displaying the length of each String
        listStr.stream().map(String::length).forEach(System.out::println);
    }

    @Test
    public void testingStreamTwoA(){
        /** filter()
         Stream filter(Predicate predicate) returns a stream consisting of the elements of this stream that match the given predicate.
         This is an intermediate operation. These operations are always lazy i.e., executing an intermediate operation such as filter() does
         not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the
         initial stream that match the given predicate.  The filter method is used to select elements as per the Predicate passed as argument.
         The filter() method allows us to pick a stream of elements that satisfy a predicate.
         Return Type: A new stream.
         */
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);
        // Getting a stream consisting of the elements that are divisible by 5
        // Using Stream filter(Predicate predicate)
        System.out.println("Printing elements divisible by 5: ");
        list.stream()
                .filter(num -> num % 5 == 0)
                .forEach(System.out::println);
        System.out.println();
        // Creating a stream of strings
        Stream<String> stream = Stream.of(
                "Geeks", "fOr", "GEEKSQUIZ", "GeeksforGeeks");
        // Getting a stream consisting of the elements having UpperCase Character
        // at custom index say be it '1'
        // using Stream filter(Predicate predicate)
        System.out.println("Printing elements with UpperCase Character at index 1");
        stream.filter(
                str -> Character.isUpperCase(str.charAt(1)))
                .forEach(System.out::println);
        System.out.println();

        List<String> stringList = Arrays.asList(
                "Geeks", "fOrT", "GEEKSQUIZ", "GeeksforGeeks");
        System.out.println("Printing Strings with UpperCase Character at index 3: ");
        stringList.stream().filter(str -> Character.isUpperCase(str.charAt(3)))
                .forEach(System.out::println);
    }

    @Test
    public void testingStreamsTwo(){
        List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        //Filtering days starting with "T"
        List<String> startingWithT = daysOfWeek.stream().filter(s -> s.startsWith("T")).collect(Collectors.toList());
        //Filtering days or the week that contain "es"
        List<String> containsEs = daysOfWeek.stream().filter(s -> s.contains("es")).collect(Collectors.toList());
        //Filtering days of week ending with "sday"
        List<String> endingWithSday = daysOfWeek.stream().filter(s -> s.endsWith("sday")).collect(Collectors.toList());

        //assertThat(containsEs, contains("Tuesday"));  Not working
        assertEquals(2, containsEs.size());
        assertThat(containsEs, hasItem("Tuesday"));  // AssertThat() is deprecated?

        System.out.println("Printing daysOfWeek: \n" + daysOfWeek);
        System.out.println("\nPrinting days starting with \"T\": " + startingWithT);
        System.out.println("\nPrinting days that contain \"es\": " + containsEs);
        System.out.println("\nPrinting days that end with \"sday\": " + endingWithSday);
    }

    @Test
    public void testingStreamsThree(){
        //sorted() method
        //The sorted method is used to sort the stream.

        List<String> names = Arrays.asList("Reflection", "Capturing", "Promoting", "Caring", "Planning", "Success");
        //sorting the list of names
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());

        System.out.println("\nPrinting list of names: \n" + names);
        System.out.println("\nPrinting the sorted list of names: \n" + sortedNames);
    }

    @Test
    public void testingStreamsFour(){
        //forEach() method
        //The forEach method is used to iterate through every element of the stream.

        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 8, 9);
        System.out.println("Printing integerList: " + integerList);
        integerList.stream().map(x -> x + 3).forEach(x -> System.out.print(x + ", "));

        //Converting an Array to a Stream
        Integer[] intArrayTwo = new Integer[]{11, 14, 15, 17};
        Stream<Integer> integerStream = Arrays.stream(intArrayTwo);
        //Converting an Array to a List
        List<Integer> integerList4 = Arrays.stream(intArrayTwo).collect(Collectors.toList());
        //Converting an Array to a Set
        Set<Integer> integerSet = Arrays.stream(intArrayTwo).collect(Collectors.toSet());

    }

    @Test
    public void testingStreamsFive(){
        //reduce() method
        //The reduce method is used to reduce the elements of a stream to a single value.
        //The reduce method takes a Binary Operator as a parameter.

        List<Integer> integerList = Arrays.asList(2, 3, 4, 5, 6);
        //Sum of even number in the list.  For uneven numbers use x % 2 != 0.
        int sumOfEvenNumbers = integerList.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        //int sumOfEvenNumbers = integerList.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).orElse(0);  //Best way to do this.
        //    Optional<Integer> sum = integerList.stream().filter(x -> x % 2 == 0).reduce(Integer::sum);  //Can also do this.
        //       int sumOfEvenNumbers = sum.get();

        System.out.println("Printing the list integerList: " + integerList);
        System.out.println("The sum of even numbers is: " + sumOfEvenNumbers);
    }

    @Test
    public void testingStreamsSix() {
        //Stream of Primitives
        //Java 8 offers the possibility to create streams out of three primitive types: int, long and double.
        // As Stream<T> is a generic interface, and there is no way to use primitives as a type parameter with generics,
        // three new special interfaces were created:
        //> IntStream
        //> LongStream
        //> DoubleStream

        //
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
    public void testingStreamSeven(){
        //Random class
        //Since Java 8, the Random class provides a wide range of methods for generating streams of primitives.

        //Creating DoubleStream from Random, loop through the DoubleStream and print each element.
        Random random = new Random();
        DoubleStream doubleStr = random.doubles(4);
        doubleStr.forEach(s -> System.out.print(s + ", "));
        //Adding DoubleStream to an array
        //double[] arrayDoubles = doubleStr.toArray();
        //Printing the Array elements

        //Creating IntStream from Random, loop through the IntStream, and print the elements.
        System.out.println();
        System.out.println();
        IntStream intStr = random.ints(3);
        intStr.forEach(s -> System.out.print(s + ", "));

        //Creating LongStream from Random doubles, add to array, then add to a list and print the list.
        System.out.println("\n\n Stream created from Random, add to array, then list: ");
        LongStream longStream = random.longs(3);
        long[] arrayLong = longStream.toArray();
        List<Long> longList = new ArrayList<>();
        for(int i = 0; i < arrayLong.length; i++){
            longList.add(arrayLong[i]);
        }
        System.out.println(longList);
        //Creating a stream of ints between 2 and 5 inclusive and adding elements to an array
        //int[] intArr = IntStream.rangeClosed(2,5).sorted().toArray();
    }

    @Test
    public void testingStreamEight(){
        //skip() method
        //skip() method allows you to skip elements of a stream.  The new Stream will not include skipped elements.
        //To create a new stream from the existing one without few elements, the skip() method can be used:

        List<String> stringList = Arrays.asList("Car", "Bike", "Motorcycle", "Boat", "MotorBike");
        List<String> sortedList = stringList.stream().sorted().collect(Collectors.toList());
        //Skipping the first 3 elements of the sortedList.
        List<String> newStringList = sortedList.stream().skip(3).collect(Collectors.toList());

        System.out.println("Printing the original String list: " + stringList);
        System.out.println("\nThe sorted list is: " + sortedList);
        System.out.println("\nPrinting the processed list: " + newStringList);
        System.out.println();
        List<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1).map(str -> str.substring(0, 3)).collect(Collectors.toList());
        System.out.println(onceModifiedStream);
    }

    @Test
    public void testingStreamNine(){
        //Stream Pipeline
        //The correct and most convenient way to use streams is by a stream pipeline,
        // which is a chain of the stream source, intermediate operations, and a terminal operation.

        List<String> stringList = Arrays.asList("abc1", "abc2", "abc3");
        long size = stringList.stream().skip(1).map(str -> str.substring(1, 4)).count();
        System.out.println(size);
        System.out.println();
        List<String> strResult = stringList.stream().skip(1).map(str -> str.substring(1, 4)).sorted().collect(Collectors.toList());
        System.out.println(strResult);
    }

    @Test
    public void testingStreamTen(){
        //Use of average(), and ifPresent() methods.
        Arrays.stream(new int[]{2, 4, 6, 8, 10}).map(x -> x * x).forEach(x -> System.out.print(x + ", "));
        System.out.println();
        System.out.println();
        Arrays.stream (new  int[]{2, 4, 6, 8, 10}).map (x -> x * x).average().ifPresent(System.out::println);
        //Note that only one element will be returned, as average() will only return one result.
        //So cannot use forEach to loop through, instead ifPresent is used.
        System.out.println();
        //Stream from Array, sort, filter and print
        String[] names = new String[]{"Al", "Ankit", "Kushal", "Brent", "Sarka", "Amanda", "Hans"};
        Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);
        System.out.println();
        //findFirst(), ifPresent() methods
        Stream.of("Ava", "Anri", "Alberto").sorted().findFirst().ifPresent(System.out::println);
        //sum() method
        System.out.println();
        System.out.println(IntStream.range(1, 5).sum());
        System.out.println();
    }

    private long counter;
    private long count;
    private void filterCalls() {
        counter++;
    }
    private void mapCalls(){
        count++;
    }

    @Test
    public void testingStreamEleven(){
        //Lazy Invocation
        //Intermediate operations are lazy.
        //This means that they will be invoked only if it is necessary for the terminal operation execution.
        // For example, let's call the method wasCalled(), which increments an inner counter every time it's called:

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream = list.stream().filter(element -> {
            filterCalls();
            return element.contains("2");
        });
        System.out.println("Filter method calls: " + counter);
        //As we have a source of three elements, we can assume that the filter() method will be called three times,
        // and the value of the counter variable will be 3. However, running this code doesn't change counter at all,
        // it is still zero, so the filter() method wasn't even called once. This is because the terminal operation is missing.
    }

    @Test
    public void testingStreamTwelve(){
        //Let's rewrite the above code here by adding a map() operation and a terminal operation findFirst().
        // We will also add the ability to track the order of method calls with the help of logging
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
       counter = 0;
       count = 0;
        Optional<String> strFirst = list.stream().filter(element -> {
            //Calling wasCalled() method to test as we couldn't get the logging to work
            filterCalls();
           // log.info("filter() was called");
            return element.contains("2");
        }).map(element -> {
            //Calling wasCalled() method to test as we couldn't get the logging to work
            mapCalls();
          //  log.info("map() was called");
            return element.toUpperCase();
        }).findFirst();
        System.out.println(strFirst.get());
        System.out.println("Filter method calls: " + counter);
        System.out.println("Map method calls: " + count);
        /*The results show that the filter() method was called twice and the map() method once.
        This is because the pipeline executes vertically. In our example, the first element of the
        stream didn't satisfy the filter's predicate. Then the filter() method was invoked for the second element,
        which passed the filter. Without calling the filter() for the third element, we went down through the
        pipeline to the map() method.  The findFirst() operation satisfies by just one element.
        So, in this particular example, the lazy invocation allowed us to avoid two method calls,
        one for the filter() and one for the map(). */
    }

    @Test
    public void testingStreamThirteen(){
        //This is a repeat of the above test with some changes
        List<String> list = Arrays.asList("abc1", "abc3", "abc2", "abc4", "cbd2", "bdc5");
        counter = 0;
        count = 0;
        List<String> resultList = list.stream().filter(element -> {
            //Calling wasCalled() method to test as we couldn't get the logging to work
            filterCalls();
            // log.info("filter() was called");
            return element.contains("2");
        }).map(element -> {
            //Calling wasCalled() method to test as we couldn't get the logging to work
            mapCalls();
            //  log.info("map() was called");
            return element.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println(resultList);
        System.out.println("Filter method calls: " + counter);
        System.out.println("Map method calls: " + count);

        //The filter() method was called 6 times, going through all the elements of the list and check was done
        //if elements satisfied the filters check.  Only 2 elements did satisfy the filter() method check.  Each time
        //a check was satisfied, the map() method was called, making a total of 2 methods call for the map() method.
        //After the map() method is called, the execution went back to the filter method which conducted more checks to
        //the remaining elements, each element in turn.  The map() method was only called when an element passed the filter.
        //The last element did not pass the filter, and the map() method was not called, then the execution went straight
        //to the Terminal method.
    }

    @Test
    public void testingStreamFourteen(){
        List<Integer> integerList = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        counter = 0;
        count = 0;
        List<Integer> processedList = integerList.stream().filter(element -> {
            filterCalls();
            return element % 2 == 0;
        }).map(element -> {
            mapCalls();
            return element * 2;
        }).collect(Collectors.toList());

        System.out.println(processedList);
        System.out.println("Filter method calls: " + counter);
        System.out.println("Map method calls: " + count);
    }

    @Test
    public void testingStreamFifteen(){
        //reduce() Method
        //There are three variations of this method, which differ by their signatures and returning types.
        // They can have the following parameters:
        //A look at these three methods in action:

        //Method 1
        OptionalInt result = IntStream.range(1, 4).reduce((a, b) -> (a + b));
        System.out.println("Method 1 result as Optional value: ");
        System.out.println(result);
        System.out.println();
        System.out.println("Method 1 result as int value: ");
        int intResult = result.getAsInt();
        System.out.println(intResult);
        System.out.println();

        //Method 2
        int result2 = IntStream.range(1, 4).reduce(10, (a, b) -> (a + b));
        System.out.println("Method 2 result: ");
        System.out.println(result2);
        System.out.println();

        //Method 3
        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    //log.info("combiner was called");
            return a + b;
        });
        System.out.println("Method 3 result: ");
        System.out.println(reducedParams);
    }

    @Test
    public void testingStreamSeventeen(){
        CarOwner carOwner = new CarOwner();
        carOwner.firstName = "John";
        carOwner.lastName = "Vall";
        carOwner.cars.add("Jeep");
        carOwner.cars.add("VW");
        carOwner.cars.add("BMW");
        carOwner.cars.add("Mercedes");

        CarOwner carOwner1 = new CarOwner();
        carOwner1.lastName = "Carlos";
        carOwner1.firstName = "Peter";
        carOwner1.cars.add("Peugeot");
        carOwner1.cars.add("Bentley");
        carOwner1.cars.add("VW");

        CarOwner carOwner2 = new CarOwner();
        carOwner2.firstName = "Daniel";
        carOwner2.lastName = "Molton";
        carOwner2.cars.add("Range Rover");
        carOwner2.cars.add("Mercedes Jeep");
        carOwner2.cars.add("Impala");
        carOwner2.cars.add("Lamborgini");

        List<CarOwner> carOwnerList = List.of(carOwner, carOwner1, carOwner2);
        List<String> carsList = new ArrayList<>();

        System.out.println("Details List b4 processing: ");
        System.out.println(carOwnerList);
        List<String> carsDetailsList = carOwnerList.stream().map(item -> item.getLastName()).sorted().collect(Collectors.toList());
       // List<String> carsStream = (List<String>) detailsList.stream().map(item -> item.getCars()).forEach(car -> carsList.addAll(car));
        carOwnerList.stream().forEach(car -> carsList.addAll(car.getCars()));
        System.out.println();
        System.out.println("Lastname details: ");
        System.out.println(carsDetailsList);
        System.out.println();
        System.out.println("List of Cars: ");
        System.out.println(carsList);
      //  System.out.println(carsStream);
    }

    @Test
    public void tests(){
        CarOwner test = new CarOwner();
        test.firstName = "Lol";
        test.lastName = "Care";
        test.cars.add("WV");

        System.out.println("Printing object: " + test);
        System.out.println("Hashcode: " + test.hashCode());
    }

    @Test
    public void testingStreamNineteen(){
        //flatMap
        //If you have a stream where every element contains its own sequence of elements, and
        //you want to create a stream of these inner elements, you should use the flatMap() method:
        CarOwner carOwner = new CarOwner();
        carOwner.firstName = "John";
        carOwner.lastName = "Vall";
        carOwner.cars.add("Jeep");
        carOwner.cars.add("VW");
        carOwner.cars.add("BMW");
        carOwner.cars.add("Mercedes");

        CarOwner carOwner1 = new CarOwner();
        carOwner1.lastName = "Carlos";
        carOwner1.firstName = "Peter";
        carOwner1.cars.add("Peugeot");
        carOwner1.cars.add("Bentley");
        carOwner1.cars.add("VW");

        CarOwner carOwner2 = new CarOwner();
        carOwner2.firstName = "Daniel";
        carOwner2.lastName = "Molton";
        carOwner2.cars.add("Range Rover");
        carOwner2.cars.add("Mercedes Jeep");
        carOwner2.cars.add("Impala");
        carOwner2.cars.add("Lamborgini");

       List<CarOwner> carOwnerList = new ArrayList<>();
       carOwnerList.add(carOwner);
       carOwnerList.add(carOwner1);
       carOwnerList.add(carOwner2);

       List<String> carsList = carOwnerList.stream().flatMap(item -> item.getCars().stream()).collect(Collectors.toList());
        System.out.println(carsList);
        System.out.println();
        List<String> carsList2 = new ArrayList<>();
        carOwnerList.stream().forEach(item -> carsList2.addAll(item.getCars()));
        System.out.println(carsList2);
    }

    @Test
    public void testingStreamTwenty(){
        //String distinct() method
        //The distinct() method represents an intermediate operation,
        //which creates a new stream of unique elements of the previous stream.
        List<String> stringList = Arrays.asList("One", "Two", "Three", "One", "Four", "Two");
        List<String> result = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void testingStreamTwentyOne(){
        //findFirst()
        //Stream method findFirst() returns an Optional (a container object which may or may not contain a
        //non-null value) describing the first element of this stream, or an empty Optional if the stream is empty.
        //If the stream has no encounter order, then any element may be returned.
        //Exception : If the element selected is null, NullPointerException is thrown.

        // Creating a List of Integers
        List<Integer> list = Arrays.asList(3, 5, 7, 9, 11);
        // Using Stream findFirst()
        Optional<Integer> answer = list.stream().findFirst();
        // if the stream is empty, an empty
        // Optional is returned.
        if (answer.isPresent()) {
            System.out.println(answer.get());
        }
        else {
            System.out.println("no value");
        }
        System.out.println();
        //The list below is empty, the findFirst() method returns an empty optional and does not throw an exception.
        List<String> emptyStrList = new ArrayList<>();
        Optional<String> firstElement = emptyStrList.stream().findFirst();
        System.out.println(firstElement);
    }

    @Test
    public void testingStringTwentyTwo(){
        //create a List from a stream without few elements
        List<String> stringList = Stream.of("abcd", "bbcd", "cbcd").skip(1).collect(Collectors.toList());
        System.out.println("String after skipping the first element: " + stringList);
        System.out.println();
        //Create a List to substitute every element of the above List with a substring of the first few chars
        List<String> modifiedList = stringList.stream().map(element -> element.substring(0, 3)).collect(Collectors.toList());
        System.out.println("Modified list: " + modifiedList);
    }

}

