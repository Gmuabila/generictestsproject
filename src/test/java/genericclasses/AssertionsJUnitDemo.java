package genericclasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AssertionsJUnitDemo {

    @Test
    public void assertEqualsTest(){
        //The assertEquals assertion verifies that the expected and the actual values are equal
        String expectedValue = "GMuabila";
        String actualValue = "GMuabila";
        int x = 3;
        int y = 5;

        assertEquals(expectedValue, actualValue);
        assertEquals("The values not are Equals", x, y); //Message does not display when test pass.
    }

    @Test
    public void assertTrueTest(){
        //With the assertTrue assertion, it's possible to verify the supplied conditions are true:
        assertTrue(5 > 4);
        assertTrue("2 is not greater than 3", 2 > 3);  //Message does not show when test pass.
    }

}
