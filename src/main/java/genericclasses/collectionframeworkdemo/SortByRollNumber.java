package genericclasses.collectionframeworkdemo;

import java.util.Comparator;

public class SortByRollNumber implements Comparator<Student> {

    @Override
    public int compare(Student x, Student y){
        //return x.rollno - y.rollno;  //Also work, find out more about this approach.
        return Integer.compare(x.rollno, y.rollno);
    }
}
