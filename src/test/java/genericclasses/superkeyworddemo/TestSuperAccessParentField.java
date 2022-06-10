package genericclasses.superkeyworddemo;

import genericclasses.superkeyworddemo.Dog;
import org.junit.Test;

public class TestSuperAccessParentField {

    @Test
    public void testSuperclass() {

        Dog d = new Dog();
        d.printColor();
    }
}
