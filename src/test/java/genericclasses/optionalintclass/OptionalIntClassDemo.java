package genericclasses.optionalintclass;

import org.junit.Test;

import java.io.IOException;
import java.util.OptionalInt;

public class OptionalIntClassDemo {
   /** OptionalInt, OptionalLong and OptionalDouble Classes in Java
    An Optional is a container object which may or may not contain a non-null value.
    Java also has separate Optional classes for primitive values: int, long and double.
            •	OptionalInt is a container object which may or may not contain an int value.
            •	OptionalLong is a container object which may or may not contain a long value.
            •	OptionalDouble is a container object which may or may not contain a double value.
    We can use these classes in place of Optional<Integer>, Optional<Long> and Optional<Double> respectively.
    The methods and behaviours of all the three classes OptionalInt, OptionalLong and OptionalDouble are very similar.
    ** OptionalInt class
    An OptionalInt is a container object which may or may not contain an int value.
    It is a primitive int version of Optional class whereas Optional is an Optional class for Integer Object.
     */
   @Test
   public void optionalIntTestOne() {
       /** empty() method
        The empty() method returns an empty OptionalInt instance. No value is present for this OptionalInt.
        So, we can say that this method help us to create empty OptionalInt object.
        Parameters: This method accepts nothing.
        Return value: This method returns an empty OptionalInt.
        */
       // create an OptionalInt using empty method
       OptionalInt opInt = OptionalInt.empty();
       // Print the created instance
       System.out.println("OptionalInt: " + opInt);
   }

   @Test
    public void optionalIntTestTwo(){
       /** of() method
        The of(int value) method help us to get an OptionalInt object which contains an int value which is passed as a parameter to this method.
        Parameters: This method accepts an int value as parameter that will be set to the returned OptionalInt object.
        Return value: This method returns an OptionalInt with the value present.
        */
       // Create a OptionalInt instance using of() method
       OptionalInt opInt = OptionalInt.of(45);
       // Get value of this OptionalInt instance
       System.out.println("OptionalInt: " + opInt);
   }

    @Test
    public void optionalIntTestThree() {
        /** getAsInt() method
         The getAsInt() method returns a value if a value is present in the OptionalInt object, otherwise throws NoSuchElementException.
         Parameters: This method accepts nothing.
         Return value: This method returns the value described by this OptionalInt.
         Exception: This method throws NoSuchElementException if no value is present
         */
        // Create an OptionalInt instance
        OptionalInt opInt = OptionalInt.of(45);
        System.out.println("OptionalInt: " + opInt);
        // Get value in this instance using getAsInt()
        System.out.println("Value in OptionalInt = "
                + opInt.getAsInt());
    }

