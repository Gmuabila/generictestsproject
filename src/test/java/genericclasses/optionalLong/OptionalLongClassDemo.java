package genericclasses.optionalLong;

import org.junit.Test;

import java.io.IOException;
import java.util.OptionalLong;

public class OptionalLongClassDemo {
    /** OptionalLong class
     ** OptionalInt, OptionalLong and OptionalDouble Classes in Java
     An Optional is a container object which may or may not contain a non-null value.
     Java also has separate Optional classes for primitive values: int, long and double.
     •	OptionalInt is a container object which may or may not contain an int value.
     •	OptionalLong is a container object which may or may not contain a long value.
     •	OptionalDouble is a container object which may or may not contain a double value.
     We can use these classes in place of Optional<Integer>, Optional<Long> and Optional<Double> respectively.
     The methods and behaviours of all the three classes OptionalInt, OptionalLong and OptionalDouble are very similar.
     ** OptionalLong class
     An OptionalLong is a container object which may or may not contain a long value.
     It is a primitive long version of Optional class whereas Optional is an Optional class for long Object.
     */
    @Test
    public void optionalLongClassTestOne() {
        /** of(long) method
         The of(long) method is used to get an OptionalLong object which contains a long value which is passed as a parameter to this method.
         Syntax: public static OptionalLong of(long value)
         Parameters: This method accepts a long value as parameter that will be set to the returned OptionalLong object.
         Return value: This method returns an OptionalLong with the value present.
         */
        // Create a OptionalLong instance
        // using of() method
        OptionalLong opLong = OptionalLong.of(45213246);
        // Print this OptionalLong instance
        System.out.println("OptionalLong: "
                + opLong);
    }

    @Test
    public void optionalLongClassTestTwo() {
        /** empty() method
         The empty() method returns an empty OptionalLong instance. No value is present for this OptionalLong.
         So, we can say that this method help us to create empty OptionalLong object.
         Parameters: This method accepts nothing.
         Return value: This method returns an empty OptionalLong.
         */
        // create an OptionalLong using empty method
        OptionalLong optLong = OptionalLong.empty();
        // Print the created instance
        System.out.println("OptionalLong: " + optLong);
    }

    @Test
    public void optionalLongClassTestThree() {
        /** getAsLong() method
         The getAsLong() method returns a value if a value is present in the OptionalLong object, otherwise throws NoSuchElementException.
         Parameters: This method accepts nothing.
         Return value: This method returns the value described by this OptionalLong.
         Exception: This method throws NoSuchElementException if no value is present
         */
        // Create an OptionalLong instance
        OptionalLong optLong = OptionalLong.of(45);
        System.out.println("OptionalLong: " + optLong);
        // Get value in this instance using getAsLong()
        System.out.println("Value in OptionalLong = "
                + optLong.getAsLong());
    }

