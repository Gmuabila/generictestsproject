package genericclasses.collectorsclassdemo;

import org.junit.Test;
import genericclasses.collectorsclassdemo.CitiesCollectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsClassTest {

    public static List<CitiesCollectors> prepareTemperature() {

        List<CitiesCollectors> citiesList = new ArrayList<>();
        citiesList.add(new CitiesCollectors("London", 33.5));
        citiesList.add(new CitiesCollectors("Kinshasa", 43));
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

        System.out.println("\nCities with Temperatures less than 5 Degrees are: ");
        System.out.println(prepareTemperature().stream().filter(city -> city.getTemperature() < 5).collect(Collectors.toList()));
        System.out.println();

        //The following will return a Set instead of a list (Note the return type is Set of String Names)
        System.out.println("Displaying names of cities with Temperature above 10");
        System.out.println(prepareTemperature().stream().filter(cities -> cities.getTemperature() > 10).map(cities -> cities.getName()).collect(Collectors.toSet()));
        System.out.println("Notice there's no duplicate in the Set");
        System.out.println();

        Set<CitiesCollectors> returnedSet = citiesCollectorsList.stream().filter(cities -> cities.getTemperature() > 1).collect(Collectors.toSet());
        System.out.println("Cities with Temperature greater than 1 are: \n" + returnedSet);
        System.out.println("Notice Duplicate here, shouldn't be");
        System.out.println();

        /*Returning Map with toMap() method.  Since our list contains duplicates, it will not filter out silently as toMap().
        Instead, it throws an IllegalStateException. We can avoid and fix this issue by avoiding the key collision(in case of duplicate keys) with
        the third argument that is BinaryOperator.  Binary operator specifies, how can we handle the collision,
        and will pick either of the colliding elements.*/
        Map<String, Double> returnedMap = citiesCollectorsList.stream().filter(cities -> cities.getTemperature() > 3)
                .collect(Collectors.toMap(CitiesCollectors::getName, CitiesCollectors::getTemperature, (key, identicalKey) -> key));
        System.out.println("Cities with Temp greater than 3 degrees in Map: \n" + returnedMap);
        System.out.println();

        System.out.println("Counting.....Collects the elements and counts the occurrences");
        System.out.println(prepareTemperature().stream()
                .collect(Collectors.groupingBy(CitiesCollectors::getName, Collectors.collectingAndThen(
                                Collectors.counting(), f -> f.intValue()))));

        //The grouping of elements is done as per the passed classifier function and returns the Collector with result in a Map.
        System.out.println("\nUsing grouping....the result is a Map");
        System.out.println(prepareTemperature().stream().collect(Collectors.groupingBy(CitiesCollectors::getName)));
    }
}

