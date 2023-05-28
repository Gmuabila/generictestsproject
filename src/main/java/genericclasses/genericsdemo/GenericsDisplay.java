package genericclasses.genericsdemo;

//You can create a class in Java that defines one or more placeholders for data type.
//The placeholders are known as generics because the class is not determined until compile time.
//Generics are notated by angle brackets < >. For example, we might wish to create a class that contains a
//method that accepts an argument of any data type, and we must use a generic for the method argument data type.
//Generic means parameterised type. The idea is to allow type (Integer, String, … etc., and user-defined types) to be a
//parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types.
//For example, classes like HashSet, ArrayList, HashMap, etc., use generics very well.
public class GenericsDisplay <T>{
    void display (T argument){
        System.out.println("Your data: " + argument);
        System.out.println("Data Type: " + argument.getClass().getName());
    }
}
