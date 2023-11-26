package genericclasses.collectionframeworkdemo;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingDeque;

public class MapCollectionDemo {
    //Map Interface
    // The Map Interface provides a way to store a collection of objects in the form of a key-value pair.
    // It represents a mapping between a key and a value.  The Map interface allows unique keys and is not a subtype of
    // the Collection interface.  All other collections in Java, except Map, implement the Collection interface.
    // Therefore, it behaves a bit differently from the rest of the collection types. However, the Map interface is
    // still considered as a java Collection. The Set interface only allows unique elements, but Map allows unique keys.
    // The key and value pair represent an entry in the Map. Map makes use of Hash Table algorithm to store the entries.
    // Map Interface is present in java.util package.  The Map interface of the Java collections framework provides the
    // functionality of the map data structure.

    @Test
    public void mapTesting(){
        Map<String, String> mapTest = new HashMap<>();
        mapTest.put("John", "Kawasaki");
        mapTest.put("George", "LeBlanc");
        mapTest.put("Mut", "Tumami");
        mapTest.put("Dandy", "MyBaby");
        mapTest.put("Ross", "Mummy");
        mapTest.put("Dorine", "Jenkins");

        Map<String, String> testMap = new HashMap<>();
        testMap.put("firstMan", "Monday");  //
        testMap.put("secondMan", "Tuesday");
        testMap.put("thirdMan", "Wednesday");

        Set<String> theKeys = mapTest.keySet();
        System.out.println("Username" + "\t" + "Password");
        System.out.println("==========" + "\t" + "============");
        for (String item: theKeys) //iterate through the set of keys
        {
            String password = mapTest.get(item);  //retrieve password value
            System.out.println (item + "\t" + password);  //format output, notice the tab in the output.
        }
        System.out.println();
        System.out.println();
        System.out.println(mapTest);

        System.out.println();
        System.out.println("User Login Name" + "\t\t\t" + "Password");
        System.out.println("=================" + "\t\t" + "============");
        for(String key: testMap.keySet()){
            System.out.println(key + "\t\t\t\t" + testMap.get(key));
        }
        System.out.println();
        System.out.println(testMap);
    }

    @Test
    public void mapTestTwo(){
        //containsKey() method
        // containsKey() method is used to check whether a particular key is being mapped into the Map or not.
        // It takes the key element as a parameter and returns True if that element is mapped in the map.
        //containsValue() method
        // containsValue() method is used to check whether a particular value is being mapped by a single or more than one key in the Map.
        // It takes the value as a parameter and returns True if that value is mapped by any of the key in the map.
        //entrySet() method
        // The entrySet() method is used to create a set out of the same elements contained in the map.
        // It basically returns a set view of the map, or we can create a new set and store the map elements into them.
        //Parameters: The method does not take any parameter.
        //Return Value: The method returns a set having same elements as the hash map.

        Map<String, Integer> hm = new HashMap<>();
        // Inserting pairs in above Map using put() method
        hm.put("a", 100);
        hm.put("b", 200);
        hm.put("c", 300);
        hm.put("d", 400);
        hm.put("e", 200);
        // Traversing through Map using for-each loop
        for (Map.Entry<String, Integer> me : hm.entrySet()) {       //Read about Map.Entry and entrySet().
            // Printing keys
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }
        System.out.println();
        System.out.println("Is the key 'c' present?: " + hm.containsKey("c"));
        System.out.println();
        System.out.println("Is the value '200' present?: " + hm.containsValue(200));
        System.out.println();
        System.out.println("The original map: " + hm);
        System.out.println("The set is: " + hm.entrySet());
        System.out.println();
        // Using entrySet() to get the set view
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        System.out.println("The converted set: " + set);
        //Printing elements of the new set one by one
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void getMethodOfMapInterface(){
        //Get() method
        // The get() method of Map interface is used to retrieve or fetch the value mapped by a particular key mentioned in the parameter.
        // It returns NULL when the map contains no such mapping for the key.
        // Parameter: The method takes one parameter key_element of object type and refers to the key whose associated value is supposed to be fetched.
        // Return Value: The method returns the value associated with the key_element in this Map collection.
        Map<String, Integer> map = new HashMap<>();
        // Mapping int values to string keys
        map.put("Geeks", 10);
        map.put("4", 15);
        map.put("Geeks", 20);
        map.put("Welcomes", 25);
        map.put("You", 30);
                // Displaying the Map
                System.out.println("Initial Mappings are: " + map);
        // Getting the value of "Geeks"
        System.out.println("The Value of 'Geeks' is: " + map.get("Geeks"));
        // Getting the value of "You"
        System.out.println("The Value of 'You' is: " + map.get("You"));
    }

    @Test
    public void keySetMethod(){
        //keySet() method
        // The keySet() method is used to return a Set view of the keys contained in this map.
        // The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
        // Parameters: This method has no argument.
        // Returns: This method returns a set containing keys of the specified map.
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> sSet = new HashSet<>();
        map.put(1, "One");
        map.put(3, "Three");
        map.put(5, "Five");
        map.put(7, "Seven");
        map.put(9, "Nine");
        System.out.println("Original Map: " + map);
        sSet = map.keySet();  //Returns the Set view of the keys contained in the map.
        System.out.println("Set view of keys: " + sSet);
    }

    @Test
    public void putAllMethod(){
        //putAll() method
        //The putAll(Map m) method is used to copy all the mappings from the specified map to this map.
        //Parameters: This method has the only argument map m, which contains key-value mappings to be copied to this map.
        //Returns: This method returns previous value associated with the key if present, else return -1.  //Returns nothing, it's a void method. investigate.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(3, "Three");
        map.put(5, "Five");
        map.put(7, "Seven");
        map.put(9, "Nine");
        System.out.println("Printing Map 'map': " + map);
        Map<Integer, String> mp = new HashMap<>();
        mp.put(10, "Ten");
        mp.put(30, "Thirty");
        mp.put(50, "Fifty");
        System.out.println("Printing Map 'mp': " + mp);
        map.putAll(mp);
        System.out.println("Added Map mp to map: " + map);
    }

    @Test
    public void removeMethod(){
        //remove() method
        // The remove(Object key) method is used to remove the mapping for a key from this map if it is present in the map.
        // Parameters: This method has the only argument 'key', whose mapping is to be removed from the map.
        // Returns: This method returns the value to which this map previously associated the key, or null if the map contained no mapping for the key.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(3, "Three");
        map.put(5, "Five");
        map.put(7, "Seven");
        map.put(9, "Nine");
        System.out.println(map);
        System.out.println("Element with key 3 removed: " + map.remove(3));
        System.out.println(map);
        // If it doesn't exist, it returns null and does not affect the map
        System.out.println("Element with key 2 removed: " + map.remove(2));
        System.out.println(map);
    }

    @Test
    public void valuesMethod(){
        //Values() method
        // The values() method of HashMap class is used to create a collection out of the values of the map.
        // It basically returns a Collection view of the values in the HashMap.
        // Parameters: The method does not accept any parameters.
        // Return Value: The method is used to return a collection view containing all the values of the map.
        HashMap<Integer, String> hash_map = new HashMap<>();
        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");
        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);
        // Using values() to get the set view of values
        System.out.println("The collection is: " + hash_map.values());
        System.out.println();
        //Creating a Collection out of Map values
        Collection<String> mapValuesCollection;
        mapValuesCollection = hash_map.values();
        System.out.println("Printing the Collection: " + mapValuesCollection);
        System.out.println();
        //Creating a ArrayList out of Map values
        List<String> mapValuesList = new ArrayList<>(hash_map.values());
        System.out.println("Printing the ArrayList: " + mapValuesList);
        System.out.println();
        //Creating a HashSet out of Map values
        Set<String> mapValuesSet = new HashSet<>(hash_map.values());
        System.out.println("Printing the HashSet: " + mapValuesSet);
    }

