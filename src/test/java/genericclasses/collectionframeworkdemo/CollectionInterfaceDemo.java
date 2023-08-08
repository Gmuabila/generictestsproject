package genericclasses.collectionframeworkdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectionInterfaceDemo {
    @Test
    public void collectionInterfaceTest(){
        //Collection Interface
        //This is a basic foundation for the Collection framework as it provides all the necessary methods for implementation.
        //The Map interface is the only data structure that does not implement the Collection interface,
        //but all the remaining interfaces implement its methods. This interface has methods for knowing the size of the collection,
        //and whether an object exists in the collection, adding or removing objects from the collection.
        //The Collection interface allows items to be grouped within a single container object.
        //It is found in the java.util package and is implemented by List, Set, and Queue.

        //This is an example of the Collection interface being implemented by an ArrayList

        Collection<String> food = new ArrayList<>();
        food.add("Cabbage");
        food.add("Pizza");
        food.add("Sausage");
        food.add("Potatoes");
        food.add("Salad");
        System.out.println("Printing the original collection: " + food);
        System.out.println("Does the collection contains Cabbage? : " + food.contains("Cabbage"));
        food.remove("Cabbage");
        System.out.println("Does the collection contain " + "\"" + "Cabbage" + "\" :" + food.contains("Cabbage"));
        System.out.println("Printing the Collection: " + food);
    }

    @Test
    public void iteratorMethod(){
        Integer[] arrayInts = new Integer[2];  //Array to hold Min and Max numbers
        Collection<Integer> integerCollection = new ArrayList<>();
        integerCollection.add(3349);
        integerCollection.add(456);
        integerCollection.add(1000);
        integerCollection.add(34);
        System.out.println("Original collection: " + integerCollection);
        System.out.println();
        //Iterating through the Collection and print all elements.
        Iterator<Integer> iterator = integerCollection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        arrayInts[0] = Collections.max(integerCollection);  //Getting a Maximum number in the collection
        arrayInts[1] = Collections.min(integerCollection);  //Getting the Minimum number in the collection.
        System.out.println("Max number is: " + arrayInts[0]);
        System.out.println("Min number is: " + arrayInts[1]);
    }

    @Test
    public void iteratorMethodTwo(){
        //Method to print a collection containing the alphabet Characters
        Collection<Character> collection = new ArrayList<>();
        for (char b = 'a'; b <= 'z'; b++) {
            collection.add(b);
        }
        System.out.print("Characters : ");
        System.out.print("[");
        Iterator<Character> iterator = collection.iterator();
        //will return the iterator for all characters
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ,");
        }
        System.out.println("]");
    }

    static int i = 1;
    @Test
    public void iteratorMethodThree() {
        Collection<String> collection = new ConcurrentLinkedQueue<>();
        collection.add("Glenn");
        collection.add("Leonie");
        collection.add("GTech");
        collection.add("Mamie");
        Iterator<String> iterator = collection.iterator();
        //Returns an iterator over the elements
        while (iterator.hasNext()) {
            System.out.println(i++ + "." + iterator.next());
        }
    }
}
