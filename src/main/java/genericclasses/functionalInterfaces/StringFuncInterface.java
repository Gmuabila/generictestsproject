package genericclasses.functionalInterfaces;

@FunctionalInterface
public interface StringFuncInterface <T, R>{//Unable to define String as a parameter and String as a return type "<String, String>", getting duplicate error.
    R run (T str);                          //Ans: if both argument and return type should have the same type, declare one generic as follows:
}                                           //    public interface StringFuncInterface <T>{
                                            //        T run (T str);
                                            //    }
