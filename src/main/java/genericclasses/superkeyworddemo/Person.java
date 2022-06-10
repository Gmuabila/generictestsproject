package genericclasses.superkeyworddemo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Builder
@Data
//@NoArgsConstructor
//@AllArgsConstructor
abstract class Person {
    int id;
    String name;

   Person(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("A Person is implicitly created from All Args Constructor");
    }

    Person(){
       System.out.println("A Person has been implicitly created from No Args Constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract float getEmployeeSalary(Employee employee);
}
