package genericclasses.optionalDouble;

import org.junit.Test;

import java.io.IOException;
import java.util.OptionalDouble;

public class OptionalDoubleClassDemo {
    /** OptionalDouble class
     ** OptionalInt, OptionalLong and OptionalDouble Classes in Java
     An Optional is a container object which may or may not contain a non-null value.
     Java also has separate Optional classes for primitive values: int, long and double.
     •	OptionalInt is a container object which may or may not contain an int value.
     •	OptionalLong is a container object which may or may not contain a long value.
     •	OptionalDouble is a container object which may or may not contain a double value.
     We can use these classes in place of Optional<Integer>, Optional<Long> and Optional<Double> respectively.
     The methods and behaviours of all the three classes OptionalInt, OptionalLong and OptionalDouble are very similar.
     ** OptionalDouble class
     An OptionalDouble is a container object which may or may not contain a double value.
     It is a primitive double version of Optional class whereas Optional is an Optional class for Double Object.
     */
    @Test
    public void optionalDoubleClassTestOne() {
        /** of(double) method
         The of(double) method is used to get an OptionalDouble object which contains a double value which is passed as a parameter to this method.
         Syntax: public static OptionalDouble of(double value)
         Parameters: This method accepts a double value as parameter that will be set to the returned OptionalDouble object.
         Return value: This method returns an OptionalDouble with the value present.
         */
        // Create a OptionalDouble instance
        // using of() method
        OptionalDouble opDouble = OptionalDouble.of(4521.3246555d);
        // Print this OptionalDouble instance
        System.out.println("OptionalDouble: " + opDouble);
    }

    @Test
    public void optionalDoubleClassTestTwo() {
        /** empty() method
         The empty() method returns an empty OptionalDouble instance. No value is present for this OptionalDouble.
         So, we can say that this method help us to create empty OptionalDouble object.
         Parameters: This method accepts nothing.
         Return value: This method returns an empty OptionalDouble.
         */
        // create an OptionalDouble using empty method
        OptionalDouble opDouble = OptionalDouble.empty();
        // Print the created instance
        System.out.println("OptionalDouble: " + opDouble);
    }

    @Test
    public void optionalDoubleClassTestThree() {
        /** getAsDouble() method
         The getAsDouble() method returns a value if a value is present in the OptionalDouble object, otherwise throws NoSuchElementException.
         Parameters: This method accepts nothing.
         Return value: This method returns the value described by this OptionalDouble.
         Exception: This method throws NoSuchElementException if no value is present
         */
        // Create an OptionalDouble instance
        OptionalDouble opDouble = OptionalDouble.of(455.899);
        System.out.println("OptionalDouble: " + opDouble);
        // Get value in this instance using getAsDouble()
        System.out.println("Value in OptionalDouble = "
                + opDouble.getAsDouble());
    }

