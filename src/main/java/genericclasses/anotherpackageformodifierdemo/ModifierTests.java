package genericclasses.anotherpackageformodifierdemo;

import genericclasses.accessmodifiersdemo.House;
import genericclasses.accessmodifiersdemo.HouseChildClass;

public class ModifierTests extends House{
    int numberTest;
    HouseChildClass houseChildClass;

    public ModifierTests() {
    }

    public ModifierTests(int numberTest) {
        this.numberTest = numberTest;
    }

    public int getNumberTest() {
        return numberTest;
    }

    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    public static void main(String args[]){
        House house1 = new House();
        house1.setStreetNumber(23);
        System.out.println(house1.getStreetNumber());
        //Accessing Public method
        house1.displayHousePublic();
        ModifierTests modifierTests = new ModifierTests();
        //Accessing Protected method via Child Class.
        modifierTests.houseDisplayTwo();  //A protected Method
        //Accessing Public method via Child Class
        modifierTests.displayHousePublic();

    }
}
