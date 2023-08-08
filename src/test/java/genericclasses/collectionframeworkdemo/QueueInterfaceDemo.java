package genericclasses.collectionframeworkdemo;

import org.junit.Test;

import java.util.*;

public class QueueInterfaceDemo {
    //Queue interface
    //The Queue interface provides a linear ordered data structure that is based on the
    //First-In-First-Out (FIFO) ordering of elements. This means that the element that is inserted first in the queue,
    //comes out first. The Queue inserts elements at the end of the list and deletes elements from the start of the list.
    //It follows the FIFO (First-In-First-Out) principle. The Queue interface is found in java.util package and extends the Collection interface.

    @Test
    public void testQueueInterfaceOne(){
        //LinkedList class
        //The LinkedList class is a linear data structure where the elements are not stored in contiguous locations and
        //every element is a separate object with a data part and the address part. The elements are linked using pointers and addresses.
        //Each element is known as a node. LinkedList forms a series of connected nodes,
        //where each node stores the data and the address of the next node.

        Queue<String> fruits = new LinkedList<>();
        fruits.add("Mango");  //add() method: Adds element at the back of the queue.
        fruits.add("Banana");
        fruits.add("Pears");
        fruits.add("Orange");
        System.out.println("List of fruits: " + fruits);
        System.out.println();
        //peek() method: Returns the element at the front of the queue without removing it. If the queue is empty, it returns null.
        System.out.println("First element in the Queue: " + fruits.peek());
        System.out.println();
        //element() method: Returns the element at the front of the queue without removing it. If the queue is empty, it throws an exception.
        System.out.println("Retrieve First element in Queue with element() method: " + fruits.element());
        System.out.println();
        //offer(element) method: Adds an element to the rear of the queue. If the queue is full, it returns false.
        fruits.offer("Pineapple");
        System.out.println("Added element " + "\"" + "Pineapple" + "\"" + " to the Queue with offer() method: " + fruits);
        System.out.println();
        //remove() method: Removes and returns the element at the front of the queue. If the queue is empty, it throws an exception.
        String s = fruits.remove();
        System.out.println("First element removed with remove() method: " + s);
        System.out.println();
        //removeIf(Predicate predicate) method: as the name implies.
        fruits.removeIf(element -> element.startsWith("O"));
        System.out.println("Remove element if first letter starts with O: " + fruits);
        System.out.println();
        //poll() method: Removes and returns the element at the front of the queue. If the queue is empty, it returns null.
        String removedElement = fruits.poll();
        System.out.println("First element removed using poll() method: " + fruits);
        System.out.println("The element removed is: " + removedElement);
        System.out.println();
        System.out.println("The size of the Queue is: " + fruits.size());
        boolean removedEl = fruits.remove("Pineapple");   //remove(element): Removes the specified and returns a boolean.
        System.out.println("List after removing Pineapple element: " + fruits);
        System.out.println("Was the element Pineapple removed?: " + removedEl);
    }