    @Test
    public void optionalDoubleClassTestFour(){
        try {
            // Create an OptionalDouble instance
            OptionalDouble opDouble = OptionalDouble.empty();
            System.out.println("OptionalDouble: " + opDouble);
            // Get value in this instance using getAsDouble()
            System.out.println("Value in OptionalDouble = "
                    + opDouble.getAsDouble());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void optionalDoubleClassTestFive() {
        /** isPresent() method
         The isPresent() method is used to check if a value is present in the OptionalDouble object or not.
         If a double value is present in this object, this method returns true, otherwise false.
         Syntax: public boolean isPresent()
         Parameters: This method accepts nothing.
         Return value: This method returns true if a double value is present, otherwise false.
         */
        // Java program to demonstrate OptionalDouble.isPresent() method
        // create an OptionalDouble
        OptionalDouble opDouble = OptionalDouble.of(1234.50059);
        // get value using isPresent()
        System.out.println("OptionalDouble has a value: "
                + opDouble.isPresent());
    }

    @Test
    public void optionalDoubleClassTestSix(){
        // create an OptionalDouble
        OptionalDouble opDouble = OptionalDouble.empty();
        // try to check that value is present or not
        boolean response = opDouble.isPresent();
        if (response)
            System.out.println("Value present");
        else
            System.out.println("Value absent");
    }

    @Test
    public void optionalDoubleClassTestSixB(){
        /** isEmpty() method
         The isEmpty() method of the OptionalDouble class is used to check if a value is present in this OptionalDouble instance.
         It returns false if the value is present otherwise returns true.
         It can be used as an alternative of isPresent() method which often needs to negate to check if value is not present.
         Please note: We can check value presence with isPresent as above or with isEmpty() methods.
         */
        OptionalDouble opDouble = OptionalDouble.of(345881.709);
        // Check value using isEmpty()
        System.out.println("OptionalDouble is empty: "
                + opDouble.isEmpty());
    }

    @Test
    public void optionalDoubleClassTestSixC() {
        OptionalDouble opDouble = OptionalDouble.empty();
        // Check value using isEmpty()
        System.out.println("OptionalDouble is empty: "
                + opDouble.isEmpty());
    }

    @Test
    public void optionalDoubleClassTestSeven(){
        /** ifPresent(DoubleConsumer action) method
         The ifPresent(DoubleConsumer action) method performs the specified DoubleConsumer action if the value of the OptionalDouble object is present.
         If a value is not present in this OptionalDouble, then this method does nothing.
         Syntax: public void ifPresent(DoubleConsumer action)
         Parameters: This method accepts a parameter action which is the action to be performed on this OptionalDouble if a value is present.
         Return value: This method returns nothing.
         Exception: This method throws NullPointerException if a value is present, and the given action is null.
         */
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.of(22347.771);
        // apply ifPresent(DoubleConsumer)
        opDouble.ifPresent((value) -> {
            value = value * 2;
            System.out.println("Value after modification: "
                    + value);
        });
    }

    @Test
    public void optionalDoubleClassTestEight(){
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.empty();
        // apply ifPresent(DoubleConsumer)
        opDouble.ifPresent((value) -> {      //Consumer will not execute as optionalDouble is empty.  //ifPresent() does nothing if value is absent.
            value = value * 2;
            System.out.println("Value after modification: "
                    + value);
        });
        System.out.println("As OptionalDouble is empty, the DoubleConsumer"
                + " is not executed");
    }

    @Test
    public void optionalDoubleClassTestNine(){
        /** orElse() method
         The orElse(double) method is used to get the value in this OptionalDouble object.
         If a value is not present in this OptionalDouble, then this method returns the double value passed as the parameter.
         Syntax: public double orElse(double other)
         Parameters: This method accepts a double value to be returned if no value is present.
         Return value: This method returns the value, if present, otherwise other.
         */
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.of(452.10044);
        // get value using orElse
        double value = opDouble.orElse(134.21);
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalDoubleClassTestTen() {
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.empty();
        // get value using orElse
        double value = opDouble.orElse(13.425);
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalDoubleClassTestEleven(){
        /** orElseGet()
         The orElseGet(DoubleSupplier supplier) method is used to get the value in this OptionalDouble object.
         If the value is not present in this OptionalDouble, then this method returns the
         result produced by the supplying function, passed as the parameter.
         Syntax: public double orElseGet(DoubleSupplier supplier)
         Parameters: This method accepts the supplying function that produces a value to be returned.
         Return value: This method returns the double value if present, otherwise the result produced by the supplying function.
         Exception: This method throw NullPointerException if no value is present, and the supplying function is null.
         */
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.of(21.341);
        // get value using orElseGet
        double value = opDouble.orElseGet(() -> getDoubleValue());
        // print value
        System.out.println("value: " + value);
    }
    //Defining a static method.  Used by the above test and the test below.
    public static double getDoubleValue() {
        return  897.09/2;
    }

    @Test
    public void optionalDoubleClassTestTwelve(){
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.empty();
        // get value using orElseGet
        double value = opDouble.orElseGet(() -> getDoubleValue());
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalDoubleClassTestThirteen(){
        /** orElseThrow(Supplier) method
         The orElseThrow(Supplier) method of OptionalDouble class is used to get the value contained by OptionalDouble instance.
         If a value is present, this method returns the value, otherwise, this method throws an exception produced by
         the exception supplying function. The exception Supplier function is passed as a parameter.
         */
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.of(2499.95);
        // apply orElseThrow(Supplier)
        double value = opDouble.orElseThrow(ArithmeticException::new);
        System.out.println("value " + value);
    }

    @Test
    public void optionalDoubleClassTestThirteenB(){
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.empty();
        // apply orElseThrow(Supplier)
        double value;
        try {
            value = opDouble.orElseThrow(IOException::new);   //It's a double value we are expecting, if there is no value, exception will be thrown.
            //value = opDouble.orElseThrow(() -> new IOException());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void optionalDoubleClassTestFourteen(){
        /** Java 10 introduced a simplified no-arg version of orElseThrow() method.
         In case of an empty Optional it throws a NoSuchElementException
         ** orElseThrow()
         The orElseThrow() method is used to get the double value in this OptionalDouble object.
         If the value is not present then this method will throw NoSuchElementException.
         Syntax: public double orElseThrow()
         Parameters: This method accepts nothing.
         Return value: This method returns the double value described by this OptionalDouble.
         Exception: This method throws NoSuchElementException if no value is present.
         */
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.of(12.345);
        // get value using orElseThrow()
        System.out.println("double value extracted using"
                + " orElseThrow() = "
                + opDouble.orElseThrow());
    }

    @Test
    public void optionalDoubleClassTestFifteen(){
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.empty();
        try {
            // try to get value from empty OptionalDouble
            double value = opDouble.orElseThrow();   //There is no value in the OptionalDouble object so, NoSuchElementException will be thrown.
        }
        catch (Exception e) {
            //System.out.println("Exception thrown: " + e);
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void optionalDoubleClassTestSixteen() {
        /** ifPresentOrElse()
         The ifPresentOrElse(DoubleConsumer, java.lang.Runnable) method is used to perform the specified DoubleConsumer action on
         the value of this OptionalDouble object. If a value is not present in this OptionalDouble, then this method performs the
         given empty-based Runnable emptyAction, passed as the second parameter.
         Syntax: public void ifPresentOrElse(DoubleConsumer action, Runnable emptyAction)
         Parameters: This method accepts two parameters:
         •	action: which is the action to be performed on this Optional if a value is present.
         •	emptyAction: which is the empty-based action to be performed if no value is present.
         Return value: This method returns nothing.
         Exception: This method throw NullPointerException if a value is present and the given action is null,
         or no value is present, and the given empty-based action is null.
         */
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.of(123.3);
        // apply ifPresentOrElse
        opDouble.ifPresentOrElse((value) -> {
                    System.out.println("Value is present : "
                            + value);
                },
                () -> {
                    System.out.println("OptionalDouble is empty");
                });
    }

    @Test
    public void optionalDoubleClassTestSixteenB() {
        // Java program to demonstrate OptionalDouble.ifPresentOrElse method
        // create a OptionalDouble
        OptionalDouble opDouble = OptionalDouble.empty();
        // apply ifPresentOrElse
        opDouble.ifPresentOrElse((value) -> {
                    System.out.println("Value is present: " + value);
                },
                () -> {
                    System.out.println("Optional is empty");
                });
    }

    @Test
    public void optionalDoubleClassTestSeventeen(){
        OptionalDouble opDouble = OptionalDouble.of(15.55);
        opDouble.ifPresentOrElse((value) -> {
            System.out.println("data exist: " + value);
        }, () -> {
            System.out.println("No Data in OptionalDouble");
        });
    }

    @Test
    public void optionalDoubleClassTestEighteen() {
        /** Creating a single element stream from an OptionalDouble
         Java 9 added a new method called stream(). If the OptionalDouble is not empty,
         it returns a sequential DoubleStream that has only that value, otherwise returns an empty DoubleStream.
         */
        OptionalDouble opDouble = OptionalDouble.of(554.502);
        opDouble.stream()
                .map(i -> i * 2)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Creating a stream on an empty OptionalDouble instance");
        opDouble = OptionalDouble.empty();
        opDouble.stream() //returns empty DoubleStream
                .map(i -> i * 3)
                .forEach(System.out::println);
    }
}
