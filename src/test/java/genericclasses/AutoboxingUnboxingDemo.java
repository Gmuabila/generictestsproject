package genericclasses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingUnboxingDemo {
    /*In Java, primitive data types are treated differently, so there comes the introduction of
    wrapper classes where two components play a role namely Autoboxing and Unboxing.
    Autoboxing refers to the conversion of a primitive value into an object of the corresponding wrapper class.
    This is called autoboxing. For example, converting int to Integer class.
    The Java compiler applies autoboxing when a primitive value is:
        •	Passed as a parameter to a method that expects an object of the corresponding wrapper class.
        •	Assigned to a variable of the corresponding wrapper class.

    Unboxing on the other hand refers to converting an object of a wrapper type to its corresponding primitive value.
    For example, conversion of Integer to int.
    The Java compiler applies to unbox when an object of a wrapper class is:
        •	Passed as a parameter to a method that expects a value of the corresponding primitive type.
        •	Assigned to a variable of the corresponding primitive type.
    Autoboxing and unboxing are the techniques that let us use primitive types and Wrapper class objects interchangeably, and
    we do not need to perform any typecasting explicitly.
     */

    @Test
    public void autoboxingDemo(){
        // Creating an empty Arraylist of integer type
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        // Adding the int primitives type values
        // using add() method
        // Autoboxing
        integerArrayList.add(1);  //Autoboxing in action, primitive values are being converted to Integer wrapper object before adding to the list.
        integerArrayList.add(2);
        integerArrayList.add(24);

        // Printing the ArrayList elements
        System.out.println("ArrayList: " + integerArrayList);

    }

    @Test
    public void unboxingDemo(){
        Integer intX = 10;
        Character charA = 'a';
        Boolean bool = true;

        int ax = intX;  //Unboxing now taking place.  The value of the object is assigned to primitive variable
        char aChar = charA;
        boolean boolB = bool;  //The value of boolean is always the same, either true of false, so no autoboxing or unboxing needed.
                               //Therefore, the same value will be passed.  To investigate further...

        System.out.println("Integer intX value is: " + intX);
        System.out.println("Character charA value is: " + charA);
        System.out.println("Boolean bool value is: " + bool);
        System.out.println();

        System.out.println("Assigning values of Wrapper object to primitive variables (Unboxing)......");
        System.out.println("integer ax value is: " + ax);
        System.out.println("char aChar value is: " + aChar);
        System.out.println("boolean boolB value is: " + boolB);


    }

    @Test
    public void addingWrapperObjectToListDemo(){
        //Neither Autoboxing or unboxing is applied here because the primitive values are
        // type cast to Integer wrapper object before being added to the list.
        List<Integer> integerList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            System.out.println(integerList.add(Integer.valueOf(i)));
            System.out.println(integerList);
        }
    }

    public int sumOfOddNumbers(List<Integer> intList){
        int sum = 0;

        for(Integer i: intList){
            if(i % 2 != 0){   //Unboxing in action
                sum += i;     //Unboxing in action
            }

        }

        return sum;
    }

    @Test
    public void testUnboxingAutoboxing(){
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i <= 10; i++){
           integerList.add(i);
        }
        int intSum = sumOfOddNumbers(integerList);
        System.out.println("The sum of Odd Numbers is: " + intSum);
    }

    /*Since you're now working with Wrapper objects, you can use certain methods to get information about
    the specific object.  For example, the following methods are used to get the value associated with the
    corresponding wrapper object: byteValue(), shortValue(), charValue(), intValue(), longValue(), floatValue(), doubleValue(),booleanValue().
     */

    @Test
    public void testGetWrapperObjectValue(){
        Integer intX = 27;
        Double doubleY = 122.55D;
        Character myChar = 'a';

        // To get the value, you can just print the object:
        System.out.println("The value of Integer is: " + intX);
        // Or you can use intValue() method as follows:
        System.out.println("The value of Integer is: " + intX.intValue());
        // You may as well print the value as a Double value as follows:
        System.out.println("Printing Integer as Double value: " + intX.doubleValue());
        System.out.println();

        // To get the value, you can just print the object:
        System.out.println("The value of Double is: " + doubleY);
        // Or you can use doubleValue() method as follows:
        System.out.println("The value of Double is: " + doubleY.doubleValue());
        // You may as well print the value as an Integer value as follows:
        System.out.println("Printing Double as Integer value: " + doubleY.intValue());
        System.out.println("Printing Character value: " + myChar);
    }

    /*Another useful method is the toString() method, which is used to convert wrapper objects to strings.
    In the following example, we convert an Integer to a String, and use the length() method of the
    String class to output the length of the "string":
     */
    @Test
    public void testToStringMethodOnWrapperObjects(){
        Integer intX = 2722;
        Double doubleY = 122.55D;
        Character myChar = 'a';

        String intString = intX.toString();
        System.out.println("Printing Integer \"IntX\" as a String: " + intString);
        System.out.println("Printing the length of the String: " + intString.length());

        System.out.println("Printing Character: " + myChar);

        String stringChar = myChar.toString();
        System.out.println("Printing Character converted to a String: " + stringChar);
        System.out.println("Printing the length: " + stringChar.length());

    }
}
