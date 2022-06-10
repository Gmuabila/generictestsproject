package genericclasses.superkeyworddemo;


import org.junit.Test;

public class TestSuperInvokeParentClassMethod {

    @Test
    public void invokeParentClassMethod() {
        Dog dog = new Dog();
        dog.work();
    }
}
