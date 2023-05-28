package genericclasses.assertionjunitdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BooleanSupplier;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class AssertionsJUnitDemoTests {

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

    @Test
    public void assertFalseTest(){
        //Thanks to the support of the lambda expression, it's possible to supply a BooleanSupplier to
        // the assertion instead of a boolean condition.

        //assertFalse verifies that the supplied condition is false.
        int x = 7;
        int y = 10;
        BooleanSupplier condition = () -> 4 > 6;

        assertFalse("4 is not greater than 6", 4 > 6);
        assertFalse(7 > 10);
    }

    @Test
    public void assertNotNullTest(){
        //When we want to assert that an object is not null, we can use the assertNotNull assertion.
        Object obj = new Object();      // obj is not null
        Assertion x = new Assertion();  // x is not null here but properties are null Strings.
        //Assertion x = null;           //x is null

        assertNotNull(obj);
        assertNotNull(x);
        //assertNotNull("Object x is Null", x);
        System.out.println(x);
        //System.out.println(x.getName());
    }

    @Test
    public void assertNullTest(){
        //We can use the assertNull assertion to check if the actual is null
        Assertion y = null;

        assertNull(y);
    }

    @Test
    public void assertArrayEqualsTest(){
        //If we want to assert that two arrays are equals, we can use the assertArrayEquals
        char[] expected = {'J', 'U', 'n', 'i', 't'};
        char[] actual = "JUnit".toCharArray();

        assertArrayEquals(expected, actual);

        //If we want to assert that two arrays are equals, we can use the assertArrayEquals
    }

    @Test
    public void assertArrayEqualsTest2(){
        //If both arrays are null, the assertion will consider them equal
        char[] expected = null;
        char[] actual = null;

        assertArrayEquals(expected, actual);
    }

    @Test
    public void assertThatTest(){
        //The assertThat assertion is the only one in JUnit 4 that has a reverse order of the parameters compared to the other assertions.
        //In this case, the assertion has an optional failure message, the actual value, and a Matcher object.

        assertThat(Arrays.asList("Java", "Kotlin", "Scala"), hasItems("Java", "Kotlin"));

    }


}
