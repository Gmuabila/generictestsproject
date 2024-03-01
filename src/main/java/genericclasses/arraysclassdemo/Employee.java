package genericclasses.arraysclassdemo;

public class Employee {
    int empId;
    String empName;
    // constructor
    public Employee(int empId, String empName){
        this.empId = empId;
        this.empName = empName;
    }
    // Override toString()
    public String toString(){
        return empId + "   " + empName;
    }
}