    @Test
    public void optionalLongClassTestFour(){
        try {
            // Create an OptionalLong instance
            OptionalLong optLong = OptionalLong.empty();
            System.out.println("OptionalLong: " + optLong);
            // Get value in this instance using getAsLong()
            System.out.println("Value in OptionalLong = "
                    + optLong.getAsLong());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void optionalLongClassTestFive() {
        /** isPresent() method
         The isPresent() method is used to check if a value is present in the OptionalLong object or not.
         If a long value is present in this object, this method returns true, otherwise false.
         Syntax: public boolean isPresent()
         Parameters: This method accepts nothing.
         Return value: This method returns true if a long value is present, otherwise false.
         */
        // Java program to demonstrate OptionalLong.isPresent() method
        // create a OptionalLong
        OptionalLong optLong = OptionalLong.of(123450059);
        // get value using isPresent()
        System.out.println("OptionalLong has a value: "
                + optLong.isPresent());
    }

    @Test
    public void optionalLongClassTestSix(){
        // create a OptionalLong
        OptionalLong opInt = OptionalLong.empty();
        // try to get that value is present or not
        boolean response = opInt.isPresent();
        if (response)
            System.out.println("Value present");
        else
            System.out.println("Value absent");
    }

    @Test
    public void optionalLongClassTestSixB(){
        /** isEmpty() method
         The isEmpty() method of the OptionalLong class is used to check if a value is present in this OptionalLong instance.
         It returns false if the value is present otherwise returns true.
         It can be used as an alternative of isPresent() method which often needs to negate to check if value is not present.
         Please note: We can check value presence with isPresent as above or with isEmpty() methods.
         */
        OptionalLong optLong = OptionalLong.of(345881709);
        // Check value using isEmpty()
        System.out.println("OptionalLong is empty: "
                + optLong.isEmpty());
    }

    @Test
    public void optionalLongClassTestSixC() {
        OptionalLong optLong = OptionalLong.empty();
        // Check value using isEmpty()
        System.out.println("OptionalLong is empty: "
                + optLong.isEmpty());
    }

    @Test
    public void optionalLongClassTestSeven(){
        /** ifPresent(LongConsumer action) method
         The ifPresent(LongConsumer action) method performs the specified LongConsumer action if the value of the OptionalLong object is present.
         If a value is not present in this OptionalLong, then this method does nothing.
         Syntax: public void ifPresent(LongConsumer action)
         Parameters: This method accepts a parameter action which is the action to be performed on this OptionalLong if a value is present.
         Return value: This method returns nothing.
         Exception: This method throws NullPointerException if a value is present, and the given action is null.
         */
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.of(22347771);
        // apply ifPresent(LongConsumer)
        opLong.ifPresent((value) -> {
            value = value * 2;
            System.out.println("Value after modification: "
                    + value);
        });
    }

    @Test
    public void optionalLongClassTestEight(){
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.empty();
        // apply ifPresent(LongConsumer)
        opLong.ifPresent((value) -> {      //Consumer will not execute as optionalLong is empty.
            value = value * 2;
            System.out.println("Value after modification: "
                    + value);
        });
        System.out.println("As OptionalLong is empty value"
                + " is not modified");
    }

    @Test
    public void optionalLongClassTestNine(){
        /** orElse() method
         The orElse(long) method is used to get the value in this OptionalLong object.
         If a value is not present in this OptionalLong, then this method returns the long value passed as the parameter.
         Syntax: public long orElse(long other)
         Parameters: This method accepts a long value to be returned if no value is present.
         Return value: This method returns the value, if present, otherwise other.
         */
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.of(45214610044l);
        // get value using orElse
        long value = opLong.orElse(134210003);
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalLongClassTestTen() {
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.empty();
        // get value using orElse
        long value = opLong.orElse(134211110063l);
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalLongClassTestEleven(){
        /** orElseGet()
         The orElseGet(LongSupplier supplier) method is used to get the value in this OptionalLong object.
         If the value is not present in this OptionalLong, then this method returns the
         result produced by the supplying function, passed as the parameter.
         Syntax: public long orElseGet(LongSupplier supplier)
         Parameters: This method accepts the supplying function that produces a value to be returned.
         Return value: This method returns the long value if present, otherwise the result produced by the supplying function.
         Exception: This method throw NullPointerException if no value is present, and the supplying function is null.
         */
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.of(213411188);
        // get value using orElseGet
        long value = opLong.orElseGet(() -> getLongValue());
        // print value
        System.out.println("value: " + value);
    }
    //Defining a static method.  Used by the above test and the test below.
    public static long getLongValue() {
        return 42 * 10000000;
    }

    @Test
    public void optionalLongClassTestTwelve(){
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.empty();
        // get value using orElseGet
        long value = opLong.orElseGet(() -> getLongValue());
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalLongClassTestThirteen(){
        /** orElseThrow(Supplier) method
         The orElseThrow(Supplier) method of OptionalLong class is used to get the value contained by OptionalLong instance.
         If a value is present, this method returns the value, otherwise, this method throws an exception produced by
         the exception supplying function. The exception Supplier function is passed as a parameter.
         */
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.of(2499955333l);
        // apply orElseThrow(Supplier)
        long value = opLong.orElseThrow(ArithmeticException::new);
        System.out.println("value " + value);
    }

    @Test
    public void optionalLongClassTestThirteenB(){
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.empty();
        // apply orElseThrow(Supplier)
        long value;
        try {
            value = opLong.orElseThrow(IOException::new);   //It's a long value we are expecting, if there is no value, exception will be thrown.
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void optionalLongClassTestFourteen(){
        /** Java 10 introduced a simplified no-arg version of orElseThrow() method.
         In case of an empty Optional it throws a NoSuchElementException
         ** orElseThrow()
         The orElseThrow() method is used to get the long value in this OptionalLong object.
         If the value is not present then this method will throw NoSuchElementException.
         Syntax: public long orElseThrow()
         Parameters: This method accepts nothing.
         Return value: This method returns the long value described by this OptionalLong.
         Exception: This method throws NoSuchElementException if no value is present.
         */
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.of(123451110990l);
        // get value using orElseThrow()
        System.out.println("long value extracted using"
                + " orElseThrow() = "
                + opLong.orElseThrow());
    }

    @Test
    public void optionalLongClassTestFifteen(){
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.empty();
        try {
            // try to get value from empty OptionalLong
            long value = opLong.orElseThrow();   //If there is no value to assign to the variable 'value', an exception will be thrown.
        }
        catch (Exception e) {
            System.out.println("Exception thrown: " + e);
            //e.printStackTrace();
        }
    }

    @Test
    public void optionalLongClassTestSixteen() {
        /** ifPresentOrElse()
         The ifPresentOrElse(LongConsumer, java.lang.Runnable) method is used to perform the specified LongConsumer action on
         the value of this OptionalLong object. If a value is not present in this OptionalLong, then this method performs the
         given empty-based Runnable emptyAction, passed as the second parameter.
         Syntax: public void ifPresentOrElse(LongConsumer action, Runnable emptyAction)
         Parameters: This method accepts two parameters:
         •	action: which is the action to be performed on this Optional if a value is present.
         •	emptyAction: which is the empty-based action to be performed if no value is present.
         Return value: This method returns nothing.
         Exception: This method throw NullPointerException if a value is present and the given action is null,
         or no value is present, and the given empty-based action is null.
         */
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.of(12333334400211l);
        // apply ifPresentOrElse
        opLong.ifPresentOrElse((value) -> {
                    System.out.println("Value is present : "
                            + value);
                },
                () -> {
                    System.out.println("OptionalLong is empty");
                });
    }

    @Test
    public void optionalLongClassTestSixteenB() {
        // Java program to demonstrate OptionalLong.ifPresentOrElse method
        // create a OptionalLong
        OptionalLong opLong = OptionalLong.empty();
        // apply ifPresentOrElse
        opLong.ifPresentOrElse((value) -> {
                    System.out.println("Value is present: " + value);
                },
                () -> {
                    System.out.println("Optional is empty");
                });
    }

    @Test
    public void optionalLongClassTestSeventeen(){
        OptionalLong optLong = OptionalLong.of(15);
        optLong.ifPresentOrElse((value) -> {
            System.out.println("data exist: " + value);
        }, () -> {
            System.out.println("No Data in OptionalLong");
        });
    }

    @Test
    public void optionalLongClassTestEighteen() {
        /** Creating a single element stream from an OptionalLong
         Java 9 added a new method called stream(). If the OptionalLong is not empty,
         it returns a sequential LongStream that has only that value, otherwise returns an empty LongStream.
         */
        OptionalLong opLong = OptionalLong.of(5);
        opLong.stream()
                .map(i -> i * 3)
                .forEach(System.out::println); //15
        System.out.println();
        System.out.println("Creating a stream on an empty OptionalLong instance");
        opLong = OptionalLong.empty();
        opLong.stream() //returns empty IntStream
                .map(i -> i * 3)
                .forEach(System.out::println);
    }
}
