package genericclasses.functionalInterfaces.userdefinedfunctionalInterface;

import genericclasses.functionalInterfaces.StringFuncInterface;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserDefinedFunctionalInterfaceTests {

    @Test
    public void testOne(){
        UserDefinedFInt<Long, Integer> adder = new UserDefinedFunctionalClass();  //Using the class to implement Functional Interface instead of Lambda.
        Integer result = adder.transform(5L);
        System.out.println("Result 1 is: " + result);
        System.out.println();
        UserDefinedFInt<Double, Long> multiply = new UserDefinedFIntMultiplyClass();  //Using the class to implement Functional Interface instead of Lambda.
        Long result2 = multiply.transform(7D);
        System.out.println("Result 2 is: " + result2);
    }

    @Test
    public void testTwo(){
        UserDefinedFInt<Long, Integer> multiply = x -> Integer.valueOf(x.intValue() * 10);  //or: Integer.valueOf((int)(x * 10));
        Integer result = multiply.transform(4L);
        System.out.println(result);
        UserDefinedFInt.display();
        multiply.displayOne();
    }

    //Defining Functional Interface 1
    public interface FuncInter1{
        int operation (int x, int y);
    }
    //Defining Functional Interface 2
    public interface FuncInter2{
        void sayMessage(String message);
    }
    //Defining a private method
    private int operate(int x, int y, FuncInter1 funcInter1Object){
        return funcInter1Object.operation(x, y);
    }
    //Defining a private method
    private void displayMessage(String message, FuncInter2 funcInter2Object){
        funcInter2Object.sayMessage(message);
    }

    @Test
    public void testThree(){
        // lambda expression for addition of two parameters
        FuncInter1 add = (a, b) -> a + b;
        // lambda expression for Multiplying two parameters
        FuncInter1 multiply = (a, b) -> a * b;
        FuncInter2 messager = str -> System.out.println(str);
        System.out.println("Result for addition is: " + operate(3, 7, add));
        System.out.println("Result for Multiplying is: " + operate(3, 7, multiply));
        displayMessage("Message to display", messager);
    }

    @Test
    public void testFour(){
        // lambda expression for addition of two parameters
        FuncInter1 add = (a, b) -> a + b;
        // lambda expression for Multiplying two parameters
        FuncInter1 multiply = (a, b) -> a * b;
        FuncInter2 messager = str -> System.out.println(str);
        // Creating an object of UserDefinedFunctionalInterfaceTest class to call both of
        // its methods "operate" and "displayMessage" with different implementations using lambda Expressions
        UserDefinedFunctionalInterfaceTests fObject = new UserDefinedFunctionalInterfaceTests();
        System.out.println("Addition result: " + fObject.operate(4, 6, add));
        System.out.println("Multiplication result: " + fObject.operate(4, 6, multiply));
        fObject.displayMessage("Message of the day: ", messager);
    }

    //The following method accepts a Lambda expression as a parameter.
    //The method is to be used in the below test
    public void printFormatted(String str, StringFuncInterface format){
        String result = (String)format.run(str);
        System.out.println(result);
    }
    @Test
    public void testFive(){
        StringFuncInterface<String, String> exclaim = str -> str + "!";
        StringFuncInterface<String, String> ask = str -> str + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);
    }

    @Test
    public void testSix(){
        MathFuncInterface<Integer, Long> add = (a, b) -> Long.valueOf(a + b);
        Long result = add.operate(4, 7);
        System.out.println("Add Result: " + result);
        MathFuncInterface<Double, Integer> mutiply = (a, b) -> Integer.valueOf(a.intValue() * b.intValue()); //or: Integer.valueOf((int)(a * b));
        Integer result2 = mutiply.operate(2D, 5D);
        System.out.println("Multiply Result: " + result2);
        MathFuncInterface<Integer, Double> divide = (a, b) -> Double.valueOf(a / b);
        Double result3 = divide.operate(15, 3);
        System.out.println("Divide Result: " + result3);
        MathFuncInterface<Long, Integer> substruct = (a, b) -> Integer.valueOf((int) (a - b));
        Integer result4 = substruct.operate(12L,6L);
        System.out.println("Substruct Result: " + result4);
    }
}
