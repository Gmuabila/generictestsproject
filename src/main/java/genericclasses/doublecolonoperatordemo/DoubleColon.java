package genericclasses.doublecolonoperatordemo;

public class DoubleColon {

    static void classFunction(String s){
        System.out.println(s);
    }

    public void instanceFunction(String s){
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "DoubleColon{}";
    }
}
