package zzzforgenerictests;

import org.junit.Test;

import java.util.Arrays;

public class ForGenericTests {
    //Use this class to test code that has do with access modifiers
    //Note that a class that has a package-private class is still accessible from a corresponding test package, this is why
    //this class has been created to perform such tests in order to get accurate result regarding access modifiers.

    @Test
    public void genericTestOne(){
//        int x = /;
//        if ((!((Integer) x instanceof Integer))){
//            System.out.println("Not an Integer");
//        }else {
//            System.out.println("An Integer");
//        }

        String[] strArr = new String[]{null, null};
        Arrays.stream(strArr)
                .filter(item -> item != null)
                .map(String::length)          //At this line there is no element in the stream so no NullPointerException will be thrown.
                .forEach(System.out::println);
    }
}
