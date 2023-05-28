package genericclasses;

import org.junit.Test;

public class ValueOfAndParseMethodsDemo {

    @Test
    public void testParseAndValueOfMethods(){
        int x = 2;
        char ch = 'b';
        long l = 55;
        float f = 77.9f;
        double d = 97.23d;
        String s = "111";

        Double y = Double.parseDouble(s); //Only takes a String as a parameter.  Returns a Double.
        String s1 = String.valueOf(l);
        String s2 = String.valueOf(d);
        String s3 = String.valueOf(ch);
        String d1 = Double.toString(d); //Just testing
        Integer int1 = Integer.parseInt(s); //Only takes a String, returns an Integer.
        Integer int2 = Integer.valueOf(s); //Only taking a String as parameter, and int.
        Double d2 = Double.valueOf(s); //Taking int, float, long, and String.
        Double d3 = Double.valueOf(x);
        Double d4 = Double.valueOf(l);
        Float f1 = Float.parseFloat(s); //Only taking a String as a parameter.
        Float f2 = Float.valueOf(x);  //Taking an int,
        float f3 = x; //Widening or implicit casting: smaller type to a larger type.  Applies to primitive types only.
        float f4 = l;
        int x1 = (int) l;  //Narrowing or explicit casting.  Converting larger type to smaller type.
        int x2 = (int) d;  //Again Narrowing or explicit casting.
        Double d5 = Double.valueOf(f);  //Converting wrapper class object to a compatible wrapper class type.



        System.out.println(d1);
        System.out.println(s2);
        System.out.println(d3);
        System.out.println(f3);
        System.out.println(f4);


    }
}
