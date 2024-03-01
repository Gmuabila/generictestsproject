package genericclasses.functionalInterfaces.consumerinterfacedemo;

import genericclasses.functionalInterfaces.userdefinedfunctionalInterface.UserDefinedFunctionalInterfaceTests;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerInterfaceDemo{
    /** Consumer Interface
    The Consumer interface of the functional interface is one that accepts only one argument and
    does not return any value. The consumer interface has no return value. It returns nothing.
    It represents a function which takes in one argument and produces a result.
    The consumer interface contains an abstract accept() and a default andThen() methods.
    It can be used as the assignment target for a lambda expression or method reference.
    The lambda expression assigned to an object of Consumer type is used to define the accept() method which
    eventually applies the given operation on its argument. Consumer interfaces are useful when there is no need to
    return any value as they are expected to operate via side-effects.
     */
    @Test
    public void consumerInterfaceTestOne(){
        //Consumer Interface
        //Using Java's Consumer interface to store a lambda expression in a variable.
        //Lambda expressions can be stored in variables if the variable's type is an interface which has only one abstract method.
        //The lambda expression should have the same number of parameters and the same return type as that method.
        //Java has many of these kinds of interfaces built in, such as the Consumer interface (found in the java.util package) used by lists.

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);

        Consumer<Integer> method = item -> System.out.println(item);
        numbers.forEach(method);
        // numbers.stream().sorted().forEach(method);   //Can be used to sort the list
        System.out.println();
        method.accept(15);
    }

    @Test
    public void consumerInterfaceTestTwo(){
        //The lambda expression passed to the List.forEach method implements the Consumer functional interface:
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name));
    }

    @Test
    public void consumerInterfaceTestThree(){
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 20);
        ages.put("Smokey", 46);
        ages.put("Carl Right", 34);
        ages.put("Damien Mores", 89);

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }

    //Consumer Functional Interface can be used as the assignment target for a lambda expression or method reference.
    //In this example we are using the Consumer Interface as an assignment target for Method reference.
    //Defining two static methods for use in the next test
    public static void printMessage(String name){
        System.out.println("Printing message: " + name);
    }
    public static void printValue(int value){
        System.out.println("Printing value: " + value);
    }

    @Test
    public void consumerInterfaceTestFour(){
        // Referring method to String type Consumer interface
        Consumer<String> consumer1 = ConsumerInterfaceDemo::printMessage;   //Assigning Method reference to Consumer Interface object.
        consumer1.accept("John");   //Calling Consumer method
        // Referring method to Integer type Consumer interface
        Consumer<Integer> consumer2 = ConsumerInterfaceDemo::printValue;    //Assigning Method reference to Consumer Interface object.
        consumer2.accept(12);   //Calling Consumer method
    }

    @Test
    public void consumerInterfaceTestFive(){
        //Writing the above test with lambda expression
        Consumer<String> consumer1 = name -> System.out.println("Hello " + name);
        Consumer<Integer> consumer2 = num -> System.out.println(num);
        consumer1.accept("John");
        consumer2.accept(12);
    }
}

