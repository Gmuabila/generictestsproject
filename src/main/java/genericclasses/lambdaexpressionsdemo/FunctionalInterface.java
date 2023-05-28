package genericclasses.lambdaexpressionsdemo;

public interface FunctionalInterface {
    // Java program to demonstrate lambda expressions
    // to implement a USER defined functional interface.
    // A sample functional interface (An interface with
    // a single abstract method)
    //A functional interface is an interface that contains only one abstract method.
    //They can have only one functionality to exhibit. From Java 8 onwards,
    //lambda expressions can be used to represent the instance of a functional interface.
    //A functional interface can have any number of default methods. Since Java8 Interfaces can also have "static" method with a body.
        // An abstract function
      void abstractFunction(int x);
        // A non-abstract (or default) function
        default void normalFunction(){
            System.out.println("Hello");
        }

    //Note that the public modifier is redundant on Interface methods,
    //because in an Interface all methods are implicitly "public" and "abstract".
    //Methods inside of interfaces can be "abstract" or non-abstract (Default).
    //Since Java8 you can have "static" methods in an interface (with body).
    //You need to call them using the name of the interface, just like static methods of a class.
}
