package genericclasses.optionalclass;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class OptionalClassDemo {
    //*** Optional Class ***
    //Every Java Programmer is familiar with NullPointerException. It can crash your code and
    // is very hard to avoid without using too many null checks.  So, to overcome this,
    // Java 8 has introduced a new class Optional in java.util package.
    // Optional can help in writing a neat code without using too many null checks.
    /** Optional is a container object which may or may not contain a non-null value.
    This class has various utility methods to facilitate code to handle values as ‘available’ or  ‘not available’ instead of checking null values.
     A Container Object can store instances of any Java class. Optional allows an object to wrap those nullable values.
     Optional allows you to boost your methods and indicate that your method probably returns “empty” (and not null) values.
     For example, you can store a String , a Date , or an Integer in the container. When you retrieve an object,
     you must cast the object back to the required type before applying a type-specific method.
     */

    @Test
    public void optionalClassTestOne() {
        // Java program without Optional Class.  Will throw a NullPointerException.
        String[] words = new String[10];
        String word = words[5].toLowerCase();
        System.out.print(word);
    }

    @Test
    public void optionalClassTestTwo(){
        //To avoid abnormal termination as in the above code, we can use the Optional class, so our program can execute without crashing.
        String[] words = new String[10];
        //words[5] = "Stands";
        Optional<String> nullCheck = Optional.ofNullable(words[5]); //Putting words[5] in the container
        if(nullCheck.isPresent()){
            String wordFive = words[5].toUpperCase();
            System.out.println(wordFive);
        }else {
            System.out.println("words[5] is null.");
        }
    }
    /**Optional is a container object which may or may not contain a non-null value. You must import java.util package to use this class.
     If a value is present, isPresent() will return true and get() will return the value. Additional methods that depend on the presence or
     absence of a contained value are provided, such as orElse() which returns a default value if the value is not present,
     and ifPresent() executes a block of code if the value is present.
     */
    @Test
    public void optionalClassTestThree() {
        /** of(T value) and empty() Methods
         ** The of() method accepts a value as parameter of type T to create an Optional instance with this value and
         returns an instance of this Optional class with the specified value of the specified type.
         This method throws NullPointerException if the specified value is null.
         ** The empty() method returns an empty optional instance.  There are several ways of creating Optional objects.
         * To create an empty Optional object, we simply need to use its empty() static method.
         */
        // creating a string array
        String[] str = new String[5];
        // Setting value for element at index 2.
        str[2] = "Geeks Classes are coming soon";
        // It returns an empty instance of Optional class
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        assertFalse(empty.isPresent());
        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[2]);
        System.out.println(value);
        assertTrue(value.isPresent());
        System.out.println();
        // create an Optional
        Optional<Integer> op = Optional.of(9455);
        // print value
        System.out.println("Optional: " + op);
        // check for the value
        System.out.println("Is any value present: " + op.isPresent());
        Optional<String> valueTwo = Optional.of(str[1]);  //Throws a NullPointerException as the specified value is null.
    }

    @Test
    public void optionalClassTestThreeB(){
        /** The of() method throws NullPointerException if the specified value is null.
         */
        try {
            // create an Optional
            Optional<Integer> op = Optional.of(null);  //Throws a NullPointerException
            // print value
            System.out.println("Optional: " + op);
        }
        catch (Exception e) {
            System.out.println(e);
        }
}

    @Test
    public void optionalClassTestFour(){
        /** get(), isPresent(), and ofNullable() Methods
         ** The isPresent()
         The isPresent() method is used to find out if there is a value present in this Optional instance.
         If there is no value present in this Optional instance, then this method returns false, else true.
         ** The get()
         The get() method of the Optional class is used to get the value of this Optional instance.
         If there is no value present in this Optional instance, then this method throws NullPointerException.
         ** ofNullable()
         The ofNullable(T value) method accepts a value as parameter of type T to create an Optional instance with this value and returns an instance of
         this Optional class with the specified value of the specified type. If the specified value is null, then this method returns an
         empty instance of the Optional class. Use the method ofNullable() instead of the of() method in case you expect some null values.
         Syntax: public static <T> Optional<T> ofNullable(T value).
         */
        // creating a string array
        String[] str = new String[5];
        // Setting value for 2nd index
        str[2] = "Geeks Classes are coming soon";
        // It returns a non-empty Optional
        Optional<String> value = Optional.of(str[2]);  //Putting the value of str[2] in the container
        // It returns value of an Optional.
        // If value is not present, it throws
        // an NoSuchElementException
        System.out.println(value.get());
        // It returns hashCode of the value
        System.out.println(value.hashCode());
        // It returns true if value is present, otherwise false
        System.out.println(value.isPresent());
        System.out.println();
        //Throws NoSuchElementException if there is no value present
        Optional<String> valueTwo = Optional.ofNullable(str[1]);
        System.out.println(valueTwo.get());  //Throws a NoSuchElementException as the value is not present.
    }

    @Test
    public void OptionalClassTestFourB() {
        // Optional.isPresent() method
        Optional<Integer> optionalInteger = Optional.of(345);
        Optional<Integer> integerOpt = Optional.ofNullable(null);

        System.out.println("Is there a value in optionalInteger: " + optionalInteger.isPresent());
        System.out.println("\nThe Optional value is: " + optionalInteger);
        Integer integerValue = optionalInteger.get();
        System.out.println("\nPrinting optionalInteger value: " + integerValue);
        try {
            System.out.println("Is there any value in integerOpt: " + integerOpt.isPresent());
            System.out.println("\nPrinting a null Optional: " + integerOpt.get());  //Throws NoSuchElementException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void optionClassTestFiveB() {
        /** isEmpty()
         The isEmpty() method of the Optional class is used to check if a value is present in this Optional instance.
         It returns false if the value is present otherwise returns true.
         It can be used as an alternative of isPresent() method which often needs to negate to check if value is not present.
         Please note: We can check value presence with isPresent as above or with isEmpty() methods.
         */
        Optional<String> opt = Optional.of("Baeldung");
        assertFalse(opt.isEmpty());
        opt = Optional.ofNullable(null);
        assertTrue(opt.isEmpty());

        String name = null;
        System.out.println(!Optional.ofNullable(name).isPresent());
        System.out.println(Optional.ofNullable(name).isEmpty());
        name = "Joe";
        System.out.println(!Optional.ofNullable(name).isPresent());
        System.out.println(Optional.ofNullable(name).isEmpty());
    }


    @Test
    public void optionClassTestFive() {
        /**IfPresent() Method
         ** The ifPresent method of the Optional class is an instance method that performs an action if the class instance contains a value.
         This method takes in the Consumer interface's implementation whose "accept" method will be called with the value of
         the optional instance as the parameter to the "accept" method.
         The ifPresent() method enables us to run some code on the wrapped value if it’s found to be non-null.
         */
        Optional<String> opt = Optional.of("G Muabila");
        opt.ifPresent(name -> System.out.println(name.length()));  //This line will execute

        Optional<String> optTwo = Optional.ofNullable(null);
        optTwo.ifPresent(name -> System.out.println(name.length()));  //This line will not execute as the value in the container is null.
    }

    @Test
    public void optionalClassTestFive(){
        //The ifPresent() method enables us to run some code on the wrapped value if it’s found to be non-null.
        Consumer<String> stringConsumer = (s) -> System.out.println("The value stored in Optional object - " + s);
        String test = "hello-educative";
        Optional<String> stringOptional = Optional.ofNullable(test);
        System.out.println("When a value is present - ");
        stringOptional.ifPresent(stringConsumer);
        System.out.println("----------");
        test = null;
        System.out.println("When no value is present - ");
        stringOptional = Optional.ofNullable(test);
        stringOptional.ifPresent(stringConsumer);
    }

    @Test
    public void optionalClassTestFiveB(){
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();
        if (gender.isPresent()) {
            System.out.println("Value available.");
        } else {
            System.out.println("Value not available.");
        }
        gender.ifPresent(g -> System.out.println("In gender Option, value available."));
        //condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
    }

    @Test
    public void optionalClassTestSix() {
        /** orElse() method
         The orElse() method of the Optional class is used to get the value of this Optional instance if present.
         If there is no value present in this Optional instance, then this method returns the specified value.
         It is used to retrieve the value wrapped inside an Optional instance. It takes one parameter, which acts as a default value.
         The orElse() method returns the wrapped value if it’s present, or its argument otherwise.
         The orElse()method is great when you want to return a default value if the Optional is empty.
         */
        //Syntax
        //public T orElse(T value)
        //
        //Parameters: This method accepts value as a parameter of type T to return if there is no value present in this Optional instance.
        //Return value: This method returns the value of this Optional instance if present.
        //If there is no value present in this Optional instance, then this method returns the specified value.

        // create an Optional
        Optional<Integer> op = Optional.of(9455);
        // print value
        System.out.println("Optional: " + op);
        // orElse value
        System.out.println("Value by orElse" + "(100) method: "
                + op.orElse(100));
        System.out.println();
        op = Optional.ofNullable(null);
        System.out.println("Printing the optional with null value: " + op);
        try{
            System.out.println("Value by " + "orElse(100): " + op.orElse(200));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void optionalClassTestSeven() {
        //orElse() is great when you want to return a default value if the Optional is empty. Consider the following example:
        // return "Unknown User" if user is null
        User user = null;
        User finalUser = (user != null) ? user : new User(0, "Unknown User");
        System.out.println("User: " + finalUser);
        System.out.println();
        //Now, let’s see how we can write the above logic using Optional’s orElse() construct:
        // return "Unknown User" if user is null
        Optional<User> optionalUser = Optional.ofNullable(user);
        User finalUserTwo = optionalUser.orElse(new User(0, "Unknown User"));
        System.out.println("User with orElse: " + finalUserTwo);
    }

    @Test
    public void optionClassTestSevenB(){
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("john", name);
    }

    @Test
    public void optionalClassTestSevenC(){
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        System.out.println(gender.orElse("<N/A>")); //MALE
        System.out.println(emptyGender.orElse("<N/A>")); //<N/A>

        System.out.println(gender.orElseGet(() -> "<N/A>")); //MALE
        System.out.println(emptyGender.orElseGet(() -> "<N/A>")); //<N/A>
    }

    @Test
    public void optionalClassTestEight(){
        /** orElseGet(Supplier<? extends T> other)
         The orElseGet() method is used to get the value of this Optional instance if present.
         If there is no value present in this Optional instance, then this method returns the value generated from the specified supplier.
         It returns the value if present, otherwise invokes 'other' and returns the result of that invocation.
         Parameters: This method accepts a supplier as a parameter of type T to generate a value to return if there is no value present in
         this Optional instance.
         Return supplier: This method returns the value of this Optional instance if present. If there is no value present in this Optional instance,
         then this method returns the value generated from the specified supplier.
         Exception: This method throws NullPointerException if there is no value present in this Optional instance.
         */
        // create an Optional
        Optional<Integer> op = Optional.of(9455);
        // print supplier
        System.out.println("Optional: " + op);
        // orElseGet supplier
        System.out.println("Value by orElseGet"
                + "(Supplier) method: "
                + op.orElseGet(() -> (int)(Math.random() * 10)));
    }

    @Test
    public void optionalClassTestNine(){
        // Java program to demonstrate Optional.orElseGet() method
        // create an Optional
        Optional<Integer> op = Optional.empty();
        // print supplier
        System.out.println("Optional: " + op);
        try {
            // orElseGet supplier
            System.out.println("Value by orElseGet"
                    + "(Supplier) method: "
                    + op.orElseGet(
                    () -> (int)(Math.random() * 10)));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void optionalClassTestTen() {
        /** Returning default value using orElseGet()
         Unlike orElse(), which returns a default value directly if the Optional is empty,
         orElseGet()allows you to pass a Supplier function which is invoked when the Optional is empty.
         The result of the Supplier function becomes the default value of the Optional.
         */
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        User finalUser = optionalUser.orElseGet(() -> {
            return new User(0, "Unknown User");
        });
        System.out.println("user: " + user);
        System.out.println("Optional: " + optionalUser);
        System.out.println();
        System.out.println("Returned user: " + finalUser);
        assertEquals(new User(0, "Unknown User"), finalUser);
    }

    @Test
    public void optionalClassTestTenB(){
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals("john", name);
    }

    @Test
    public void optionalClassTestEleven(){
        /** orElseThrow (Supplier<? extends X> exceptionSupplier)
         The orElseThrow() method of Optional class in Java is used to get the value of this Optional instance if present.
         If there is no value present in this Optional instance, then this method throws the exception generated from the specified supplier.
         ** Parameters: This method accepts supplier as a parameter of type X to throws an exception if
         there is no value present in this Optional instance.
         Return supplier: This method returns the value of this Optional instance if present. If there is no value present in this Optional instance,
         then this method throws the exception generated from the specified supplier.
         Exception: This method throws NullPointerException if there is no value present in this Optional instance.
         */
        // create a Optional
        Optional<Integer> op = Optional.of(9455);
        // print supplier
        System.out.println("Optional: " + op);
        // orElseThrow supplier
        System.out.println(
                "Value by orElseThrow("
                        + "ArithmeticException::new) method: "
                        + op.orElseThrow(
                        ArithmeticException::new));
    }

    @Test
    public void optionalClassTestTwelve(){
        // Java program to demonstrate Optional.orElseThrow() method
        // create an Optional
        Optional<Integer> op = Optional.empty();
        // print supplier
        System.out.println("Optional: " + op);
        try {
            // orElseThrow supplier
            System.out.println(
                    "Value by orElseThrow("
                            + "ArithmeticException::new) method: "
                            + op.orElseThrow(
                            ArithmeticException::new));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void optionalClassTwelveB(){
            String nullName = null;
            String name = Optional.ofNullable(nullName).orElseThrow(
                    IllegalArgumentException::new);
    }

    //Same test as the test above, but the test below does not throw an exception as the test declares the exception is expected.
    @Test(expected = IllegalArgumentException.class)
    public void optionalClassTwelveC(){
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(
                IllegalArgumentException::new);
    }

    @Test
    public void optionalClassTwelveD(){
       /** Java 10 introduced a simplified no-arg version of orElseThrow() method.
            In case of an empty Optional it throws a NoSuchElementException
        */
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow();
    }

    @Test(expected = NoSuchElementException.class)     //Will not throw exception as above due to this declaration.
    public void optionalClassTwelveE(){
        /** Java 10 introduced a simplified no-arg version of orElseThrow() method.
         In case of an empty Optional it throws a NoSuchElementException
         */
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow();
    }

    /** Difference Between orElse() and orElseGet()                                                                    */
    //Let’s see and observe the side effects established both where orElse() and orElseGet() overlap and where they differ:
    public String getMyDefault() {
        System.out.println("Getting Default Value....");
        return "Default Value";
    }
    @Test
    public void optionalClassTwelveF(){
        String text = null;
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
        //The getMyDefault() method is called in each case. It so happens that when the wrapped value is not present,
        //then both orElse() and orElseGet() work exactly the same way.
    }

    @Test
    public void optionalClassTwelveG(){
        String text = "Text present";
        System.out.println("Using orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text present", defaultText);
        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text present", defaultText);
        //Notice that when using orElseGet() to retrieve the wrapped value, the getMyDefault() method is not even invoked since the
        //contained value is present.  However, when using orElse(), whether the wrapped value is present or not,
        //the default object is created. So, in this case, we have just created one redundant object that is never used.
        //In this simple example, there is no significant cost to creating a default object, as the JVM knows how to deal with such.
        //However, when a method such as getMyDefault() has to make a web service call or even query a database, the cost becomes very obvious.
    }

    @Test
    public void optionalClassTestThirteen() {
        /** The findFirst() method (of the Stream class)
         The findFirst() method of the Stream class returns an Optional describing the first element of this stream,
         or an empty Optional if the stream is empty. If the stream has no encounter order, then any element may be returned.
         It throws a NullPointerException if the element selected is null.
         */
        String[] words = new String[10];
        words[1] = "12";
        words[3] = "45";
        words[0] = null;
        System.out.println();
        try {
            Optional<String> wordCheck = Stream.of(words).findFirst();  //findFirst() will find the first element null and throw exception
            System.out.println("Printing optional: " + wordCheck);
            String wordResult = wordCheck.get();
            System.out.println();
            System.out.println("Value of Optional: " + wordResult);
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }

    @Test
    public void optionalClassTestFourteen(){
        /** filter(Predicate<? super <T> predicate)
         The filter() method of the Optional class is used to filter the value of this Optional instance by matching it with the given Predicate,
         and then return the filtered Optional instance. If there is no value present in this Optional instance,
         then this method returns an empty Optional instance.
         If a value is present and the value matches a given predicate, it returns an Optional describing the value,
         otherwise returns an empty Optional.
         Syntax: public Optional<T> filter(Predicate<T> predicate)
         Parameters: This method accepts predicate as parameter of type Predicate to filter an Optional instance with this.
         Return value: This method returns the filtered Optional instance. If there is no value present in this Optional instance,
         then this method returns an empty Optional instance.
         Exception: This method throws NullPointerException if the specified predicate is null.
         */
        // create an Optional
        Optional<Integer> op = Optional.of(9454);
        // print value
        System.out.println("Optional: " + op);
        // filter the value
        System.out.println("Filtered value " + "for odd or even: "
                + op.filter(num -> num % 2 == 0));     //The value of the Optional matches the Predicate, the Optional is returned
    }

    @Test
    public void optionalClassTestFourteenB(){
        // create an Optional
        Optional<Integer> op = Optional.of(9451);
        // print value
        System.out.println("Optional: " + op);
        // filter the value
        System.out.println("Filtered value " + "for odd or even: "
                + op.filter(num -> num % 2 == 0));    //The value of the Optional doesn't match the Predicate, an empty Optional is returned.
    }

    @Test
    public void optionalClassTestFourteenC(){
        // create an Optional
        Optional<Integer> op = Optional.empty();  //The Optional is empty, therefore an empty Optional is returned.
        // print value
        System.out.println("Optional: " + op);
        try {
            // filter the value
            System.out.println("Filtered value " + "for odd or even: "
                    + op.filter(num -> num % 2 == 0));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void optionalClassTestFourteenD(){
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        assertTrue(is2016);
        System.out.println("Value passed filter?: " + is2016);
        System.out.println();
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        assertFalse(is2017);
        System.out.println("Value passed filter?: " + is2017);
    }

    @Test
    public void optionalClassTestFourteenE(){
        //Let’s look at another meaningful example. Say we want to buy a modem, and we only care about its price.
        //We receive push notifications on modem prices from a certain site and store these in objects.
        //We then feed these objects to some code whose sole purpose is to check if the modem price is within our budget range.
        //Let’s now take a look at the code without Optional. See the method "priceIsInRange1" below this Unit Test.

        //Testing code without Optional.  Method: priceIsInRange1.
        assertTrue(priceIsInRange1(new Modem(10.0)));
        assertFalse(priceIsInRange1(new Modem(9.9)));
        assertFalse(priceIsInRange1(new Modem(null)));
        assertFalse(priceIsInRange1(new Modem(15.5)));
        assertFalse(priceIsInRange1(null));
        System.out.println("Price in range?: " + priceIsInRange1(new Modem(8.3)));
        System.out.println("Price in range?: " + priceIsInRange1(new Modem(15.0)));
        System.out.println("Price in range?: " + priceIsInRange1(new Modem(12.50)));
    }

    //Code without Optional:
    public boolean priceIsInRange1(Modem modem) {
        boolean isInRange = false;
        if (modem != null && modem.getPrice() != null && (modem.getPrice() >= 10 && modem.getPrice() <= 15)) {
            isInRange = true;
        }
        return isInRange;

        //Pay attention to how much code we have to write to achieve this, especially in the if condition.
        //The only part of the if condition that is critical to the application is the last price-range check;
        //the rest of the checks are defensive
    }

    //Code with Optional
    public boolean priceIsInRange2(Modem modem2) {
        return Optional.ofNullable(modem2).map(Modem::getPrice).filter(price -> price >= 10).filter(price -> price <= 15).isPresent();

        //The map() method call is simply used to transform a value to some other value. Keep in mind that this operation does not modify the
        //original value.  In our case, we are obtaining a price object from the Modem class.  First of all, if a null object is passed to this method,
        //we don’t expect any problem. Secondly, the only logic we write inside this body is exactly what the method name describes,
        //price-range check. Optional takes care of the rest.
    }

    @Test
    public void optionalClassTestFourteenF(){
        //Testing code with Optional.  Method: priceIsInRange2.
        assertTrue(priceIsInRange2(new Modem(10.0)));
        assertFalse(priceIsInRange2(new Modem(9.9)));
        assertFalse(priceIsInRange2(new Modem(null)));
        assertFalse(priceIsInRange2(new Modem(15.5)));
        assertFalse(priceIsInRange2(null));
        assertTrue(priceIsInRange2(new Modem(13.77)));
        System.out.println("Price in range?: " + priceIsInRange2(new Modem(8.3)));
        System.out.println("Price in range?: " + priceIsInRange2(new Modem(15.0)));
        System.out.println("Price in range?: " + priceIsInRange2(new Modem(12.50)));

        //The previous approach promises to check price range but has to do more than that to defend against its inherent fragility.
        //Therefore, we can use the filter() method to replace unnecessary if statements and reject unwanted values.
    }

    @Test
    public void optionalClassTestFourteenG(){
            List<Optional<String>> optionalList = Arrays.asList(
                    Optional.of("hello"),
                    Optional.empty(),
                    Optional.of("world"),
                    Optional.empty(),
                    Optional.of("welcome to JavaProgramTo.com blog"));
        System.out.println("Optional list: " + optionalList);
        System.out.println();
        List<Optional<String>> nonEmptyOptList = optionalList
                .stream()
                .filter(opt -> opt.isPresent())
                .collect(Collectors.toList());
        System.out.println("Non Empty Optional List: " + nonEmptyOptList);
        System.out.println();
            List<String> nonEmptyValuesList = optionalList
                    .stream()
                    .filter(o -> o.isPresent())
                    .map(Optional::get)
                    .collect(Collectors.toList());
            System.out.println("List of non empty values: " + nonEmptyValuesList);
    }

    @Test
    public void optionalClassTestFourteenH(){
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();
        //Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty
    }

    @Test
    public void optionalClassTestFifteen(){
        /** map(Function<? super T,? extends U> mapper)
         The map() method transforms the value contained in an Optional if present and returns a new Optional of the transformed value.
         If not present, it returns an empty Optional.
         If a value is present, applies the provided mapping function to it, and if the result is non-null, returns an Optional describing the result.
         Mapping function: is a strategy that starts with a collection of items and runs a function on each item individually to
         compute a new value for that item.
         */
        String str = "Muabila";
        Optional.ofNullable(str).map(x -> x.toUpperCase())
                .filter(x -> x.contains("A"))
                .ifPresent(x -> System.out.println("Name: " + x));
        System.out.println();
        System.out.print("Name: ");
        Optional.ofNullable(str).filter(x -> x.contains("a"))
                .map(String::toUpperCase)
                .ifPresent(System.out::println);
        System.out.println();
        Optional<String> stringOptional = Optional.ofNullable("value1");
        stringOptional.map(value -> value.concat("234"))
                .ifPresent(System.out::println);
        System.out.println();
        String result = " abc ";
        Optional<String> optionalStr = Optional.of(result);
        optionalStr.filter(str1 -> str1.contains("abc"))
                .map(String::trim)
                .ifPresent((str2) -> System.out.println(str2));
    }

    @Test
    public void optionalClassTestFifteenB(){
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional
                .map(List::size)
                .orElse(0);
        assertEquals(6, size);
        // In this example, we wrap a list of strings inside an Optional object and use its map method to perform an action on the contained list.
        // The action we perform is to retrieve the size of the list. The map method returns the result of the computation wrapped inside Optional.
        // We then have to call an appropriate method on the returned Optional to retrieve its value. Notice that the filter method simply
        // performs a check on the value and returns an Optional describing this value only if it matches the given predicate.
        // Otherwise, returns an empty Optional. The map method however takes the existing value, performs a computation using this value,
        // and returns the result of the computation wrapped in an Optional object
    }

    @Test
    public void optionalClassTestFifteenC(){
        String name = "baeldung";
        Optional<String> nameOptional = Optional.of(name);
        int length = nameOptional
                .map(String::length)
                .orElse(0);
        assertEquals(8, length);
    }

    @Test
    public void optionalClassTestFifteenD(){
        //We can chain map and filter together to do something more powerful.
        //Let’s assume we want to check the correctness of a password input by a user.
        //We can clean the password using a map transformation and check its correctness using a filter:
        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt
                .filter( pass -> pass.equals("password"))
                .isPresent();
        assertFalse(correctPassword);
        correctPassword = passOpt
                .map(String::trim)
                .filter(pass -> pass.equals("password"))
                .isPresent();
        assertTrue(correctPassword);
        //As we can see, without first cleaning the input, it will be filtered out.  Yet users may take for granted that
        //leading and trailing spaces all constitute input. So, we transform a dirty password into a clean one with a
        //map before filtering out incorrect ones.
    }

    //Class method to use with example below.


    @Test
    public void optionalClassTestSixteen(){
        /** flatMap(Function<? super T, Optional<U>> mapper)
         If a value is present, it applies the provided mapping function to it, returns that result,
         otherwise returns an empty Optional.
         In case when we have nested Optionals (Optional<Optional<String>>),we can use the flatMap() method to flatten the result and get the raw value.
         As you all know, the Optional object is a generic object, its data type can be any object, and therefore,
         we can meet the case that its data type is also an Optional object, such as: Optional<Optional<String>>.
         To resolve this problem, Java introduces us to the flatMap() method so that Optional’s data type is simpler: Optional<String> for example.
         Mapping function: is a strategy that starts with a collection of items and runs a function on each item individually to
         compute a new value for that item.
         */
        //Using map() method
        Example user = new Example();
        Optional<Example> optExample = Optional.ofNullable(user);
        System.out.println(optExample.map(x -> x.findName()));     //findName() method returns: "Optional.empty()".
        System.out.println();

        //Using flatMap() method
        Example userTwo = new Example();
        Optional<Example> optExTwo = Optional.ofNullable(userTwo);
        System.out.println(optExTwo.flatMap(x -> x.findName()));   //findName() method returns: "Optional.empty()".

        // The distinction between map() and flatMap() is noticed when the map() function is used to transform its input into Optional values.
        //The map() function would wrap the existing Optional values with another Optional,
        // whereas the flatMap() function flattens the data structure so that the values keep just one Optional wrapping.
        //flatMap() doesn't re-wrap the result in another Optional, so we're left with the original one.
        // This same behaviour can be used to unwrap optionals.
    }

    @Test
    public void optionalClassTestSixteenB(){
        // Here we create first one Optional instance optional1 with string value "Hello Java 8" and next we created another
        // Optional instance optional2 with optional1.  Now, optional2 has an optional value of optional1. optional2 type is Optional.
        // This is called Two levels nested Optional instance.
        Optional<String> optional1 = Optional.of("Hello Java 8");
        Optional<Optional<String>> optional2 = Optional.of(optional1);

        System.out.println("Optional1 value: " + optional1);
        System.out.println("Optional2 value : " + optional2);
        System.out.println();
        Optional<String> output = optional2.flatMap(value -> value.map(String::toLowerCase));
        System.out.println("output value : " + output);
        //After calling the flatMap() method we can see that output is converted into lowercase and removed the nested Optional.
    }

    @Test
    public void optionalClassTestSixteenC() {
        // Now creating a Three level nested Optional object. Checking if the string contains "Java 8" then
        // return Optional instance with content "Yes, Java 8 is found.".
        Optional<String> optional1 = Optional.of("Hello Java 8");
        Optional<Optional<String>> optional2 = Optional.of(optional1);
        Optional<Optional<Optional<String>>> optional3 = Optional.of(optional2);
        System.out.println("optional1 value: " + optional1);
        System.out.println("optional2 value: " + optional2);
        System.out.println("optional3 value: " + optional3);
        System.out.println();
        Optional<String> output = optional3.flatMap(value -> value.flatMap(v -> {
            if (v.get().contains("Java 8")) {
                return Optional.of("Yes, Java 8 is found.");
            }
            return Optional.empty();
        }));
        System.out.println("output value : " + output);
    }

    @Test
    public void optionalClassTestSixteenD(){
        Optional<String> nullOptional = Optional.ofNullable(null);
        Optional<String> output = nullOptional.flatMap(value -> Optional.of("No Value"));//flatMap() will find no value then returns empty optional.
        System.out.println("output value : " + output);
        System.out.println();

        //Using map() method
//        Optional<String> nullOpt = Optional.ofNullable(null);
//        Optional<String> outPut2 = nullOpt.map(value -> Optional.of("No value"));  //map() method won't work with empty optional this way. can only work
//        System.out.println("outPut2 value: " + outPut2);                          //if Optional assignment target type is changed to Object as there is
//        //no type described in the empty optional.  Note that the result will still be empty optional.
    }

    @Test
    public void optionalClassTestSixteenE(){
        //Let’s create a Student class that will contain one Optional field "address".
        Student student = new Student("John", "Smith", 8);
        Student student1 = new Student("Carl", "James", 11, Optional.of("St Rob Street, London"));
        student.setAddress(Optional.of("5th Avenue, New York"));
        Optional<Student> studentOptional = Optional.ofNullable(student);
        //Now, let’s try to get the address value using map() operation
        studentOptional
                .filter(s1 -> s1.getGrade() > 7) // returns Optional<Student>
                .map(s1 -> s1.getAddress()) // returns Optional<Optional<String>>
                .ifPresent(item -> System.out.println("ifPresent Print the item: " + item));
        //As you can see, the map() method received the Optional<Student> value as a parameter,
        //and it returned the value of the address field, which is actually an Optional.
        //So we got the Optional object in the output, not the actual value contained by it.
        System.out.println();
        //Let's try with flatMap()
        studentOptional
                .filter(s1 -> s1.getGrade() > 7) // returns Optional<Student>
                .flatMap(Student::getAddress) // returns Optional<String>
                .ifPresent(System.out::println);
        //We got the actual value in the output since the flatMap() operation flattened/unpacked the Optional parameter.
    }

    @Test
    public void optionalClassTestSixteenF(){
        List<Optional<String>> optionalStringList = Arrays.asList(
                Optional.of("hello"),
                Optional.empty(),
                Optional.of("world"),
                Optional.empty(),
                Optional.of("welcome to"),
                Optional.of("JavaProgram.com"));
        System.out.println("optionalStringList values : " + optionalStringList);
        List<String> nonEmptyValuesList = optionalStringList
                .stream()
                .flatMap(optional -> optional.isPresent() ? Stream.of(optional.get()) : Stream.empty())
                .collect(Collectors.toList());
        System.out.println("nonEmptyValuesList: " + nonEmptyValuesList);
        System.out.println();
        List<Optional<String>> nonEmptyOptionalList = optionalStringList
                .stream()
                .flatMap(opt -> opt.isPresent() ? Stream.of(opt) : Stream.empty())
                .collect(Collectors.toList());
        System.out.println("nonEmptyOptionalList: " + nonEmptyOptionalList);

        List<Optional<String>> nonEmptyOptList = optionalStringList
                .stream()
                .filter(opt -> opt.isPresent())
                .collect(Collectors.toList());
        System.out.println("Non Empty Optionals list: " + nonEmptyOptList);
        System.out.println();
        List<String> optValuesList = optionalStringList
                .stream()
                .filter(opt -> opt.isPresent())
                .map(opt -> opt.get())     //or: flatMap(opt -> Stream.of(opt.get()))
                .collect(Collectors.toList());
        System.out.println("optValuesList: " + optValuesList);
    }

    @Test
    public void optionalClassTestSixteenG(){
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOptionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOptionalGender
                .map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender
                .flatMap(gender -> gender.map(String::toUpperCase)));
        System.out.println();
        Optional<Optional<Optional<String>>> nonEmptyOptionalOptional = Optional.of(Optional.of(Optional.of("Female")));
        System.out.println("Optional.flaMap flatMap: " + nonEmptyOptionalOptional
                .flatMap(gender -> gender.flatMap(value -> value.map(String::toUpperCase))).orElse("Null"));
    }

    @Test
    public void optionalClassSixteenH(){
        /** Stream() method
         The stream() method of the Optional class is used to get the sequential stream of the only value present in this Optional instance.
         If there is no value present in this Optional instance, then this method returns an empty Stream.
         Syntax: public Stream<T> stream()
         Parameters: This method do not accept any parameter.
         Return value: This method returns the sequential stream of the only value present in this Optional instance.
         If there is no value present in this Optional instance, then this method returns an empty Stream.
         Note: Below programs require JDK 9 and above to execute.
         */
        // create an Optional
        Optional<Integer> op = Optional.of(9455);
        // print value
        System.out.println("Optional: " + op);
        // get the Stream
        System.out.println("Getting the Stream:");
        op.stream().forEach(System.out::println);
        System.out.println();
        // create a Optional
        op = Optional.empty();
        // print value
        System.out.println("Optional: " + op);
        try {
            // get the Stream
            System.out.println("Getting the Stream:");
            op.stream().forEach(System.out::println);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test
    public void optionalClassTestSeventeen(){
        /** ifPresentOrElse() method
         The ifPresentOrElse(Consumer, Runnable) method of java.util.Optional class is used to perform the specified Consumer action on
         the value of this Optional object. If a value is not present in this Optional,
         then this method performs the given empty-based Runnable,passed as the second parameter.
         Syntax: public void ifPresentOrElse(Consumer<T> action, Runnable emptyAction)
         Parameters: This method accepts two parameters:
         •	action: which is the action to be performed on this Optional if a value is present.
         •	emptyAction: which is the empty-based action to be performed if no value is present.
         Return value: This method returns nothing.
         Exception: This method throw NullPointerException if a value is present and the given action is null, or no value is present,
         and the given empty-based action is null.
         Note: As this method was added in Java 9, the programs need JDK 9 to execute.
         */
        // create a Optional
        Optional<Integer> op = Optional.of(9455);
        // print value
        System.out.println("Optional: " + op);
        // apply ifPresentOrElse
        op.ifPresentOrElse(value -> {
                    System.out.println("Value is present: "
                                    + value);
                },
                () -> {
                    System.out.println("Value is empty");
                });
    }

    @Test
    public void optionalClassTestSeventeenB(){
        // create a Optional
        Optional<Integer> op = Optional.empty();
        // print value
        System.out.println("Optional: " + op);
        try {
            // apply ifPresentOrElse
            op.ifPresentOrElse(value -> {
                System.out.println("Value is present: " + value);
                },
                    () -> {
                System.out.println("Value is empty");
            });
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void optionalClassTestEighteen(){
        /** equals(Object obj)
         The equals() method of Optional class is used to check for equality of this Optional with the specified Optional.
         This method takes an Optional instance and compares it with this Optional and returns a boolean value representing the same.
         Syntax: public boolean equals(Object obj)
         Parameter: This method accepts a parameter obj which is the Optional to be checked for equality with this Optional.
         Return Value: This method returns a boolean which tells if this Optional is equal to the specified Object.
         Exception: This method do not throw any Exception.
         */
        Optional<Integer> op1 = Optional.of(456);
        System.out.println("Optional 1: " + op1);
        Optional<Integer> op2 = Optional.of(456);
        System.out.println("Optional 2: " + op2);
        System.out.println("Comparing Optional 1"
                + " and Optional 2: "
                + op1.equals(op2));
        System.out.println();
        Optional<Integer> op3 = Optional.of(456);
        System.out.println("Optional 3: " + op3);
        Optional<Integer> op4 = Optional.empty();
        System.out.println("Optional 4: " + op4);
        System.out.println("Comparing Optional 3"
                + " and Optional 4: "
                + op3.equals(op4));
    }

    @Test
    public void optionalClassTestNineteen(){
        /** hashCode()
         The hashCode() method of the Optional class is used to get the hashCode value of this Optional instance.
         If there is no value present in this Optional instance, then this method returns 0.
         Syntax: public int hashCode()
         Parameter: This method does not accept any parameter.
         Return Value: This method returns the hashCode value of this Optional instance.
         If there is no value present in this Optional instance, then this method returns 0.
         Exception: This method does not throw any Exception.
         */
        Optional<Integer> op = Optional.of(456);
        System.out.println("Optional: " + op);
        System.out.println("Optional hashCode value: " + op.hashCode());
        System.out.println();
        Optional<Integer> opt = Optional.empty();
        System.out.println("Optional: " + opt);
        System.out.println("Optional hashCode value: "
                + opt.hashCode());
    }

    @Test
    public void optionalClassTestNineteenB(){
            // creating a string array
            String[] str = new String[5];
            // Setting value for 2nd index
            str[2] = "Geeks Classes are coming soon";
            // It returns a non-empty Optional
            Optional<String> value = Optional.of(str[2]);
            // It returns value of an Optional.
            // If value is not present, it throws
            // an NoSuchElementException
            System.out.println(value.get());
            // It returns hashCode of the value
            System.out.println(value.hashCode());
            // It returns true if value is present,
            // otherwise false
            System.out.println(value.isPresent());
    }

    @Test
    public void optionalClassTwenty(){
        /** toString()
         The toString() method of the Optional class is used to get the string representation of this Optional instance.
         Syntax: public String toString()
         Parameters: This method accepts nothing.
         Return value: This method returns the string representation of this Optional instance.
         Returns a non-empty string representation of this Optional suitable for debugging.
         */
        // create an Optional
        Optional<Integer> op = Optional.of(452146);
        // get value using toString
        String value = op.toString();
        // print value
        System.out.println("String Representation of the optional: "
                + value);
        System.out.println();
        // create a Optional
        Optional<Integer> opt = Optional.empty();
        // get value using toString
        String val = opt.toString();
        // print value
        System.out.println("String Representation of empty optional: "
                + val);
    }
}
