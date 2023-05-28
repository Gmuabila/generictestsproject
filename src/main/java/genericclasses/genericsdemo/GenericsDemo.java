package genericclasses.genericsdemo;

//You can create a class in Java that defines one or more placeholders for data type.
//The placeholders are known as generics because the class is not determined until compile time.
//Generics are notated by angle brackets < >. For example, we might wish to create a class that contains a
//method that accepts an argument of any data type, and we must use a generic for the method argument data type.
//Generic means parameterised type. The idea is to allow type (Integer, String, … etc., and user-defined types) to be a
//parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types.
//For example, classes like HashSet, ArrayList, HashMap, etc., use generics very well.
public class GenericsDemo<T, M>{
    T obj;
    M obj2;
    Double db;
    String str;

    public GenericsDemo(){      //No args constructor
    }
    public GenericsDemo(T obj, M obj2){     //Constructor
        this.obj = obj;
        this.obj2 = obj2;
    }
    public GenericsDemo(T obj, M obj2, Double db){
        this.obj = obj;
        this.obj2 = obj2;
        this.db = db;
    }
    public GenericsDemo(T obj, M obj2, Double db, String str){      //All args constructor
        this.obj = obj;
        this.obj2 = obj2;
        this.db = db;
        this.str = str;
    }
    public T getObj(){
        return obj;
    }
    public M getObj2(){
        return obj2;
    }
    public void setObj(T obj){
        this.obj = obj;
    }
    public void setObj2(M obj2){
        this.obj2 = obj2;
    }
    public Double getDb(){
        return db;
    }
    public void setDb(Double db){
        this.db = db;
    }
    public String getStr(){
        return str;
    }
    public void setStr(String str){
        this.str = str;
    }

    public void displayGenericType(T a, M b){
        System.out.println("The value of Generic Type T is: " + a);
        System.out.println("Type: " + a.getClass().getName());
        System.out.println("The value of Generic Type M is: " + b);
        System.out.println("Type: " + b.getClass().getName());
    }

    @Override
    public String toString() {
        return "GenericsDemo{" +
                "obj=" + obj +
                ", obj2=" + obj2 +
                ", db=" + db +
                ", str='" + str + '\'' +
                '}';
    }
}
