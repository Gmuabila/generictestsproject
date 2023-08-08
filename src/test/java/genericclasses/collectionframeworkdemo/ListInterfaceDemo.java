package genericclasses.collectionframeworkdemo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListInterfaceDemo {
    //List Interface
    //The List interface in Java provides a way to store an ordered collection of objects in which duplicate values can be stored.
    //It is a sub interface of the Collection interface.  Since the List preserves the insertion order,
    //it allows positional access and insertion of elements.  The List interface is found in java.util package and inherits the Collection interface.
    //It is a factory of the ListIterator interface. Through the ListIterator, we can iterate the list in forward and backward directions.
    //The implementation classes of the List interface are ArrayList, LinkedList, Stack, and Vector.
    //ArrayList and LinkedList are widely used in Java programming. The Vector class is deprecated since Java 5.
    //Since the List is an interface, objects cannot be created of the type list. We always need a class that implements this
    //List in order to create an object. And also, after the introduction of Generics in Java 1.5, it is possible to restrict the
    //type of object that can be stored in the List.

    @Test
    public void testListInterfaceOne() {
        //ArrayList class
        //ArrayList class provides us with dynamic arrays in Java. Though, it may be slower than standard arrays but can be helpful in
        //programs where lots of manipulation in the array is needed. The size of an ArrayList increases automatically if the collection grows or
        //shrinks if the objects are removed from the collection. Java ArrayList allows us to randomly access the list.
        //ArrayList cannot be used for primitive types, like int, char, etc. We will need a wrapper class for such cases.
        List<Integer> integerList = new ArrayList<>();
        //Adding elements at index 0, and 1.
        integerList.add(0, 1);
        integerList.add(1, 2);
        System.out.println("Printing integerList: " + integerList);
        System.out.println();
        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(5);
        integerList2.add(6);
        integerList2.add(7);
        integerList2.add(1);
        System.out.println("Printing integerList2: " + integerList2);
        System.out.println();
        integerList.addAll(integerList2);
        System.out.println("Printing integerList: " + integerList);
        System.out.println();
        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(1);
        System.out.println("Printing integerList3: " + integerList3);
        integerList.removeAll(integerList3);
        System.out.println("Printing integerList: " + integerList);
        System.out.println();
        System.out.println("Printing element at index 3 in integerList: " + integerList.get(3));
        System.out.println();
        //Set element at index 3 with value 10 in integerList
        integerList.set(3, 10);
        System.out.println("Printing element at index 3 in integerList: " + integerList.get(3));
        System.out.println();
    }

    @Test
    public void testListInterfaceTwo() {
        //indexOf(), lastIndexOf(), contains(), containsAll(Collection collection) methods
        //The List interface provides several methods to search for elements, such as the indexOf(), lastIndexOf() methods.
        //The indexOf() method returns the index of the first occurrence of a specified element in the list,
        //while the lastIndexOf() method returns the index of the last occurrence of a specified element.
        //The contains() method is used to search for an element
        //The containsAll() method returns true if all the items in collection are contained in the collection.
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(1);
        integerList.add(0, 1);
        System.out.println("Printing the list: " + integerList);
        System.out.println();
        //Printing the index of the first occurrence of the element 1.
        System.out.println("index of the first occurrence of 1 is: " + integerList.indexOf(1));
        System.out.println();
        System.out.println("index of the last occurrence of 1 is: " + integerList.lastIndexOf(1));
        System.out.println();
        //Using contains() method to find an element in a List
        System.out.println("The List contains 7?: " + integerList.contains(7));
        System.out.println();
        //Using containsAll() to find if all element in integerList2 are contained in integerList.
        List<Integer> integerList2 = new ArrayList<>();
        integerList2 = Arrays.asList(6, 7, 1);
        System.out.println("Does the integerList contains all elements in integerList2?: " + integerList.containsAll(integerList2));
    }

    @Test
    public void testListInterfaceThree() {
        //remove(int index), removeAll(Collection<T> c), and removeIf(Predicate predicate)
        //remove(int index) is used to remove an element from the collection using its index.
        //
        //removeAll(Collection<T> c) is used to remove from this list all of its elements that are contained in the specified collection.
        //Parameters: This method takes collection c as a parameter containing elements to be removed from this list.
        //Returns Value: This method returns true if this list changed as a result of the call.
        //Exception: This method throws NullPointerException if this list contains a null element and the specified collection does not
        //permit null elements (optional), or if the specified collection is null.
        try {
            List<Integer> integerList = new ArrayList<>();
            for (int i = 9; i < 15; i++) {
                integerList.add(i);
            }
            System.out.println("Printing integerList elements one by One:.....");
            for (int i = 0; i < integerList.size(); i++) {
                System.out.print(integerList.get(i) + " ");
            }
            //Deleting element at index 4 using the index and print the list
            integerList.remove(4);
            System.out.println();
            System.out.println("Printing the list after removing element at index 4: " + integerList);
            System.out.println();
            //Adding more elements to make duplicates
            integerList.add(12);
            integerList.add(11);
            System.out.println("Printing the list before using removeAll method: " + integerList);
            //Deleting all elements in integerList2 from integerList
            List<Integer> integerList2 = new ArrayList<>();
            integerList2 = List.of(11, 12);
            boolean boo = integerList.removeAll(integerList2);  //Will remove all elements in integerList2 from the integerList including all duplicates.
            System.out.println("Are the elements removed?: " + boo);
            System.out.println();
            System.out.println("Printing the list: " + integerList);
        } catch (NullPointerException e) {
            System.out.println("Exception thrown: " + e);
        }

    }

    @Test
    public void testListLinkedListOne(){
        //LinkedList class
        //The LinkedList class is a linear data structure where the elements are not stored in contiguous locations and
        //every element is a separate object with a data part and address part. The elements are linked using pointers and addresses.
        //Each element is known as a node.   LinkedList forms a series of connected nodes,
        //where each node stores the data and the address of the next node.
        LinkedList<Integer> lList = new LinkedList<>();
        // Appending new elements at the end of the list
        for (int i = 1; i <= 5; i++)
            lList.add(i);
        // Printing elements
        System.out.println("Original linkedList: " + lList);
        System.out.println();
        // Remove element at index 3
        lList.remove(3);
        // Displaying the List after deletion
        System.out.println("LinkedList after removing element at index 3: " + lList);
        System.out.println();
        // Printing elements one by one
        for (int i = 0; i < lList.size(); i++)
            System.out.print(lList.get(i) + " ");
        System.out.println();
        System.out.println();
        //Add and new element at index 2
        lList.add(2, 7);
        System.out.println("Printing lList after adding element at index 2: " + lList);
        System.out.println();
        //AddLast() method appends the element to the end of the list
        lList.addLast(10);
        System.out.println("Element added to the end of the list: " + lList);
        System.out.println();
        //addFirst() method adds the element to the front of the list
        lList.addFirst(15);
        System.out.println("Element added at the start of the list: " + lList);
        System.out.println();
        //adding another element at the end of the list
        lList.add(33);
        System.out.println("New element added at the end of the list: " + lList);
        //Updating element at index 1 with 45
        lList.set(1, 45);
        System.out.println("Updated element at index 1 with 45: " + lList);
        System.out.println();
        //Printing index of element 33
        System.out.println("Index of element 33 is: " + lList.indexOf(33));
    }

    //Stack class
    //Stack class is a linear data structure that is based on the basic principle of last-in-first-out.
    //The class can also be said to extend Vector.  The class can also be referred to as the subclass of Vector.
    //The class supports one default constructor Stack() which is used to create an empty stack.
    //In addition to the basic push and pop operations, the class provides three more functions, empty, search, and peek.
    //Stack Data structure
    //Stack is a linear data structure that follows a particular order in which the operations are performed.
    //The order may be LIFO(Last In First Out) or FILO(First In Last Out). LIFO implies that the element that is inserted last,
    //comes out first and FILO implies that the element that is inserted first, comes out last.

    @Test
    public void testStackOne() {
        //push() method
        //The push() method is used to push an element into the Stack. The element gets pushed onto the top of the Stack.
        //The method accepts one parameter element that refers to the element to be pushed into the stack.
        //The method returns the argument passed.  It also accepts the null value unlike ArrayDeque.push() which throws
        //java.lang.NullPointerException on doing the same.

        //initialisation of Stack using generics
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Monday");
        stringStack.push("Tuesday");
        stringStack.push(null);       //Notice that stack accepts null values.
        stringStack.push("Wednesday");
        stringStack.push("Thursday");
        stringStack.push("Friday");
        System.out.println("The original stack is: " + stringStack);
        System.out.println();
        Iterator<String> iterator = stringStack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        stringStack.pop();
        //Reinitialising the iterator as if you try reusing, you get ConcurrentModificationException
        iterator = stringStack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        //Default initialisation of the Stack
        Stack stack = new Stack();  //Need to use generics to restrict the type of elements in the stack.
        stack.push("Carmel");
        stack.push(23);
        stack.push(44.5);
        System.out.println("Printing Stack initialised with Default initialisation: " + stack);
        //Notice the different data types in the stack and the compiler does not complain.  Object in this case is the type.
    }

    @Test
    public void testStackOneB(){
        //peek() method
        //The peek() method in Java is used to retrieve or fetch the first element of the Stack or
        //the element present at the top of the Stack. The element retrieved does not get deleted or removed from the Stack.
        //The method does not take any parameters but returns the element at the top of the Stack.
        //The method throws EmptyStackException if the stack is empty.
        //Search() method
        //The search(Object element) method in Java is used to search for an element in the stack and get its distance from the top.
        //It returns the position of the element from the top of the stack.
        //This method starts the count of the position from 1 and not from 0. The element that is on the top of the stack is
        //considered to be at position 1. If more than one element are present, the index of the element closest to the top is returned.
        //The method returns its position if the element is successfully found and returns -1 if the element is not found.
        Stack<Integer> intStack = new Stack<>();
        for(int i = 1; i < 6; i++){
            intStack.push(i);
        }
        System.out.println("Stack elements: " + intStack);
        System.out.println();
        System.out.println("Element at the top of the stack is: " + intStack.peek());
        System.out.println("The position of this element in the stack is: " + intStack.search(5));
        System.out.println();
        //Creating an empty stack
        Stack<String> strStack = new Stack<>();
        //empty() method / isEmpty method()
        //The empty() method of the Stack class is used to check whether a stack is empty or not.
        //The method returns true if the stack is empty else false. The method does not take any parameters.
        //Also note that the Collection interface provide the method isEmpty() that the Stack class can inherit to check if a Stack is empty.
        //Using Stack empty() method to check if the stack is empty before retrieving an element with peek.
        if (!strStack.empty()){
            System.out.println("Is the stack empty? if not print the first element: " + strStack.peek());
        }else {
            System.out.println("The stack is Empty");
        }
        String element = strStack.peek();   //Will throw EmptyStackException as this stack is empty.
        System.out.println();
        System.out.println("Stack is not empty, peek() result: " + element);
    }

    @Test
    public void testStackOneC(){
        //pop() method
        //pop() method in Java is used to pop an element from the stack.
        //The element is popped from the top of the stack and removed.
        //The method does not take any parameters, and returns the element present at the top of the stack and then removes it.
        //The Exception EmptyStackException is thrown if the stack is empty.
        Stack<Integer> integerStack = new Stack<>();
        for (int i =10; i <= 15; i++){
            integerStack.push(i);
        }
        System.out.println("Stack elements are: " + integerStack);
        System.out.println();
        Integer removedInt = integerStack.pop();
        System.out.println("The removed element is: " + removedInt);
        System.out.println("The stack is now: " + integerStack);
        System.out.println();
        System.out.println("Removing another top element: " + integerStack.pop());
        System.out.println("The stack is now: " + integerStack);
    }

    // Pushing element on the top of the stack
    static void stack_push(Stack<Integer> stack) {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println("Elements in the original stack: " + stack);
        System.out.println();
    }

    // Popping element from the top of the stack
    static void stack_pop(Stack<Integer> stack) {
        System.out.println("Pop Operation:");
        for (int i = 0; i < 5; i++) {
            Integer y = stack.pop();
            System.out.println(y);
        }
        System.out.println();
        System.out.println("Element in stack after pop: " + stack);
    }

    // Displaying element on the top of the stack
    static void stack_peek(Stack<Integer> stack) {
        Integer element = stack.peek();
        System.out.println("Element on stack top: " + element);
        System.out.println("Stack elements after peek: " + stack);
    }

    // Searching element in the stack
    static void stack_search(Stack<Integer> stack, int element) {
        Integer pos = stack.search(element);
        if (pos == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position: " + pos);
    }

    @Test
    public void testStackTwo() {
        Stack<Integer> stack = new Stack<>();
        stack_push(stack);
        stack_pop(stack);
        stack_push(stack);
        stack_peek(stack);
        stack_search(stack, 2);
        stack_search(stack, 6);
    }

    @Test
    public void testStackThree(){
        //Using methods of the Collection interface
        //The Stack search() method is defined below again for clarification.  It returns the position of an element from the top of the stack not the index.
        //Search() method
        //The search(Object element) method in Java is used to search for an element in the stack and get its distance from the top.
        //It returns the position of the element from the top of the stack.
        //This method starts the count of the position from 1 and not from 0. The element that is on the top of the stack is
        //considered to be at position 1. If more than one element are present, the index of the element closest to the top is returned.
        //The method returns its position if the element is successfully found and returns -1 if the element is not found.
        Stack<Integer> stackOne = new Stack<>();
        for (int i = 100; i <= 110; i++){
            stackOne.add(i);   //Using add() method of the Collection interface that is used to insert an element into the collection
        }
        System.out.println("Printing stack one: " + stackOne);
        //search() method returns the position of the element at the top of the stack.
        System.out.println("Position of 104 in the stack using search() is: " + stackOne.search(104));  //Returns the position of 104 in the stack not the index.
        System.out.println("The index of 104 in the stack using indexOf() is: " + stackOne.indexOf(104));  //Returns the index of 104 in the stack
        System.out.println("The element at index 4 using get(index) is: " + stackOne.get(4)); //Returns the element at index 4 in the stack
        System.out.println();
        //The capacity() method of Stack Class is used to get the capacity of the Stack. That is the number of elements present in this stack container.
        System.out.println("Printing the capacity of stackOne: " + stackOne.capacity()); //Not clear, to be looked at.
        System.out.println();
        //elementAt(int pos) method is used to fetch or retrieve an element at a specific index from a Stack.
        System.out.println("Element at index 4 using elementAt(): " + stackOne.elementAt(4)); //Returns the element at index 4 in the stack.

        //get(index) method of the stack class is used to fetch or retrieve an element at a specific index from a Stack.
        System.out.println("Element at index 4 using get(index) method: " + stackOne.get(4));
        System.out.println();
        System.out.println("Element at index 0: " + stackOne.get(0));
        System.out.println();
        Stack<Integer> stackTwo = new Stack<>();
        for (int i = 300; i <= 303; i++){
            stackTwo.push(i);
        }
        System.out.println("Printing stack two: " + stackTwo);
        System.out.println();
        //Insert stackTwo at index 4 of stackOne
        stackOne.addAll(4, stackTwo);
        System.out.println("stackOne after adding stackTwo from index 4: " + stackOne);
    }

    @Test
    public void testStackFour(){
        //Testing the code example above with ArrayList
        List<Integer> integerList1 = new ArrayList<>();
        for (int i = 100; i <= 110; i++){
            integerList1.add(i);   //Using add() method of the Collection interface that is used to insert an element into the collection
        }
        System.out.println("Printing List one: " + integerList1);
        System.out.println("index of 104: " + integerList1.indexOf(104));
        System.out.println();
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 300; i <= 303; i++){
            integerList2.add(i);
        }
        System.out.println("Printing List two: " + integerList2);
        System.out.println();
        //Insert stackTwo at index 4 of stackOne
        integerList1.addAll(4, integerList2);
        System.out.println("integerList1 after adding integerList2 from index 4: " + integerList1);
    }

    @Test
    public void testStackFive(){
        // Creating an empty Stack
        Stack<String> STACK = new Stack<>();
        // Stacking strings
        STACK.push("Geeks");
        STACK.push("4");
        STACK.push("Geeks");
        STACK.push("Welcomes");
        STACK.push("You");
        // Displaying the Stack
        System.out.println("The stack is: " + STACK);
        // Checking for the element "4"
        System.out.println("Does the stack contains '4'? "
                + STACK.search("4"));
        System.out.println("4 is at index: " + STACK.indexOf("4"));
        // Checking for the element "Hello"
        System.out.println("Does the stack contains 'Hello'? "
                + STACK.search("Hello"));
        // Checking for the element "Geeks"
        System.out.println("Does the stack contains 'Geeks'? "
                + STACK.search("Geeks"));

    }

    @Test
    public void testStackSix(){
        //equals(Object o) method
        //Comparing two stacks for equality.
        //The Stack equals(Object obj) method of Stack class is used verify the equality of an Object with a Stack and compare them.
        //The method returns true only if both Stack contains the same elements with same order.
        //Syntax:
        //firstStack.equals(secondStack)
        Stack<String> stack1 = new Stack<>();
        stack1.add("Geeks");
        stack1.add("4");
        stack1.add("Geeks");
        stack1.add("Welcomes");
        stack1.add("You");
        System.out.println("The Stack One is: " + stack1);
        Stack<String> stack2 = new Stack<>();
        stack2.add("Geeks");
        stack2.add("4");
        stack2.add("Geeks");
        stack2.add("Welcomes");
        stack2.add("You");
        System.out.println("The Stack Two is: " + stack2);
        System.out.println("Are both of the Stack equal? " + stack1.equals(stack2));
    }

    @Test
    public void testStackSeven(){
        //copyInto()
        //The copyInto() method is used to copy all the components from this Stack to an Array,
        //having enough space to hold all the components of the Stack. It is to be noted that the index of the elements remains unchanged.
        //The elements present in the Array are replaced by the elements of the Stack.
        //Syntax
        //Stack.copyInto(Object[] anArray)
        //The parameter Object[] is of the type of Object. This is the Array into which the elements of the Stack are to be copied.
        //The method throws NullPointerException if the Stack is NULL.
        Stack<String> stack = new Stack<>();
        stack.add("Welcome");
        stack.add("To");
        stack.add("Geeks");
        stack.add("4");
        stack.add("Geeks");
        System.out.println("Stack: " + stack);
        String arr[] = new String[6];
        arr[0] = "Hello";
        arr[1] = "World";
        System.out.println("The initial Array is: ");
        for (String str : arr)
            System.out.println(str);
        // Copying
        stack.copyInto(arr);
        // The final Stack
        System.out.println("The final Array is: ");
        for (String str : arr)
            System.out.println(str);
    }

    @Test
    public void testStackEight(){
        //One more reason to use Deque over Stack is Deque has the ability to use streams convert to
        //list with keeping LIFO concept applied while Stack does not.
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();
        stack.push(1);//1 is the top
        deque.push(1);//1 is the top
        stack.push(2);//2 is the top
        deque.push(2);//2 is the top
        List<Integer> list1 = stack.stream().collect(Collectors.toList());//[1,2]
        System.out.println("Using Stack -");
        System.out.println(list1);
        System.out.println("Index of 2: " + list1.indexOf(2 ));  //Strange.  Stack seem to maintain the order of element when converted to a list
        System.out.println("Original stack: " + stack);
        System.out.println("Index of 2 in the stack: " + stack.indexOf(2));  //In the stack the index of 2 is 1 and in the list the index of 2 is still 1.
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.print(list1.get(i) + " ");
//        }
        System.out.println();
        List<Integer> list2 = deque.stream().collect(Collectors.toList());//[2,1]
        System.out.println("Using Deque -");
        System.out.println(list2);
        System.out.println("Index of 2: " + list2.indexOf(2));   //Deque does not seem to keep the order of element.  To be looked into.
        System.out.println("Original deque: " + deque );
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.print(list2.get(i) + " ");
//        }
        System.out.println();
    }

    @Test
    public void testListRetainAllMethod(){
        List<Integer> integerList = new ArrayList<>();
        List<Integer> integerList2 = new ArrayList<>();
        integerList.add(34);
        integerList.add(40);
        integerList.add(11);
        integerList.add(22);
        integerList.add(40);
        integerList.add(34);
        integerList.add(40);
        integerList.add(11);
        System.out.println("Original integerList: " + integerList);
        System.out.println();
        integerList2.add(55);
        //integerList2.add(40);
        //integerList2.add(34);
        integerList2.add(11);
        integerList2.add(22);
        System.out.println("Original integerList2: " + integerList2);
        integerList.retainAll(integerList2);  //retainAll() retains only elements in the specified collection including duplicates and deletes the rest.
        System.out.println();
        System.out.println("After retainAll() integerList is: " + integerList);
    }
}