    @Test
    public void testQueueInterfaceTwo(){
        //Deque interface
        //The Deque interface is related to the double-ended queue that supports the addition and removal of elements from
        //either end of the data structure. It can either be used as a queue(first-in-first-out/FIFO) or
        //as a stack(last-in-first-out/LIFO). Deque is the acronym for double-ended queue.  Deque interface is found in
        //java.util package is a subtype of the queue interface.  The Deque (double-ended queue) interface is a subinterface of
        //the Queue interface and extends it to provide a double-ended queue, which is a queue that allows elements to be added and
        //removed from both ends. The Deque interface is part of the Java Collections Framework and is used to provide a generic and
        //flexible data structure that can be used to implement a variety of algorithms and data structures.
        //
        //ArrayDeque in Java
        //The ArrayDeque class is an implementation of the Deque interface that uses a resizable array to store its elements.
        //The ArrayDeque provides a way to apply a resizable-array in addition to the implementation of the Deque interface.
        //It is also known as Array Double Ended Queue or Array Deck. This is a special kind of array that grows and
        //allows users to add or remove elements from both sides of the queue. This class provides a more efficient alternative to
        //the traditional Stack class, which was previously used for double-ended operations. The ArrayDeque class provides constant-time
        //performance for inserting and removing elements from both ends of the queue, making it a good choice for scenarios where you need to
        //perform many add and remove operations.

        Deque<Integer> dequeList =  new ArrayDeque<>();
        dequeList.offer(9);  //offer() method: Adds element at the back of the queue.
        dequeList.offer(7);
        dequeList.offer(18);
        System.out.println("The Original DeQue is: " + dequeList);
        System.out.println();
        //Adding element at the start of the queue
        dequeList.addFirst(33);
        System.out.println("Element 33 added using addFirst() method: " + dequeList);
        dequeList.addFirst(47);
        System.out.println();
        System.out.println("Again 44 added using addFirst() method: " + dequeList);
        System.out.println();
        //Adding element at the end of the queue with addLast() method
        dequeList.addLast(91);
        System.out.println("91 added at the end of the queue using addLast() method " + dequeList);
        System.out.println();
        dequeList.addLast(110);
        System.out.println("Again 110 added at the end of the queue using addLast() method: " + dequeList);
        System.out.println();
        //Now adding an element with add() method.  add() method add the element at the end of the queue like addLast() method
        dequeList.add(55);
        System.out.println("55 added using add() method: " + dequeList);
        System.out.println();
        //Adding element using add() method again
        dequeList.add(89);
        System.out.println("Added 89 using add() method: " + dequeList);
        System.out.println();
        //Remove element with remove() method. The remove() method removes the first element at the start of the queue.
        dequeList.remove();
        System.out.println("Element removed with remove(): " + dequeList);
        dequeList.remove();
        System.out.println("Element removed again with remove(): " + dequeList);
        System.out.println();
        //Remove the first element with removeFirst() method.  removeFirst() removes the first element of the queue.
        int removedElement = dequeList.removeFirst();
        System.out.println("Element removed: " + removedElement);
        System.out.println("First element removed with removeFirst(): " + dequeList);
        dequeList.removeFirst();
        System.out.println("Again removed first element with removeFirt() " + dequeList);
        System.out.println();
        //Removing the last element with removeLast() method
        dequeList.removeLast();
        System.out.println("Last element removed with removeLast() method: " + dequeList);
        dequeList.removeLast();
        System.out.println("Again removed last element with removeLast() method: " + dequeList);
    }

    @Test
    public void testQueueInterfaceThree(){
        Deque<Integer> integerQueue = new ArrayDeque<>();
        for (int i = 111; i <= 117; i++){
            integerQueue.add(i);
        }
        System.out.println("The queue is: " + integerQueue);
        integerQueue.add(112);
        integerQueue.offer(111);
        integerQueue.offer(112);
        integerQueue.offer(119);
        integerQueue.offer(112);
        System.out.println();
        System.out.println("Added more element: " + integerQueue);
        System.out.println();
        //Removing the first occurence of an element with removeFirstOccurence() method.
        integerQueue.removeFirstOccurrence(112);
        System.out.println("First occurence of 112 removed with removeFirstOccurrence() method: " + integerQueue);
        System.out.println();
        //Removing last occurrence of an element with removeLastOccurrence() method.
        integerQueue.removeLastOccurrence(112);
        System.out.println("Removed last occurrence of 112 with removeLastOccurrence() method: " + integerQueue);
        System.out.println();
        System.out.println("Get the first element: " + integerQueue.getFirst());  //Getting the first element
        System.out.println("Get the last element: " + integerQueue.getLast());    //Getting the last element
        System.out.println("The size of the queue: " + integerQueue.size());
        System.out.println("Get the first element with element() method: " + integerQueue.element());
        //contains() method is used to check whether the queue contains the given object or not.  returns true if found or false otherwise.
        System.out.println("Does the list contains element 115?: " + integerQueue.contains(115));
        System.out.println();
        System.out.println("Remove the first element using poll(): " + integerQueue.poll()); //poll() method: Removes and returns the first element
        System.out.println("Checking first element has been removed: " + integerQueue);
        System.out.println();
        integerQueue.push(255);  //push() method: pushes an element onto stack represented by deque.  Adds the element at the beginning of the queue.
        System.out.println("Added the first element 255 using push(): " + integerQueue);
        System.out.println();
        System.out.println("Remove the first element with pop(): " + integerQueue.pop());  //The method pops out the first element of the queue.
        //The pop() method throws an EmptyStackException if the stack is empty.
        System.out.println("Check that the element has been removed: " + integerQueue);
        System.out.println();
        System.out.println("Remove last element using pollLast(): " + integerQueue.pollLast());  //pollLast() method: Removes and returns the last element.
        System.out.println("Checking element has been removed: " + integerQueue);
        System.out.println();
        System.out.println("Remove the first element with pollFirst(): " + integerQueue.pollFirst());  //pollFirst(): Removes and returns the first element.
        System.out.println("Checking that the element has been removed: " + integerQueue);
        System.out.println();
        integerQueue.clear();   //clear() method: deletes all elements from this collection.  The collection will be empty after this code is executed.
        System.out.println("Clearing the ArrayDequeue with clear(): " + integerQueue);
    }

