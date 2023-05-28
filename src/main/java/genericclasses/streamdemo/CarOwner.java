package genericclasses.streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarOwner {
    String firstName;
    String lastName;
    List<String> cars = new ArrayList<>();

    public CarOwner() {
    }

    public CarOwner(String firstName, String lastName, List<String> cars) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cars = cars;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

//    @Override
//    public String toString() {
//        return "CarOwner{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", cars=" + cars +
//                '}';
//    }
}
