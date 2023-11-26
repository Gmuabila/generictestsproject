package genericclasses.comparatorDemo;

import java.util.Comparator;

public class ComparatorEmployeeByAge implements Comparator<Employee> {
    @Override
    public int compare(Employee empOne, Employee empTwo){
        return Integer.compare(empOne.getAge(), empTwo.getAge());
    }
}

//The compare()
// The compare()method of Integer class of java.lang package compares two integer values (x, y) given
// as a parameter and returns the value zero if (x==y), if (x < y) then it returns a value less than zero and
// if (x > y) then it returns a value greater than zero.
