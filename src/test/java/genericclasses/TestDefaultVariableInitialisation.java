package genericclasses;

import org.junit.Test;

public class TestDefaultVariableInitialisation {

    @Test
    public void testDefaultVariableInitValue(){
        /* DefaultVariableInitialisation defaultVariableInitialisation = new DefaultVariableInitialisation();
        defaultVariableInitialisation.print(); */
        new DefaultVariableInitialisation().print();  //Gives the same result as the above.
    }
}
