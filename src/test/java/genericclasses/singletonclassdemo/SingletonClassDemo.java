package genericclasses.singletonclassdemo;

import org.junit.Test;

public class SingletonClassDemo {

    @Test
    public void singletonClassDemoTest() {

        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();

        //Printing Hashcodes for the above variables
        System.out.println("Hashcode for x is: " + x.hashCode());
        System.out.println("Hashcode for y is: " + y.hashCode());
        System.out.println("Hashcode for z is: " + z.hashCode());
        System.out.println("");


        if (x == y && y == z) {
            System.out.println("Three objects point to the same memory location on the heap i.e, to the same object");
        } else {
            System.out.println("Three objects DO NOT point to the same memory location on the heap");
        }
    }

    @Test
    public void singletonClassDemoWithSingletonMethod(){

        Singleton x = Singleton.Singleton();
        Singleton y = Singleton.Singleton();
        Singleton z = Singleton.Singleton();

        // Now  changing variable of instance x
        // via toUpperCase() method
        x.s = (x.s).toUpperCase();

        // Print and display commands
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");

        // Now again changing variable of instance x
        z.s = (z.s).toLowerCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);

    }

    @Test
    public void singletonClassDemoTestTwo(){
        //This test demonstrates that it is not possible to instantiate a Singleton class.
       // Singleton w = new Singleton();  //Error: Singleton has private access in genericclasses.singletonclassdemo.Singleton.
    }
}
