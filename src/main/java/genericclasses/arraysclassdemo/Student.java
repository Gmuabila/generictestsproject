package genericclasses.arraysclassdemo;

public class Student {
    int rollno;
    String name, address;
    // Constructor
    public Student(int rollno, String name,
                   String address){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    @Override
    public boolean equals(Object obj) {
        // typecast obj to Student so that we can compare students
        Student s = (Student) obj;
        return this.rollno == s.rollno && this.name.equals(s.name)
                && this.address.equals(s.address);
    }

    @Override
    public String toString(){
        return "Student{" + "Name: " + name + "\n"
                + "Roll Number: " + rollno + "\n"
                + "Address: " + address + "}\n";
    }

}
