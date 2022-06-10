package genericclasses.superkeyworddemo;

import lombok.*;

@Builder
@Data
//@Getter
//@Setter
//@NoArgsConstructor
@AllArgsConstructor
 class Employee extends Person {
     float salary;

    Employee(int id, String name, float salary) {
        super(id, name);                //Here, Employee class inherits Person class so all the properties of Person will be inherited to Emp by default.
                                        // To initialize all the property, we are using parent class constructor from child class.
        this.salary = salary;           // In such way, we are reusing the parent class constructor.
        System.out.println("Employee: " + name + " Object is created from All Args Constructor");
    }

    Employee(){
        System.out.println("An Employee created from No Args Constructor");
    }

   void displayEmp(int id, String name, int salary){
        System.out.println("Employee ID: " + id + " " + "Employee Name: " + name +" " + "Salary: " + salary);
    }
    
    float getEmployeeSalary(Employee employee){
       return employee.getSalary();
    }
}
