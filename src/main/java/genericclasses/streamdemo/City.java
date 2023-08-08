package genericclasses.streamdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private double temperature;

    public City(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public static List<City> prepareTemperature(){
        List<City> cities = new ArrayList<>();
        cities.add(new City("New Delhi", 33.5));
        cities.add(new City("Mexico", 9));
        cities.add(new City("New York", 13));
        cities.add(new City("Dubai", 45));
        cities.add(new City("London", 15));
        cities.add(new City("Alaska", 1));
        cities.add(new City("Kolkata", 30));
        cities.add(new City("Sydney", 11));
        cities.add(new City("Mexico", 9));
        cities.add(new City("Dubai", 45));
        return cities;
    }
}
