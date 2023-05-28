package genericclasses.functionalInterfaces.userdefinedfunctionalInterface;

@FunctionalInterface
public interface MathFuncInterface<T, R>{
    R operate(T a, T b);
}
