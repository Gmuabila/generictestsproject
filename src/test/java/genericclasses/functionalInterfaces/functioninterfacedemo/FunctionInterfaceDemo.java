package genericclasses.functionalInterfaces.functioninterfacedemo;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionInterfaceDemo {
    /** Function Interface  ******
    The Java Function interface is one of the most central functional interfaces in Java.
    The Function interface represents a function (method) that accepts a single argument and returns a single value.
    It represents a function which takes in one parameter and produces a result.
    The argument and output (the return value) can be a different type.
    The most simple and general case of a lambda is a functional interface with
    a method that receives one value and returns another.
    The Function interface actually contains a few extra methods in addition to the apply() method,
    but since they all come with a default implementation, you do not have to implement these extra methods.
    The only method you have to implement in order to implement the Function interface is the apply() method.
     */

    @Test
    public void functionInterfaceTestOne(){
        Function<Long, Integer> adder = new AddThree();
        // AddThree adder = new AddThree(); // Will also work as the class AddThree implements Function Interface.
        Integer result = adder.apply(5L);
        System.out.println("Result: " + result);
        //First this example creates a new AddThree instance and assigns it to a Function variable.
        //Second, the example calls the apply() method on the AddThree instance. Third, the example prints out the result.
    }

    @Test
    public void functionInterfaceTestTwo(){
        //You can also implement the Function interface using Java lambda expression.
        Function<Long, Integer> adder = num -> num.intValue() + 3;   //or Integer.valueOf(num.intValue() + 3)
        Integer result = adder.apply(5L);
        System.out.println("Result: " + result);
        //As you can see, the Function interface implementation is now inline in the declaration of the adder Lambda variable,
        //rather than in a separate class. This is a bit shorter, plus we can see directly in the above code what it is doing.
    }

    @Test
    public void functionInterfaceTestThree(){
        //This example takes a String and returns the length of the string as Integer.
        Function<String, Integer> stringFunction = str -> str.length();
        Integer strLength = stringFunction.apply("Muabila");
        System.out.println("Name length: " + strLength);
    }

    @Test
    public void functionInterfaceTestFour(){
        Function<Integer, String> function = num -> {
            if (num % 2 == 0){
                return "The number entered " + "\"" + num + "\"" + " is even";
            }
            else {
                return "The number entered " + "\"" + num + "\"" + " is odd";
            }
        };
        System.out.println(function.apply(11));
    }

    @Test
    public void functionInterfaceTestFive(){
        //This example chains the Function with andThen() method.
        Function<String, Integer> function2 = str -> str.length();
        Function<Integer, Integer> function3 = num -> num * 2;
        Integer result = function2.andThen(function3).apply("Muabila");
        System.out.println("Result: " + result);
    }

    @Test
    public void functionInterfaceTestSix(){
        //This example accepts Function as an argument, converts a List into a Map
        //The Map will contain Strings and the length of the string as key-pair values.
        List<String> stringList = Arrays.asList("Banana", "Mango", "Apple", "Watermelon");
        Map<String, Integer> mapString = convertListToMap(stringList, str -> str.length());
        System.out.println(mapString);
    }
    private static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func){
        Map<T, R> resultMap = new HashMap<>();
        for (T item: list){
            resultMap.put(item, func.apply(item));
        }
        return resultMap;
    }

    @Test
    public void functionInterfaceTestEight(){
        //This example defines a Function which takes in a number and returns half of it
        Function<Integer, Double> half = num -> num / 2.0;  //Divide the number by a double value to get the correct double value.
        System.out.println(half.apply(11));              //You get the same result with: num -> Double.valueOf(num / 2.0);
    }

    @Test
    public void functionInterfaceTestNine(){
        //This example defines a Function which takes in a number and returns half of it
        //It then uses andThen() method to multiply the result of the function by 3.
        Function<Integer, Double> half = num -> num / 2.0;
        half = half.andThen(num -> num * 3);
        System.out.println(half.apply(11));
    }
}
