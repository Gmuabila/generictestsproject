package genericclasses.collectorsclassdemo;

import org.junit.Test;
import genericclasses.collectorsclassdemo.CitiesCollectors;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsClassTest {

    public static List<CitiesCollectors> prepareTemperature() {

        List<CitiesCollectors> citiesList = new ArrayList<>();
        citiesList.add(new CitiesCollectors("New Delhi", 33.5));
        citiesList.add(new CitiesCollectors("Mexico", 12));
        citiesList.add(new CitiesCollectors("New York", 13));
        citiesList.add(new CitiesCollectors("Dubai", 47));
        citiesList.add(new CitiesCollectors("London", 15));
        citiesList.add(new CitiesCollectors("Alaska", 1));
        citiesList.add(new CitiesCollectors("Sydney", 11));
        citiesList.add(new CitiesCollectors("Paris", 14));
        citiesList.add(new CitiesCollectors("Kinshasa", 43));

        return citiesList;
    }

    @Test
    public void collectorsClassTesting(){
        // The following statement filters
        // cities having temp > 10
        // The map function transforms only
        // the names of the cities
        // The collect function collects the
        // output as a List
//        System.out.println(prepareTemperature().stream()
//                .filter(f -> f.getTemperature() < 15)
//                .map(f -> f.getName())
//                .collect(Collectors.toList()));
        List<CitiesCollectors> citiesCollectorsList = prepareTemperature();


        List<String> citiesNames = citiesCollectorsList.stream().filter(cities -> cities.getTemperature() > 40).map(cities -> cities.getName()).collect(Collectors.toList());
        System.out.println("Names of Cities with Temperature greater than 40 are: ");
        System.out.println(citiesNames);
        System.out.println();

        List<CitiesCollectors> returnedCities = citiesCollectorsList.stream().filter(cities -> cities.getTemperature() < 15).collect(Collectors.toList());
        System.out.println("Cities with Temperature less than 15 are: \n" + returnedCities);
        System.out.println();

        List<Double> tempList = citiesCollectorsList.stream().filter(cities -> cities.getTemperature() > 30).map(cities -> cities.getTemperature()).collect(Collectors.toList());
        System.out.println("The highest Temperatures are: \n" + tempList);
    }
}

