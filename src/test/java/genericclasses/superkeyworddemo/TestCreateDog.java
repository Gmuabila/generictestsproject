package genericclasses.superkeyworddemo;

import genericclasses.superkeyworddemo.Dog;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCreateDog {

    @Test
    public void testCreateADog(){

        Dog tony = new Dog();

        Dog mic = new Dog();
        //mic.setColor("Blue");

        Dog dog = new Dog();
       Dog dog4 = Dog.builder().color(".").build();    //It creates a new Dog using Lombok AllArgsConstructor.
        Dog dog5 = Dog.builder().build();

        assertEquals("Black...for Subclass", tony.getColor());  //Dog Class has color field set to "Black...for Subclass".
        assertEquals("Black...for Subclass", mic.getColor());   //When a new Dog instance is created, the color field will have this value assigned,
        assertEquals("Black...for Subclass", dog.getColor());   //unless the new object is created with a new value for color, or the new value is
        assertEquals("Black...for Subclass", dog.getColor());   //set after the object is created.
        assertEquals(".", dog4.getColor());
        assertEquals("'White'...In Super Class", dog.getSuperColorValue()); //Using getSuperColorValue() method to access Super Class attribute.
        assertEquals(null, dog5.getColor());
        assertEquals("'White'...In Super Class", dog5.getSuperColorValue());
    }                                                                    //Note: with Lombok, unless you assign the value of color during object creation,
}                                                                        //Lombok does not seem to create new objects with value of color initialised in class.
                                                                         //the getColor() returns null for object created with Lombok with no args constructor
