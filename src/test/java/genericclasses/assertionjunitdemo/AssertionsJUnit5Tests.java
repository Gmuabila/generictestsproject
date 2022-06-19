package genericclasses.assertionjunitdemo;

import org.junit.Test;

import java.util.Locale;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsJUnit5Tests {

    @Test
    public void assertThatJUnit5Tests(){
        //However, if we want to assert that the actual value differs by a predefined delta from
        // the expected value, we can still use the assertEquals but we have to pass the delta value as the third parameter:
        float square = 3.3357f;
        float rectangle = 3.33529f;
        float delta = 0.0001f;   //Delta will allow to check the difference up to 3 numbers after the decimal point. 3.335 = 3.335.

        assertEquals(square, rectangle, delta);
    }

    @Test
    public void assertArrayEqualsTest(){
        char[] expected = { 'J', 'u', 'p', 'i', 't', 'e', 'r' };
        char[] actual = "Jupiter".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void assertTrueTest(){
       // With the assertTrue assertion, it's possible to verify the supplied conditions are true:
        assertTrue(5 > 4, "5 is greater the 4");
        assertTrue(null == null, "null is equal to null");

       // Thanks to the support of the lambda expression, it's possible to supply a BooleanSupplier to the assertion instead of a boolean condition.
            BooleanSupplier condition = () -> 5 > 6;
            assertFalse(condition, "5 is not greater then 6");
        }

    @Test
    public void assertNullTests(){
       // When we want to assert that an object is not null we can use the assertNotNull assertion
        Object dog = new Object();
        assertNotNull(dog, () -> "The dog should not be null");
    }

    @Test
    public void assertNotNullTest(){
       // We can use the assertNull assertion to check if the actual is null:
        Object cat = null;
        assertNull(cat, () -> "The cat should be null");
    }

    @Test
    public void assertNotEqualsTest(){
        //Complementary to the assertEquals, the assertNotEquals assertion asserts that
        // the expected and the actual values aren't equal.  If both are null, the assertion fails.
        Integer value = 5; // result of an algorithm
        assertNotEquals(0, value, "The result cannot be 0");
    }

    @Test
    public void assertAllTest(){
        //One of the new assertion introduced in JUnit 5 is assertAll.
        // This assertion allows the creation of grouped assertions, where all the assertions are executed,
        // and their failures are reported together. In details, this assertion accepts a heading, that will be
        // included in the message string for the MultipleFailureError, and a Stream of Executable.
        Assertion as = null;
        assertAll(
                "Heading of all asserts",
                () -> assertEquals(4, 2 * 2),
                () -> assertEquals("java", "JAVA".toLowerCase()),
                () -> assertNull(as, "Object is null")
        );
    }

    @Test
    public void assertSameTest(){
        //When we want to assert that the expected and the actual refer to the same Object,
        // we must use the assertSame assertion:
        String language = "Java";
        Optional<String> optional = Optional.of(language);
        assertSame(language, optional.get());
    }
}
