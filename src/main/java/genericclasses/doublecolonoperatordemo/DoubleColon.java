package genericclasses.doublecolonoperatordemo;

import java.math.BigDecimal;

public class DoubleColon {

    private String s;

    public DoubleColon() {
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


