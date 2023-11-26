package genericclasses.methodreferencedemo;

public class ComparisonProvider {
    // To compare by Name
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
    // To compare by Age
    public int compareByAge(Person a, Person b) {
        return Integer.compare(a.getAge(), b.getAge());
        //return a.getAge().compareTo(b.getAge());   //This implementation also works
    }
}
