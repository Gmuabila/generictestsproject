package genericclasses.methodsignaturedemo;

//******   Method Signature   ************
//The method signature consists of the method name and the parameter list.
// Method signature does not include the return type of the method.
// A class cannot have two methods with the same signature.
// If we try to declare two methods with same signature you will get a compiler time error.

import org.hibernate.annotations.Synchronize;

public class MethodSignatureDemo {

    public int add (int a, int b){
        int c = a + b;

        return c;
    }

    public double add (double a, double b){
        double c = a + b;

        return c;
    }

    //The below method yields a compiler error as two methods in the same class should not have the same Method Signature.
    //Method signature "add (int a, int b)".
//    public double add (int a, int b){
//        double c = a + b;
//
//        return c;
//    }
}
