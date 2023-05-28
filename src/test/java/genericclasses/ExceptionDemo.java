package genericclasses;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class ExceptionDemo {
    //When executing Java code, different errors can occur: Coding errors made by the programmer,
    //errors due to wrong input, or other unforeseeable things.  When an error occurs, Java will normally stop and generate an error message.
    //The technical term for this is: Java will throw an exception (throw an error).
    //An Exception is an unexpected event, which occurs during the execution of a program at run time, that disrupts the
    //normal flow of the program’s instructions. Exceptions can be caught and handled by the program.
    //When an exception occurs within a method, it creates an object. This object is called the exception object.
    //The object contains information about the exception, such as the name and description of the exception and the state of
    //the program when the exception occurred.
    //Exception Handling is one of the effective means to handle runtime errors so that the regular flow of the application can be preserved.
    //Java Exception Handling is a mechanism to handle runtime errors such as ClassNotFoundException, IOException, SQLException, RemoteException, etc.

    //Errors
    //Errors represent irrecoverable conditions such as Java virtual machine (JVM) running out of memory, memory leaks, stack overflow errors,
    //library incompatibility, infinite recursion, etc. Errors are usually beyond the control of the programmer, and we should not try to handle errors.

    @Test
    public void exceptionTestOne() {
        //Methods to print the Exception information ********************
        //
        // 1. printStackTrace()
        //This method prints exception information in the format of Name of the exception: description of the exception, stack trace.
        int x = 3;
        int y = 0;
        try {
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Exception has been handled");
        }
    }

    @Test
    public void exceptionTestTwo() {
        // 2. toString()
        //This method prints exception information in the format of Name of the exception: description of the exception.
        int a = 5;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            //System.out.println(e.toString()); //Giving error: Unnecessary toString() call.  Remove redundant toString() call.
            System.out.println(e);
        }
    }

    @Test
    public void exceptionTestThree() {
        // 3. getMessage()
        //This method prints only the description of the exception.
        Object obj = null;
        try {
            System.out.println(obj.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void exceptionTestFour() {
        //getMessage() example 2.
        int x = 5;
        int y = 0;
        try {
            System.out.println(x / y);
        } catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Test
    public void exceptionTestFive() {
        //getMessage() example 3
        String str = null;
        try {
            System.out.println(str.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception has been handled");
        } finally {
            //Any code that absolutely must be executed after a try block completes is put in finally block.
            System.out.println("\nThis is the Finally block.");
        }
    }

    //How Does JVM handle an Exception?
    //Default Exception Handling
    //Whenever inside a method, if an exception occurs, the method creates an Object known as an Exception Object and hands it off to
    //the run-time system(JVM). The exception object contains the name and description of the exception and the current state of the program where
    //the exception has occurred. Creating the Exception Object and handing it to the run-time system is called throwing an Exception.
    //There might be a list of methods that had been called to get to the method where an exception occurred.
    //This ordered list of the methods is called Call Stack. Now the following procedure will happen.
    //
    //•	The run-time system searches the call stack to find the method that contains a block of code that can handle the occurred exception.
    //  The block of code is called an Exception handler.
    //•	The run-time system starts searching from the method in which the exception occurred and proceeds through the call stack in the
    //  reverse order in which methods were called.
    //•	If it finds an appropriate handler, then it passes the occurred exception to it. An appropriate Exception handler means
    //  the type of the exception object thrown matches the type of the exception object it can handle.
    //•	If the run-time system searches all the methods on the call stack and does not find the appropriate handler,
    //  then the run-time system handover the Exception Object to the default exception handler,
    //  which is part of the run-time system. This handler prints the exception information in the
    //  following format and terminates the program abnormally.

    //Let us see an example that illustrates how a run-time system searches for appropriate exception handling code on the call stack.
    //
    // Method 1
    // throws the Exception(ArithmeticException).
    // Appropriate Exception handler is not found within this method.
    static int divideByZero(int a, int b) {
        // this statement will cause ArithmeticException
        // (/by zero)
        int i = a / b;
        return i;
    }

    // The runTime System searches the appropriate Exception handler in this method also but couldn’t find
    // So, looking forward on the call stack
    static int computeDivision(int a, int b) {
        int res = 0;
        // Try block to check for exceptions
        try {
            res = divideByZero(a, b);
        }
        // Catch block to handle NumberFormatException
        // exception Doesn't match with ArithmeticException
        catch (NumberFormatException ex) {
            // Display message when exception occurs
            System.out.println(
                    "NumberFormatException occurred");
        }
        return res;
    }

    @Test
    public void exceptionTestSix() {
        // Found appropriate Exception handler. i.e., matching catch block.
        int a = 1;
        int b = 0;
        // Try block to check for exceptions
        try {
            int i = computeDivision(a, b);
        }
        // Catch block to handle ArithmeticException exceptions
        catch (ArithmeticException ex) {
            // getMessage() will print description
            // of exception(here / by zero)
            //System.out.println(ex.getMessage());
            ex.printStackTrace();  //Printing Stack Trace
        }
    }

    @Test
    public void exceptionTestSeven() {
        //Customized Exception Handling
        //Java exception handling is managed via five keywords: try, catch, throw, throws, and finally. Briefly, here is how they work.
        //Program statements that you think can raise exceptions are contained within a try block. If an exception occurs within the try block,
        //it is thrown. Your code can catch this exception (using catch block) and handle it in some rational manner.
        //System-generated exceptions are automatically thrown by the Java run-time system. To manually throw an exception, use the keyword throw.
        //Any exception that is thrown out of a method must be specified as such by a throws clause.
        //Any code that absolutely must be executed after a try block completes is put in finally block.
        //
        //The below code will throw an NullPointerException and JVM will terminate the program abnormally.
        //The statement System.out.println(“Hi, I want to execute”); will never execute. To execute it,
        //we must handle the exception using try-catch. Hence, to continue the normal flow of the program, we need a try-catch clause.
        String str = null;
        System.out.println(str.length());
        System.out.println("Hi, I want to execute");
    }

    @Test
    public void exceptionTestEight() {
        int[] intArr = new int[]{2, 7, 9, 3, 11};
        String str = null;
        try {
            System.out.println(intArr[5]);  //Once an exception is thrown in the try block, subsequents codes will not execute
            System.out.println("This code will not execute as the above statement throws an exception");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Array Exception handled");
        }
        try {                       //However, the code in the next try block will execute
            System.out.println(str.toUpperCase());
            System.out.println("This code also does not execute as the above throws an exception");
        } catch (NullPointerException n) {
            n.printStackTrace();
            //System.out.println(n.getMessage());
            System.out.println("NPE handled");
        } finally {
            System.out.println("\nFinally block ");  //Finally block always execute after try block
        }
    }

    @Test
    public void exceptionTestNine() {
        // Taking an array of size 4
        try {
            int[] arr = new int[4];
            // Now this statement will cause an exception
            int i = arr[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        // This statement will execute as it comes after the try-catch block
        System.out.println("Hi, I want to execute");
    }

    @Test
    public void exceptionTestTen() {
        //finally block
        //The finally block is optional. It always gets executed whether an exception occurred in try block or not.
        //If an exception occurs, then it will be executed after try and catch blocks. And if an exception does not occur,
        //then it will be executed after the try block. The finally block in java is used to
        //put important codes such as clean up code e.g., closing the file or closing the connection.
        //
        //Showing use of finally when an exception does not occur in the try block
        //No exception is throw here, the finally block will execute after the try block.
        try {
            int[] intArr = new int[]{11, 79, 29, 30, 5};
            System.out.println(Arrays.toString(intArr));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block. Stack Trace should not print this time as no exception is thrown");
        }
    }

    @Test
    public void exceptionTestEleven() {
        //Showing use of finally when an exception occurs in the try block
        //An exception is thrown here and the finally block will execute after the try and catch blocks.
        try {
            int[] intArr = new int[]{11, 79, 29, 30, 5};
            int x = intArr[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block should execute here after stack trace");
        }
        System.out.println("\nLast statement .....");
    }

    //throws keyword
    //throws is a keyword in Java which is used in the signature of a method to indicate that
    //this method might throw one of the listed type exceptions.
    //The caller to these methods has to handle the exception using a try-catch block.
    //
    //In a program, if there is a chance of raising an exception then the compiler will warn us about it,
    //and compulsorily we should handle that checked exception, Otherwise we will get compile time error saying
    //"unreported exception XXX must be caught or declared to be thrown". To prevent this compile time error,
    //we can handle the exception in two ways:
    // 1. By using try catch
    // 2. By using throws keyword
    //
    //We can use throws keyword to delegate the responsibility of the exception handling to
    //the caller (It may be a method or JVM) then the caller method is responsible to handle that exception.

    //This method might throw one of the listed type exceptions.
    public void fun() throws FileNotFoundException, ClassNotFoundException {
        System.out.println("Inside Fun()");
        throw new ClassNotFoundException("CNF exception has been thrown");
    }

    @Test
    public void exceptionTestTwelve() {
        try {
            fun();
        } catch (ClassNotFoundException e){
            System.out.println("CNF exception handled");
        }catch (FileNotFoundException e){
            System.out.println("FNF exception handled");
        }
        System.out.println("\nProvision to complete program execution");
    }
}


