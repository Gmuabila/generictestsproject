package genericclasses.systemLineseparatorMethod;

import org.junit.Test;

public class SystemLineSeparator {
    /** System.lineSeparator() method
     ------------------------------------------------------
     The lineSeparator() is a built-in method in Java which returns the system-dependent line separator string.
     It always returns the same value, the initial value of the system property line.separator.
     Syntax: public static String lineSeparator()
     Parameters: This method does not take any parameters.
     Return Values: In any UNIX systems, it will return “\n” or a positive integer; and on Windows systems it returns “\r\n” or a positive integer.
     Exception: It throws NullPointerException , if the string is null Below programs illustrate the System.lineSeparator() method:                 */
     //Program 1: To illustrate the working of static String lineSeparator() method.
    @Test
    public void lineSeparatorMethod() {
        String s = System.lineSeparator();
        for (char c : s.toCharArray()) {
            System.out.println((int)c);
        }
    }

    @Test
    public void lineSeparatorMethodB(){
        String s = System.lineSeparator();
        System.out.println("a");
        System.out.println("b");
        System.out.print(s);
        System.out.println("a");
        System.out.println("b");
        System.out.println("--------------------");
        System.out.print("a");
        System.out.print("b");
        System.out.print(s);
        System.out.print("a");
        System.out.print("b");
    }

    @Test
    public void lineSeparatorMethodC(){
        Integer x = 636;
        System.out.println(System.lineSeparator());
    }

}
