package genericclasses.extendskeyworddemo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCreateCity {

    @Test
    public void testCreateCityObject(){
        City city = new City();

        City city1 = new City("Great Britain", "Islington");
       //City city2 = City.builder().state("UK").city("London").super.name("UKK|").build();

        City city2 = new City();
        city2.setName("Kinshasa");
        city2.setCity("Lemba");
        city2.setState("DR Congo");

        assertEquals("England", city.getState());
        assertEquals("London", city.getCity());
        assertEquals("UK", city.getName());

        assertEquals("Great Britain", city1.getState());
        assertEquals("Islington", city1.getCity());
        assertEquals("UK", city1.getName());

        assertEquals("Kinshasa", city2.getName());
        assertEquals("Lemba", city2.getCity());
        assertEquals("DR Congo", city2.getState());

        Country country = city2;
        System.out.println();
        System.out.println("Converting subclass to superclass...");
        System.out.println(country);

        City city3 = (City) country;
        System.out.println();
        System.out.println("Converting super class to subclass...");
        System.out.println(city3);
    }
}
