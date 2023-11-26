package genericclasses.optionalclass;

import java.util.Optional;

public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private Optional<String> address;

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Student(String firstName, String lastName, int grade, Optional<String> address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }
}
