package genericclasses.functionalInterfaces.predicateInterfacedemo;

import genericclasses.functionalInterfaces.predicateinterfacedemo.LessThanFive;
import genericclasses.functionalInterfaces.userdefinedfunctionalInterface.UserDefinedFunctionalInterfaceTests;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class predicateInterfaceTesting {
    /** Predicate functional interface
    The predicate is a functional interface that accepts one argument and returns a boolean value.
    It helps with manageability of code, aids in unit-testing, and provides various handy functions.
    With predicates, we can create code that is more clean and readable. Predicates also help to create better tests.
    Predicate in general meaning is a statement about something that is either true or false.
    Predicate in Java is defined in the java.util.Function package.
    Predicates in Java are implemented with interfaces. Predicate<T> is a generic functional interface representing a
    single argument function that returns a boolean value. Predicate contains a test(T t) method that evaluates the predicate on the given argument.

    In Java, we do not have standalone functions. Furthermore, methods are not first-class citizens. (They cannot be added to collections or
    passed to methods as parameters.) Therefore, we define interfaces and create objects from these interfaces.
    Such objects can be then passed to methods such as Iterables.filter.
    With Java lambdas it is much easier to work with predicates. */

    @Test
    public void predicateTestOne(){
        List<String> names = Arrays.asList("John", "Mark", "Carl", "Josh", "Micheal");
        List<String> result = names.stream().filter(name -> name.startsWith("J")).collect(Collectors.toList());
        assertEquals(2, result.size());
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Josh"));
        assertEquals(true, result.contains("John"));
        assertEquals(true, result.contains("Josh"));
        assertFalse(result.contains("Mark"));
    }

    @Test
    public void predicateTestTwo(){
        /** Multiple Filters
        If we wanted to apply multiple Predicates, one option is to simply chain multiple filters.*/
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        List<String> result = names.stream().filter(name -> name.startsWith("M")).filter(name -> name.length() > 4).collect(Collectors.toList());
        assertEquals(2, result.size());
        assertEquals(false, result.contains("Mike"));
        assertEquals(true, result.contains("Micheal"));
        assertEquals(true, result.contains("Monserat"));
        assertTrue(result.contains("Micheal"));
        assertTrue(result.contains("Monserat"));
        //We've filtered our list by extracting names that start with “M” and
        //have a length that is greater than 4.  We used two filters — one for each Predicate.
    }

    @Test
    public void predicateTestThree(){
        /** Complex Predicate
        Now, instead of using multiple filters, we can use one filter with a complex Predicate.*/
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        List<String> result = names.stream().filter(name -> name.startsWith("M") && name.length() > 4 || name.contains("y")).collect(Collectors.toList());
        assertEquals(3, result.size());
        assertTrue(result.contains("Micheal"));
        assertTrue(result.contains("Monserat"));
        assertEquals(false, result.contains("Jermain"));
        assertEquals(true, result.contains("Carney"));
        assertEquals(false, result.contains("Mike"));
        assertEquals(false, result.contains("Josh"));
        assertEquals(false, result.contains("John"));
        //We've filtered our list by extracting names that start with “M” and
        //have a length that is greater than 4, or names that contains "y".  We used One filter for all Predicates.
    }

    @Test
    public void predicateTestFour(){
        /** Combining Predicates
        //Next, if we don't want to build a complex Predicate using bitwise operations,
        //Java 8 Predicate has useful methods that we can use to combine Predicates.
        //We'll combine Predicates using the methods Predicate.and(), Predicate.or(), and Predicate.negate().

        Predicate.and()                                                                                     */
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        //We will define our Predicates explicitly, and then we'll combine them using Predicate.and()
        Predicate<String> predicate1 = name -> name.startsWith("M");
        Predicate<String> predicate2 = name -> name.length() > 4;
        List<String> result = names.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
        assertEquals(2, result.size());
        assertTrue(result.contains("Micheal"));
        assertTrue(result.contains("Monserat"));
        assertEquals(true, result.contains("Micheal"));
        assertEquals(true, result.contains("Monserat"));
        assertEquals(false, result.contains("Mike"));
        assertFalse(result.contains("Josh"));
    }

    @Test
    public void predicateTestFive(){
        /** Predicate.or()
        We can also use Predicate.or() to combine Predicates.                                                         */
        //Let's extract names start with “M”, as well as names with a length that's less than 5
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        Predicate<String> predicate1 = name -> name.startsWith("M");
        Predicate<String> predicate2 = name -> name.length() < 5;
        List<String> result = names.stream().filter(predicate1.or(predicate2)).collect(Collectors.toList());
        assertEquals(5, result.size());
        assertTrue(result.contains("Mike"));
        assertTrue(result.contains("Micheal"));
        assertTrue(result.contains("Josh"));
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Monserat"));
        assertEquals(true, result.contains("Josh"));
        assertEquals(false, result.contains("Carney"));
        assertFalse(result.contains("Jermain"));
    }

    @Test
    public void predicateTestFiveB(){
        //Predicate.and() & Predicate.or()
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        //We will define our Predicates explicitly, and then we'll combine them using Predicate.and(), and Predicate.or().
        Predicate<String> predicate1 = name -> name.startsWith("M");
        Predicate<String> predicate2 = name -> name.length() > 4;
        Predicate<String> predicate3 = name -> name.contains("y");
        List<String> result = names.stream().filter(predicate1.and(predicate2).or(predicate3)).collect(Collectors.toList());
        assertEquals(3, result.size());
        assertTrue(result.contains("Micheal"));
        assertTrue(result.contains("Monserat"));
        assertTrue(result.contains("Carney"));
        assertEquals(true, result.contains("Micheal"));
        assertEquals(true, result.contains("Monserat"));
        assertEquals(false, result.contains("Mike"));
        assertFalse(result.contains("Josh"));
    }

    @Test
    public void predicateTestSix(){
        /** Predicate.negate()                                                                                        */
        //Here, we will use a combination of or() and negate() to filter the List by names that start with “M” or
        //have a length that isn't less than 5.
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        Predicate<String> predicate1 = name -> name.startsWith("M");
        Predicate<String> predicate2 = name -> name.length() < 5;
        //Filtering for names that starts with "M" or names with length not less than 5.
        List<String> result = names.stream().filter(predicate1.or(predicate2.negate())).collect(Collectors.toList());
        assertEquals(5, result.size());
        assertTrue(result.contains("Carney"));
        assertTrue(result.contains("Micheal"));
        assertTrue(result.contains("Jermain"));
        assertTrue(result.contains("Monserat"));
        assertTrue(result.contains("Mike"));
        assertEquals(true, result.contains("Carney"));
        assertEquals(false, result.contains("Josh"));
        assertFalse(result.contains("John"));
    }

    @Test
    public void predicateTestSeven(){
        /** Combine Predicates Inline
        We don't need to explicitly define our Predicates to use and(), or(), and negate().
        We can also use them inline by casting the Predicate.  Only need to cast the first Predicate.                 */
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        List<String> result = names.stream().filter(((Predicate<String>) name -> name.startsWith("M"))
                .and(name -> name.length() < 5)).collect(Collectors.toList());
        assertEquals(1, result.size());
        assertTrue(result.contains("Mike"));
        assertEquals(false, result.contains("Josh"));
        assertEquals(true, result.contains("Mike"));
        assertFalse(result.contains("John"));
    }

    @Test
    public void predicateTestEight(){
        /** Combining a Collection of Predicates
        Finally, let's see how to chain a collection of Predicates by reducing them.
        In the following example, we have a List of Predicates that we combined using Predicate.and()                 */
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        List<Predicate<String>> allPredicates = new ArrayList<>();
        allPredicates.add(name -> name.startsWith("J"));
        allPredicates.add(name -> name.length() < 5);
        allPredicates.add(name -> name.contains("o"));
        List<String> result = names.stream().filter(allPredicates.stream().reduce(x -> true, Predicate::and)).collect(Collectors.toList());
        assertEquals(2, result.size());
        assertTrue(result.contains("Josh"));
        assertTrue(result.contains("John"));
        assertEquals(true, result.contains("John"));
        assertEquals(false, result.contains("Jermain"));
    }

    @Test
    public void predicateTestNine(){
        /** Note that in the above example we used our base identity as X -> true.
        But that will be different if we want to combine them using Predicate.or()                                  */
        List<String> names = List.of("Carney", "Micheal", "Josh", "Mike", "Jermain", "John", "Monserat");
        List<Predicate<String>> allPredicates = new ArrayList<>();
        allPredicates.add(name -> name.startsWith("J"));
        allPredicates.add(name -> name.length() < 5);
        allPredicates.add(name -> name.contains("o"));
        List<String> result = names.stream().filter(allPredicates.stream().reduce(x -> false, Predicate::or)).collect(Collectors.toList());
        assertEquals(5, result.size());
        assertTrue(result.contains("Josh"));
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Mike"));
        assertTrue(result.contains("Jermain"));
        assertTrue(result.contains("Monserat"));
        assertEquals(true, result.contains("John"));
        assertEquals(false, result.contains("Carney"));
    }

    //Defining methods below to show that Predicate Functional Interface can also be an assignment target for a Method reference.
    public static boolean startWithMethod(String name){
        return name.startsWith("A");
    }
    public static boolean sizeLessThanMethod(String name){
        return name.length() < 5;
    }

    @Test
    public void predicateTestTen(){
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        Predicate<String> predicate1 = predicateInterfaceTesting::startWithMethod;
        Predicate<String> predicate2 = predicateInterfaceTesting::sizeLessThanMethod;
        List<String> result = names.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
        System.out.println("Names that start with " + "\"" + "A" + "\"" + " and have length less than 5 are: " + result);
        System.out.println();
        List<String> result2 = names.stream().filter(predicate1).collect(Collectors.toList());
        System.out.println("Names that start with " + "\"" + "A" + "\"" + ": \n" + result2);
        System.out.println();
        List<String> result3 = names.stream().filter(predicate2).collect(Collectors.toList());
        System.out.println("Names that have length less than 5:\n" + result3);
        System.out.println();
        List<String> result4 = names.stream().filter(predicate1.or(predicate2)).collect(Collectors.toList());
        System.out.println("Name that start with " + "\"" + "A" + "\"" + " or have length less than 5:\n" + result4);
        assertTrue(result.contains("Adam"));
        assertEquals(1, result.size());
    }

    @Test
    public void predicateTestEleven(){
        List<Integer> nums = List.of(2, 3, 1, 5, 6, 7, 8, 9, 12);
       // Predicate<Integer> ltf = new LessThanFive();
        LessThanFive ltf = new LessThanFive();    //This is the same as the above as the class implements Predicate.
        nums.stream().filter(ltf).sorted().forEach(System.out::println);
    }

    //Java lambda expression simplifies the creation of Java Predicates.
    //In the above example we created a class to implement Predicate,
    //in the following example we use Lambda to simplify the code.
    //The example filters integer values; this time we use Java lambda expression,
    //which makes the code much shorter.
    @Test
    public void predicateTestTwelve(){
        List<Integer> nums = List.of(2, 3, 1, 5, 6, 7, 8, 9, 12);
        Predicate<Integer> ltf = num -> num < 5;
        nums.stream().filter(ltf).sorted().forEach(System.out::println);
    }
}
