package genericclasses.streamdemo;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.*;
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

        List<String> names = Arrays.asList("Reflection","Collection","Stream");
        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());


        assertTrue(containsEs.contains("Tuesday"));
        assertTrue(containsEs.contains("Wednesday"));
        assertEquals(2, containsEs.size());
        assertTrue(result.contains("Stream"));
        //assertThat(containsEs, hasItem("Tuesday"));  // AssertThat() is deprecated?

        System.out.println("Printing daysOfWeek: \n" + daysOfWeek);
        System.out.println("\nPrinting days starting with \"T\": " + startingWithT);
        System.out.println("\nPrinting days that contain \"es\": " + containsEs);
        System.out.println("\nPrinting days that end with \"sday\": " + endingWithSday);
        System.out.println("\nPrinting result: " + result);
    }

    @Test
    public void testingStreamsThree(){
      /** sorted()
       The Stream sorted() method returns a stream consisting of the elements of this stream, sorted according to natural order.
       For ordered streams, the sort() method is stable but for unordered streams, no stability is guaranteed.
       It is a stateful intermediate operation i.e., it may incorporate state from previously seen elements when processing new elements.
       Syntax: Stream<T> sorted()
       Where, Stream is an interface and T is the type of stream elements.
       Exception : If the elements of this stream are not Comparable,
       a java.lang.ClassCastException may be thrown when the terminal operation is executed.
       */
        // Creating a list of integers
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
        System.out.println("Original Integer list: " + list);
        System.out.print("The sorted list : ");
        // displaying the stream with elements
        // sorted in natural order
        list.stream().sorted().forEach(item -> System.out.print(item + " "));
        System.out.println();
        System.out.println();
        List<String> names = Arrays.asList("Reflection", "Capturing", "Promoting", "Caring", "Planning", "Success");
        System.out.print("The list of names: " + names);
        //sorting the list of names
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println("\nPrinting the sorted list of names: \n" + sortedNames);
    }

    @Test
    public void testingStreamThreeA(){
        /** sorted (Comparator comparator)
         Stream sorted(Comparator comparator) returns a stream consisting of the elements of this stream, sorted according to
         the provided Comparator. For ordered streams, the sort() method is stable but for unordered streams, no stability is guaranteed.
         It is a stateful intermediate operation i.e, it may incorporate state from previously seen elements when processing new elements.
         In java 8, the Comparator can be instantiated using lambda expression.
         We can also reverse the natural ordering as well as ordering provided by Comparator.
         Syntax: Stream<T> sorted(Comparator<? super T> comparator)
         Where, Stream is an interface and T is the type of stream elements.
         comparator is used to compare stream elements.
         */
        // Implementation of Stream.sorted(Comparator comparator) to get a stream of sorted elements according to the provided Comparator.
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(5, -10, 7, -18, 23);
        //Displaying the list of Integer in sorted order
        System.out.println("list in sorted order according "
                + "to the provided Comparator: ");
        list.stream().sorted(Comparator.naturalOrder())//No need to use a comparator with naturalOrdering() as the sorted() will do.  See the previous test.
                .forEach(System.out::println);
        System.out.println();
        // Displaying the list of Integer in reverse order after sorting
        System.out.println("List in reverse order: ");
        list.stream().sorted(Comparator.reverseOrder())//No need to use a comparator for naturalOrdering() as the sorted() will do.  See the previous test.
                .forEach(System.out::println);
        System.out.println();

        // Creating a list of Strings
        List<String> slist = Arrays.asList("Geeks", "For",
                "Home", "for", "Rock", "bed", "arc", "Ash");
        System.out.println("List in sorted natural order: ");
        slist.stream()
                .sorted(Comparator.naturalOrder())  //In natural ordering Uppercase letter seems to come before lowercase letters.
                .forEach(System.out::println);      //Example: arc, Ash => Ash will come before arc.  Check Unicode of characters.
        System.out.println();
        System.out.println("Sorted list according "
                + "to provided Comparator in reverse order : ");
        // Displaying the list of Strings in reverse order after sorting
        slist.stream().sorted(Comparator.reverseOrder()).
                forEach(System.out::println);
    }

    @Test
    public void testingStreamThreeB(){
        /** Using stream sorted(Comparator comparator) to sort a stream of user defined class objects. */
        List<Point> aList = new ArrayList<>();
        aList.add(new Point(10, 20));
        aList.add(new Point(5, 10));
        aList.add(new Point(1, 100));
        aList.add(new Point(50, 2000));
        // displaying the stream with elements
        // sorted according to x coordinate
        PointXComparator pointXComparator = new PointXComparator();
        System.out.println("Sorted list: ");
        aList.stream()
                .sorted(pointXComparator)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Reversed list: ");
        aList.stream()
                .sorted(pointXComparator.reversed())
                .forEach(System.out::println);
        System.out.println();
        System.out.println();
        List<Point> bList = Arrays.asList(
                new Point(9, 89),
                new Point(120, 7),
                new Point(48, 45),
                new Point(1, 33)
        );
        PointYComparator pointYComparator = new PointYComparator();
        System.out.println("Sorted list: ");
        bList.stream()
                .sorted(pointYComparator)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Reversed list: ");
        bList.stream()
                .sorted(pointYComparator.reversed())
                .forEach(System.out::println);
    }

    @Test
    public void testingStreamThreeC(){
        // Creating an array of Strings
        String[] array = { "GgB", "Bob", "fora",
                "GeeksforGeeks", "GeeksQuiz" };
        System.out.println("The sorted stream is :");
        // sorting the elements of array based
        // on their last character
        Stream.of(array).sorted((str1, str2)
                        -> Character.compare(str1
                                .charAt(str1.length() - 1),
                        str2.charAt(str2.length() - 1)))
                .forEach(System.out::println);
        System.out.println();
        //Best implementation using Comparator.comparingInt() method
        System.out.println("Best implementation: ");
        Stream.of(array).sorted(Comparator.comparingInt(str -> str    //comparing() will also work.
                        .charAt(str.length() - 1)))
                .forEach(System.out::println);
    }

    @Test
    public void testingStreamThreeD(){
        /** Comparator.comparing() method
         introduced in Java 8, the comparing() method returns a Comparator object that will use the specified field as the sort key.
         The Comparator interface is a functional interface, and the method implemented is the compare() method.
         Therefore, the compare() method is implemented by the comparing() method using the specified key.
         The comparing() static function accepts a sort key Function and returns a Comparator for the type that contains the sort key.
         ** Comparator interface
         * The Comparator interface is used to order the objects of user-defined classes.
         * A comparator object is capable of comparing two objects of the same class.
         */
        List<MusicalInstrument> musicalInstruments = new ArrayList<>();
        musicalInstruments.add(new MusicalInstrument("Trumpet", "brass"));
        musicalInstruments.add(new MusicalInstrument("Solo", "guitard"));
        musicalInstruments.add(new MusicalInstrument("Timpani", "percussion"));
        musicalInstruments.add(new MusicalInstrument("Piano", "keyboard"));

        System.out.println("Musical instruments in the collection sorted by name:");
        Collections.sort(musicalInstruments, Comparator.comparing((MusicalInstrument instrument) -> instrument.getName()));
        musicalInstruments.stream().forEach(System.out::println);
        System.out.println();
        System.out.println("Musical instruments in the collection sorted by type:");
        Collections.sort(musicalInstruments, Comparator.comparing(MusicalInstrument::getType));
        musicalInstruments.stream().forEach(instrument -> System.out.println(instrument));
    }

    @Test
    public void testingStreamThreeF(){
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        // For test assertions, we’ll use this pre-sorted array that we’ll compare to our sort results.
        Employee[] sortedEmployeesByName = new Employee[] {
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)};

        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Arrays.sort(employees, employeeNameComparator);
        assertTrue(Arrays.equals(employees, sortedEmployeesByName));
        Arrays.stream(employees).forEach(System.out::println);
        System.out.println();
        Arrays.stream(sortedEmployeesByName).forEach(System.out::println);
        System.out.println();

        Comparator<Employee> sortByAge = Comparator.comparing(Employee::getAge);
        //Comparator<Employee> sortByAge = Comparator.comparing((Employee emp) -> emp.getAge());  //Same as the line above.
        System.out.println("Employee sorted by age: ");
        Arrays.sort(employees, sortByAge);
        Arrays.stream(employees).forEach(System.out::println);
        System.out.println();

        //Create a stream from an Array, sort the Array with Comparator.comparing, reverse the sort order and print the sorted Array.
        System.out.println("Employee sorted by salary.  Highest salary first: ");
        Arrays.stream(employees).sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
    }

    @Test
    public void testingStreamThreeG(){
        //There’s another option that facilitates overriding the natural ordering of the sort key by providing a Comparator that
        //creates a custom ordering for the sort key.  So, let’s modify the test above. We’ll override the natural order of
        //sorting by the name field by providing a Comparator for sorting the names in descending order as
        //the second argument to Comparator.comparing
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByNameDesc = new Employee[]{
                new Employee("Keith", 35, 4000.0, 3924401),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001)
        };
