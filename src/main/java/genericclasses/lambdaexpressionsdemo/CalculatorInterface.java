package genericclasses.lambdaexpressionsdemo;


//It is not necessary to use the annotation (@ FunctionalInterface) in this case. The annotation works only when using generics.
//like other annotations (@Override, for example), it is a best practice to use it because it
//tells the compiler to check that it would work — otherwise, it will be overlooked until runtime.
public interface CalculatorInterface {
    void calculate(int x, int y);

    //Note that the "public" modifier is redundant on Interface methods,
    //because in an Interface all methods are implicitly public and abstract.
    //Methods inside of interfaces can be abstract or non-abstract (Default).
    //Since Java8 you can have "static" methods in an interface (with body).
    //You need to call them using the name of the interface, just like static methods of a class.
}
