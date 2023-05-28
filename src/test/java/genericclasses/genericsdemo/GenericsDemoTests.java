package genericclasses.genericsdemo;

import org.junit.Test;

import java.util.Date;

public class GenericsDemoTests {

    @Test
    public void genericTestOne(){
        GenericsDisplay<String> genericsDisplayString = new GenericsDisplay<>();
        genericsDisplayString.display("Hello Generics");
        GenericsDisplay<Date> genericsDisplayDate = new GenericsDisplay<>();
        genericsDisplayDate.display(new Date());
        GenericsDisplay<Integer> intX = new GenericsDisplay<>();
        intX.display(115);
        GenericsDisplay<Double> genericsDisplaydouble = new GenericsDisplay<>();
        genericsDisplaydouble.display(814.55);
    }

    @Test
    public void genericsTestTwo(){
        GenericsDemo<String, Boolean> genDemo = new GenericsDemo<>("Silver", true, 44.7, "Odeon");
        System.out.println(genDemo);
        System.out.println("The value of double field is: " + genDemo.getDb());
        System.out.println("The value of obj is: " + genDemo.getObj());
        System.out.println("The value of obj2 is: " + genDemo.getObj2());
        System.out.println("The value of str is: " + genDemo.getStr());
        System.out.println();
        //Setting the values of db and obj2 fields
        System.out.println("Setting the values of db and obj2 fields.......");
        genDemo.setDb(25D);
        genDemo.setObj2(false);
        System.out.println("Displaying the object with new values: ");
        System.out.println(genDemo);
        System.out.println();
        System.out.println("The value of obj is: " + genDemo.obj);
        System.out.println("The value of obj2 is: " + genDemo.obj2);
    }

    @Test
    public void genericsTestThree(){
        GenericsDemo demo = new GenericsDemo();   //When no Type is specified during the creation of a generic class instance, the object is a "Raw Type".
        demo.setObj(123);        //No type specified but set the field to numeric(is it Integer?).  See below, the value has been set to input value type.
        demo.setObj2("hello");   //No type specified but set the field to String.  See below, the type has been set to the input value type.
        demo.setDb(155d);
        System.out.println(demo);
        System.out.println();
        System.out.println("The Data type for obj is: " + demo.getObj().getClass().getName());
        System.out.println("The Data type for obj2 is: " + demo.getObj2().getClass().getName());

        //Raw Types
        //https://docs.oracle.com/javase/tutorial/java/generics/rawTypes.html#:~:text=A%20raw%20type%20is%20the,*%2F%20%7D%20%2F%2F%20...%20%7D
        //A raw type is the name of a generic class or interface without any type arguments. For example, given the generic Box class:
        //public class Box<T> {
        //    public void set(T t) {
        //    /* ... */
        //    }
        //}
        //To create a parameterized type of Box<T>, you supply an actual type argument for the formal type parameter T:
        //Box<Integer> intBox = new Box<>();
        //If the actual type argument is omitted, you create a "raw type" of Box<T>:
        //Box rawBox = new Box();
        //Therefore, Box is the raw type of the generic type Box<T>. However, a non-generic class or interface type is not a raw type.
        //Raw types show up in legacy code because lots of API classes (such as the Collections classes) were not generic prior to JDK 5.0.
        //When using raw types, you essentially get pre-generics behavior — a Box gives you Objects. For backward compatibility,
        //assigning a parameterized type to its raw type is allowed:
        //Box<String> stringBox = new Box<>();
        //Box rawBox = stringBox;               // OK
        //But if you assign a raw type to a parameterized type, you get a warning:
        //Box rawBox = new Box();           // rawBox is a raw type of Box<T>
        //Box<Integer> intBox = rawBox;     // warning: unchecked conversion
    }

    @Test
    public void genericsTestFour(){
        GenericsDemo<Integer, String> gbox = new GenericsDemo<>(11, "Gin", 110D);
        System.out.println(gbox);
        System.out.println("db is: " + gbox.getDb());
        System.out.println();
        gbox.displayGenericType(11, "Hello");
    }
}
