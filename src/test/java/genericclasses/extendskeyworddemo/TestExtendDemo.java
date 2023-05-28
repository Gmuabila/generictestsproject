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

    @Test
    public void testExtendsKeywordDemoTwo(){
        City city = new City();
        System.out.println(city.getCity());
        System.out.println(city.getState());
        System.out.println(city.getName());
    }

    @Test
    public void testExtendsKeywordDemoThree(){
        City city1 = new City();
        Country country = city1;
        System.out.println(country);
        City city = (City) country;
        System.out.println();
        System.out.println(city);
    }

    @Test
    public void testExtendsKeywordDemoFour(){
        Country country = new Country();
        System.out.println(country);
        City city = (City) country;
        System.out.println(city);
    }

    @Test
    public void testExtendsKeywordDemoFive(){
        City city = new City();
        city.setName("");
    }

}
