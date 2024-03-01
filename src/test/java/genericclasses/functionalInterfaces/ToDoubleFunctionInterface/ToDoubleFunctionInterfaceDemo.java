package genericclasses.functionalInterfaces.ToDoubleFunctionInterface;

import org.junit.Test;

import java.util.function.ToDoubleFunction;

public class ToDoubleFunctionInterfaceDemo {
    /**
     * ToDoubleFunction Interface
     * The ToDoubleFunction Interface represents a function which takes in an argument of type T and produces a double-valued result.
     * This functional interface takes in only one generic, namely: T: denotes the type of the input argument to the operation
     * The lambda expression assigned to an object of ToDoubleFunction type is used to define its applyAsDouble() method which
     * eventually applies the given operation on its only argument. It is similar to using an object of type Function<T, Double>.
     * The ToDoubleFunction interface has only one function: applyAsDouble().  This method accepts an argument of type T and gives a double-valued result.
     * Syntax: double applyAsDouble(T value)
     * Parameters: This method takes in one parameter value which is an argument of type T.
     * Returns: This method returns a double-valued result.
     */
    @Test
    public void testToDoubleFunctionInterface() {

        ToDoubleFunction<Integer> ob = a -> a / 2;
        // using applyAsDouble()
        System.out.println(ob.applyAsDouble(3));
    }
}
