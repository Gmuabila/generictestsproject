package genericclasses.functionalInterfaces.predicateinterfacedemo;

import java.util.function.Predicate;

//In the example, the predicate is used to filter integers.
//This is a Java class implementing the Predicate<Integer> interface.
//Its "test" method returns true for values less than five.
public class LessThanFive implements Predicate<Integer> {
    @Override
    public boolean test(Integer x){
        final Integer five = 5;
        return x < five;
    }
}
