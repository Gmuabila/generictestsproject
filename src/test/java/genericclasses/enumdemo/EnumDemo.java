package genericclasses.enumdemo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EnumDemo {
    //**** Enum in java ****
    // An Enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
    // To create an Enum , use the enum keyword (instead of class or interface), and separate the constants with a comma.
    // Note that they should be in uppercase letters. Enum is short for "enumerations", which means "specifically listed".
    // You can also have an Enum inside a class.
    //Additionally, enums come with many useful methods that we would otherwise need to
    // write if we were using traditional public static final constants.
    //You can access enum constants with the 'dots' syntax.
    //Why And When to Use Enums?
    //Use enums when you have values that you know aren't going to change, like month, days, colours, deck of cards, etc.

    public enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    @Test
    public void enumTestOne(){
        Level myVar = Level.MEDIUM;
        System.out.println("Level: " + myVar);
    }

    @Test
    public void enumTestTwo(){
        PizzaStatus pizzaStatus = PizzaStatus.READY;
        System.out.println("Order Status: " + pizzaStatus);
    }

    //Loop Through an Enum
    // The enum type has a values() method, which returns an array of all enum constants.
    // This method is useful when you want to loop through the constants of an enum:
    @Test
    public void enumTestThree(){
        for(PizzaStatus pizzaStatus: PizzaStatus.values()){
            System.out.println(pizzaStatus);
        }
    }

    // let's print name of each enum and their action
    // - Enum values() examples
    @Test
    public void enumTestFour(){
        TrafficSignals[] enumConstants = TrafficSignals.values();
        for (TrafficSignals signal: enumConstants){
            System.out.println("Name: " + signal.name() + " Action: " + signal.getAction());
        }
    }


    Map<String, Courses> courseByCode = new HashMap<>();
    Map<Integer, Courses> courseByRoom = new HashMap<>();
    Map<Double, Courses> courseByTime = new HashMap<>();

    public Courses valueOfCourseByCode(String code){
        return courseByCode.get(code);
    }
    public Courses valueOfCourseByRoom(Integer room){
        return courseByRoom.get(room);
    }
    public Courses valueOfCourseByTime(Double time){
        return courseByTime.get(time);
    }
    // *** Attaching Multiple Values ***
    //The Enum constructor can accept multiple values.
    @Test
    public void enumTestFive(){
        for(Courses course: Courses.values()){
            courseByCode.put(course.getCourseCode(), course);
            courseByRoom.put(course.getRoomNumber(), course);
            courseByTime.put(course.getTime(), course);
        }

        System.out.println(valueOfCourseByCode("MAT20"));
        System.out.println(valueOfCourseByRoom(15));
        System.out.println(valueOfCourseByTime(16.00));
    }

}
