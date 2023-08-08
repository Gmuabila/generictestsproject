package genericclasses.collectionframeworkdemo;

public class Student{
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name,
                   String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()
    public String toString()
    {
        return this.rollno + " " + this.name +
                " " + this.address;
    }

//    @Override
//    public int compareTo(Student otherStudent){
//        return Integer.compare(this.rollno, otherStudent.rollno);
//    }
}
