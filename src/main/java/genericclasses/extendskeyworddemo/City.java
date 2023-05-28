package genericclasses.extendskeyworddemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

//@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class City extends Country{
    String state = "England";
    String city = "London";

    public City(){
        System.out.println("City object is created");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
