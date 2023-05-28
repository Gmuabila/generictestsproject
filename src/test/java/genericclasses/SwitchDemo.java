package genericclasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwitchDemo {
    /*The switch statement allows us to replace several nested if-else constructs and
    thus improve the readability of our code.  Use the switch statement to select one
    of the many code blocks to be executed.
    •	The switch expression is evaluated once.
    •	The value of the expression is compared with the values of each case.
    •	If there is a match, the associated block of code is executed.
    •	The break and default keywords are optional
*/

    public String switchTest(String animal){
        String result;

        switch (animal){
            case "Dog":
                result = "This is a Domestic Animal";
                break;
            case "Cat":
                result = "This is again a Domestic Animal";
                break;
            case "Tiger":
                result = "This is a Wild Animal, be careful";
                break;
            default:
                result = "Unknown Animal";
                break;
        }
        return result;
    }

    @Test
    public void testSwitchOne(){

        assertEquals("This is a Domestic Animal", switchTest("Dog"));
        assertEquals("This is again a Domestic Animal", switchTest("Cat"));
        assertEquals("This is a Wild Animal, be careful", switchTest("Tiger"));
        assertEquals("Unknown Animal", switchTest("Mouse"));
    }

    @Test
    public void testSwitchTwo(){
        String result = switchTest("Cat");

        System.out.println("The Cat result is: " + result);
        System.out.println(switchTest("Dog"));
        System.out.println(switchTest("Mouse"));
    }
}
