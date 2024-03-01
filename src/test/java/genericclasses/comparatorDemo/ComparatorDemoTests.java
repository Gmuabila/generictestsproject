package genericclasses.comparatorDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemoTests {
    /** Comparator interface
     The Comparator interface is used to order the objects of user-defined classes.  A comparator object is
     capable of comparing two objects of the same class.
    To sort two objects by an order other than their natural order (or to sort objects of classes that do not implement Comparable at all),
    we have to use the java.util.Comparator interface.
    The Comparator interface defines the method compare(T o1, T o2) to compare the two passed objects.
    The Comparator interface defines a compare(arg1, arg2) method with two arguments that represent compared objects and
    works similarly to the Comparable.compareTo() method.
     */
    @Test
    public void testComparatorOne(){
        Employee emp1 = new Employee();
        ComparatorEmployeeByAge comparatorEmployeeByAge = new ComparatorEmployeeByAge();
        emp1.setName("Boldy");
        emp1.setAge(45);
        emp1.setId(12);
        Employee emp2 = new Employee(78, "Carlos", 56);
        Employee emp3 = new Employee(55, "White", 90);
        Employee emp4 = new Employee();
        emp4.setId(23);
        emp4.setName("Philip");
        emp4.setAge(35);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        System.out.println("Display original Employee list: \n" + employeeList);
        Collections.sort(employeeList, comparatorEmployeeByAge);
        System.out.println();
        System.out.println("Employee list sorted by age: \n" + employeeList);
        System.out.println();
        Collections.sort(employeeList, comparatorEmployeeByAge.reversed());
        System.out.println("Employee list by age reversed: \n" +employeeList);
    }

    @Test
    public void testComparatorTwo(){
        ComparatorEmployeeByName comparatorEmployeeByName = new ComparatorEmployeeByName();

        Employee emp1 = new Employee();
        emp1.setName("Boldy");
        emp1.setAge(45);
        emp1.setId(12);
        Employee emp2 = new Employee(78, "Carlos", 56);
        Employee emp3 = new Employee(55, "White", 90);
        Employee emp4 = new Employee();
        emp4.setId(23);
        emp4.setName("Philip");
        emp4.setAge(35);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        System.out.println("Display the original list: \n" + employeeList);
        System.out.println();
        Collections.sort(employeeList, comparatorEmployeeByName);
        System.out.println("Display Employee list sorted by Name: \n" + employeeList);
        System.out.println();
        Collections.sort(employeeList, comparatorEmployeeByName.reversed());
        System.out.println("Employee list sorted by Name reversed: \n" + employeeList);
    }

    @Test
    public void testCompratorThree(){
        ComparatorEmployeeByName comparatorEmployeeByName = new ComparatorEmployeeByName();
        Employee emp1 = new Employee(23, "John", 89);
        Employee emp2 = new Employee(55, "Johnston", 97);
        List<Employee> EmpList = new ArrayList<>();
        EmpList.add(emp1);
        EmpList.add(emp2);
        Collections.sort(EmpList, comparatorEmployeeByName);
        System.out.println(EmpList);
    }
}
