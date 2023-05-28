package genericclasses.lambdaexpressionsdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExpressionsDemoTests {
    //Lambda Expression added in Java 8, is an inline implementation of a functional interface.
    //From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface.
    //A lambda expression is a short block of code which takes in parameters and returns a value.
    //Lambda expressions are similar to methods, but they do not need a name, and they can be
    //implemented right in the body of a method.  Lambda expressions basically express instances of
    //functional interfaces (An interface with single abstract method) and implement the only abstract function and
    //therefore implement functional interfaces.

    @Test
    public void testingLambdaExpressions() {
        // lambda expression to implement User-defined Functional Interface "FunctionalInterface".
        // This interface by default implements abstractFunction() method.
        FunctionalInterface fInterObj = (int x) -> System.out.println(2 * x);
       // FunctionalInterface fInterObj = x -> System.out.println(2 * x);    //This line produces the same result.  We just omitted the parameter type.
                                                                            //Note that if parameter types can be inferred, they can be omitted.

        // This calls above lambda expression and prints 10.
        fInterObj.abstractFunction(5);
        fInterObj.normalFunction();
    }

    @Test
    public void testingLambdaExpressionsTwo(){
        List<Integer> integerList ;
        integerList = Arrays.asList(1, 3, 6, 7, 8, 5, 9, 4);
        integerList.stream().sorted().forEach(n -> System.out.println(n));
    }

    @Test
    public void testingLambdaExpressionsThree(){
        List<Integer> integerList = new ArrayList<>();
        integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Using lambda expression to print all element of integerList
        System.out.println("Printing all elements times 2: ");
        integerList.forEach(item -> System.out.print(item * 2 + "  "));
        System.out.println();
        // Using lambda expression to print uneven elements
        // of integerList
        System.out.println("Printing Uneven elements of the List: ");
        integerList.forEach(item -> {
            if(item % 2 == 1){
                System.out.println(item);
            }
        });
    }

    @Test
    public void testingLambdaExpressionsFour(){
        //Every object in Java has a type; the same is true of lambda expressions.
        //The type of lambda expression is any functional interface for which the lambda expression is an implementation.
        //Naming a lambda expression is done by using an appropriate functional interface as its type, like naming any other object.
        CalculatorInterface adder = (int a, int b) -> System.out.println(a + b);
        adder.calculate(3, 5);
    }

    //Defining a Static method that takes in a Lambda expression of type LambdaInt.
    //We define Lambda expression in the method below and pass it to this method as an argument.
    static void printMultiplier(LambdaInt lbInt){
        System.out.println(lbInt.lambdafunction(3, 4));
        //or
//        int result = lbInt.lambdafunction(3, 4);
//        System.out.println(result);
    }

    @Test
    public void testingLambdaExpressionsFive(){
       // Lambda expressions can be passed as an argument and used to evaluate expressions.
        LambdaInt multiplier = (int a, int b) -> a * b;
        LambdaInt adder = (a, b) -> a + b;

        printMultiplier(multiplier);   //Calling the Static method "printMultiplier" above and passing Lambda expression as an argument.
        printMultiplier(adder);    //Calling printMultiplier again and passing Lambda expression as an argument.

        //Getting Lambda from the method getLambdaSubstract() that returns a Lambda object
        LambdaInt substract = getLambdaSubstract();
        //Passing Lambda object as an argument to printMultiplier() method
        printMultiplier(substract);
    }

    @Test
    public void testingLambdaExpressionsSix(){
        LambdaInt lsum = (a, b) -> a + b;
        int sum = lsum.lambdafunction(9, 4);

        System.out.println("The sum is: " + sum);
    }

    //Defining a Static function that returns a Lambda expression of type LambdaInt.
    static LambdaInt getLambdaSubstract(){
        LambdaInt substraction = (a, b) -> a - b;
        return substraction;       //returning a Lambda expression as an object.
    }

    @Test
    public void testingLambdaExpressionSeven(){
        //Lambda expressions can be returned as a return object.
        LambdaInt substract = getLambdaSubstract();      //Calling the "getLambdaSubstract" method above that returns a Lambda expression of type LambdaInt.
        int result = substract.lambdafunction(9, 3);
        System.out.println("The result is: " + result);
    }
}
