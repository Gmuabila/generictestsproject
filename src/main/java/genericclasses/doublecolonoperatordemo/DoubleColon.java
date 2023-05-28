package genericclasses.doublecolonoperatordemo;

import java.math.BigDecimal;

public class DoubleColon {
    /*The :: operator (double colon operator) in java, also known as Method reference operator in Java,
    is used to call a method by referring to it with the help of its class directly.
    They behave exactly as the lambda expressions. The only difference it has from lambda expressions is that
    this uses direct reference to the method by name instead of providing a delegate to the method.
     */

    private String s;

    public DoubleColon() {
        System.out.println("Empty constructor called...");
    }
    // Class constructor
    public DoubleColon(String s) {
        System.out.println("Hello " + s);
        System.out.println("Constructor Active now....\n");
    }

    static void classFunction(String s){
        System.out.println(s);
    }

    public void instanceFunction(String s){
        System.out.println("[" + s + "]");
    }

    String print(String str){
        return ("Hello " + str + "\n");
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}


