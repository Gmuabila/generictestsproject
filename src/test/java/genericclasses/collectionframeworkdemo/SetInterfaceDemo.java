package genericclasses.collectionframeworkdemo;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

import static org.junit.Assert.*;

public class SetInterfaceDemo {
    // Set Interface
    // The Set interface provides a way to store an unordered collection of objects in which duplicate values cannot be stored.
    // It is an interface that models the mathematical set abstraction. The set interface contains the methods inherited from
    // the Collection interface and adds a feature that restricts the insertion of duplicate elements.
    // There are two interfaces that extend the set implementation namely SortedSet and NavigableSet.
    // The set interface is present in java.util package and extends the Collection interface.
    //
    // The navigableSet interface extends the sortedSet interface. Since a set doesn't retain the insertion order,
    // the navigableSet interface provides the implementation to navigate through the Set. The class which implements the navigableSet is a TreeSet class,
    // which is an implementation of a self-balancing tree. Therefore, this interface provides us with a way to navigate through this tree.

    @Test
    public void testSetInterfaceOne(){
        Set<String> setString = new HashSet<>();
        // Adding elements to the Set using add() method
        setString.add("Geeks");
        setString.add("For");
        setString.add("Geeks");
        setString.add("Example");
        setString.add("Set");
        //Printing elements of HashSet object
        System.out.println("The original Set: " + setString);
        System.out.println();
        System.out.println("Adding a duplicate element: " + setString.add("For"));  //add() returns false if adding an element that's already in the Set.
        System.out.println();
        List<String> stringList = new ArrayList<>();
        stringList.add("Example");
        stringList.add("Set");
        stringList.add("For");
        stringList.add("Johns");
        setString.retainAll(stringList);  //retainAll() retains only elements in the specified collection and deletes the rest. It does not add any elements.
        System.out.println("Set after retainAll(): " + setString);
    }

