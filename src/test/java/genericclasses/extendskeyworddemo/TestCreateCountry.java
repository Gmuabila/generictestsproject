package genericclasses.extendskeyworddemo;

import static org.junit.Assert.assertEquals;

import lombok.Builder;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestCreateCountry {

    @Test
    public void testCreateCountry(){
        Country myCountry = new Country();       //Using the defined constructor to create new object

        Country country = Country.builder().name("United Kingdom").build(); //Using Lombok AllArgsConstructor to create new object

        Country england = Country.builder().build();    //Creating object without setting attribute.

        assertEquals("UK", myCountry.getName());
        assertEquals("United Kingdom", country.getName());
        assertEquals(null, england.getName());  //england.getName() returns null. Again when object is created without assigning value to attribute,
                                                         //Lombok assigns null to the field even though the attribute has been initialised in Class declaration.
    }
}
