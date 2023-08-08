package genericclasses.hashcodeAndEqualsMethodsDemo;

// Java program to demonstrate working of
// hashCode() and toString()

public class Pupils {
        static int last_roll = 11005511;
        int roll_no;
        // Constructor
       public Pupils() {
            roll_no = last_roll;
            last_roll++;
        }
        // Overriding hashCode()
        @Override public int hashCode() {
            return roll_no;
        }

        public String toString(){

           return "Roll number: \t" + roll_no + "\t Last Roll Number: \t" + last_roll;
        }

    }
