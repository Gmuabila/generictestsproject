package genericclasses.methodreferencedemo;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MethodReferenceTest {
    /** Method Reference *****
     * A method reference is the shorthand syntax for a lambda expression that contains just one method call.
     * It is a compact and easy form of a lambda expression. Each time when you are using lambda expression
     * to just refer to a method, you can replace your lambda expression with a method reference.
     * Method references are special type of lambda expressions. They're often used to
     * create simple lambda expressions by referencing existing methods.
     * The method references can only be used to replace a single method of the lambda expression.
     * A code is clearer and shorter if one uses a lambda expression rather than using an anonymous class and
     * one can use method reference rather than using a single function lambda expression to achieve the same.
     * In general, one does not have to pass arguments to a method references.
     */

     @Test
    public void methodReferenceTesting(){
        List<String> messages = Arrays.asList("hello", "my", "dear", "friend");

//       messages.forEach(word -> StringUtils.capitalize(word));  //Does not convert Strings to Uppercase. To investigate.
//       System.out.println(messages);

//        messages.forEach(word -> word.toUpperCase());  //Does not convert Strings to UpperCase.  To investigate.
//        System.out.println(messages);

        //Capitalizing and printing a list of Strings
        List<String> messagesToUpperCase = messages.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(messagesToUpperCase);
    }


    //The following example is about performing some operations on elements in the list and adding them.
    //The operation to be performed on elements is a function argument that the caller can pass accordingly.
    public int transformAndAdd(List<Integer> list, Function<Integer, Integer> ops) {
        int result = 0;
        for (Integer num : list)
            result += ops.apply(num);
        return result;
    }

    @Test
    public void methodReferenceTestTwo() {
        List<Integer> list;
        // Add some element to list
        list = Arrays.asList(4, 6, 8, 10, 20);

        // Using a lambda expression
        System.out.println("Using Lambda expression........");
        System.out.println(transformAndAdd(list, i -> OpsUtil.doHalf(i)));
        System.out.print(transformAndAdd(list, i -> OpsUtil.doSquare(i)));
        System.out.println();

        // Using a method reference
        System.out.println("\nUsing Method reference.......");
        System.out.println(transformAndAdd(list, OpsUtil::doHalf) + " ");
        System.out.print(transformAndAdd(list, OpsUtil::doSquare) + " ");
        System.out.println();
    }

    /** Types of Method References ****
     There are four types of method references in java:
      1.	Static method reference.
      2.	Instance method reference of a particular objects
      3.	Instance method reference of an arbitrary object of a particular type
      4.	Constructor reference.

  Type 1: Reference to a static method
//  If a lambda expression just call a static method of a class
    (args) -> Class.staticMethod(args)
    Then method reference is like: Class::staticMethod                                                                */
    @Test
    public void methodReferenceTestThree(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Mamie", 24));
        personList.add(new Person("Glenn", 25));
        personList.add(new Person("Leonie", 19));
        // Using static method reference to sort array by name
        Collections.sort(personList, GFG::compareByName);
        System.out.println("Sort by name :");
        // Using streams over above object of Person type
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        // Now using static method reference to sort array by age
        Collections.sort(personList, GFG::compareByAge);
        System.out.println("Sort by age :");
        // Using streams over above object of Person type
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }

  /**    Type 2: Reference to an instance method of a particular object
        If a lambda expression just call a default method of an object:
        (args) -> obj.instanceMethod(args)
        Then method reference is like: obj::instanceMethod                                                            */
    @Test
    public void methodReferenceTestFour(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Mamie", 24));
        personList.add(new Person("Glenn", 25));
        personList.add(new Person("Leonie", 19));
        // A comparator class with multiple comparator methods
        ComparisonProvider comparator
                = new ComparisonProvider();
        // Now using instance method reference to sort array by name
        Collections.sort(personList,
                comparator::compareByName);
        System.out.println("Sort by name :");
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
        // Using instance method reference to sort array by age
        Collections.sort(personList,
                comparator::compareByAge);
        System.out.println("Sort by age :");
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }

    /**Type 3: Reference to an instance method of an arbitrary object of a particular type
     If a Lambda expression is like:
     // If a lambda expression just call an instance method of a ObjectType
     (obj, args) -> obj.instanceMethod(args)

     Then method reference is like:
     // Shorthand if a lambda expression just call an instance method of a ObjectType
     ObjectType::instanceMethod
*/
    @Test
    public void methodReferenceTestFive(){
        List<String> personList = new ArrayList<>();
        personList.add("Mamie");
        personList.add("Glenn");
        personList.add("Leonie");
        // Method references to String type
        Collections.sort(personList, String::compareToIgnoreCase);
        System.out.println(personList);
        System.out.println();
        // Printing the elements(names) on console
        personList.forEach(System.out::println);
    }

    /**Type 4: Constructor method reference
     If a Lambda expression is like:
     // If a lambda expression just create an object
     (args) -> new ClassName(args)
     Then method reference is like:
     // Shorthand if a lambda expression just create an object
     ClassName::new
*/
    // Get List of objects of given length and Supplier
    public static <T> List<T> getObjectList(int length, Supplier<T> objectSupply){
        List<T> list = new ArrayList<>();
        for (int i = 0; i < length; i++)
            list.add(objectSupply.get());
        return list;
    }

    public static <T> List<T> getPersonList(int listLength, Supplier<T> personSupplier){
        List<T> personList = new ArrayList<>();
        for(int i = 0; i < listLength; i++)
            personList.add(personSupplier.get());
        return personList;
    }

    @Test
    public void methodReferenceTestSix(){
       List<Person> personListOne = getPersonList(4, Person::new);  //Can also do: () -> new Person() for Person::new.
       personListOne.stream().forEach(System.out::println);
        System.out.println();
        // Get person by supplying person supplier, Supplier is
        // created by person constructor reference
        List<PersonMRef> personList = getObjectList(5, () -> new PersonMRef());
        // Print names of personList
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }
}
