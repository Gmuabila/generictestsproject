package genericclasses.doublecolonoperatordemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DoubleColonOperatorDemoTests {
        /*The :: operator (double colon operator) in java, also known as Method reference operator in Java,
    is used to call a method by referring to it with the help of its class directly.
    They behave exactly as the lambda expressions. The only difference it has from lambda expressions is that
    this uses direct reference to the method by name instead of providing a delegate to the method.
     */

    @Test
    public void printWithoutDoubleColonOperator(){
        //To print the elements of Stream without using double colon operator
        //To print all elements of the stream using Lambda expression
        Stream<String> s = Stream.of("Here", "We",
                                    "Go", "Again",
                                    "Mistery", "Victory");

        System.out.println("Printing Stream of Strings using Lambda expression:");
        s.forEach(item -> System.out.println(item));
        System.out.println();

    }

    @Test
    public void doubleColonOperatorTest2(){
        //To print the elements of Stream using double colon operator
        Stream<String> s = Stream.of("Here", "We", "Go", "Again", "Mistery", "Victory");

        System.out.println("Printing stream of Strings with double colon operator:");
        s.forEach(System.out::println);
        System.out.println();
    }

    @Test
    public void doubleColonOperatorTest3(){
        // Java code to show the use of double colon operator for "static methods"
        List<String> st = Arrays.asList("It's", "OK", "to be", "here", "forever");

        System.out.println("Printing a list of Strings using double colon operator:");
        st.forEach(DoubleColon::classFunction);
        System.out.println();
    }

    @Test
    public void doubleColonOperatorTest4(){
        // Java code to show use of double colon operator for "instance methods"
        List<String> st2 = Arrays.asList("Thanks", "For", "being there", "for me");
        //Stream<String> st3 = Stream.of("Thank you", "For", "being there", "for me"); //Also works with Streams
        DoubleColon dc = new DoubleColon();

        System.out.println("Printing list of Strings using double colon operator \nfor instance method:");
        st2.forEach((new DoubleColon())::instanceFunction);
        //st2.forEach(dc::instanceFunction);   //Also works when calling the method from the object.
        System.out.println();
    }

    @Test
    public void doubleColonOperatorTest5(){
        // Java code to show use of double colon operator for class constructor
        Stream<String> str = Stream.of("Hey", "It's all", "Good");
        // call the class constructor
        // using double colon operator
        str.forEach(DoubleColon::new);
    }
}