    @Test
    public void testSetInterfaceTwo(){
        // Creating an object of Set class
        Set<Integer> setA = new HashSet<>();
        // Adding all elements to List
        setA.addAll(Arrays.asList(
                new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));
        System.out.println("Original setA: " + setA);
        // Again declaring object of Set class with reference to HashSet
        Set<Integer> setB = new HashSet<>();
        setB.addAll(Arrays.asList(1, 3, 7, 5, 4, 0, 7, 5));
        System.out.println("Original setB: " + setB);
        System.out.println();
        // To find union
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.print("Union of the two Set");
        System.out.println(union);
        // To find intersection
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);
        // To find the symmetric difference
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
    }

    @Test
    public void testHashSetClass(){
        //HashSet class
        // The HashSet class implements the Set interface and is backed by HashMap internally.
        // The elements are inserted based on their hashcode. It stores unique elements, allows null values,
        // and does not maintain the insertion order. The class also offers constant time performance for the basic operations like add,
        // remove, contains, and size assuming the hash function disperses the elements properly among the buckets.
        // This class is not thread-safe. Note that the internal HashMap gets initialized when an instance of the HashSet is created.
        // Instantiate an object of HashSet
        HashSet<ArrayList> set = new HashSet<>();
        // create ArrayList list1
        ArrayList<Integer> list1 = new ArrayList<>();
        // create ArrayList list2
        ArrayList<Integer> list2 = new ArrayList<>();
        // Add elements using add method
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        System.out.println("Adding ArrayList list1: " + set.add(list1));
        System.out.println("Adding ArrayList list2: " + set.add(list2));  //will not add duplicate.
        // print the set size to understand the
        // internal storage of ArrayList in Set
        System.out.println(set.size());
    }

    @Test
    public void testHashSetClassTwo(){
        //add() method
        //To add an element to the HashSet, we can use the add() method. However, the insertion order is not retained in the HashSet.
        //We need to keep a note that duplicate elements are not allowed and all duplicate elements are ignored.
        //remove()
        //The values can be removed from the HashSet using the remove() method.
        //Iterating through the HashSet
        //Iterate through the elements of HashSet using the iterator() method.
        //Also, the most famous one is to use the enhanced for loop.
        HashSet<String> h = new HashSet<>();
        // Adding elements into HashSet using add() method
        h.add("India");
        h.add("Australia");
        h.add("South Africa");
        // Adding duplicate elements
        h.add("India");
        // Displaying the HashSet
        System.out.println(h);
        System.out.println("List contains India or not:"
                + h.contains("India"));
        // Removing items from HashSet using remove() method
        h.remove("Australia");
        System.out.println("List after removing Australia:"
                + h);
        // Display message
        System.out.println("Iterating over list:");
        // Iterating over hashSet items
        Iterator<String> i = h.iterator();
        // Holds true till there is single element remaining
        while (i.hasNext())
            // Iterating over elements using next() method
            System.out.println(i.next());
    }

    @Test
    public void iteratorObject(){
        //iterator() method
        //The iterator() method returns an iterator over the elements in the Set.
        // The elements are visited in no particular order and iterators are fail-fast.
        // An Iterator is an object that can be used to loop through collections, like ArrayList and HashSet.
        // It is called an "iterator" because "iterating" is the technical term for looping.
        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    @Test
    public void iteratorObjectTwo(){
        //If the set is modified at any time after the iterator is created in any way
        //except through the iterator's own remove() method, the Iterator throws a ConcurrentModificationException.
        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()){
            itr.next();
            hashset.remove("Second");
        }
    }

    @Test
    public void iteratorObjectThree(){
        //Alternatively, if we used the iterator's remove() method, then we wouldn't have encountered the exception.
        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        String elementIn = "Second";
        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()) {
            String currenElement = itr.next();
            if (currenElement.equals(elementIn))
                itr.remove();
        }
        assertEquals(2, hashset.size());
    }

    @Test
    public void linkdedHashSetTest(){
        //LinkedHashSet class
        // The LinkedHashSet class extends the HashSet class and implements the Set interface.
        // It is an ordered version of HashSet that maintains a doubly linked List across all elements.
        // It stores unique elements only like HashSet, permits null values, and maintains the insertion order.
        // Use this class instead of HashSet when you care about the iteration order. When you iterate through a HashSet the order is unpredictable,
        // while a LinkedHashSet lets you iterate through the elements in the order in which they were inserted.  The iteration order is defined by the
        // insertion order of the elements into the set.  LinkedHashSet class is a Hashtable and Linked list implementation of the Set interface.
        // The LinkedHashSet is a generic data structure that belongs to the Java.util library.  It's a direct descendant of the HashSet data structure,
        // hence, contains non-duplicate elements.  While its performance is likely to be just slightly less than that of HashSet,
        // due to the added expense of maintaining the linked list.
        LinkedHashSet<String> linkedset = new LinkedHashSet<>();
        // Adding element to LinkedHashSet using add() method
        linkedset.add("A");
        linkedset.add("B");
        linkedset.add("C");
        linkedset.add("D");
        // Note: This will not add new element as A already exists
        linkedset.add("A");
        linkedset.add("E");
        // Getting size of LinkedHashSet using size() method
        System.out.println("Size of LinkedHashSet = " + linkedset.size());
        System.out.println("Original LinkedHashSet:" + linkedset);
        // Removing existing entry from above Set using remove() method
        System.out.println("Removing D from LinkedHashSet: " + linkedset.remove("D"));
        // Removing an element that does not exist in the Set
        System.out.println("Trying to Remove Z which is not "
                + "present: " + linkedset.remove("Z"));
        // Checking for element whether it is present inside
        // Set or not using contains() method
        System.out.println("Checking if A is present = " + linkedset.contains("A"));
        // Printing the updated LinkedHashMap
        System.out.println("Updated LinkedHashSet: " + linkedset);
    }

    @Test
    public void addCollectionOfElements(){
        //We can add a Collection of elements to a LinkedHashSet
            Collection<Integer> data = Arrays.asList(1,2,3);
            LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
            assertTrue(linkedHashSet.addAll(data));
            assertTrue(data.containsAll(linkedHashSet) && linkedHashSet.containsAll(data));
    }

    @Test
    public void addCollectionOfElementsTwo(){
        //The rule of not adding duplicates also applies to the addAll() method as demonstrated below
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(2);
        Collection<Integer> data = Arrays.asList(1, 1, 2, 3);
        System.out.println("All elements added: " + linkedHashSet.addAll(data));
       // assertTrue(linkedHashSet.addAll(data));  //Will return true as all elements are added except duplicates elements which are not added.
                                                   //If there's more duplicates, the method return true if at least one element is added
                                                   //If nothing is added because the set already contains the elements, the method returns false.
        assertEquals(3, linkedHashSet.size());
        assertTrue(data.containsAll(linkedHashSet) && linkedHashSet.containsAll(data));
    }

    @Test
    public void linkedHashSetIterator(){
        //Iterating LinkedHashSet with Iterator
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(0);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        Iterator<Integer> iterator = linkedHashSet.iterator();
        for (int i = 0; i < linkedHashSet.size(); i++) {
            int nextData = iterator.next();
            assertEquals(i, nextData);
        }
    }

    @Test
    public void removeIfLinkedHashSet(){
        //removeIf() method
        //The removeIf() method removes an element that satisfies specified predicate conditions.
        //The example below removes all elements in the LinkedHashSet that are greater than 2:
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(0);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        System.out.println("The original LinkedHashSet: " + linkedHashSet);
        linkedHashSet.removeIf(data -> data > 2);
        assertFalse(linkedHashSet.contains(3));
        assertFalse(linkedHashSet.contains(4));
        System.out.println();
        System.out.println("The updated LinkedHashSet: " + linkedHashSet);
    }

    @Test
    public void sortedSetTests(){
        //SortedSet interface
        //The SortedSet interface extends the Set interface and is used to provide a particular ordering on the elements.
        // The elements are ordered either by using a natural ordering or by using a Comparator typically provided at the SortedSet creation time.
        // The SortedSet interface behaves like a normal Set with the exception that the elements it contains are sorted internally.
        // This means that when you iterate the elements of a SortedSet the elements are iterated in the sorted order.
        //The set's iterator will traverse the set in ascending element order. All the elements which are inserted into a sortedSet must
        // implement the Comparable interface. The SortedSet implements the mathematical set. This interface contains the methods inherited from
        // the Set interface and adds a feature that stores the elements in a sorted manner.
        // Several additional operations are provided to take advantage of the ordering. (This interface is the set analogue of SortedMap).
        SortedSet<String> ts = new TreeSet<>();
        // Adding elements into the TreeSet using add()
        ts.add("India");
        ts.add("Australia");
        ts.add("South Africa");
        ts.add("Madagascar");
        ts.add("Congo");
        // Adding the duplicate element
        ts.add("India");
        // Displaying the TreeSet
        System.out.println(ts);
        // Removing items from TreeSet using remove()
        ts.remove("Australia");
        System.out.println("Set after removing " + "Australia:" + ts);
        // Iterating over Tree set items
        System.out.println("Iterating over set:");
        Iterator<String> iterator = ts.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        //Notice in the output that elements are ordered in the natural order.
    }

    @Test
    public void sortedSetMethods(){
        //first() method
        // The first() method of SortedSet interface in Java is used to return the first or the lowest element currently in the set.
        // This function does not accept any parameter.  It returns the first or the lowest element currently in the set.
        // The function throws NoSuchElementException, if the set is empty.
        //last() method
        // The last() method of SortedSet interface in Java is used to return the last or the highest element currently in the set.
        // This function does not accept any parameter.  It returns the last or the highest element currently in the set.
        // The function throws NoSuchElementException, if the set is empty.
        //contains() method
        // The contains() method is used to check whether a specific element is present in the SortedSet or not.
        // Basically, it is used to check if a SortedSet contains any particular element.
        // The method returns true if the element is present in the set else return False.
        // The contains() method in SortedSet is inherited from the Set interface in Java.
        //Add() method
        // In order to add an element to the SortedSet, we can use the add() method. However, the insertion order is not retained in the TreeSet.
        // Internally, for every element, the values are compared and sorted in the ascending order. We need to keep a note that
        // duplicate elements are not allowed, and all the duplicate elements are ignored. And also, Null values are not accepted by the SortedSet.
        //remove() method
        // The values can be removed from the SortedSet using the remove() method.
        SortedSet<String> ts = new TreeSet<>();
        // Elements are added using add() method
        ts.add("A");
        ts.add("B");
        ts.add("C");
        ts.add("A");
        System.out.println("Sorted Set is " + ts);
        String check = "D";
        // Check if the above string exists in the SortedSet or not
        System.out.println("Contains " + check + " " + ts.contains(check));
        // Print the first element in the SortedSet
        System.out.println("First Value " + ts.first());
        // Print the last element in the SortedSet
        System.out.println("Last Value " + ts.last());
        //remove element and print the set
        System.out.println("Element C removed: " + ts.remove("C"));
        System.out.println("Set After C removed: " + ts);
    }

    @Test
    public void headSetMethodSet(){
        //headSet() method
        //The headSet(E toElement) method of SortedSet interface in Java is used to return a view of the portion of this
        // set whose elements are strictly less than the parameter toElement.
        //•	The set returned by this method is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        //•	The set returned by this method supports all optional set operations that this set supports.
        //
        // This function accepts a single parameter toElement which represent the high endpoint (exclusive) of the returned set.
        // It returns the last or the highest element currently in the set.
        // Create a TreeSet and inserting elements
        SortedSet<Integer> s = new TreeSet<>();
        // Adding Element to SortedSet
        s.add(1);
        s.add(5);
        s.add(2);
        s.add(3);
        s.add(9);
        // Returning the set with elements strictly less than the passed value
        System.out.print("Elements strictly less than 4 in set are : "
                + s.headSet(4));
    }

    @Test
    public void tailSetMethodSet(){
        //tailSet() method
        //The tailSet(E fromElement) method of SortedSet interface in Java is used to return a view of the portion of
        // this set whose elements are greater than or equal to the parameter fromElement.
        //•	The set returned by this method is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        //•	The set returned by this method supports all optional set operations that this set supports.
        //
        //This function accepts a single parameter fromElement which represent the low endpoint (inclusive) of the returned set.
        SortedSet<Integer> s = new TreeSet<>();
        // Adding Element to SortedSet
        s.add(1);
        s.add(5);
        s.add(2);
        s.add(3);
        s.add(9);
        System.out.println("Original set: " + s);
        // Returning the set with elements strictly less than the passed value
        System.out.print("Elements greater than or equal to 5 in set are : "
                + s.tailSet(5));
    }

    @Test
    public void iteratingThroughSortedSet(){
        //Iterating through the SortedSet
        //There are various ways to iterate through the SortedSet. The most famous one is to use the enhanced for loop.
        SortedSet<String> ts = new TreeSet<>();
        // Elements are added using add() method
        ts.add("C");
        ts.add("D");
        ts.add("E");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        // Iterating though the SortedSet
        for (String value : ts)
            System.out.print(value + ", ");
        System.out.println();
    }

    @Test
    public void subsetMethod(){
        //subSet(E fromElement, E toElement ) method
        //The subSet() method of SortedSet interface in Java is used to return a view of the portion of this set whose
        // elements range from fromElement, inclusive, to toElement, exclusive.
        //•	The set returned by this method is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        //•	The set returned by this method supports all optional set operations that this set supports.
        //Note: The set returned by this method will throw an IllegalArgumentException if an attempt is made to insert an element outside its range.
        //This function accepts two parameters fromElement and toElement which represent the low endpoint (inclusive) and high endpoint (exclusive) of
        //the returned set.  It returns the elements which in range between fromElement and toElement passed as argument.
        // Create a TreeSet and inserting elements
        SortedSet<Integer> s = new TreeSet<>();
        // Adding Element to SortedSet
        s.add(1);
        s.add(5);
        s.add(2);
        s.add(3);
        s.add(9);
        // Returning the set with elements ranging between the passed value
        System.out.print("Elements range between 2 and 9 in set are : "
                + s.subSet(2, 9));
    }

    @Test
    public void treesetClassTest(){
        //treeSet class
        //The TreeSet class is an implementation of the SortedSet Interface and is used to store elements in a sorted order.
        // It behaves like a normal set and uses a tree data structure for storage and elements are stored in a sorted, ascending order.
        // But we can iterate in descending order using method TreeSet.descendingIterator().  The ordering of the elements is maintained by
        // a set using their natural ordering whether or not an explicit comparator is provided. This must be consistent with equals if it
        // is to correctly implement the Set interface.  It can also be ordered by a Comparator provided at set creation time, depending on
        // which constructor is used. The TreeSet implements a NavigableSet interface by inheriting AbstractSet class.
        // Creating a NavigableSet object  with reference to TreeSet class
        //The lower(E ele)
        // The lower(E ele)method of TreeSet class in Java is used to return the greatest element in this set which is
        // strictly less than the given element. If no such element exists in this TreeSet collection then this method returns a NULL.
        //higher() method
        // The higher(E ele) method of TreeSet class in Java is used to return the least element in this set which is strictly greater than
        // the given element ele. If no such element is there then this method returns NULL.
        //Parameters: It takes only one parameter ele. It is the element based on which the least value in the
        // set which is strictly greater than this value is determined.
        //Return Value: It returns a value of type which this TreeSet stores which is either null or the required value.
        NavigableSet<String> ts = new TreeSet<>();
        // Elements are added using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        // Printing the elements inside the TreeSet object
        System.out.println("Tree Set is " + ts);
        String check = "Geeks";
        // Check if the above string exists in the treeset or not
        System.out.println("Contains " + check + " "
                + ts.contains(check));
        // Print the first element in the TreeSet
        System.out.println("First Value " + ts.first());
        // Print the last element in the TreeSet
        System.out.println("Last Value " + ts.last());
        String val = "Geek";
        // Find the values just greater and smaller than the above string
        System.out.println("Higher " + ts.higher(val));
        System.out.println("Lower " + ts.lower(val));
    }

    @Test
    public void lowerMethod(){
        TreeSet<Integer> tree = new TreeSet<Integer>();
        // Add elements to this TreeSet
        tree.add(10);
        tree.add(5);
        tree.add(8);
        tree.add(1);
        tree.add(11);
        tree.add(3);
        System.out.println(tree.lower(8));
    }

    @Test
    public void higherMethod(){
        TreeSet<String> tree = new TreeSet<>();
        tree.add("10");
        tree.add("5");
        tree.add("8");
        tree.add("1");
        tree.add("11");
        tree.add("3");
        // Pass a NULL to the method
        try {
            System.out.println(tree.higher(null));
        } // Catch the Exception
        catch (Exception e) {
            // Print the Exception
            System.out.println(e);
        }
    }

    @Test
    public void higherMethodTwo(){
        TreeSet<Integer> tree = new TreeSet<>();
        // Add elements to this TreeSet
        tree.add(10);
        tree.add(5);
        tree.add(8);
        tree.add(1);
        tree.add(11);
        tree.add(3);
        System.out.println(tree.higher(3));
    }

    @Test
    public void treesetClassTestTwo(){
        // Creating an object of NavigableSet with reference to TreeSet class
        // Declaring object of string type
        NavigableSet<String> ts = new TreeSet<>();
        // Elements are added using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        // Print and display initial elements of TreeSet
        System.out.println("Initial TreeSet " + ts);
        // Removing a specific existing element inserted above
        ts.remove("B");
        // Printing the updated TreeSet
        System.out.println("After removing element " + ts);
        // Now removing the first element using pollFirst() method
        ts.pollFirst();
        // Again, printing the updated TreeSet
        System.out.println("After removing first " + ts);
        // Removing the last element using pollLast() method
        ts.pollLast();
        // Printing the elements of TreeSet remaining to figure out pollLast() method
        System.out.println("After removing last " + ts);
    }

    @Test
    public void iteratingTreeSet(){
        //Iterating through the TreeSet
        // There are various ways to iterate through the TreeSet. The most famous one is to use the enhanced for loop.
        // Geeks mostly would be iterating the elements with this approach while practicing questions over TreeSet as
        // this is most frequently used when it comes to tree, maps, and graphs problems.
        Set<String> ts = new TreeSet<>();
        // Adding elements in above object using add() method
        ts.add("Geek");
        ts.add("For");
        ts.add("Geeks");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        // Now we will be using for each loop in order to iterate through the TreeSet
        for (String value : ts)
            // Printing the values inside the object
            System.out.print(value + ", ");
        System.out.println();
    }

    @Test
    public void treesetClassTestThree(){
        Set<StringBuffer> ts = new TreeSet<>();
        // Adding elements to the above object using add() method
        ts.add(new StringBuffer("A"));
        ts.add(new StringBuffer("Z"));
        ts.add(new StringBuffer("L"));
        ts.add(new StringBuffer("B"));
        ts.add(new StringBuffer("O"));
        ts.add(new StringBuffer(1));
        // Note: StringBuffer implements Comparable interface
        System.out.println(ts);
        System.out.println();

        StringBuffer stringBuffer = new StringBuffer(2);
        System.out.println("Value of StringBuffer: " + stringBuffer);
        System.out.println();
        stringBuffer = new StringBuffer("Monday");
        System.out.println("Updated value: " + stringBuffer);
        //The capacity refers to the total amount of characters storage size in string buffer.
        // An empty StringBuffer class contains the default 16 character capacity. If the number of the character increases from
        // its current capacity, it increases the capacity by (oldcapacity*2)+2.
    }

    @Test
    public void treesetClassTestFour(){
        //Demonstration of ClassCastException
        TreeSet<List> tree = new TreeSet<>();
        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        tree.add(l1);  //Throws ClassCastException
        List<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(6);
        tree.add(l3);  //Throws ClassCastException
        System.out.println("Original treeSet: " + tree);
        System.out.println();
        try {
            System.out.println(tree.lower(l3));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        //Getting ClassCastException when trying to add both ArrayList an LinkdedList to the TreeSet, as objects of List do not seem to
        // be implementing Comparable interface.  See exception below:
        // "java.lang.ClassCastException: class java.util.ArrayList cannot be cast to class java.lang.Comparable (java.util.ArrayList and
        // java.lang.Comparable are in module java.base of loader 'bootstrap')"
    }

    @Test
    public void ceilingMethod(){
        //ceiling() method
        // The ceiling(e) method of java.util.TreeSet<E> class is used to return the least element in this set greater than or
        // equal to the given element, or null if there is no such element.
        //Parameters: This method takes the value e as a parameter which is to be matched.
        //Return Value: This method returns the least element greater than or equal to e, or null if there is no such element.
        // Exception: This method throws NullPointerException if the specified element is null and this set uses natural ordering,
        // or its comparator does not permit null elements.
        // create tree set object
        try {
        TreeSet<Integer> treeAdd = new TreeSet<Integer>();
        // populate the TreeSet
        treeAdd.add(10);
        treeAdd.add(20);
        treeAdd.add(30);
        treeAdd.add(40);
            // Print the TreeSet
            System.out.println("TreeSet: " + treeAdd);
            // getting ceiling value for 25 using ceiling() method
            int value = treeAdd.ceiling(25);
            // printing the ceiling value
            System.out.println("Ceiling value for 25: "
                    + value);
        } catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }

    @Test
    public void ceilingMethodTwo(){
        try {
            // create tree set object
            TreeSet<Integer> treeAdd = new TreeSet<>();
            // populate the TreeSet
            treeAdd.add(10);
            treeAdd.add(20);
            treeAdd.add(30);
            treeAdd.add(40);
            // Print the TreeSet
            System.out.println("TreeSet: " + treeAdd);
            //descendingSet(): This method returns a reverse order view of the elements contained in this set.
            System.out.println("Descending set: " + treeAdd.descendingSet());
            // getting ceiling value for null using ceiling() method
            System.out.println("Trying to compare" + " with null value ");
            int value = treeAdd.ceiling(null);
            // printing  the ceiling value
            System.out.println("Ceiling value for null: " + value);
            System.out.println();
        }
        catch (NullPointerException e) {
            System.out.println("Exception: " + e);
        }
    }

    @Test
    public void floorMethodTest(){
        //floor(E e)
        //This method returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        // populate the TreeSet
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(40);
        // Print the TreeSet
        System.out.println("TreeSet: " + treeSet);
        Integer intX = treeSet.floor(25);
        System.out.println();
        System.out.println("The floor of 25 is: " + intX);
    }

    @Test
    public void navigableSetTest(){
        //NavigableSet interface
        // The NavigableSet interface extends the SortedSet interface. It behaves like a SortedSet with the exception that it contains
        // navigation methods in addition to the sorting mechanisms of the SortedSet.
        // In short, the NavigableSet is a SortedSet with navigation facilities. The NavigableSet interface provides many methods that can be used to
        // find the closest matches of any given element. It has the methods to find out less than, less than or equal to,
        // greater than and greater than or equal to of any element in a SortedSet.  For example, the NavigableSet interface can navigate the set in
        // reverse order compared to the order defined in SortedSet. A NavigableSet may be accessed and traversed in either ascending or descending order.
        // The classes that implement this interface are, TreeSet and ConcurrentSkipListSet.
        NavigableSet<Integer> ns = new TreeSet<>();
        ns.add(0);
        ns.add(1);
        ns.add(2);
        ns.add(3);
        ns.add(4);
        ns.add(5);
        ns.add(6);
        // Get a reverse view of the navigable set
        NavigableSet<Integer> reverseNs = ns.descendingSet();
        // Print the normal and reverse views
        System.out.println("Normal order: " + ns);
        System.out.println("Reverse order: " + reverseNs);
        NavigableSet<Integer> tailMore = ns.tailSet(3, true);
        System.out.println("tailSet:  " + tailMore);
        NavigableSet<Integer> headMore = ns.headSet(3, false);
        System.out.println("headSet: " + headMore);
        System.out.println("lower(3): " + ns.lower(3));
        System.out.println("floor(3): " + ns.floor(3));
        System.out.println("higher(3): " + ns.higher(3));
        System.out.println("ceiling(3): " + ns.ceiling(3));
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
        System.out.println("pollLast(): " + ns.pollLast());
        System.out.println("Navigable Set:  " + ns);
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);
        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("pollLast(): " + ns.pollLast());
        //Note: The NavigableSet interface provides many methods that can be used to find the closest matches of any given element.
        // It has methods to find less than, less than or equal to, greater than and greater than or equal to of any element in a SortedSet.
        //ceiling() method
        // The ceiling(e) method of java.util.TreeSet<E> class is used to return the least element in this set greater than or
        // equal to the given element, or null if there is no such element.
        //floor(E e)
        // This method returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
        //lower(E ele)
        // The lower(E ele)method of TreeSet class in Java is used to return the greatest element in this set which is
        // strictly less than the given element. If no such element exists in this TreeSet collection then this method returns a NULL.
        //higher() method
        // The higher(E ele) method of TreeSet class in Java is used to return the least element in this set which is strictly greater than
        // the given element ele. If no such element is there then this method returns NULL.
        //headSet() method
        // The headSet(E toElement) method of SortedSet interface in Java is used to return a view of the portion of this
        // set whose elements are strictly less than the parameter toElement.
        //tailSet() method
        // The tailSet(E fromElement) method of SortedSet interface in Java is used to return a view of the portion of
        // this set whose elements are greater than or equal to the parameter fromElement.
        //•	The set returned by this method is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        //•	The set returned by this method supports all optional set operations that this set supports.
    }

    @Test
    public void navigableSetTwo(){
        //Contains(), first(), last() methods
        //After adding the elements, if we wish to access the elements, we can use inbuilt methods like contains(), first(), last(), etc.
        NavigableSet<String> ts = new TreeSet<>();
        // Elements are added using add() method
        ts.add("A");
        ts.add("B");
        ts.add("C");
        ts.add("A");
        System.out.println("Navigable Set is " + ts);
        String check = "D";
        // Check if the above string exists in the NavigableSet or not
        System.out.println("Contains " + check + " "
                + ts.contains(check));
        // Print the first element in the NavigableSet
        System.out.println("First Value " + ts.first());
        // Print the last element in the NavigableSet
        System.out.println("Last Value " + ts.last());
    }

    @Test
    public void navigableSetThree(){
        //Remove(), pollFirst(), pollLast() methods
        //The values can be removed from the NavigableSet using the remove(), pollFirst(), pollLast() methods.
        NavigableSet<String> ts = new TreeSet<>();
        // Elements are added using add() method
        ts.add("A");
        ts.add("B");
        ts.add("C");
        ts.add("B");
        ts.add("D");
        ts.add("E");
        System.out.println("Initial TreeSet " + ts);
        // Removing the element b
        ts.remove("B");
        System.out.println("After removing element " + ts);
        // Remove the First element of TreeSet
        ts.pollFirst();
        System.out.println(
                "After the removal of First Element " + ts);
        // Remove the Last element of TreeSet
        ts.pollLast();
        System.out.println(
                "After the removal of Last Element " + ts);
    }

    @Test
    public void iteratingNavigableSet(){
        //Iterating through the NavigableSet
        //There are various ways to iterate through the NavigableSet. The most famous one is to use the enhanced for loop.
        NavigableSet<String> ts = new TreeSet<>();
        // Elements are added using add() method
        ts.add("C");
        ts.add("D");
        ts.add("E");
        ts.add("A");
        ts.add("B");
        ts.add("Z");
        // Iterating though the NavigableSet
        for (String value : ts)
            System.out.print(value + ", ");
        System.out.println();
    }
}