    @Test
    public void optionalIntTestFour(){
        try {
            // Create an OptionalInt instance
            OptionalInt opInt = OptionalInt.empty();
            System.out.println("OptionalInt: " + opInt);
            // Get value in this instance using getAsInt()
            System.out.println("Value in OptionalInt = "
                    + opInt.getAsInt());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void optionalIntTestFive() {
        /** isPresent() method
         The isPresent() method help us to get the answer that int value is present in the OptionalInt object or not.
         If an int value is present in this object, this method returns true, otherwise false.
         Syntax: public boolean isPresent()
         Parameters: This method accepts nothing.
         Return value: This method returns true if an int value is present, otherwise false.
         */
        // Java program to demonstrate OptionalInt.isPresent() method
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.of(12345);
        // get value using isPresent()
        System.out.println("OptionalInt has a value: "
                + opInt.isPresent());
    }

    @Test
    public void optionalIntTestSix(){
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.empty();
        // try to get that value is present or not
        boolean response = opInt.isPresent();
        if (response)
            System.out.println("Value present");
        else
            System.out.println("Value absent");
    }

    @Test
    public void optionalIntTestSixB(){
        /** isEmpty() method
         The isEmpty() method of the OptionalInt class is used to check if a value is present in this OptionalInt instance.
         It returns false if the value is present otherwise returns true.
         It can be used as an alternative of isPresent() method which often needs to negate to check if value is not present.
         Please note: We can check value presence with isPresent as above or with isEmpty() methods.
         */
        OptionalInt opInt = OptionalInt.of(345);
        // Check value using isEmpty()
        System.out.println("OptionalInt is empty: "
                + opInt.isEmpty());
    }

    @Test
    public void optionalIntTestSixC() {
        OptionalInt optInt = OptionalInt.empty();
        // Check value using isEmpty()
        System.out.println("OptionalInt is empty: "
                + optInt.isEmpty());
    }

    @Test
    public void optionalIntTestSeven(){
        /** ifPresent(IntConsumer action) method
         The ifPresent(IntConsumer action) method performs the specified IntConsumer action if the value of the OptionalInt object is present.
         If a value is not present in this OptionalInt, then this method does nothing.
         Syntax: public void ifPresent(IntConsumer action)
         Parameters: This method accepts a parameter action which is the action to be performed on this OptionalInt if a value is present.
         Return value: This method returns nothing.
         Exception: This method throws NullPointerException if a value is present, and the given action is null.
         */
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.of(2234);
        // apply ifPresent(IntConsumer)
        opInt.ifPresent((value) -> {
            value = value * 2;
            System.out.println("Value after modification: "
                    + value);
        });
    }

    @Test
    public void optionalIntTestEight(){
        // create a OptionalInt
        OptionalInt opint = OptionalInt.empty();
        // apply ifPresent(IntConsumer)
        opint.ifPresent((value) -> {      //Consumer will not execute as optionalInt is empty.
            value = value * 2;
            System.out.println("Value after modification: "
                    + value);
        });
        System.out.println("As OptionalInt is empty value"
                + " is not modified");
    }

    @Test
    public void optionalIntTestNine(){
       /** orElse() method
        The orElse(int) method is used to get the value in this OptionalInt object.
        If a value is not present in this OptionalInt, then this method returns the int value passed as the parameter.
        Syntax: public int orElse(int other)
        Parameters: This method accepts an int value to be returned if no value is present.
        Return value: This method returns the value, if present, otherwise other.
        */
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.of(452146);
        // get value using orElse
        int value = opInt.orElse(13421);
        // print value
        System.out.println("value: " + value);
        }

    @Test
    public void optionalIntTestTen() {
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.empty();
        // get value using orElse
        int value = opInt.orElse(13421);
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalIntTestEleven(){
       /** orElseGet()
        The orElseGet(IntSupplier supplier) method is used to get the value in this OptionalInt object.
        If the value is not present in this OptionalInt, then this method returns the
        result produced by the supplying function, passed as the parameter.
        Syntax: public int orElseGet(IntSupplier supplier)
        Parameters: This method accepts the supplying function that produces a value to be returned.
        Return value: This method returns the int value if present, otherwise the result produced by the supplying function.
        Exception: This method throw NullPointerException if no value is present, and the supplying function is null.
        */
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.of(2134);
        // get value using orElseGet
        int value = opInt.orElseGet(() -> getIntValue());
        // print value
        System.out.println("value: " + value);
    }
    //Defining a static method.  Used by the above test and the test below.
    public static int getIntValue() {
        return 42 + 12;
    }

    @Test
    public void optionalIntTestTwelve(){
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.empty();
        // get value using orElseGet
        int value = opInt.orElseGet(() -> getIntValue());
        // print value
        System.out.println("value: " + value);
    }

    @Test
    public void optionalIntTestThirteen(){
        /** orElseThrow(Supplier) method
         The orElseThrow(Supplier) method of OptionalInt class used to get the value contained by OptionalInt.
         If a value is present, this method returns the value, otherwise, this method throws an exception produced by
         the exception supplying function. The exception Supplier function is passed as a parameter.
         */
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.of(24);
        // apply orElseThrow(Supplier)
        int value = opInt.orElseThrow(ArithmeticException::new);
        System.out.println("value " + value);
    }

    @Test
    public void optionalIntTestThirteenB(){
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.empty();
        // apply orElseThrow(Supplier)
        int value;
        try {
            value = opInt.orElseThrow(IOException::new);   //It's an int value we are expecting, if there is no value, exception will be thrown.
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void optionalIntTestFourteen(){
       /** Java 10 introduced a simplified no-arg version of orElseThrow() method.
        In case of an empty Optional it throws a NoSuchElementException
        ** orElseThrow()
        The orElseThrow() method is used to get the int value in this OptionalInt object.
        If the value is not present then this method will throw NoSuchElementException.
        Syntax: public Int orElseThrow()
        Parameters: This method accepts nothing.
        Return value: This method returns the int value described by this OptionalInt.
        Exception: This method throws NoSuchElementException if no value is present.
        */
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.of(12345);
        // get value using orElseThrow()
        System.out.println("int Value extracted using"
                + " orElseThrow() = "
                + opInt.orElseThrow());
    }

    @Test
    public void optionalIntTestFifteen(){
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.empty();
        try {
            // try to get value from empty OptionalInt
            int value = opInt.orElseThrow();   //If there is no value to assign to the variable 'value', an exception will be thrown.
        }
        catch (Exception e) {
            System.out.println("Exception thrown: " + e);
            //e.printStackTrace();
        }
    }

    @Test
    public void optionalIntTestSixteen() {
        /** ifPresentOrElse()
         The ifPresentOrElse(IntConsumer, java.lang.Runnable) method is used to perform the specified IntConsumer action on
         the value of this OptionalInt object. If a value is not present in this OptionalInt, then this method performs the
         given empty-based Runnable emptyAction, passed as the second parameter.
         Syntax: public void ifPresentOrElse(IntConsumer action, Runnable emptyAction)
         Parameters: This method accepts two parameters:
         •	action: which is the action to be performed on this Optional if a value is present.
         •	emptyAction: which is the empty-based action to be performed if no value is present.
         Return value: This method returns nothing.
         Exception: This method throw NullPointerException if a value is present and the given action is null,
         or no value is present, and the given empty-based action is null.
         */
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.of(12);
        // apply ifPresentOrElse
        opInt.ifPresentOrElse((value) -> {
                    System.out.println("Value is present : "
                            + value);
                },
                () -> {System.out.println("OptionalInt is empty");
                });
    }

    @Test
    public void optionalIntTestSixteenB() {
        // Java program to demonstrate OptionalInt.ifPresentOrElse method
        // create a OptionalInt
        OptionalInt opInt = OptionalInt.empty();
        // apply ifPresentOrElse
        opInt.ifPresentOrElse((value) -> {
                    System.out.println("Value is present: " + value);
                },
                () -> {
                    System.out.println("Optional is empty");
                });
    }

    @Test
    public void optionalIntTestSeventeen(){
        OptionalInt optInt = OptionalInt.of(15);
        optInt.ifPresentOrElse((value) -> {
            System.out.println("data exist: " + value);
        }, () -> {
            System.out.println("No Data in OptionalInt");
        });
    }

    @Test
    public void optionalIntTestEighteen() {
        /** Creating a single element stream from an OptionalInt
         Java 9 added a new method called stream(). If the OptionalInt is not empty,
         it returns a sequential IntStream that has only that value, otherwise returns an empty IntStream.
         */
        OptionalInt optionalInt = OptionalInt.of(5);
        optionalInt.stream()
                .map(i -> i * 3)
                .forEach(System.out::println); //15
        System.out.println();
        System.out.println("Creating a stream on an empty OptionalInt instance");
        optionalInt = OptionalInt.empty();
        optionalInt.stream() //returns empty IntStream
                .map(i -> i * 3)
                .forEach(System.out::println);
    }
}





