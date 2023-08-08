package genericclasses.hashcodeAndEqualsMethodsDemo;

public class Student {
        static int last_roll = 10011;
        int roll_no;
        // Constructor
       public Student() {
            roll_no = last_roll;
            last_roll++;
        }
//    // Overriding hashCode()
//    @Override
//    public int hashCode() {
//        return roll_no;
//    }
}
