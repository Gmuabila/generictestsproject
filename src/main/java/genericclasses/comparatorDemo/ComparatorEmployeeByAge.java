package genericclasses.comparatorDemo;

import java.util.Comparator;

public class ComparatorEmployeeByAge implements Comparator<Employee> {
    @Override
    public int compare(Employee empOne, Employee empTwo){
        return Integer.compare(empOne.getAge(), empTwo.getAge());
    }
}
