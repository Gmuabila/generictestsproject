package genericclasses.streamdemo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.*;

public class CollectorsDemo {
    //Java Collectors class
    //The Collectors class in Java is a utility class that provides various implementations of reduction operations such as grouping elements,
    //collecting elements to different collections, summarizing elements according to various criteria, etc.
    //The different functionalities in the Collectors class are usually used as the final operations on streams.
    //Collectors represent implementations of the Collector interface, which implements various useful reduction operations,
    //such as accumulating elements into collections, summarizing elements based on a specific parameter, etc.
    //All predefined implementations can be found within the Collectors class.
    //You can also very easily implement your own collector and use it instead of the predefined ones, though you can get
    //pretty far with the built-in collectors, as they cover the vast majority of cases in which you might want to use them.

    //Let’s consider a City class, which has attributes like name and temperature which are being
    //initialized with the parameterized constructor. We will observe the different
    //methods available in the collectors class using this example.

    @Test
    public void testCollectorsOne() {
        // The following statement filters
        // cities having temp > 10
        // The map function transforms only
        // the names of the cities
        // The collect function collects the
        // output as a List
        System.out.println(new City().prepareTemperature().stream()
                .filter(f -> f.getTemperature() > 10)
                .map(f -> f.getName())
                .distinct()
                .collect(Collectors.toList()));

//        List<City> cityList = new ArrayList<>();
//        cityList = City.prepareTemperature();
//        System.out.println(cityList.stream().distinct() //distinct will not work here as it sees only object and cannot compare.
//                .filter(f -> f.getTemperature() > 10)
//                .map(f -> f.getName())
//                .collect(Collectors.toList()));
    }

