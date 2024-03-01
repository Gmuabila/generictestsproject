package zzzforgenerictests;

public class MethodOverloading {
    public static void hello(String a){
        System.out.println("String");
    }
    public static void hello(Object a){
        System.out.println("Object");
    }
}