    @Test
    public void getOrDefaultMethod(){
        //getOrDefault() method
        // The getOrDefault(Object key, V defaultValue) method of Map interface, implemented by HashMap class, is used to get the value
        // mapped with the specified key. If no value is mapped with the provided key then the default value is returned.
        // Parameters: This method accepts two parameters:
        // •	key: which is the key of the element whose value has to be obtained.
        // •	defaultValue: which is the default value that has to be returned if no value is mapped with the specified key.
        // Return Value: This method returns the value mapped with the specified key, otherwise default value is returned.
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 100);
        map.put("b", 200);
        map.put("c", 300);
        map.put("d", 400);
        // print map details
        System.out.println("HashMap: " + map.toString());
        // provide key whose value has to be obtained
        // and default value for the key. Store the return value in k.
        int k = map.getOrDefault("b", 500);
        // print the value of k returned by getOrDefault(Object key, V defaultValue) method
        System.out.println("Returned Value: " + k);
        System.out.println();
        //Print the num value when the key for the value is not mapped in the map
        int num = map.getOrDefault("m", 555);
        System.out.println("Returned value is: " + num);
    }

    @Test
    public void putIfAbsentMethod(){
        //putIfAbsent() method
        // The putIfAbsent(K key, V value) method of HashMap class is used to map the specified key with the specified value,
        // only if no such key exists (or is mapped to null) in this HashMap instance.
        // Parameters: This method accepts two parameters:
        // • key: which is the key with which the provided value has to be mapped.
        // • value: which is the value which has to be associated with the provided key, if absent.
        // Return Value: This method returns null (if there was no mapping with the provided key before, or it was mapped to a null value) or
        // the current value associated with the provided key.
        // Exceptions: This method can throw the following exceptions:
        // • NullPointerException: if the specified key or value is null, and this map does not support null value.
        // • IllegalArgumentException: if the specified key or value is preventing it from being stored in the map.
        // • UnsupportedOperationException – if the put operation is not supported by this map (optional)
        // • ClassCastException – if the key or value is of an inappropriate type for this map (optional)
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 10000);
        map.put("b", 55000);
        map.put("c", 44300);
        map.put("e", 53200);
        map.put("f", null);
        // print original map
        System.out.println("HashMap:\n " + map);
        // put a new value which is not mapped before in map
        Integer returnValue = map.putIfAbsent("d", 77633);  //Returned null.  No previous mapping with this key.
        System.out.println("New HashMap:\n " + map);
        System.out.println("putIfAbsent returnValue: " + returnValue);
        // try to put a new value with existing key before in map
        Integer returnValue2 = map.putIfAbsent("d", 55555);  //Returned the current value associated with the provided existing key.
        // print newly mapped map
        System.out.println("Unchanged HashMap:\n " + map);
        System.out.println("putIfAbsent returnValue2: " + returnValue2);
        System.out.println();
        // put a new value for key 'f' which is mapped with a null value
        Integer returnedValue3 = map.putIfAbsent("f", 11118);  //As key f is mapped with null value, it maps the value 11118 with the key f and returns null.
        System.out.println("Updated HashMap: " + map);
        System.out.println("putIfAbsent returnValue3: " + returnedValue3);
        Hashtable<Integer, String> hashtable = new Hashtable<>();
    }

    @Test
    public void changingElement(){
        //Changing Element
        //HashMap put() method
        // After adding the elements if we wish to change the element, it can be done by again adding the element with the put() method.
        // Since the elements in the map are indexed using the keys, the value of the key can be changed by simply inserting the
        // updated value for the key for which we wish to change.
        //The put() method of HashMap is used to insert a mapping into a map. This means we can insert a specific key and the value it is mapping to
        // into a particular map. If an existing key is passed then the previous value gets replaced by the new value.
        // If a new pair is passed, then the pair gets inserted as a whole.
        //Parameters: The method takes two parameters, both are of the Object type of the HashMap.
        //•	key: This refers to the key element that needs to be inserted into the Map for mapping.
        //•	value: This refers to the value that the above key would map into.
        //Return Value: If an existing key is passed then the previous value gets returned. If a new pair is passed, then NULL is returned.
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");
        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);
        // Inserting existing key along with new value
        String returned_value = hash_map.put(20, "All");
        // Verifying the returned value
        System.out.println("Returned value is: " + returned_value);
        // Displaying the new map
        System.out.println("New map is: " + hash_map);
    }

    @Test
    public void iteratingMap(){
        //Iterating through the Map
        // There are multiple ways to iterate through the Map. The most famous way is to use a for-each loop and get the keys.
        // The value of the key is found by using the getValue() method.  The key is found by using the getKey() method.
        Map<Integer, String> hm1 = new HashMap<>();
        // Inserting the Elements
        hm1.put(1, "Geeks");
        hm1.put(2, "For");
        hm1.put(3, "Geeks");
        for (Map.Entry<Integer, String> mapElement: hm1.entrySet()) {
            int key = mapElement.getKey();
            // Finding the value
            String value = mapElement.getValue();
            System.out.println(key + " : " + value);
        }
    }

    @Test
    public void hashMapTest(){
        //HashMap class
        // The HashMap class is an implementation of the Map interface and is used to store data in key-value pairs, where the keys are unique.
        // It is a data structure that is used to store and retrieve values by using keys. (an index of another type, such as an Integer, or String).
        // In a key-value pair one object is used as a key (index), and another is used as a value. HashMap does not allow duplicate keys,
        // if you try to insert a duplicate key, HashMap will replace the value of the corresponding key.  Values can be added, retrieved,
        // and deleted using keys.  HashMap does not retain the insertion order.  It allows null keys but there should only be one entry with a null key.
        // However, there can be any number of null values.  HashMap class uses a technique called Hashing to store and retrieve the entries.
        // Hashing is a technique of converting a large String to a small String that represents the same String.
        // A shorter value helps in indexing and faster searches.
        //replace() method
        // The replace(K key, V value) method of Map interface, implemented by HashMap class is used to replace the value of the
        // specified key only if the key is previously mapped with some value. Note that replace happens only if the key is present in the collection.
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 100);
        map.put("b", 300);
        map.put("c", 300);
        map.put("d", 400);
        // print map details
        System.out.println("HashMap: " + map);
        Integer intA = map.replace("c", 755);
        System.out.println("Value for intA: " + intA);  //Returns the previous value mapped to the key "c", which is replaced by 755.
        // provide value for the key which is not mapped previously and store the
        // return value in Integer k, using replace(K key, V value) method
        Integer k = map.replace("e", 200);
        // print the value of k
        System.out.println("Value of k, returned "
                + "for key 'e': " + k);

        // print new mapping
        System.out.println("New HashMap: "
                + map.toString());
    }

    @Test
    public void hashMapReplaceAllMethod(){
        //replaceAll(BiFunction) method
        // The replaceAll(BiFunction) method of HashMap class replaces each value with the result of applying the given
        // function(performs a certain operation) on the corresponding value. This process continues in the same manner until all the
        // entries have been processed or until an exception is thrown by the function. It rethrows exceptions thrown by the replacement function.
        //Syntax
        //default void replaceAll(BiFunction<K, V> function)
        //Parameter:
        //       • BiFunction: function to do the operation on value for each entry.
        //         BiFunction interface represents a function that takes two arguments of different types and produces a result of another type.
        //Return value: replaces calculated values in place and the method returns nothing.
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("key1", 1);
        map1.put("key2", 2);
        map1.put("key3", 3);
        map1.put("key4", 4);
        System.out.println("HashMap1: " + map1);
        // replace oldValue with square of oldValue
        // using replaceAll method
        map1.replaceAll((key, oldValue) -> oldValue * oldValue);
        // print new mapping
        System.out.println("New HashMap: " + map1);
    }

    @Test
    public void hashMapReplaceAllMethodTestTwo(){
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Tushar", 2000);
        map1.put("Anushka", 2001);
        map1.put("Sanskriti", 2003);
        map1.put("Anuj", 2002);
        System.out.println("HashMap1: " + map1);
        // replace yearOfBirth with current age
        // using replaceAll method
        map1.replaceAll((key, yearOfBirth) -> 2019 - yearOfBirth);
        System.out.println("New HashMap: " + map1);
    }

    @Test
    public void replaceMethodTest(){
        //replace(K key, V oldValue, V newValue) method
        // The replace(K key, V oldValue, V newValue) method of Map interface, implemented by HashMap class is used to replace the
        // old value of the specified key only if the key is previously mapped with the specified old value.
        //Syntax
        // default boolean replace(K key, V oldValue, V newValue)
        //Parameters: This method accepts three parameters :
        //  • key: which is the key of the element whose value has to be replaced.
        //  • oldValue: which is the old value which has to be mapped with the provided key.
        //  • newValue: which is the new value which has to be mapped with the specified key.
        //Return Value: This method returns boolean value true if old value was replaced, otherwise false.
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 100);
        map.put("b", 300);
        map.put("c", 300);
        map.put("d", 400);
        System.out.println("HashMap: " + map);
        // provide old value, new value for the key
        // which has to replace its old value, using
        // replace(K key, V oldValue, V newValue) method
        map.replace("b", 300, 200);
        // print new mapping
        System.out.println("New HashMap: " + map);
    }

    @Test
    public void replaceMethodTestTwo(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 100);
        map.put("b", 300);
        map.put("c", 300);
        map.put("d", 400);
        System.out.println("HashMap: " + map);
        // provide old value, new value for the key
        // which has to replace its old value,
        // and store the return value in isReplaced using
        // replace(K key, V oldValue, V newValue) method
        boolean isReplaced = map.replace("b", 200, 500);
        // print the value of isReplaced
        System.out.println("Old value for 'b' was " + "replaced: " + isReplaced);
        // print new mapping
        System.out.println("New HashMap: " + map);
    }

    @Test
    public void linkedHashMapTest(){
        //LinkedHashMap class
        // The LinkedHashMap class extend the HashMap class and implement the Map interface.
        // It is an ordered version of HashMap that maintains a doubly linked List across all elements.
        // It is just like HashMap with an additional feature of maintaining the insertion order of the elements.
        // The LinkedHashMap class is based on both Hash table and Linked list to enhance the functionality of HashMap.
        // HashMap provides quick access to elements but does not maintain the order of insertion.
        // With LinkedHashMap the elements can be accessed in the order in which they were inserted.
        //put() method
        // In order to add an element to the LinkedHashMap, we can use the put() method. This is different from HashMap because in HashMap,
        // the insertion order is not retained, but it is retained in the LinkedHashMap.
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
        lhm.put("one", "practice.geeksforgeeks.org");
        lhm.put("two", "code.geeksforgeeks.org");
        lhm.put("four", "www.geeksforgeeks.org");
        System.out.println(lhm);
        // Note: It prints the elements in same order as they were inserted
        // Getting and printing value for a specific key
        System.out.println("Getting value for key 'one': " + lhm.get("one"));
        // Getting size of Map using size() method
        System.out.println("Size of the map: " + lhm.size());
        // Checking whether Map is empty or not
        System.out.println("Is map empty? " + lhm.isEmpty());
        // Using containsKey() method to check for a key
        System.out.println("Contains key 'two'? " + lhm.containsKey("two"));
        // Using containsKey() method to check for a value
        System.out.println(
                "Contains value 'practice.geeks"
                        + "forgeeks.org'? "
                        + lhm.containsValue("practice"
                        + ".geeksforgeeks.org"));
        // Removing entry using remove() method
        System.out.println("delete element 'one': "
                + lhm.remove("one"));
        // Printing mappings to the console
        System.out.println("Mappings of LinkedHashMap : "
                + lhm);
    }

    @Test
    public void linkedHashMapTestTwo(){
        //Changing/Updating Elements
        //put() method
        // After adding elements, if we wish to change the element, it can be done by again adding the element using the put() method.
        // Since the elements in the LinkedHashMap are indexed using the keys, the value of the key can be changed by
        // simply re-inserting the updated value for the key for which we wish to change.
        // Initialization of a LinkedHashMap using Generics
        //remove() method
        // In order to remove an element from the LinkedHashMap, we can use the remove() method. This method takes the value of key as input,
        // searches for existence of such key and then removes the mapping for the key from this LinkedHashMap if it is present in the map.
        // Apart from that, we can also remove the first entered element from the map if the maximum size is defined.
        LinkedHashMap<Integer, String> hm
                = new LinkedHashMap<>();
        // Inserting mappings into Map using put() method
        hm.put(3, "Geeks");
        hm.put(2, "Geeks");
        hm.put(1, "Geeks");
        // Printing mappings to the console
        System.out.println("Initial map : " + hm);
        // Updating the value with key 2
        hm.put(2, "For");
        // Printing the updated Map
        System.out.println("Updated Map : " + hm);
        // Removing an element
        String removed = hm.remove(3);
        System.out.println("Removed element: " + removed);
        System.out.println("Updated Map: " + hm);
    }

    @Test
    public void iteratingLinkedHashMap(){
        //Iterating through the LinkedHashMap
        // There are multiple ways to iterate through the LinkedHashMap. The most famous way is to use a for-each loop over the set view of
        // the map (fetched using map.entrySet() instance method). Then for each entry (set element) the values of
        // key and value can be fetched using the getKey() and the getValue() method.
        LinkedHashMap<Integer, String> hm = new LinkedHashMap<>();
        // Inserting elements into Map using put() method
        hm.put(3, "Geeks");
        hm.put(2, "For");
        hm.put(1, "Geeks");
        // For-each loop for traversal over Map
        for(Map.Entry<Integer, String> mapElement: hm.entrySet()) {
            Integer key = mapElement.getKey();
            // Finding the value using getValue() method
            String value = mapElement.getValue();
            // Printing the key-value pairs
            System.out.println(key + " : " + value);
        }
    }

    @Test
    public void sortedMapTest() {
        //SortedMap interface
        // The SortedMap interface extends the Map interface and is used to provide a particular ordering on the elements.
        // The elements are ordered either by using a natural ordering of the keys, which must implement the Comparable interface,
        // or by using a Comparator provided at the SortedMap creation time.  The SortedMap interface behaves like a normal Map with the
        // exception that the elements are stored in a sorted order internally. This means that when you iterate the elements of a SortedMap,
        // the elements are iterated in the sorted order.  The Map's iterator will traverse the Map in an ascending element order.
        // All the keys in the sortedMap must implement the Comparable interface. This interface contains the methods inherited from the
        // Map interface and adds a feature that stores the elements in a sorted manner.
        SortedMap<Integer, String> sm = new TreeMap<>();
        sm.put(2, "practice");
        sm.put(3, "quiz");
        sm.put(5, "code");
        sm.put(4, "contribute");
        sm.put(1, "geeksforgeeks");
        Set s = sm.entrySet();
        // Using iterator in SortedMap
        Iterator i = s.iterator();
        // Traversing map. Note that the traversal
        // produced sorted (by keys) output .
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            int key = (Integer) m.getKey();
            String value = (String) m.getValue();
            System.out.println("Key : " + key + "  value : " + value);
        }
    }

    @Test
    public void sortedMapTestTwo(){
        //put() Method
        // In order to add an element to the SortedMap, we can use the put() method. However, the insertion order is not retained in the TreeMap.
        // Internally, for every element, the keys are compared and sorted in ascending order.
        // The put(key, value) method of TreeMap is used to insert a mapping into a map. This means we can insert a specific key and the value it is
        // mapping to into a particular map. If an existing key is passed then the previous value gets replaced by the new value. If a new pair is passed,
        // then the pair gets inserted as a whole.
        // Parameters: The method takes two parameters, both are of the Object type of the TreeMap.
        // •	key: This refers to the key element that needs to be inserted into the Map for mapping.
        // •	value: This refers to the value that the above key would map into.
        // Return Value: If an existing key is passed then the previous value gets returned. If a new pair is passed, then NULL is returned.
        //put() method
        // After adding the elements, if we wish to change the element, it can be done by again adding the element with the put() method.
        // Since the elements in the SortedMap are indexed using the keys, the value of the key can be changed by
        // simply inserting the updated value for the key for which we wish to change.
        // Creating an empty TreeMap
        TreeMap<Integer, String> tree_map = new TreeMap<>();
        // Mapping string values to int keys
        tree_map.put(30, "Geeks");
        tree_map.put(25, "4");
        tree_map.put(49, "Geeks");
        tree_map.put(15, "Welcomes");
        tree_map.put(10, "You");
        // Displaying the TreeMap
        System.out.println("Initial Mappings are: " + tree_map);
        // Inserting existing key along with new value
        String returned_value = tree_map.put(15, "All");
        String returned_value2 = tree_map.put(55, "None");
        // Verifying the returned value
        System.out.println("Returned value with existing key: " + returned_value);
        System.out.println("Returned value with a new key: " + returned_value2);
        // Displayin the new map
        System.out.println("New map is: " + tree_map);
    }

    @Test
    public void sortedMapTestThree(){
        //Remove() method
        // In order to remove an element from the SortedMap, we can use the remove() method. This method takes the key value and removes the
        // mapping for the key from this SortedMap if it is present in the map.  The remove(key, value) method of TreeMap class and is used to
        // remove the mapping of any particular key from the map. It basically removes the values for any particular key in the Map.
        // Parameters: The method takes one parameter key whose mapping is to be removed from the Map.
        // Return Value: The method returns the value that was previously mapped to the specified key if the key exists else the method returns NULL.
        SortedMap<Integer, String> tm = new TreeMap<>();
        tm.put(3, "Geeks");
        tm.put(2, "Geeks");
        tm.put(1, "Geeks");
        tm.put(4, "For");
        System.out.println(tm);
        System.out.println("Remove with existing key: " + tm.remove(4));
        System.out.println("Remove with non-existing key: " + tm.remove(9));
                System.out.println(tm);
    }

    @Test
    public void iteratingSortedMap(){
        //Iterating through the SortedMap
        // There are multiple ways to iterate through the Map. The most famous way is to use the enhanced for loop and get the keys.
        // The value of the key is found by using the getValue() method and the value for the key is found with getKey().
        SortedMap<Integer, String> tm = new TreeMap<>();
        tm.put(3, "Geeks");
        tm.put(2, "For");
        tm.put(1, "Geeks");
        for (Map.Entry<Integer, String> mapElement: tm.entrySet()) {
            int key = mapElement.getKey();
            // Finding the value
            String value = mapElement.getValue();
            System.out.println(key + " : " + value);
        }
    }

    @Test
    public void iteratorSortedMapTestTwo() {
        // You iterate a Java SortedMap just like you iterate a normal Java Map. Since the keys of a SortedMap are sorted,
        // you will iterate the keys in their sorted order. You can iterate the keys of a SortedMap by calling the keySet() method, like this:
        SortedMap sortedMap = new TreeMap();
        sortedMap.put("a", "one");
        sortedMap.put("b", "two");
        sortedMap.put("c", "three");
        Iterator iterator = sortedMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = (String) sortedMap.get(key);
            System.out.println("Key: " + key + " " + "Value: " + value);
        }
    }

    @Test
    public void iteratorSortedMapTestThree(){
        //Example above improved
        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("a", "one");
        sortedMap.put("b", "two");
        sortedMap.put("c", "three");
        Iterator<String> iterator = sortedMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = sortedMap.get(key);
            System.out.println("Key: " + key + " " + "Value: " + value);
        }
    }

    @Test
    public void firstKeyAndLastKeyMethods(){
        //firstKey() method
        // The firstKey() method of SortedMap interface in Java is used to return the first or the lowest key currently in this map.
        // Parameters: This function does not accept any parameter.
        // Return Value: It returns the first or the lowest key currently in this map.
        // Exception: It throws NoSuchElementException if this map is empty.
        //lastKey() method
        // The lastKey() method of SortedMap interface in Java is used to return the last or the greatest key currently in this map.
        // Parameters: This function does not accept any parameter.
        // Return Value: It returns the last or the greatest key currently in this map.
        // Exception: It throws NoSuchElementException if this map is empty.
        // Create a TreeMap of SortedMap
        SortedMap<Integer, String> mp = new TreeMap<>();
        // Adding Element to SortedSet
        mp.put(1, "One");
        mp.put(5, "Five");
        mp.put(2, "Two");
        mp.put(3, "Three");
        mp.put(9, "Nine");
        System.out.println("Elements in the map: " + mp);
        // Returning the first key element
        // from the map
        System.out.println("First Key in the map: "
                + mp.firstKey());
        // Returning the last key element
        // from the map
        System.out.println("Last Key in the map: "
                + mp.lastKey());
    }

    @Test
    public void headMapAndTailMapMethods(){
        //headMap() method
        // The headMap(K toKey) method of SortedMap interface in Java is used to return a view of the portion of
        // this map whose keys are strictly less than toKey.
        // •	The map returned by this method is backed by this map, so changes in the returned map are reflected in this map, and vice-versa.
        // •	The map returned by this method supports all optional map operations that this map supports.
        // Note: The map returned by this method will throw an IllegalArgumentException if any attempt is made to insert a key outside its range.
        //tailMap() method
        // The tailMap(K fromKey) method of SortedMap interface in Java is used to return a view of the portion of
        // this map whose keys are greater than or equal to fromKey.
        // •	The map returned by this method is backed by this map, so changes in the returned map are reflected in this map, and vice-versa.
        // •	The map returned by this method supports all optional map operations that this map supports.
        // Note: The map returned by this method will throw an IllegalArgumentException if an attempt is made to insert a key outside its range.
        // Create a TreeSet and inserting elements
        SortedMap<Integer, String> mp = new TreeMap<>();
        mp.put(1, "One");
        mp.put(2, "Two");
        mp.put(3, "Three");
        mp.put(4, "Four");
        mp.put(5, "Five");
        System.out.println("Map elements: " + mp);
        // Returning the map with key less than 3
        System.out.println("Keys less than 3: "
                + mp.headMap(3));
        // Returning the key greater than or equal to 2
        System.out.println("Keys greater than or equal to 2: "
                + mp.tailMap(2));
    }

    @Test
    public void headMapAndTailMapTestTwo(){
        SortedMap<String, String> mp = new TreeMap<>();
        // Adding Element to SortedSet
        mp.put("One", "Geeks");
        mp.put("Two", "For");
        mp.put("Three", "Geeks");
        mp.put("Four", "Code");
        mp.put("Five", "It");
        // Returning map with key less than H
        System.out.println("Keys less than H: "
                + mp.headMap("H"));
        // Returning the key greater than or equal to O
        System.out.println("Keys greater than or equal to O: "
                + mp.tailMap("O"));
    }

    @Test
    public void subMapMethod(){
        //subMap() method
        // The subMap(K fromKey, K toKey) method of SortedMap interface in Java is used to return a view of the
        // portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.
        // •	The map returned by this method is backed by this map, so changes in the returned map are reflected in this map, and vice-versa.
        // •	The map returned by this method supports all optional map operations that this map supports.
        // Note: The map returned by this method will throw an IllegalArgumentException if an attempt is made to insert a key outside its range.
        // Create a TreeSet and inserting elements
        SortedMap<Integer, String> mp = new TreeMap<>();
        mp.put(1, "One");
        mp.put(2, "Two");
        mp.put(3, "Three");
        mp.put(4, "Four");
        mp.put(5, "Five");
        // Returning the key ranging between 2 and 5
        System.out.print("Elements in range from 2 to 5 in the map: "
                + mp.subMap(2, 5));
    }

    @Test
    public void subMapMethodTestTwo(){
        // Create a TreeMap and inserting elements
        SortedMap<String, String> mp = new TreeMap<>();
        mp.put("One", "Geeks");
        mp.put("Two", "For");
        mp.put("Palm", "Geeks");
        mp.put("Four", "Code");
        mp.put("More", "It");
        // Returning the key range between O and Z
        System.out.print("Key in range from O to Z in the map is: "
                + mp.subMap("O", "Z"));
    }

    public static void createConstrWithComparator(){
        Map<Student, Integer> treeMap = new TreeMap<>(new SortByRollNumber());
        treeMap.put(new Student(44, "Henry", "Hackney"), 1008);
        treeMap.put(new Student(11, "Carl", "Islington"), 1109);
        treeMap.put(new Student(30, "Martin", "Peckham"), 2000);
        treeMap.put(new Student(2, "Paul", "Bermonsey"), 8877);
        System.out.println("Treemap: " + treeMap);
    }
    @Test
    public void treeMapTest(){
        //TreeMap class
        // The TreeMap class is an implementation of the SortedMap Interface and is used to store key-value pairs in a sorted order,
        // where the keys are ordered based on their natural ordering or by using a Comparator provided at the TreeMap creation time.
        // It behaves like a normal Map and uses a tree data structure for storage and objects are stored in a sorted, ascending order.
        // But we can also store keys in descending order by passing a comparator.
        //TreeMap(Comparator comp)
        // This constructor is used to build an empty TreeMap object in which the elements will need an external specification of the sorting order.
        System.out.println("TreeMap using "
                + "TreeMap(Comparator)"
                + " constructor:\n");
        createConstrWithComparator();   //Calling the static method above
    }

    public static void createTreeMapWithMap(){
        //TreeMap(Map M)
        // This constructor is used to initialize a TreeMap with the entries from the
        // given map which will be sorted by using the natural order of the keys.
        // Creating an empty HashMap
        Map<Integer, String> hash_map= new HashMap<>();
        // Mapping string values to int keys using put() method
        hash_map.put(15, "Geeks");
        hash_map.put(30, "4");
        hash_map.put(21, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(10, "You");
        System.out.println("HashMap: " + hash_map);
        // Creating the TreeMap using the Map
        TreeMap<Integer, String> tree_map = new TreeMap<>(hash_map);
        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
    }

    @Test
    public void treeMapTestTwo(){
        System.out.println("TreeMap using "
                + "TreeMap(Map)"
                + " constructor:\n");
        createTreeMapWithMap();
    }

    public static void createTreeMapWithSortedMap(){
        //TreeMap(SortedMap sm)
        // This constructor is used to initialize a TreeMap with the entries from the given sorted map which will
        // be stored in the same order as the given sorted map.
        // Creating a SortedMap
        SortedMap<Integer, String> sorted_map
                = new ConcurrentSkipListMap<>();
        // Mapping string values to int keys using put() method
        sorted_map.put(10, "Geeks");
        sorted_map.put(15, "4");
        sorted_map.put(20, "Geeks");
        sorted_map.put(25, "Welcomes");
        sorted_map.put(30, "You");
        System.out.println("ConcurrentSkipListMap: " + sorted_map);
        // Creating the TreeMap using the SortedMap
        TreeMap<Integer, String> tree_map
                = new TreeMap<>(sorted_map);
        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
    }

    @Test
    public void treeMapTestThree(){
        System.out.println("TreeMap using "
                + "TreeMap(SortedMap)"
                + " constructor:\n");
        createTreeMapWithSortedMap();
    }


    //The following programs below will demonstrate better how to create, insert, and traverse through the TreeMap.
    static TreeMap<Integer, String> tree_map;
    static void create(){
        // Creating an empty TreeMap
        tree_map = new TreeMap<>();
        // Display message only
        System.out.println("TreeMap successfully"
                + " created");
    }
    // Method 2
    // To Insert values in the TreeMap
    static void insert(){
        // Mapping string values to int keys using put() method
        tree_map.put(10, "Geeks");
        tree_map.put(15, "4");
        tree_map.put(20, "Geeks");
        tree_map.put(25, "Welcomes");
        tree_map.put(30, "You");
        // Display message only
        System.out.println("\nElements successfully"
                + " inserted in the TreeMap");
    }
    // Method 3
    // To search a key in TreeMap
    static void search(int key){
        // Checking for the key
        System.out.println("\nIs key \"" + key
                + "\" present? "
                + tree_map.containsKey(key));
    }
    // Method 4
    // To search a value in TreeMap
    static void search(String value){
        // Checking for the value
        System.out.println("\nIs value \"" + value
                + "\" present? "
                + tree_map.containsValue(value));
    }
    // Method 5
    // To display the elements in TreeMap
    static void display(){
        // Displaying the TreeMap
        System.out.println("\nDisplaying the TreeMap:");
        System.out.println("TreeMap: " + tree_map);
    }
    // Method 6
    // To traverse TreeMap
    static void traverse(){
        // Display message only
        System.out.println("\nTraversing the TreeMap:");
        for (Map.Entry<Integer, String> e :
                tree_map.entrySet())
            System.out.print(e.getKey() + ":"
                    + e.getValue() + "   ");
    }

    @Test
    public void treeMapTestFour(){
        // Calling above defined methods inside main()
        // Creating a TreeMap
        create();
        // Inserting the values in the TreeMap
        insert();
        // Search key "50" in the TreeMap
        search(50);
        // Search value "Geeks" in the TreeMap
        search("Geeks");
        // Display the elements in TreeMap
        display();
        // Traversing the TreeMap
        traverse();
    }

    @Test
    public void putRemoveMethodsTreeMap(){
        //put() method
        // The put(key, value) method of TreeMap is used to insert a mapping into a map. This means we can insert a specific key and the
        // value it is mapping to into a particular map. If an existing key is passed then the previous value gets replaced by the new value.
        // If a new pair is passed, then the pair gets inserted as a whole.
        // Parameters: The method takes two parameters, both are of the Object type of the TreeMap.
        // •	key: This refers to the key element that needs to be inserted into the Map for mapping.
        // •	value: This refers to the value that the above key would map into.
        // Return Value: If an existing key is passed then the previous value gets returned. If a new pair is passed, then NULL is returned.
        //remove() method
        // The remove(key) method is an inbuilt method of TreeMap class and is used to remove the mapping of any particular key from the map.
        // It basically removes the values for any particular key in the Map.
        // Parameters: The method takes one parameter key whose mapping is to be removed from the Map.
        // Return Value: The method returns the value that was previously mapped to the specified key if the key exists else the method returns NULL.
        TreeMap<Integer, String> tree_map = new TreeMap<>();
        // Mapping string values to int keys
        tree_map.put(30, "Geeks");
        tree_map.put(25, "4");
        tree_map.put(20, "Geeks");
        tree_map.put(10, "Welcomes");
        tree_map.put(15, "You");
        // Displaying the TreeMap
        System.out.println("Initial Mappings are: " + tree_map);
        // Verifying that if a new key is passed, the put() method returns NULL
        String returnedValue = tree_map.put(45, "Hello");
        System.out.println("put() returned value: " + returnedValue);
        // Verifying that if an existing key is passed, put() method returns previous value
        String returnedValue2 = tree_map.put(15, "Bravo");
        System.out.println("put() returned value: " + returnedValue2);
        // Removing the existing key mapping
        String returned_value = tree_map.remove(20);
        // Verifying the returned value
        System.out.println("Returned value is: " + returned_value);
        // Verifying the returned value if a new key is passed with the remove().
        String returned_value2 = tree_map.remove(55);
        System.out.println("Returned value is: " + returned_value2);
        // Displaying the new map
        System.out.println("New map is: " + tree_map);
    }

    @Test
    public void iteratingTreeMap(){
        //Iterating through the TreeMap
        // There are multiple ways to iterate through the Map. The most famous way is to use a for-each loop and get the keys.
        // The value of the key is found by using the getValue() method.
        //Initialization of a TreeMap using Generics
        TreeMap<Integer, String> tm = new TreeMap<>();
        // Inserting the elements using put() method
        tm.put(3, "Geeks");
        tm.put(2, "For");
        tm.put(1, "Geeks");
        // For-each loop for traversal over Map
        // via entrySet() Method
        for (Map.Entry<Integer, String> mapElement: tm.entrySet()) {
            int key = mapElement.getKey();
            // Finding the value
            String value = mapElement.getValue();
            // Printing the key and value
            System.out.println(key + " : " + value);
        }
    }
}

