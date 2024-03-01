package genericclasses.functionalInterfaces.supplierInterface;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class SupplierInterfaceDemo {
    /** The Supplier Interface is a functional interfaces that does not take in any argument but produces a value of type T.
    Hence this functional interface takes in only one generic.  The Supplier Interface is a part of the java.util.function package which
     has been introduced since Java 8, to implement functional programming in Java.
     The lambda expression assigned to an object of Supplier type is used to define its get() method which eventually produces a value.
     Suppliers are useful when we don’t need to supply any value and obtain a result at the same time.  The Supplier interface consists of
     only one function, get().  This method does not take in any argument but produces a value of type T: T get().
     The Supplier Interface throws only unchecked exceptions.  One of the most frequent use cases of this interface is to
     defer the execution of some code.  The Optional class has a few methods that accept a Supplier as a parameter, such as Optional.or(),
     Optional.orElseGet().  So, the Supplier is executed only when the Optional is empty.
     The Java Supplier interface is a functional interface that represents a function that supplies a value of some sorts.
     It can also be thought of as a factory interface.                                                                                   */
    @Test
    public void supplierInterfaceTestOne() {
        Supplier<Double> randomValue = () -> Math.random();
        // Print the random value using get()
        System.out.println(randomValue.get());
        System.out.println();
        //This Java Supplier implementation returns a new Integer instance with a random value between 0 and 10000.
        Supplier<Integer> supplier = () -> (int) (Math.random() * 10000);
        System.out.println(supplier.get());
    }

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @Test
    public void supplierInterfaceTestTwo(){
        //This example uses Supplier to return a current date-time.
        Supplier<LocalDateTime> dateTimeSupplier = () -> LocalDateTime.now();
        LocalDateTime dateTimeNow = dateTimeSupplier.get();
        System.out.println(dateTimeNow);
        System.out.println("Formatted date: " + dtf.format(dateTimeNow));
        System.out.println();
        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();
        System.out.println(time2);
    }

}
