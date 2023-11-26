package genericclasses.methodreferencedemo;

public class GFG {
    // Static method to compare by name
    public static int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
    // Static method to compare by age
    public static int compareByAge(Person a, Person b) {
        return Integer.compare(a.getAge(), b.getAge());
       // return a.getAge().compareTo(b.getAge());  // This implementation also works
    }
}
