package genericclasses.DefineToStringMethod;

public class Student {
    private String name;
    private int rollno;
    private String city;

    public Student(String name, int rollno, String city){
        this.rollno=rollno;
        this.name=name;
        this.city=city;
    }
    public String toString(){//overriding the toString() method
        return "Student Name is: " + name + "\nStudent roll No: " + rollno + "\nCity: " + city + "\n";
    }
}

