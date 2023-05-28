package genericclasses.accessmodifiersdemo;

import org.junit.Test;

public class AccessModifiersDemo {

    @Test
    public void accessModifiersTest(){
        //Trying to access a class, which Modifier is set to Default
        House house = new House();
        house.setStreetNumber(2);
        house.setCity("London");
        house.setRoad("Duke Road");

        System.out.println("New registered house is: " + house);
    }

    @Test
    public void testingPrivateModifierMethod(){
        House hs1 = new House();
        hs1.setStreetNumber(78);
        hs1.setRoad("Gtech Street");
        hs1.setPostcode(922);
        hs1.setCity("London");

        //  hs1.houseDisplay(); //When calling this method, we get the error: "houseDisplay()" has private access in
        //"genericclasses.accessmodifiersdemo.House".  This is because Access Modifier is set to Private and cannot be access outide the class.
    }


}