    @Test
    public void testQueueInterfaceFour(){
        Deque<Integer> intQueue = new ArrayDeque<>(5);  //Does not seem to restrict adding more than 5 elements.
        intQueue.push(239);
        intQueue.push(415);
        intQueue.offerLast(500);
        intQueue.addFirst(1);
        intQueue.addLast(337);
        intQueue.offer(55);
        intQueue.addLast(200);
        System.out.println("Printing the original Queue: ");
        for(Integer element: intQueue){
            System.out.println("Element: " + element);
        }
        System.out.println();
        System.out.println("Converting the DeQueue to an Array and printing elements:");
        Object[] intArray = intQueue.toArray();
        for (int i = 0; i < intArray.length; i++){
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
        System.out.println("The Array length is: " + intArray.length);
        System.out.println();
        System.out.println("Printing the elements of the ArrayDeQue using the iterator: ");
        for (Iterator<Integer> iterator = intQueue.iterator();   //Using "for loop" instead of "While loop".
        iterator.hasNext();){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        //descendingIterator()
        //Using the descendingIterator() method to reverse the deque order
        System.out.println("Printing the element of the ArrayQue in descending order: ");
        for (Iterator<Integer> descIterator = intQueue.descendingIterator(); descIterator.hasNext();){
            System.out.print(descIterator.next() + " ");
        }
        System.out.println();
        System.out.println("Using peekFist() to access the first element: " + intQueue.peekFirst());//peekFirst(): returns the first element without removing it.
        System.out.println();
        System.out.println("Using peekLast to access the last element: " + intQueue.peekLast()); //peekLast(): returns the last element without removing it.
        System.out.println("Printing the queue again: " + intQueue);
        System.out.println();
    }

    @Test
    public void testDeQueInterface(){
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.offer("Sunday");
        stringDeque.offer("Saturday");
        stringDeque.offer("Friday"); //offer() method: Adds element at the back of the queue.
        stringDeque.add("Thursday");  //add() method: Adds element at the back of the queue.
        stringDeque.push("Test");  //The push() method: Adds element at the front of the queue.
        stringDeque.offer("Wednesday");
        stringDeque.offer("Tuesday");
        stringDeque.offer("Monday");
        String strIn = "Friday";
        int counter = 0;
        int pos = 0;

        System.out.println("The original Deque is: \n" + stringDeque);
        System.out.println("Original size of Deque is: " + stringDeque.size());
        for (Iterator iterator = stringDeque.iterator(); iterator.hasNext();){
            counter++;
            if(iterator.next() == strIn){   //Trying to find how many item on top of strIn and remove strIn.  go back to this later.
                pos = counter -1;
                stringDeque.remove(strIn);
            }
        }
        System.out.println();
        System.out.println("After removing element, Queue size is now: " + stringDeque.size());
        System.out.println("Number of element of top of the removed element: " + pos);
    }

    @Test
    public void testDeQueInterfaceTwo(){
        Deque<String> dq = new ArrayDeque<>();
        // add() method to insert
        dq.add("For");
        dq.addFirst("Geeks");
        dq.addLast("Geeks");
        System.out.println(dq);
        System.out.println(dq.pollLast());
        System.out.println(dq.poll());
        System.out.println(dq.pollFirst());
        System.out.println(dq.pop());  //Throws an exception as no element to delete is found. pop() method throws exception if the queue is empty.
                                       //poll(),pollLast(),and pollFirst() methods do not throw an exception when the queue is empty, they return null.
    }

    @Test
    public void testDequeInterfaceThree(){
        // Initializing an deque
        Deque<Integer> de_que = new ArrayDeque<>(5);  //Capacity restriction does not seem to work.  Elements keep being added.
        // add() method to insert
        de_que.add(10); //The add() method adds elements at the back of the queue.
        de_que.add(20);
        de_que.add(30);
        de_que.add(40);
        de_que.add(50);
        System.out.println(de_que);
        System.out.println();
        // clear() method
        de_que.clear();   //clear method removes all elements from the queue.
        System.out.println("All elements deleted with clear(): " + de_que);
        System.out.println();
        // addFirst() method to insert the elements at the head
        de_que.addFirst(564);
        de_que.addFirst(291);
        // addLast() method to insert the elements at the tail
        de_que.addLast(24);
        de_que.addLast(14);
        System.out.println(de_que);
    }

    @Test
    public void testPriorityQueueOne(){
        //PriorityQueue class
        //A PriorityQueue class implements the Queue interface and is used when the objects are supposed to be processed based on the priority.
        //It is a data structure in which elements are ordered by priority, with the highest-priority elements appearing at the front of the queue.
        //It is known that the Queue follows the First-In-First-Out algorithm, but sometimes the elements of the queue need to be processed according to
        //the priority, that’s when the PriorityQueue comes into play.  The PriorityQueue is based on the priority heap. The elements of the
        //priorityQueue are ordered according to the natural ordering, or by a Comparator provided at the queue construction time,
        //depending on which constructor is used.

        //Basic operations of the priority queue
        // • boolean add(E element): This method inserts the specified element into this priority queue.
        // • public peek(): This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        // • public poll(): This method retrieves and removes the head of this queue or returns null if this queue is empty.

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(15);
        priorityQueue.add(33);
        priorityQueue.add(7);
        priorityQueue.add(2);
        System.out.println("Original Priority queue: " + priorityQueue);  //Notice that the elements are not showing the order in which they are stored.
        System.out.println();                                             //Elements are stored in natural order if the comparator has not been provided.
        // Printing the top element of PriorityQueue
        System.out.println("Top element in the Priority queue: " + priorityQueue.peek());
        System.out.println();
        System.out.println("Printing the Priority queue again after peek() operation: " + priorityQueue);
        // Printing the top element and removing it from the PriorityQueue container
        System.out.println("Removing the top element from the Priority queue: " + priorityQueue.poll());
        System.out.println();
        System.out.println("Printing the Priority queue again: " + priorityQueue);
        System.out.println();
        // Printing the top element again
        System.out.println("Top element in the Priority queue: " + priorityQueue.peek());
        System.out.println();
        System.out.println("Removing top element again: " + priorityQueue.poll());
        System.out.println("Printing the queue again: " + priorityQueue);
        System.out.println();
        System.out.println("Removing top element again: " + priorityQueue.poll());
        System.out.println("Printing the queue again: " + priorityQueue);  //These steps confirm that the elements of PriorityQueue are ordered according to
                                                                            //the natural ordering.
    }

    @Test
    public void testPriorityQueueTwo(){
        //Adding Elements with add() method
        //In order to add an element in a priority queue, we can use the add() method.
        //The insertion order is not retained in the PriorityQueue.
        //The elements are stored based on the priority order which is ascending by default.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<3;i++){
            pq.add(i);
            pq.add(1);
        }
        System.out.println(pq);
        //Note: We will not get sorted elements by printing the PriorityQueue.
    }

    @Test
    public void testPriorityQueueTwoB(){
        //The elements of the priorityQueue are ordered according to the natural ordering,
        //or by a Comparator provided at the queue construction time, depending on which constructor is used.
        //The insertion order is not retained in the PriorityQueue.
        //The elements are stored based on the priority order which is ascending by default.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(23);
        priorityQueue.add(20);
        priorityQueue.add(11);
        priorityQueue.add(3);
        priorityQueue.add(9);
        System.out.println("Printing original PriorityQueue: " + priorityQueue);
        for (Iterator<Integer> iterator = priorityQueue.iterator(); iterator.hasNext();){
            System.out.println("Removed element: " + priorityQueue.poll());  //Output confirms elements are removed based on natural ordering.
        }
    }

    @Test
    public void testPriorityQueueThree(){
        //Removing Elements with remove() and poll() methods
        //In order to remove an element from a priority queue, we can use the remove() method.
        //If there are multiple such objects, then the first occurrence of the object is removed.
        //Apart from that, the poll() method is also used to remove the head and return it.
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
        System.out.println("Initial PriorityQueue " + pq);
        System.out.println("Removing element Geeks: " + pq.remove("Geeks"));//remove() method throws an exception if the queue is empty and,
        System.out.println("After Remove - " + pq);                            //it returns true if the element is removed.
        System.out.println("Poll Method - " + pq.poll());
        System.out.println("Final PriorityQueue - " + pq);
    }

    @Test
    public void testPriorityQueueThreeB(){
        //remove() method
        //We can use the remove() method to remove the head element from a priority queue.
        //If there are multiple such objects, then the first occurrence of the object is removed.
        //The method returns true if the element is removed, and throws an exception if the queue is empty
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(27);
        priorityQueue.add(15);
        priorityQueue.add(1);
        priorityQueue.add(8);
        System.out.println("Original PriorityQueue: " + priorityQueue);
        priorityQueue.remove();
        System.out.println("PriorityQueue after remove(): " + priorityQueue);
        System.out.println();
        priorityQueue.remove();
        System.out.println("PriorityQueue after remove() again: " + priorityQueue);
    }

    @Test
    public void testPriorityQueueFour(){
        //Accessing the elements with peek() method
        //Since Queue follows the First In First Out principle, we can access only the head of the queue.
        //To access elements from a priority queue, we can use the peek() method.
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
        System.out.println("PriorityQueue: " + pq);
        // Using the peek() method
        String element = pq.peek();
        System.out.println("Accessed Element: " + element);
    }

}
