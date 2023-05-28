package genericclasses;

import org.junit.Test;

public class TernaryOperator {
    //Ternary Operator
    //Java ternary operator is the only conditional operator that takes three operands.
    // It’s a one-liner replacement for the if-then-else statement and is used a lot in Java programming.
    // We can use the ternary operator in place of if-else conditions or even switch conditions using nested ternary operators.
    // Although it follows the same algorithm as of if-else statement, the conditional operator takes less space and
    // helps to write the if-else statements in the shortest way possible.
    //Syntax:
    //variable = Expression1 ? Expression2: Expression3
    //If operates similarly to that of the if-else statement as in
    //Expression2 is executed if Expression1 is true else Expression3 is executed.
    //   if(Expression1){
    //      variable = Expression2;
    //   }
    //   else{
    //      variable = Expression3;
    //   }

    private int intX = 10;
    private int intY = 15;
    private int intMax = 0;

    @Test
    public void testingTernaryOperator(){
     intMax = (intX > intY) ? (intX + intY) : (intY - intX);

        System.out.println("Value of intX: " + intX);
        System.out.println("Value of intY: " + intY);
        System.out.println("Value of intMax: " + intMax);
    }

    @Test
    public void testingTernaryOperatorTwo(){
        intMax = (intY > intX) ? intY : intX;

        System.out.println("Value of intX: " + intX);
        System.out.println("Value of intY: " + intY);
        System.out.println("Value of intMax: " + intMax);
    }
}
