package genericclasses.comparatorDemo;

import java.util.Comparator;

public class ComparatorEmployeeByName implements Comparator<Employee> {
    @Override
    public int compare(Employee empOne, Employee empTwo){
        return empOne.getName().compareToIgnoreCase(empTwo.getName());
    }

    //String compareTo() Method
    //The compareTo() method compares two strings lexicographically.
    //The comparison is based on the Unicode value of each character in the strings.
    //The method returns 0 if the string is equal to the other string.
    //A value less than 0 is returned if the string is less than the other string (less characters) and a
    //value greater than 0 if the string is greater than the other string (more characters).

    //In programming, lexicographical order is popularly known as Dictionary order and is used to sort a string array,
    //compare two strings, or sorting array elements. It becomes quite easy to sort elements lexically.
    //The term Lexicographical order is a mathematical term known by names: lexical order,
    //lexicographic(al) product, alphabetical order, or dictionary order.
    //Tip: Use compareToIgnoreCase() to compare two strings lexicographically, ignoring lower case and upper case differences.
    //Tip: Use the equals() method to compare two strings without consideration of Unicode values.
    //Remember: The equals() method compares two strings, and returns true if the strings are equal, and false if not.  Cannot be used in comparator.
}
