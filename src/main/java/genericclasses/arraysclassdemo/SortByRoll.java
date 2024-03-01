package genericclasses.arraysclassdemo;

import java.util.Comparator;

public class SortByRoll implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b){
        return Integer.compare(a.rollno, b.rollno);
    }
}
