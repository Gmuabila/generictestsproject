package genericclasses.extendskeyworddemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class Country {
    String name = "UK";

    public Country(){
        System.out.println("Country Object is created");
    }
    void display(){
        System.out.println("This in my country United Kingdom");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
