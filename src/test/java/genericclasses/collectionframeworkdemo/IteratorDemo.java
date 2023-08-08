package genericclasses.collectionframeworkdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    @Test
    public void iteratorDemo(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        numbers.add(79);
        numbers.add(87);
        numbers.add(5);

        System.out.println("Items in the list before processing:\n" + numbers);
        System.out.println();
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()) {
            Integer i = iterator.next();
            if(i < 10) {
                iterator.remove();
            }
        }
        System.out.println("After removing numbers less than 10:");
        System.out.println(numbers);
    }
}


