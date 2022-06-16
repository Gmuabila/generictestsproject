package genericclasses.doublecolonoperatordemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DoubleColonOperatorDemoTests {

    @Test
    public void doubleColonOperatorTest(){
        //To print the elements of Stream without using double colon operator
        //To print all elements of the stream using Lambda expression
        Stream<String> s = Stream.of("Here", "We",
                                    "Go", "Again",
                                    "Mistery", "Victory");

        System.out.println("Printing Stream of String using Lambda expression:");
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
        st.forEach(DoubleColon::someFunction);
        System.out.println();
    }

    @Test
    public void doubleColonOperatorTest4(){
        // Java code to show use of double colon operator for "instance methods"
        List<String> st2 = Arrays.asList("Thanks", "For", "being there", "for me");
        DoubleColon dc = new DoubleColon();

        System.out.println("Printing list of Strings using double colon operator \nfor instance method:");
        st2.forEach((new DoubleColon())::instanceFunction);
        //st2.forEach(dc::instanceFunction);   //Also works when calling the method from the object.
        System.out.println();
    }
}
