package genericclasses;

import org.junit.Test;

public class TestDefaultVariableInitialisation {

    @Test
    public void testDefaultVariableInitValue(){
        /* DefaultVariableInitialisation defaultVariableInitialisation = new DefaultVariableInitialisation();
        defaultVariableInitialisation.print(); */
        new DefaultVariableInitialisation().print();  //Gives the same result as the above.
        System.out.println();

        Object o = new Object();
        o = null;
        System.out.println("Object o has been initialised then set to null.\nIt's value is now: " + o);
    }
}
