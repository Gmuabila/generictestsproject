package genericclasses;

import org.junit.Test;

public class UnaryNotOperatorDemo {

    @Test
    public void notOperatorDemo(){
        // Initializing variables
        boolean cond = true;
        int a = 10, b = 1;

        // Displaying values stored in above variables
        System.out.println("Cond is: " + cond);
        System.out.println("Var1 = " + a);
        System.out.println("Var2 = " + b);

        // Displaying values stored in above variables
        // after applying unary NOT operator
        System.out.println("Now cond is: " + !cond);
        System.out.println("!(a < b) = " + !(a < b));
        System.out.println("!(a > b) = " + !(a > b));

    }
}
