package genericclasses.functionalInterfaces.ToLongFunctionInterface;

import org.junit.Test;

import java.util.function.ToLongFunction;

public class ToLongFunctionInterfaceDemo {
    /** ToLongFunction Interface
     The ToLongFunction Interface represents a function which takes in an argument of type T and produces a long-valued result.
     This functional interface takes in only one generic, namely: T: denotes the type of the input argument to the operation.
     The lambda expression assigned to an object of ToLongFunction type is used to define its applyAsLong() method which
     eventually applies the given operation on its only argument. It is similar to using an object of type Function<T, Long>.
     The ToLongFunction interface has only one function: applyAsLong(). This method accepts an argument of type T and gives a long-valued result.
     Syntax: long applyAsLong(T value)
     Parameters: This method takes in one parameter value which is an argument of type T.
     Returns: This method returns a long-valued result.                                                                     */

    @Test
    public void testToLongFunctionInterface(){
        // Instantiating ToLongFunction
        ToLongFunction<Integer> ob = a -> a * 10000;
        // Applying the above function
        // using applyAsLong()
        System.out.println(ob.applyAsLong(3));
    }
}
