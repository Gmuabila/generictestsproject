package genericclasses.functionalInterfaces.userdefinedfunctionalInterface;

@FunctionalInterface
public interface UserDefinedFInt<T, R>{
   //Note that the "public" modifier is redundant on Interface methods,
   //because in an Interface all methods are implicitly "public" and "abstract".
   //Methods inside of interfaces can be abstract or non-abstract.
   //Since Java8 you can have static methods in an interface (with body).
   //You need to call them using the name of the
   // interface, just like static methods of a class.

   //Abstract method
   R transform(T x);
   //Default method test
   default void displayOne(){
      System.out.println("This is a Default method");
   }
   //Static method test
   static void display(){
      System.out.println("This is a static method");
   }
}
