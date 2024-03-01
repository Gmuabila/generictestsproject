package genericclasses.breakAndContinueStatements;

import org.junit.Test;

public class BreakAndContinueStatements {
    /** Break and Continue statement
     The break and continue statements are the jump statements that are used to skip some statements inside the loop or terminate the
     loop immediately without checking the test expression. These statements can be used inside any loops such as for, while, do-while loop.
     Break:
     The break statement is used to terminate from the loop immediately. When a break statement is encountered inside a loop,
     the loop iteration stops there, and control returns from the loop immediately to the first statement after the loop. Basically,
     break statements are used in situations when we are not sure about the actual number of iteration for the loop, or we want to
     terminate the loop based on some condition.
     Syntax: break;
     A break statement is mainly used for:
     •	To exit a loop.
     •	Used as a “civilized” form of goto.
     •	Terminate a sequence in a switch statement.                                                                                                 */
    @Test
    public void testBreakStatement(){
        /** Using break to exit a loop
         Using break, we can force immediate termination of a loop, bypassing the conditional expression and any remaining code in the
         body of the loop. When we use break inside the nested loops, it will only break out of the innermost loop.                                 */
        // Initially loop is set to run from 0-9
        for (int i = 0; i < 10; i++) {
            // Terminate the loop when i is 5
            if (i == 5)
                break;
            System.out.println("i: " + i);
        }
        System.out.println("Out of Loop");
    }

    @Test
    public void testBreakStatementB() {
        /** Using break as a Form of Goto
         Java does not have a goto statement because it provides a way to branch in an arbitrary and unstructured manner.
         Java uses a label. A Label is used to identify a block of code.
         Syntax:
         label:
         {
         statement1;
         statement2;
         statement3;
         .
         .
         }
         Now, the break statements can be used to jump out of the target block. We cannot break to any
         label which is not defined for an enclosing block.                                                                                     */
        // First label
        first:
        for (int i = 0; i < 3; i++) {
            // Second label
            second:
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // Using break statement with label
                    break first;
                }
                System.out.println(i + " " + j);
            }
        }
    }

    @Test
    public void testBreakStatementC(){
        /** Using break to terminate a sequence in a switch statement
         The switch statement is a multi-way branch statement. It provides an easy way to dispatch execution to different parts of
         code based on the value of the expression. The break statement is used inside the switch to terminate a statement sequence.
         The break statement is optional. If omitted, execution will continue on into the next case.
         Syntax:
         switch (expression){
         case value1:
         statement1;
         break;
         case value2:
         statement2;
         break;
         .
         .
         case valueN:
         statementN;
         break;
         default:
         statementDefault;
         }                                                                                                                              */
        int i = 1;
        switch (i) {
            case 0:
                System.out.println("i is zero.");
                break;
            case 1:
                System.out.println("i is one.");
                break;
            case 2:
                System.out.println("i is two.");
                break;
            default:
                System.out.println("Invalid number");
        }
    }

    @Test
    public void testContinueStatement() {
        /** Continue
         The continue statement is used to skip the current iteration of a loop. We can use continue statement inside any
         types of loops such as for, while, and do-while loop. Basically, continue statements are used in the situations when
         we want to continue the loop but do not want the remaining statement after the continue statement.
         Syntax:
         continue;
         Using continue to continue a loop
         Using continue, we can skip the current iteration of a loop and jumps to the next iteration of the loop immediately.                   */
        for (int i = 0; i < 10; i++) {
            // If the number is 2
            // skip and continue
            if (i == 2)
                continue;
            System.out.print(i + " ");
            if (i == 5)
                continue;
            System.out.print("* ");
        }
    }

    @Test
    public void testContinueStatementB(){
        /** Using continue as a labelled continue statement
         The unlabeled continue statement is used to continue the innermost loop. However, since JDK 1.5 java introduces another
         feature known as labelled continue statement. We can use a labelled continue statement to continue the outermost loop.                         */
        // First label
        first:
        for (int i = 0; i < 3; i++) {
            // Second label
            second:
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // Using continue statement with label
                    continue first;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}