//        Comparator<Employee> employeeNameComparator
//                = Comparator.comparing(
//                Employee::getName, (s1, s2) -> {
//                    return s2.compareTo(s1);
//                });
//        //One of the best way to reverse the order is as follow:
//        Comparator<Employee> employeeNameComparator
//                = Comparator.comparing(
//                Employee::getName, Comparator.reverseOrder());

        //One more best way to reverse the order is as follow:
        Comparator<Employee> employeeNameComparator =
                Comparator.comparing(Employee::getName).reversed();

        Arrays.sort(employees, employeeNameComparator);
        assertTrue(Arrays.equals(employees, sortedEmployeesByNameDesc));
        System.out.println("The sorted and reversed employee array by name: ");
        Arrays.stream(employees).forEach(System.out::println);
    }

    @Test
    public void testingStreamThreeH() {
        /** Comparator reversed() method
         When invoked on an existing Comparator, the instance method Comparator.reversed() returns a new Comparator that
         reverses the sort order of the original Comparator.  The reversed() method of Comparator Interface returns a comparator that
         imposes the reverse ordering of this comparator. If you use sort() method of the array and passes this
         comparator after applying the reversed() method then it will sort the array in reverse order.
         */
        //Let's use the Comparator that sorts the employees by name and reverse it so that the employees are sorted in
        //descending order of the name:
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByNameDesc = new Employee[]{
                new Employee("Keith", 35, 4000.0, 3924401),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001)
        };
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparatorReversed
                = employeeNameComparator.reversed();
        Arrays.sort(employees, employeeNameComparatorReversed);
        assertTrue(Arrays.equals(employees, sortedEmployeesByNameDesc));
    }

    @Test
    public void testingStreamThreeI(){
        /** Comparator.comparingInt
         There’s also a function, Comparator.comparingInt, which does the same thing as Comparator.comparing,
         but it takes only int selectors.
         */
        //Let’s try it with an example where we order employees by age:
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByAge = new Employee[]{
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Comparator<Employee> employeeAgeComparator
                = Comparator.comparingInt(Employee::getAge);
        Arrays.sort(employees, employeeAgeComparator);
        assertTrue(Arrays.equals(employees, sortedEmployeesByAge));
         }

    @Test
    public void testingStreamThreeJ() {
        /** Comparator.comparingLong
         Similar to what we did for int keys, let’s look at an example using Comparator.comparingLong to
         consider a sort key of type long by ordering the employees array by the mobile field:
         */
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByMobile = new Employee[]{
                new Employee("Keith", 35, 4000.0, 3924401),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001)
        };
        Comparator<Employee> employeeMobileComparator
                = Comparator.comparingLong(Employee::getMobile);
        Arrays.sort(employees, employeeMobileComparator);
        assertTrue(Arrays.equals(employees, sortedEmployeesByMobile));
    }

    @Test
    public void testingStreamThreeK(){
        /** Comparator.comparingDouble
         Again, as we did for int and long keys, let’s look at an example using Comparator.comparingDouble to
         consider a sort key of type double by ordering the employees array by the salary field:
         */
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesBySalary = new Employee[]{
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Comparator<Employee> employeeSalaryComparator
                = Comparator.comparingDouble(Employee::getSalary);
        Arrays.sort(employees, employeeSalaryComparator);
        assertTrue(Arrays.equals(employees, sortedEmployeesBySalary));
    }

    @Test
    public void testingStreamThreeL(){
        /** Comparator naturalOrder()
         The naturalOrder() method of Comparator Interface returns a comparator that is used to
         compare Comparable objects in natural order. The returned comparator by this method is serializable and throws
         NullPointerException when comparing null.
         Parameters: This method accepts nothing.
         Return value: This method returns a comparator that imposes the natural ordering on Comparable objects.
         We can define the natural order by the behaviour of the Comparable interface implementation.
         Let’s implement Comparable in our Employee class so that we can try the naturalOrder() and reverseOrder() functions of the
         Comparator interface:
         Natural order: The content of lists in Java are sorted according to natural order. This means that, if the content are numbers,
         it is sorted as ascending or lowest to the highest order when sorted. Similarly, characters are sorted according to their alphabetical order.
         */
         Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByName = new Employee[]{
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Comparator<Employee> employeeNameComparator
                = Comparator.<Employee> naturalOrder();   //Or: Comparator.naturalOrder();
        Arrays.sort(employees, employeeNameComparator);
        assertTrue(Arrays.equals(employees, sortedEmployeesByName));
    }

    @Test
    public void testingStreamThreeM(){
        /** Comparator reverseOrder() method
         The reverseOrder() method of Comparator Interface returns a comparator that is used to
         compare Comparable objects in reverse of natural order. The returned comparator by this method is serializable and
         throws NullPointerException when comparing null.
         Parameters: This method accepts nothing.
         Return value: This method returns a comparator that imposes the reverse natural ordering on Comparable objects.
         Similar to how we used naturalOrder, we’ll use the reverseOrder method to generate a Comparator that will
         produce a reverse ordering of employees compared to the one in the naturalOrder example:
         */
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByNameDesc = new Employee[]{
                new Employee("Keith", 35, 4000.0, 3924401),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001)
        };
        Comparator<Employee> employeeNameComparator
                = Comparator.<Employee> reverseOrder();
        Arrays.sort(employees, employeeNameComparator);
        assertTrue(Arrays.equals(employees, sortedEmployeesByNameDesc));
    }

    @Test
    public void testingStreamThreeN(){
        /** Considering Null Values in Comparator
         nullsFirst() and nullsLast() methods
         The nullsFirst() and nullsLast() functions consider null values in ordering and keep the
         null values at the beginning or end of the ordering sequence.
         nullsFirst() method
         The nullsFirst() function returns a Comparator that keeps all nulls at the beginning of the ordering sequence.
         */
        Employee[] employeesArrayWithNulls = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                null,
                new Employee("Ace", 22, 2000.0, 5924001),
                null,
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesArray_WithNullsFirst = new Employee[]{
                null,
                null,
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };

        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparator_nullFirst
                = Comparator.nullsFirst(employeeNameComparator);
        Arrays.sort(employeesArrayWithNulls,
                employeeNameComparator_nullFirst);
        assertTrue(Arrays.equals(
                employeesArrayWithNulls,
                sortedEmployeesArray_WithNullsFirst));
         }

    @Test
    public void testingStreamThreeO() {
        /** nullsFirst() and nullsLast() methods
         The nullsFirst() and nullsLast() functions consider null values in ordering and keep the
         null values at the beginning or end of the ordering sequence.
         nullsLast() method
         The nullsLast() function returns a Comparator that keeps all nulls at the end of the ordering sequence.
         */
        Employee[] employeesArrayWithNulls = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                null,
                new Employee("Ace", 22, 2000.0, 5924001),
                null,
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesArray_WithNullsLast = new Employee[]{
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401),
                null,
                null
        };
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparator_nullLast
                = Comparator.nullsLast(employeeNameComparator);
        Arrays.sort(employeesArrayWithNulls, employeeNameComparator_nullLast);
        assertTrue(Arrays.equals(
                employeesArrayWithNulls, sortedEmployeesArray_WithNullsLast));
    }

    @Test
    public void testingStreamThreeP() {
        /** Comparator.thenComparing()
         The thenComparing() function lets us set up lexicographical ordering of values by
         provisioning multiple sort keys in a particular sequence.
         */
         Employee[] someMoreEmployees = new Employee[]{
                new Employee("Jake", 25, 3000.0, 9922001),
                new Employee("Jake", 22, 2000.0, 5924001),
                new Employee("Ace", 22, 3000.0, 6423001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByAgeName = new Employee[]{
               new Employee("Ace", 22, 3000.0, 6423001),
               new Employee("Jake", 22, 2000.0, 5924001),
               new Employee("Jake", 25, 3000.0, 9922001),
               new Employee("Keith", 35, 4000.0, 3924401)
        };
        Comparator<Employee> employee_Age_Name_Comparator
                = Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName);
        Arrays.sort(someMoreEmployees, employee_Age_Name_Comparator);
        assertTrue(Arrays.equals(someMoreEmployees, sortedEmployeesByAgeName));
    }

    @Test
    public void testingStreamThreeQ(){
        /** Now we can use the other version of thenComparing, thenComparingInt,
        by changing the lexicographical sequence to name followed by age:
         */
        Employee[] someMoreEmployees = new Employee[]{
                new Employee("Jake", 25, 3000.0, 9922001),
                new Employee("Jake", 22, 2000.0, 5924001),
                new Employee("Ace", 22, 3000.0, 6423001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Employee[] sortedEmployeesByNameAge = new Employee[]{
                new Employee("Ace", 22, 3000.0, 6423001),
                new Employee("Jake", 22, 2000.0, 5924001),
                new Employee("Jake", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        };
        Comparator<Employee> employee_Name_Age_Comparator
                = Comparator.comparing(Employee::getName)
                .thenComparingInt(Employee::getAge);
        Arrays.sort(someMoreEmployees, employee_Name_Age_Comparator);
        assertTrue(Arrays.equals(someMoreEmployees,
                sortedEmployeesByNameAge));
    }

    @Test
    public void testingStreamFourA(){
        /** flatMap() method
         Stream flatMap(Function mapper) returns a stream consisting of the results of replacing each element of this stream with
         the contents of a mapped stream produced by applying the provided mapping function to each element.
         Stream flatMap(Function mapper) is an intermediate operation. These operations are always lazy.
         Intermediate operations are invoked on a Stream instance, and after they finish their processing, they give a Stream instance as output.
         Note : Each mapped stream is closed after its contents have been placed into this stream.
         If a mapped stream is null, an empty stream is used instead.
         flatMap() vs map()
         1) map() takes a Stream and transforms it to another Stream. It applies a function on each element of the Stream and store the
         return value into new Stream. It does not flatten the stream. But flatMap() is the combination of a map and a flat operation i.e.,
         it applies a function to elements as well as flatten them.
         2) map() is used for transformation only, but flatMap() is used for both transformation and flattening.
         If you have a stream where every element contains its own sequence of elements, and you want to
         create a stream of these inner elements, you should use the flatMap() method.
         */
        CarOwner carOwner1 = new CarOwner();
        carOwner1.firstName = "John";
        carOwner1.lastName = "Valle";
        carOwner1.cars.add("Jeep");
        carOwner1.cars.add("VW");
        carOwner1.cars.add("BMW");
        carOwner1.cars.add("Mercedes");

        CarOwner carOwner2 = new CarOwner();
        carOwner2.lastName = "Carlos";
        carOwner2.firstName = "Peter";
        carOwner2.cars.add("Peugeot");
        carOwner2.cars.add("Bentley");
        carOwner2.cars.add("VW");

        CarOwner carOwner3 = new CarOwner();
        carOwner3.firstName = "Daniel";
        carOwner3.lastName = "Moulton";
        carOwner3.cars.add("Range Rover");
        carOwner3.cars.add("Mercedes Jeep");
        carOwner3.cars.add("Impala");
        carOwner3.cars.add("Lamborghini");

        List<CarOwner> carOwnerList = new ArrayList<>();
        carOwnerList.add(carOwner1);
        carOwnerList.add(carOwner2);
        carOwnerList.add(carOwner3);
        System.out.println("Car owner list: \n" + carOwnerList);
        System.out.println();
        List<String> carsList = carOwnerList.stream().flatMap(item -> item.getCars().stream()).collect(Collectors.toList());
        System.out.println("carsList1: " + carsList);
        System.out.println();
        List<String> carsList2 = new ArrayList<>();
        carOwnerList.stream().forEach(item -> carsList2.addAll(item.getCars()));
        System.out.println("carsList2: " + carsList2);
        System.out.println();
        List<List<String>> carsList3 = carOwnerList.stream()
                .flatMap(carOwner -> Stream.of(carOwner.getCars())).collect(Collectors.toList());
        System.out.println("carsList3: " + carsList3);
    }

    @Test
    public void testingStreamFourB() {
        // Java code for Stream flatMap(Function mapper) to get a stream by
        // replacing the stream with a mapped stream by applying the provided mapping function.
        List<String> list = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");
        // Using Stream flatMap(Function mapper)
        list.stream().flatMap(str ->
                        Stream.of(str.charAt(2))).
                forEach(System.out::println);
        System.out.println();
       List<Character> result = list.stream()             //Stream of strings
               .flatMap(str -> Stream.of(str.charAt(2)))  //Creating a stream of charAt(2) which returns a stream of characters and not Strings.
               .collect(Collectors.toList());
        System.out.println("Second List: " + result);
    }

    @Test
    public void testingStreamFourC(){
        /** How does flatMap() work ?
         As already discussed, flatMap() is the combination of a map and a flat operation i.e.,
         it first applies map function and then flattens the result.
         Example:
         The list before flattening :
         [ [2, 3, 5], [7, 11, 13], [17, 19, 23] ]
         The list has 2 levels and consists of 3 small lists. After Flattening, it gets transformed into “one level” structure as shown :
         [ 2, 3, 5, 7, 11, 13, 17, 19, 23 ]
         In short, we can say that if there is a Stream of List of <<Data Type>> before flattening,
         then on applying flatMap(), Stream of <<Data Type>> is returned after flattening.
         */
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        System.out.println("The Structure before flattening is : " +
                listOfListofInts);
        // Using flatMap for transformation and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("The Structure after flattening is : " +
                listofInts);
    }

    @Test
    public void testingStreamFourD(){
        /** Stream of(T t) method
         Stream of(T t) returns a sequential Stream containing a single element.  It is a static method of the Stream class.
         Parameters: This method accepts a mandatory parameter t which is the single element in the Stream.
         Return Value: The Stream of(T t) returns a sequential Stream containing the single specified element.         */
        // Creating a Stream having single element only
        Stream<String> stream = Stream.of("Geeks");
        // Displaying the Stream having single element
        stream.forEach(System.out::println);
    }

    @Test
    public void testingStreamFourE(){
        /** Stream of(T… values)
         The Stream of(T… values) returns a sequential ordered stream whose elements are the specified values.
         Parameters: This method accepts a mandatory parameter values which are the elements of the new stream.
         Return Value : Stream of(T… values) returns a sequential ordered stream whose elements are the specified values.    */
        // Creating a Stream
        Stream<String> stream = Stream.of("Geeks", "for", "Geeks");
        // Displaying the sequential ordered stream
        stream.forEach(System.out::println);
    }

    @Test
    public void testingStreamFourF(){
        /** Stream distinct() method
         The distinct() method returns a stream consisting of distinct elements in a stream.
         distinct() is the method of Stream interface. This method uses hashCode() and equals() methods to get distinct elements.
         In case of ordered streams, the selection of distinct elements is stable. But, in case of unordered streams,
         the selection of distinct elements is not necessarily stable and can change.
         The distinct() method performs stateful intermediate operation i.e, it maintains some state internally to accomplish the operation.
         The distinct() method represents an intermediate operation, which creates a new stream of unique elements of the previous stream.     */
        // Creating a list of integers
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5);
        System.out.println("The distinct elements are :");
        // Displaying the distinct elements in the list
        // using Stream.distinct() method
        list.stream().distinct().forEach(System.out::println);
        System.out.println();
        List<String> stringList = Arrays.asList("One", "Two", "Three", "One", "Four", "Two");
        List<String> result = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void testingStreamFourG(){
        /** skip(n) method
         The skip(n) method is an intermediate operation that discards the first n elements of a stream.
         The n parameter can’t be negative, and if it’s higher than the size of the stream, skip() returns an empty stream.
         The new Stream will not include skipped elements. In order to do this, the skip(n) operation has to keep the state of
         the elements seen at each moment. For this reason, we say that skip(n) is a stateful operation.              */
         Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
         .filter(i -> i % 2 == 0).skip(2)
         .forEach(i -> System.out.print(i + " "));
         // When this stream is executed, the forEach() method starts asking for items. When it gets to skip(),
         // this operation knows that the first two items have to be discarded, so it does not add them to the resulting stream.
         // After that, it creates and returns a stream with the remaining items.
         }

    @Test
    public void testingStreamFourH(){
        /** skip(n) method                                                                                          */
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
    public void testingStreamFourI(){
        /** limit(n) Method
         The limit(n) method is an intermediate operation that returns a stream not longer than the requested size.
         The n parameter can’t be negative.                                                                */
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0) .limit(2)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println();
       /** When working with infinite streams, limit() can be very useful for truncating a stream into a finite one:     */
        Stream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .limit(10)
                .forEach(System.out::println);
        //In this example, we’re truncating an infinite stream of numbers into a stream with only ten even numbers.
    }
    /** Combining skip() and limit()
     As we mentioned earlier, the skip and limit operations are complementary, and if we combine them,
     they can be very helpful in some cases. Let’s imagine that we want to modify our previous example so that
     it gets even numbers in batches of ten. We can do that simply by using both skip() and limit() on the same stream:              */
     private static List<Integer> getEvenNumbers(int offset, int limit) {
        return Stream.iterate(0, i -> i + 1)  //Produces an infinite stream but the limit() method is used to truncate the stream to a finite one.
                .filter(i -> i % 2 == 0)           //Adding a condition trancate the stream to a finite one: Stream.iterate(0, i->i<5, i->i+1).
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }
    /** Offset: The offset is the first index of the storage that is used.                                                          */
    @Test
    public void testingStreamJ(){
         List<Integer> result = getEvenNumbers(10, 10);
        System.out.println(result);
        System.out.println();
        //Next you may call the method again to get the next batch of
        //10 even numbers in sequence by calling getEvenNumbers(20, 10) and so on.
        List<Integer> result2 = getEvenNumbers(20, 10);
        System.out.println(result2);
        System.out.println();
        List<Integer> result3 = getEvenNumbers(30, 10);
        System.out.println(result3);
        System.out.println();
        //Check result when skip() method is not used:
        List<Integer> result4 = getEvenNumbers(0, 40);
        System.out.println(result4);
    }

    @Test
    public void testingStreamK(){
        /** Stream iterate(T, Predicate, UnaryOperator) method
         The iterate(T, Predicate, UnaryOperator) method allows us to iterate stream elements till the specified condition.
         This method returns a sequential ordered stream produced by iterative application of the given next function to an initial element,
         conditioned on satisfying hasNext predicate passed as parameter. The stream terminates as soon as the hasNext predicate returns false.
         The resulting sequence returned by this method may be empty if passed predicate does not hold on the seed value. Otherwise,
         the first element will be the supplied seed value, the next element will be the result of applying the next function to the seed value,
         and so on iteratively until the hasNext predicate indicates that the stream should terminate.
         Syntax: static <T> Stream<T> iterate(T seed, Predicate<T> hasNext, UnaryOperator<T> next)
         Parameters: This method accepts three parameters:
         •	seed: which is the initial element.
         •	hasNext: which is a predicate to apply to elements to determine when the stream must terminate.
         •	next: which is a function to be applied to the previous element to produce a new element.
         Return value: This method returns a new sequential stream.                                                   */
        // create a stream using iterate
        Stream<Integer> stream
                = Stream.iterate(2, i -> i <= 20, i -> i * 2); //i=1,i*2=2, i=2,i*2=4, i=4,i*2=8, i=8,i*2=16.  Result: 1,2,4,8,16.
        // print Values
        stream.forEach(System.out::println);
        System.out.println();
        System.out.println();
        List<Integer> integerList = Stream.iterate(3, i -> i < 30, i -> i * 2).collect(Collectors.toList());
        //i = 3, 3*2=6; i=6,6*2=12; i=12,12*2=24; i=24,24*2=48,48>30 terminates.  Result:3,6,12,24.
        System.out.println(integerList);
    }

    @Test
    public void testingStreamL(){
        /** Stream iterate(T, UnaryOperator) method
         This method produces an infinite stream. In this version of this method a predicate is not used to apply to
         elements to determine when the stream must terminate. Adding a condition(Predicate) truncates the stream to a finite one.
         for example: Stream.iterate(0, i -> i < 5, i -> i + 1). In the following example, the limit() method is used instead to
         indicate when the stream must terminate.                                                                                               */
        Stream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .limit(6)
                .forEach(System.out::println);
        System.out.println();
        // create a stream using iterate
        Stream<Double> stream = Stream.iterate(2.0,
                decimal -> decimal > 0.25, decimal -> decimal / 2);
        // print Values
        stream.forEach(System.out::println);
    }


    @Test
    public void testingStreamsFive(){
      /** Stream forEach() method
       Stream forEach(Consumer action) performs an action for each element of the stream.
       It is used to iterate through every element of the stream.  Stream forEach(Consumer action) is
       a terminal operation i.e.,it may traverse the stream to produce a result or a side-effect.
       Syntax: void forEach(Consumer<? super T> action)
       Where, Consumer is a functional interface and T is the type of stream elements.
       Note : The behaviour of this operation is explicitly nondeterministic. Also, for any given element,
       the action may be performed at whatever time and in whatever thread the library chooses.                             */
       List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 8, 9);
        System.out.println("Printing integerList: " + integerList);
        integerList.stream().map(x -> x + 3).forEach(x -> System.out.print(x + ", "));
        System.out.println();
        //Converting an Array to a Stream
        Integer[] intArrayTwo = new Integer[]{11, 14, 15, 17};
        Stream<Integer> integerStream = Arrays.stream(intArrayTwo);
        //Converting an Array to a List
        List<Integer> integerList4 = Arrays.stream(intArrayTwo).collect(Collectors.toList());
        //Converting an Array to a Set
        Set<Integer> integerSet = Arrays.stream(intArrayTwo).collect(Collectors.toSet());
    }

    @Test
    public void testingStreamFiveAA(){
        /** Stream forEach() method                                                                                         */
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
        // Using forEach(Consumer action) to print the elements of stream in reverse order
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();
        // Creating a Stream of Strings
        Stream<String> stream = Stream.of("GFG", "Geeks",
                "for", "GeeksforGeeks");
        // Using forEach(Consumer action) to print Character at index 1 in reverse order
        stream.sorted(Comparator.reverseOrder())
                .flatMap(str -> Stream.of(str.charAt(1)))
                .forEach(System.out::println);
}

    @Test
    public void testingStreamFiveA(){
        /** Stream max() method
         The max(Comparator comparator) method returns the maximum element of the stream based on the provided Comparator.
         A Comparator is a comparison function, which imposes a total ordering on some collection of objects.
         max() is a terminal operation which combines stream elements and returns a summary result.
         So, max() is a special case of reduction. The method returns Optional instance.
         Syntax: Optional<T> max(Comparator<? super T> comparator)
         Where, Optional is a container object which may or may not contain a non-null value and T is the type of
         objects that may be compared by this comparator.
         Exception: This method throws NullPointerException if the maximum element is null.                            */
        // Creating a list of integers
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
        System.out.print("The maximum value is : ");
        // Using stream.max() to get maximum
        // element according to provided Comparator
        // and storing in variable var
        Integer var = list.stream().max(Integer::compare).get(); //Or: max((x, y) -> x.compareTo(y)).get(); Or: max(Comparator.naturalOrder()).get()
        //Or: Integer var = list.stream().max((x, y) -> Integer.compare(x, y)).get();
        System.out.print(var);
        System.out.println();
        System.out.println();
        // Using stream.max() to get maximum
        // element according to provided Comparator
        // Here, the smallest element in list
        // will be stored in variable var
        Optional<Integer> varTwo = list.stream()
                .max(Comparator.reverseOrder());
        // If a value is present, isPresent()
        // will return true, else display message
        if (varTwo.isPresent()) {
            System.out.println("The minimum value is: " + varTwo.get());
        }
        else {
            System.out.println("-1");
        }
        System.out.println();
        Integer valThree = list.stream().max(Comparator.comparing(Integer::valueOf)).get();  //Or: Comparator.naturalOrder();
        System.out.println("Maximum value: " + valThree);
    }

    @Test
    public void testingStreamFiveB(){
        /** Stream max() method                                                                                     */
        // Creating a list of Strings
        List<String> list = Arrays.asList("G", "E", "E", "K",
                "g", "e", "e", "k");
        // using Stream.max() method with Comparator
        // Here, the character with maximum ASCII value
        // is stored in variable MAX
        String MAX = list.stream().max(Comparator.
                comparing(String::valueOf)).get();  // Or: Comparator.comparing((String str) -> String.valueOf(str))).get(); Or: max(Comparator.naturalOrder()).get()
        // Displaying the maximum element in
        // the stream according to provided Comparator
        System.out.println("Maximum element in the "
                + "stream is : " + MAX);
        System.out.println();
        List<String> strList = List.of("Zack", "Moulton", "James", "Pat", "Carmel");
        String maximum = strList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Maximum string: " + maximum);
        System.out.println();
        System.out.print("Minimum string: ");
        System.out.println(strList.stream().max(Comparator.reverseOrder()).get());
    }

    @Test
    public void testingStreamFiveC(){
        /** Stream max() method                                                                                           */
        // creating an array of strings
        String[] array = { "Geeks", "for", "GeeksforGeeks",
                "GeeksQuiz" };
        // Here, the Comparator compares the strings
        // based on their last characters and returns
        // the maximum value accordingly
        // The result is stored in variable MAX
        Optional<String> MAX = Arrays.stream(array).max((str1, str2) ->
                Character.compare(str1.charAt(str1.length() - 1),
                        str2.charAt(str2.length() - 1)));
        // If a value is present,
        // isPresent() will return true
        if (MAX.isPresent())
            System.out.println(MAX.get());
        else
            System.out.println("-1");
        System.out.println();
        //Best approach
        Optional<String> Max = Arrays.stream(array).max(Comparator.comparing(str -> str.charAt(str.length() -1)));
        System.out.println(Max.get());
    }

    @Test
    public void testingStreamFiveD(){
        /** Stream min() method
        Stream.min(Comparator comparator) returns the minimum element of the stream based on the provided Comparator.
         A Comparator is a comparison function, which imposes a total ordering on some collection of objects. min() is a
         terminal operation which combines stream elements and returns a summary result. So, min() is a special case of reduction.
         The method returns Optional instance.
         Syntax: Optional<T> min(Comparator<? super T> comparator)
         Where, Optional is a container object which may or may not contain a non-null value and T is the type of objects that may be
         compared by this comparator.
         Exception: This method throws NullPointerException if the minimum element is null.                                 */
        // Creating a list of integers
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
        // Using stream.min() to get minimum
        // element according to provided Integer Comparator
        Integer var = list.stream().min(Integer::compare).get();
        System.out.print(var);
        System.out.println();
        System.out.println();
        // Using Stream.min() with reverse
        // comparator to get maximum element.
        Optional<Integer> varTwo = list.stream()
                .min(Comparator.reverseOrder());
        // IF varTwo is empty, then output will be Optional.empty
        // else value in varTwo is printed.
        if(varTwo.isPresent()){
            System.out.println(varTwo.get());
        }
        else{
            System.out.println("NULL");
        }
    }

    @Test
    public void testingStreamFiveE() {
        /** Stream.min() method                                                                                             */
        // creating an array of strings
        String[] array = {"Geeks", "for", "GeeksforGeeks",
                "GeeksQuiz"};
        // The Comparator compares the strings
        // based on their last characters and returns
        // the minimum value accordingly.
        Optional<String> MIN = Arrays.stream(array).min((str1, str2) ->
                Character.compare(str1.charAt(str1.length() - 1),
                        str2.charAt(str2.length() - 1)));
        // If a value is present,
        // isPresent() will return true
        if (MIN.isPresent())
            System.out.println(MIN.get());
        else
            System.out.println("-1");
        System.out.println();
        System.out.println();
        //Best approach
        Optional<String> minStr = Arrays.stream(array).min(Comparator.comparing(str -> str.charAt(str.length() - 1)));
        System.out.println(minStr.get());

    }

    @Test
    public void testingStreamFiveF() {
        /** Stream allMatch() method
         Stream allMatch(Predicate predicate) returns whether all elements of the stream match the provided predicate.
         It may not evaluate the predicate on all elements if not necessary for determining the result.
         This is a short-circuiting terminal operation. A terminal operation is short-circuiting if,
         when presented with infinite input, it may terminate in finite time.
         Syntax: boolean allMatch(Predicate<? super T> predicate)
         Where, T is the type of the input to the predicate and the function returns true if all elements of the stream match the
         provided predicate, or the stream is empty, otherwise false.  If the stream is empty then true is returned and the
         predicate is not evaluated. Once any function is done using the stream it can’t be used again until it is re-initialised.              */
        // Driver code
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);
        // Check if all elements of stream are divisible by 3 or not using
        // Stream allMatch(Predicate predicate)
        boolean answer = list.stream().allMatch(n -> n % 3 == 0);
        // Displaying the result
        System.out.println("Are all element divisible by 3: " + answer);
        System.out.println();
        System.out.println();
        // Creating a Stream of Strings
        Stream<String> stream = Stream.of("Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");
        // Check if all elements of stream have length greater than 2 using
        // Stream allMatch(Predicate predicate)
        boolean ans = stream.allMatch(str -> str.length() > 2);
        // Displaying the result
        System.out.println("All length greater than 2: " + ans);
    }

    @Test
    public void testingStreamFiveG(){
        /** Stream allMatch() method                                                                                    */
        // Creating a Stream of Strings
        Stream<String> stream = Stream.of("Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");
        // Check if Character at 1st index is UpperCase in all strings or not, using
        // Stream allMatch(Predicate predicate)
        boolean ansOne = stream.allMatch(str-> Character
                .isUpperCase(str.charAt(0)));
        // Displaying the result
        System.out.println("All first letter Uppercase: " + ansOne);
        System.out.println();
        System.out.println();
        final String sample = "To God be the Glory";
        // converting to Ascii
        IntStream intstreams = sample.chars();//Chars() method of String class returns IntStream of unicode of all characters in the String object.
        // All match to check if all Ascii value greater than 100
        boolean ansTwo = intstreams.allMatch(c -> c > 100);
        System.out.println("All Unicode greater than 100: " + ansTwo);
        // Need to initialize the stream again to avoid runtime exception
        intstreams = sample.chars();  // Getting Ascii value for each character
        // All match to check if all Ascii value greater than 31
        ansTwo = intstreams.allMatch(c -> c > 31);
        System.out.println("All Unicode greater than 31: " + ansTwo);
        System.out.println();
        System.out.println();
        System.out.println("Printing the Unicodes...........");
        sample.chars().forEach(System.out::println);
    }

    @Test
    public void allMatchTestThree(){
        /** allMatch() function to check whether all strings have Uppercase character at 1st index.                         */
        Stream<String> stringStream = Stream.of("Geeks", "For", "GeeksQuix", "GeeksForGeeks");
        boolean result = stringStream.allMatch(str -> Character.isUpperCase(str.charAt(0)));
        if(result){
            System.out.println("All strings start with Uppercase Character at 1st index");
        }
        else {
            System.out.println("All strings do not have Uppercase Characters at 1st index");
        }
    }

    @Test
    public void allMatchTestFive(){
        Stream<String> stream = Stream.of("one", "two", "Three", "four");
        boolean match = stream.allMatch(s -> s.length() > 0 &&
                Character.isLowerCase(s.charAt(0)));
        System.out.println(match);
    }

    @Test
    public void allMatchTestSix(){
        //An Empty stream will return true
        boolean b = new ArrayList<>().stream()
                .allMatch(e -> false);  //May also try:  .allMatch(e -> e != null);
        System.out.println(b);
    }

    @Test
    public void testingStreamFiveH(){
        /** Stream anyMatch() method
        Stream anyMatch(Predicate predicate) method returns whether any elements of this stream match the provided predicate.
        It may not evaluate the predicate on all elements if not necessary for determining the result.
        This is a short-circuiting terminal operation. A terminal operation is short-circuiting if, when presented with infinite input,
        it may terminate in finite time.
        Syntax: boolean anyMatch(Predicate<? super T> predicate)
        Where, T is the type of the input to the predicate and the function returns true if any elements of the stream match the
        provided predicate, otherwise false.  If the stream is empty then false is returned and the predicate is not evaluated.                 */
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);
        // Stream anyMatch(Predicate predicate)
        boolean answer = list.stream().anyMatch(n
                -> (n * (n + 1)) / 4 == 5);
        // Displaying the result
        System.out.println(answer);
        System.out.println();
        System.out.println();
        // Creating a Stream of Strings
        Stream<String> stream = Stream.of("Geeks", "fOr",
                "GEEKSQUIZ", "GeeksforGeeks");
        // Check if Character at 1st index is UpperCase in any string or not, using
        // Stream anyMatch(Predicate predicate)
        answer = stream.anyMatch(str -> Character.isUpperCase(str.charAt(1)));
        // Displaying the result
        System.out.println(answer);
    }

    @Test
    public void anyMatchTestOne(){
        /** Stream anyMatch() method                                                                                        */
        Stream<String> stream
                = Stream.of("Geeks", "fOr", "GEEKSQUIZ",
                "GeeksforGeeks", "CSe");
        boolean answer = stream.anyMatch(str -> Character.isUpperCase(str.charAt(1))
                && Character.isLowerCase(str.charAt(2))
                && str.charAt(0) == 'f');
        System.out.println(answer);
    }

    @Test
    public void testingStreamFiveI(){
        /** Stream noneMatch() method
         The Stream noneMatch(Predicate predicate) method returns whether no elements of the stream match the provided predicate.
         It may not evaluate the predicate on all elements if not necessary for determining the result.
         This is a short-circuiting terminal operation. A terminal operation is short-circuiting if, when presented with infinite input,
         it may terminate in finite time. The noneMatch() method works opposite to Stream anyMatch() method.
         Syntax: boolean noneMatch(Predicate<? super T> predicate)
         Where, T is the type of the input to the predicate and the function returns true if no elements of the stream match the
         provided predicate, or the stream is empty, otherwise false.  If the stream is empty then true is returned and the
         predicate is not evaluated.                                                                                                    */
        // Creating a Stream of strings. Custom input strings are passed as arguments
        Stream<String> stream
                = Stream.of("CSE", "C++", "Java", "DS");
        // Now using Stream noneMatch(Predicate predicate)
        // and later storing the boolean answer as
        boolean answer
                = stream.noneMatch(str -> str.length() == 4);
        // Printing the boolean value on the console
        System.out.println("No element length is equal to 4: " + answer);
        System.out.println();
        System.out.println();
        // Creating a list of Integers using asList() of
        // Arrays class by declaring object of List
        List<Integer> list = Arrays.asList(4, 0, 6, 2);
        // Using Stream noneMatch(Predicate predicate) and
        // storing the boolean value
         answer = list.stream().noneMatch(num -> num < 0);
        // Printing and displaying the above boolean value
        System.out.println("No element is less than 0: " + answer);
    }

    @Test
    public void testingStreamFiveJ() {
        /** Stream noneMatch() method                                                                                         */
        // Creating a Stream of Strings using of() method
        // by creating object of Stream of string type
        Stream<String> stream
                = Stream.of("Geeks", "fOr", "GEEKSQUIZ",
                "GeeksforGeeks", "CSe");
        // Using Stream noneMatch(Predicate predicate)
        // and storing the boolean value
        boolean answer = stream.noneMatch(
                str -> Character.isUpperCase(str.charAt(1))
                        && Character.isLowerCase(str.charAt(2))
                        && str.charAt(0) == 'f');
        // Printing the above boolean value on console
        System.out.println(answer);
    }

    @Test
    public void noneMatchTestOne(){
        //Stream noneMatch() Method
        //noneMatch() of Stream class returns whether no elements of this stream match the provided predicate.
        //It may not evaluate the predicate on all elements if not necessary for determining the result.
        //This is a short-circuiting terminal operation.
        List<String> stringList = List.of("One", "Two", "Three", "Four");
        boolean result = stringList.stream().noneMatch(item -> item.length() < 2 && Character.isLowerCase(item.charAt(0)));
        System.out.println(result);
    }

    @Test
    public void testingStreamFiveK() {
        /** Stream generate() method
         Stream generate(Supplier<T> s) method returns an infinite sequential unordered stream where each element is generated by
         the provided Supplier. This is suitable for generating constant streams, streams of random elements, etc.
         Syntax: static <T> Stream<T> generate(Supplier<T> s)
         Where, Stream is an interface and T is the type of stream elements. s is the Supplier of generated elements,
         and the return value is a new infinite sequential unordered Stream.                                                    */
        // using Stream.generate() method
        // to generate 5 random Integer values
        Stream.generate(new Random()::nextInt)
                .limit(3).forEach(System.out::println);
        System.out.println();
        // using Stream.generate() method
        // to generate 8 random Double values
        Stream.generate(new Random()::nextDouble)
                .limit(3).forEach(System.out::println);
        System.out.println();
        Stream.generate(Math::random).limit(3).forEach(System.out::println);
        System.out.println();
        Stream.generate(() -> (int)(Math.random() * 100) + 1).limit(4).forEach(System.out::println);
    }

    @Test
    public void testingStreamPeekMethod(){
        /** Stream peek() method
         The Stream peek(Consumer action) returns a stream consisting of the elements of this stream.
         Additionally, performs the provided action on each element as elements are consumed from the resulting stream.
         This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline”.
         It is an intermediate operation, as it creates a new stream that, when traversed, contains the elements of the initial stream.
         Syntax: Stream<T> peek(Consumer<? super T> action)                                                                             */
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(System.out::println);
        //However, the code snippet above produces no output.  The reason peek() did not work in this example is that
        //it’s an intermediate operation, and we did not apply a terminal operation to the pipeline.
    }

    @Test
    public void testingStreamPeekMethodTwo(){
        /** Alternatively, we could have used forEach() with the same argument to get the desired behaviour:                            */
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(element -> System.out.println("Element passed: " + element )).forEach(System.out::println);
    }

    @Test
    public void testingStreamPeekMethodThree(){
        /** peek() method                                                                                                   */
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    @Test
    public void testingStreamPeekMethodFour(){
        /** On top of that, peek() can be useful in another scenario: when we want to alter the inner state of an element.
        For example, let’s say we want to convert all user’s name to lowercase before printing them.
        Alternatively, we could use map(), but peek() is more convenient since we don’t want to replace the elements.                                   */
        Stream<User> userStream = Stream.of(new User("ALICE", 33), new User("BOB", 79), new User("CHUCK", 16));
        userStream.peek(u -> u.setName(u.getName().toLowerCase()))
                .forEach(System.out::println);
        /**                   */
        System.out.println();
        //Adding elements to the list after the peek() has been called to see if the elements have been changed.
        userStream = Stream.of(new User("ALICE", 33), new User("BOB", 79), new User("CHUCK", 16));
        List<User> userList = userStream.peek(user -> user.setName(user.getName().toLowerCase())).collect(Collectors.toList());
        System.out.println(userList);
    }

    @Test
    public void testingStreamPeekMethodFive(){
        /** peek() method                                                                                                   */
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(0, 2, 4, 6, 8, 10);
        // Using peek with count() method,Method which is a terminal operation
        list.stream().peek(System.out::println).collect(Collectors.toList());  //count() is a terminal operation but does not cause peek() to display elements.
    }

    @Test
    public void testMapToIntMethod(){
        /** Stream mapToInt() method
         The Stream mapToInt(ToIntFunction mapper) returns an IntStream consisting of the results of applying the given function to
         the elements of this stream.  The Stream mapToInt(ToIntFunction mapper) is an intermediate operation. These operations are always lazy.
         Intermediate operations are invoked on a Stream instance, and after they finish their processing, they give a Stream instance as output.
         Syntax: IntStream mapToInt(ToIntFunction<? super T> mapper)
         Where, IntStream is a sequence of primitive int-valued elements and T is the type of stream elements.
         mapper is a stateless function which is applied to each element and the function returns the new stream.                               */
        // Creating a list of Strings
        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");
        // Using Stream mapToInt(ToIntFunction mapper)
        // and displaying the corresponding IntStream
        list.stream().mapToInt(num -> Integer.parseInt(num))
                .filter(num -> num % 3 == 0)
                .forEach(System.out::println);
        System.out.println();
        int[] intsArray = list.stream().mapToInt(Integer::parseInt).toArray(); //Or: mapToInt(num -> Integer.parseInt(num))
        Arrays.stream(intsArray).forEach(item -> System.out.print(item + " "));
    }

    @Test
    public void testMapToIntMethodTwo(){
        /** Stream mapToInt() method                                                                                            */
        // Creating a list of Strings
        List<String> list = Arrays.asList("Geeks", "for", "gfg",
                "GeeksforGeeks", "GeeksQuiz");
        // Using Stream mapToInt(ToIntFunction mapper)
        // and displaying the corresponding IntStream
        // which contains length of each element in
        // given Stream
        list.stream().mapToInt(str -> str.length()).forEach(System.out::println);
    }

    @Test
    public void testMapToDoubleMethod(){
        /** Stream mapToDouble() method
         Stream mapToDouble (ToDoubleFunction mapper) returns a DoubleStream consisting of the results of
         applying the given function to the elements of this stream. Stream mapToDouble (ToDoubleFunction mapper) is an intermediate operation.
         These operations are always lazy. Intermediate operations are invoked on a Stream instance, and after they finish their processing,
         they give a Stream instance as output.
         Syntax: DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
         Where, A sequence of primitive double-valued elements and T is the type of stream elements.  mapper is a
         stateless function which is applied to each element and the function returns the new stream.                                   */
        // Creating a list of Strings
        List<String> list = Arrays.asList("10", "6.548", "9.12",
                "11", "15");
        // Using Stream mapToDouble(ToDoubleFunction mapper)
        // and displaying the corresponding DoubleStream
        list.stream().mapToDouble(num -> Double.parseDouble(num))
                .filter(num -> (num * num) * 2 == 450)
                .forEach(System.out::println);
        System.out.println();
        // Creating a list of Strings
        list = Arrays.asList("CSE", "JAVA", "gfg",
                "C++", "C");
        // Using Stream mapToDouble(ToDoubleFunction mapper)
        // and displaying the corresponding DoubleStream
        // which contains square of length of each element in
        // given Stream
        list.stream().mapToDouble(str -> str.length() * str.length())
                .forEach(System.out::println);
    }

    @Test
    public void testMapToLongMethod(){
        /** Stream mapToLong() method
         The Stream mapToLong(ToLongFunction mapper) returns a LongStream consisting of the results of applying the given function to
         the elements of this stream. Stream mapToLong(ToLongFunction mapper) is an intermediate operation. These operations are always lazy.
         Intermediate operations are invoked on a Stream instance, and after they finish their processing, they give a Stream instance as output.
         Syntax: LongStream mapToLong(ToLongFunction<? super T> mapper)
         Where, LongStream is a sequence of primitive long-valued elements and T is the type of stream elements.
         mapper is a stateless function which is applied to each element and the function returns the new stream.                               */
        System.out.println("The stream after applying "
                + "the function is : ");
        // Creating a list of Strings
        List<String> list = Arrays.asList("25", "225", "1000",
                "20", "15");
        // Using Stream mapToLong(ToLongFunction mapper)
        // and displaying the corresponding LongStream
        list.stream().mapToLong(num -> Long.parseLong(num))
                .filter(num -> Math.sqrt(num) / 5 == 3 )
                .forEach(System.out::println);
        System.out.println();
        System.out.println("The square root of 225 is: " + Math.sqrt(225));
    }

    @Test
    public void testMapToLongMethodB(){
        /** Stream mapToLong() method                                                                                               */
        // Creating a list of Strings
        List<String> list = Arrays.asList("Data Structures", "JAVA", "OOPS",
                "GeeksforGeeks", "Algorithms");
        // Using Stream mapToLong(ToLongFunction mapper)
        // and displaying the corresponding LongStream
        // which contains the number of one-bits in
        // binary representation of String length
        list.stream().mapToLong(str -> Long.bitCount(str.length()))
                .forEach(System.out::println);
    }

    @Test
    public void testFlatMapToIntMethod(){
        /** Stream flatMapToInt() method
         The Stream flatMapToInt(Function mapper) returns an IntStream consisting of the results of replacing each element of
         this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
         Stream flatMapToInt(Function mapper) is an intermediate operation. These operations are always lazy. Intermediate operations are
         invoked on a Stream instance, and after they finish their processing, they give a Stream instance as output.
         Each mapped stream is closed after its contents have been placed into this stream. If a mapped stream is null,
         an empty stream is used instead.
         Syntax: IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper)
         Where, IntStream is a sequence of primitive int-valued elements and T is the type of stream elements.
         mapper is a stateless function which is applied to each element and the function returns the new stream.                               */
        // Java code for Stream flatMapToInt(Function mapper) to get an IntStream consisting of
        // the results of replacing each element of this stream with the contents of a mapped stream.
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        // Using Stream flatMapToInt(Function mapper)
        list.stream().flatMapToInt(num -> IntStream.of(Integer.parseInt(num))).
                forEach(System.out::println);
    }

    @Test
    public void testFlatMapToIntMethodB(){
        /** Stream flatMapToInt() method                                                                                            */
        // Java code for Stream flatMapToInt(Function mapper) to get an IntStream consisting of
        // the results of replacing each element of this stream with the contents of a mapped stream.
        // Creating a List of Strings
        List<String> list = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");
        // Using Stream flatMapToInt(Function mapper)
        // to get length of all strings present in list
        list.stream().flatMapToInt(str -> IntStream.of(str.length())).
                forEach(System.out::println);
        System.out.println();
        //Does the same thing as the above
        list.stream().mapToInt(str -> str.length())
                .forEach(System.out::println);
    }




    @Test
    public void testingStreamsSix(){
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
    public void testingStreamsSixB() {
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

