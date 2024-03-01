package genericclasses.functionalInterfaces.ToIntFunctionInterface;

import org.junit.Test;

import java.util.function.ToIntFunction;

public class ToIntFunctionInterfaceDemo {
    /** ToIntFunction Interface
     The ToIntFunction Interface represents a function which takes in an argument of type T and produces an int-valued result.
     This functional interface takes in only one generic, namely: T: denotes the type of the input argument to the operation.
     The lambda expression assigned to an object of ToIntFunction type is used to define its applyAsInt() method which eventually applies the
     given operation on its only argument. It is similar to using an object of type Function<T, Integer>.
     The ToIntFunction interface has only one function: applyAsInt(). This method accepts an argument of type T and gives an int-valued result.
     Syntax: int applyAsInt(T value)
     Parameters: This method takes in one parameter value which is an argument of type T.
     Returns: This method returns an int-valued result.                                                                                         */
    @Test
    public void testToIntFunctionInterface(){
        // Instantiating ToIntFunction
        ToIntFunction<Double> ob = a -> (int) (a * 10);
        // Applying the above function
        // using applyAsInt()
        System.out.println(ob.applyAsInt(3.2));
    }
}
