package genericclasses;

import org.junit.Test;

public class StackTraceDemo {
    //In simple terms, a stack trace is a list of method calls that the application was in the middle of when an Exception was thrown.
    //A stack trace is a very helpful debugging tool. It shows the call stack (meaning, the stack of functions that were called up to that point) at
    //the time an uncaught exception was thrown (or the time the stack trace was generated manually). This is very useful because it
    // doesn't only show you where the error happened, but also how the program ended up in that place of the code.
    //An Exception is what the runtime environment uses to tell you that an error occurred. When an error occurs,
    //Java will normally stop and generate an error message. The technical term for this is: Java will throw an
    //exception (throw an error).Popular examples are NullPointerException, IndexOutOfBoundsException or ArithmeticException.
    //Each of these are caused when you try to do something that is not possible. For example,
    //a NullPointerException will be thrown when you try to dereference a Null object:


    public static void stackTraceTestOne(){
        Object obj = null;
        System.out.println(obj.toString());  //this line throws a NullPointerException
    }

    public static void stackTraceTestTwo(){
        Object[] arrObj = new Object[5];
        System.out.println(arrObj[10]);  //this line throws an IndexOutOfBoundsException
    }

    @Test
    public void stackTraceTestThree(){
        int x = 3;
        int y = 0;
        System.out.println(x/y);     //this line throws an  ArithmeticException with the
                                     //message "/ by 0", because you are trying to
                                     //divide by 0, which is not possible.
    }

    //All the above methods throw exceptions.   Looking at the stack trace, we can determine exactly where the exception was thrown in the application.
    //If we start at the beginning of the list of "at ...", we can tell where our error happened.

    //Please note that what we're looking for is the topmost method call that is part of our application.

    @Test
    public void stackTraceMethodCalling(){
        StackTraceDemo.stackTraceTestOne();
        StackTraceDemo.stackTraceTestTwo();
    }

    @Test
    public void stackTraceTestFour(){
        //When dealing with String, if you want to use equals method I think it´s better to use the constant
        // on the left side of the comparison, like this:
        //Instead of:
        //if(firstName == null || firstName.equals(""))
        //return;
        //
        //Use:
        //if(("").equals(firstName))
        //This prevents the NullPointerException
        String str = "";
        if(("").equals(str)) {
            System.out.println("String is null");
        }
        else {
            System.out.println(str.toUpperCase());
        }

    }
}
