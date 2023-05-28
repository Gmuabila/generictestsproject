package genericclasses.anotherpackageformodifierdemo;

import genericclasses.accessmodifiersdemo.House;

public class ModifierTestsTwo {
    String roadName;

    public ModifierTestsTwo() {
    }

    public ModifierTestsTwo(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public static void main(String args[]){
        House house = new House();
        house.setRoad("Doctor Road");
        house.setCity("London");
        house.setStreetNumber(33);

        //Accessing the Public method but unable to access Protected, private, and default methods of the House class.
        house.displayHousePublic();

    }
}
