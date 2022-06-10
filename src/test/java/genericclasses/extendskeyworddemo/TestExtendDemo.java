package genericclasses.extendskeyworddemo;

import org.junit.Test;

public class TestExtendDemo {

    @Test
    public void testExtendsKeywordDemo() {

        City obj = new City();
        obj.display();
        System.out.println("Name of the city is: " + "'" + obj.getCity() + "'");
        System.out.println("City is present in " + obj.getState() + " State");
    }

}
