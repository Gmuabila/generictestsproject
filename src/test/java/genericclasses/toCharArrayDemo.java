package genericclasses;

import org.junit.Test;

public class toCharArrayDemo {

    @Test
    public void convertStringToCharArray(){
        //The String toCharArray() method converts the string into a character array i.e.,
        // first it will calculate the length of the given Java String including spaces and
        // then create an array of char type with the same content.
        String s1="Welcome to Lufuku";
        char[] ch = s1.toCharArray();
        for(int i=0; i<ch.length; i++){
            System.out.print(ch[i]);
        }

        System.out.println("\n\nCharacter at index 0 is: " + s1.charAt(0));
        System.out.println("Character at index 1 is: " + s1.charAt(1));
        System.out.println("Character at index 2 is: " + s1.charAt(2));
        System.out.println("Character at index 3 is: " + s1.charAt(3));
        System.out.println("Character at index 7 is: " + s1.charAt(7));
        System.out.println("Character at index 8 is: " + s1.charAt(8));
        System.out.println("Character at index 9 is: " + s1.charAt(9));
        System.out.println("Character at index 10 is: " + s1.charAt(10));
        System.out.println("Character at index 11 is: " + s1.charAt(11));
        System.out.println("Character at index 12 is: " + s1.charAt(12));


        char twelve = s1.charAt(12);
        System.out.println("\n The twelve character is: " + twelve);

    }
}
