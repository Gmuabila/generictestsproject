package genericclasses.technicalTestsDSIT;

import org.junit.Test;
import java.util.*;

public class DepartmentForScienceInovationAndTechnology {
    //String Challenge
    //Have the function StringChallenge (str) take the str parameter being passed and determine the largest number of unique characters that
    //exists between a pair of matching letters anywhere in the string. For example: if str is "ahyiakh" then there are only two pairs of
    //matching letters the two a's and the two h's. Between the pair of a's there are 3 unique characters: n, y, and j.
    //Between the h's there are 4 unique characters: y, j, a, and k. So for this example your program should return 4
    //Another example: if str is "ghececgkaem" then your program should return 5 because the most unique characters exists within the
    //farthest pair of e characters. The Input string may not contain any character pairs, and in that case your program should just return 0.
    //The input will only consist of lowercase alphabetic characters.
    //Examples
    //Input: "mmmerme'
    //Output: 3
    //Input: "abccdefghi"
    //Output: 0

    public String StringChallenge(String str) {
        String cleanStr = str.toLowerCase();
        List<String> stringList = new ArrayList<>();
        String newResutlStr = null;

        for (int i = 0; i < cleanStr.length(); i++) {
            for (int j = 1; j < cleanStr.length(); j++) {
                if (cleanStr.charAt(i) == cleanStr.charAt(j) && i != j && j > i) {
                    String resultStr = cleanStr.substring(i + 1, j);
                    int index = resultStr.indexOf(cleanStr.charAt(i));
                    if (index != -1) {
                        newResutlStr = resultStr.replaceFirst(String.valueOf(resultStr.charAt(index)), "");
                        stringList.add(newResutlStr);
                    } else {
                        stringList.add(resultStr);
                    }
                }
            }
        }
        //stringList.stream().max(Comparator.comparing(String::length)).map(item -> Stream.of(item)).stream().distinct().collect(Collectors.toList());
        Optional<String> optionalSubString = stringList.stream().max(Comparator.comparing(String::length));
        if (optionalSubString.isPresent()){
            String longestString = optionalSubString.get();
            return String.valueOf(longestString.length());
        }else {
            return "0";
        }
    }

    @Test
    public void testStringChallenge(){
//        Scanner s = new Scanner(System.in);
//        System.out.print(StringChallenge(s.nextLine()));
        System.out.println(StringChallenge("abccd"));
    }
}