    @Test
    public void testCollectorsTwo(){
        // Here, we have applied the filter
        // to get the set of the names
        // of the cities whose temperature
        // is greater than 10
        System.out.println(City.prepareTemperature()
                .stream()
                .filter(f -> f.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(toSet()));
    }

    @Test
    public void testCollectorsThree(){
        // Here, a list of all the names
        // have been returned
        System.out.println(City.prepareTemperature()
                .stream()
                .map(f -> f.getName())
                //.collect(Collectors.toCollection(List::new)));
                .collect(Collectors.toList()));
    }

    @Test
    public void testCollectorsFour(){
        //toMap()
        //toMap() is used to collect input of elements and convert it into Map instance.
        //Contrary to toSet(), toMap() method does not silently filter duplicates,
        //which is understandable because how would it figure out which value to pick for this key?
        // Here, the name and the temperature
        // are defined as the type City
        System.out.println(City.prepareTemperature()
                .stream()
                .filter(city -> city.getTemperature() > 10)
                .collect(Collectors.toMap(City::getName, City::getTemperature,
                        (key, identicalKey) -> key)));
        //Adding the converted Map instance to a Map.
        Map<String, Double> citiesTempMap = City.prepareTemperature()
                .stream()
                .filter(city -> city.getTemperature() < 10)
                .collect(Collectors.toMap(City::getName, City::getTemperature, (key, identicalKey) -> key));
        System.out.println();
        System.out.println("Printing Map: " + citiesTempMap);
        //Since our list contains duplicates, the toMap() method will not filter it out silently as with toSet() method.
        //Instead, it throws an IllegalStateException.
        //The third argument "(key, identicalKey) -> key" is used in case the stream has duplicates elements.
        //To avoid the key collision, we use the third argument, that is the BinaryOperator "(key, identicalKey) -> key".
        //Binary operator specifies how we can handle the collision. Above statements pick either of the colliding elements.
    }

    @Test
    public void testCollectorsFive(){
        //Collectors toUnmodifiableList() method
        //Java 10 introduced a convenient way to accumulate the Stream elements into an unmodifiable List
        //If you try to modify the unModifiable List, you'll get an "UnsupportedOperationException".
        List<City> unModifyList = City.prepareTemperature()
                .stream()
                .filter(city -> city.getTemperature() < 10)
                .collect(Collectors.toUnmodifiableList());
        unModifyList.add(new City("Kinshasa", 47));  //Cannot add to this type of list.  Will throw the below exception.
        //java.lang.UnsupportedOperationException
        //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        //	at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:147)
        //	at genericclasses.streamdemo.CollectorsDemo.testCollectorsFive(CollectorsDemo.java:103)
    }

    @Test
    public void testCollectorsSix(){
        //A Set doesn't contain duplicate elements. If our collection contains elements equal to each other,
        //they appear in the resulting Set only once:

        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> result = listWithDuplicates.stream().collect(toSet());
        assertNotEquals(result.size(), listWithDuplicates.size());  //The size of the original List is not equal to the new Set as duplicates are removed.
    }

    @Test
    public void testCollectorsSeven(){
        //toUnmodifiableSet() method
        //Since Java 10, we can easily create an unmodifiable Set using the toUnmodifiableSet() collector.
        //Any attempt to modify the result Set will end up with an UnsupportedOperationException:
        List<String> givenList = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> result = givenList.stream().collect(Collectors.toUnmodifiableSet());
        result.add("rd");  //Will throw UnsupportedOperationException. Cannot add to an Unmodifiable Set.
    }

    @Test
    public void testCollectionEight(){
        //Collectors toCollection() method
        //The toCollection() collector transforms the input elements into a new Collection.
        //If we observe toList() and toSet() methods discussed above, We don’t have control over their implementations.
        //So, with toCollection() we can achieve custom implementation.  As we've already noted,
        //when using the toSet() and toList() collectors, we can't make any assumptions of their implementations.
        //If we want to use a custom implementation, we'll need to use the toCollection() collector with a provided collection of our choice.

        System.out.println(City.prepareTemperature()
                .stream()
                .map(city -> city.getName())
                .sorted()
                //.collect(Collectors.toCollection(ArrayList::new)));  //Does not work, to be investigated further.
                .collect(Collectors.toCollection(() -> new ArrayList<>()))); //Note that with toCollection() we have control over the implementation.
                                                                             //In this case we have chosen ArrayList as the implementation of our List.
                                                                             //Explicit type argument can be replaced with <> as follows: ArrayList<>.
    }

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

    @Test
    public void testJoiningMethod(){
        /** joining() method
         The joining() method of the Collectors Class is used to join various elements of a character or string array into a single string object.
         This method uses the stream to do so. There are various overloads of joining() methods present in the Collector class.
         joining()
         java.util.stream.Collectors.joining() is the simplest joining() method which does not take any parameter.
         It returns a Collector that joins or concatenates the input streams into String in the order of their appearance.                      */
        // Creating a custom character array
        char[] ch = { 'G', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'G', 'e', 'e', 'k', 's' };
        // Converting character array into string
        // using joining() method of Collectors class
        String chString = Stream.of(ch)
                .map(arr -> new String(arr))
                .collect(Collectors.joining());
        // Printing concatenated string
        System.out.println(chString);
        //In this program, a character list is created. Then this list is fed to be converted into Stream.
        //Then the characters are converted into Strings, resulted stream is mapped for a sequential series using map().
        // At last, the sequential stream containing the string list is joined into a single String using Collectors.joining() method.
        // It is stored in ‘chString’ variable.
    }

    @Test
    public void testJoiningMethodB(){
        /** joining() method                                                                                                                */
        // Creating a character list
        List<Character> ch = Arrays.asList(
                'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G',
                'e', 'e', 'k', 's');
        // Converting character list into string
        // using joining() method of Collectors class
        String chString = ch.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        // Printing the concatenated string
        System.out.println(chString);
    }

    @Test
    public void testJoiningMethodC(){
    /** joining(delimiter)
     java.util.stream.Collectors.joining(CharSequence delimiter) is an overload of joining() method which takes delimiter as a parameter,
     of the type CharSequence. A delimiter is a symbol or a CharSequence that is used to separate words from each other. For example,
     in every sentence, space ‘ ‘ is used as the default delimiter for the words in it. It returns a Collector that joins or concatenates the
     input elements into String in the order of their appearance, separated by the delimiter.                                                   */
    // Create a character list
    List<Character> ch = Arrays.asList('G', 'e', 'e', 'k', 's', 'f',
            'o', 'r', 'G', 'e', 'e', 'k', 's');
    // Convert the character list into String using Collectors.joining() method
    // with, as the delimiter
    String chString = ch.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
    // Print the concatenated String
        System.out.println(chString);
    }

    @Test
    public void testJoiningMethodD(){
        /** joining(delimiter)
         java.util.stream.Collectors.joining(CharSequence delimiter) is an overload of joining() method which takes a delimiter as a parameter,
         of the type CharSequence. A delimiter is a symbol or a CharSequence that is used to separate words from each other. For example,
         in every sentence, space ‘ ‘ is used as the default delimiter for the words in it. It returns a Collector that joins or
         concatenates the input elements into String in the order of their appearance, separated by the delimiter.                              */
        // Create a character list
        List<Character> ch = Arrays.asList('G', 'e', 'e', 'k', 's', 'f',
                'o', 'r', 'G', 'e', 'e', 'k', 's');
        // Convert the character list into String using Collectors.joining() method
        // with, as the delimiter
        String chString = ch.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        // Print the concatenated String
        System.out.println(chString);
    }

    @Test
    public void testJoiningMethodE(){
        /** joining(delimiter, prefix, suffix) method
         The joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix) is an overload of joining() method which takes a delimiter,
         a prefix, and a suffix as parameter, of type CharSequence. A delimiter is a symbol or a CharSequence that is used to separate words from
         each other. A prefix is a symbol or a CharSequence that is joined at the starting of the 1st element of the String.
         Then suffix is also a CharSequence parameter, but this is joined after the last element of the string. i.e. at the end. For example,
         in every {Geeks, for, Geeks}, space ‘ ‘ is used as the by default delimiter for the words in it. The ‘{‘ is the prefix and ‘}’ is the suffix.
         It returns a Collector that joins or concatenates the input elements into String in the order of their appearance, separated by the delimiter.
         Syntax:
         public static Collector<CharSequence, ?, String> joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix))                     */
        // Create a character list
        List<Character> ch = Arrays.asList('G', 'e', 'e', 'k', 's', 'f',
                'o', 'r', 'G', 'e', 'e', 'k', 's');
        // Convert the character list into String using Collectors.joining() method
        // with, as the delimiter
        String chString = ch.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        // Print the concatenated String
        System.out.println(chString);
    }

    @Test
    public void testJoiningMethodF(){
        /** joining(delimiter, prefix, suffix) method                                                                                           */
        // Create a string list
        List<String> str = Arrays.asList("Geeks", "for", "Geeks");
        // Convert the string list into String using Collectors.joining() method
        String chString = str.stream().collect(Collectors.joining(", ", "{", "}"));
        // Print the concatenated String
        System.out.println(chString);
    }
}
