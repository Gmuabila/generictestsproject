package genericclasses.accessmodifiersdemo;

public class HouseChildClass extends House {
    //Use this class to access House from other Packages
    int nextHouseNumber;
    House house = new House();

    public static void main (String args[]){
        House house = new House();
        house.setStreetNumber(2);
        System.out.println(house.getStreetNumber());
        //house.houseDisplay();
        house.houseDisplayTwo();
        house.displayHouse();
    }
}
