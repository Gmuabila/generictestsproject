package genericclasses;

import org.junit.Test;

public class PalindromeDemo {

    public boolean isPalindrome(String text) {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        int wordLength = cleanText.length();
        int forward = 0;
        int backward = wordLength - 1;

        //The following is just for checking the index.
        char firstChar = cleanText.charAt(0);
        System.out.println("The char at index 0 is: " + firstChar);

        while (backward > forward) {
            //The value of forward will be 0 at first until it passes the
            //first round of the loop then becomes 1 the second time around.
            //The same applies for backward variable.
            char forwardChar = cleanText.charAt(forward++);
            char backwardChar = cleanText.charAt(backward--);

            if (forwardChar != backwardChar) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPalindrome() {
        String word = " redivider ";                              //redivider, Racecar, Level, madam
        boolean result = isPalindrome(word);

        if (result) {
            System.out.println("\n\nThe String" + word + "is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }

    //Best approach to solve a Palindrome test
    public boolean isPalindromeTwo(String wordIn){
        String cleanWord = wordIn.replaceAll("\\s+", "").toLowerCase();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cleanWord);
        StringBuilder reverseSBuilder = stringBuilder.reverse();

        String reversedWord = reverseSBuilder.toString();

        if(cleanWord.equals(reversedWord)){
            return true;
        }
        else{
            return false;
        }
    }

    @Test
    public void testIsPalindromeTwo(){
        String word = " Level ";                       //redivider, Racecar, Level, madam
        boolean result = isPalindromeTwo(word);

        if (result) {
            System.out.println("\n\nThe String" + word + "is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }
}
