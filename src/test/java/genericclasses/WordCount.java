package genericclasses;

import org.junit.Test;

import java.util.*;

public class WordCount {

    @Test
    public void wordCountTests() {
        String text = "Every morning I go to work.  " +
                "Monday is the day we all start work. " +
                "Every week the same thing happens.  " +
                "The cycle repeat itself every week. " +
                "Next Monday, Tuesday, Wednesday. " +
                "work, work, work, Monday, Tuesday, Tuesday ";

        String cleanText = text.replace(".", "").toLowerCase();  //remove all dot "." and convert all to lowercase.
        String cleanTextTwo = cleanText.replace(",", "");  //removing ","

        String[] textArray = cleanTextTwo.split("\\s+");
        List<String> wordList = new ArrayList<>(Arrays.asList(textArray));
        Collections.sort(wordList);
        System.out.println("Printing the original list: " + wordList);
        System.out.println();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++){
            countMap.putIfAbsent(wordList.get(i), Collections.frequency(wordList, wordList.get(i)));
        }
        //System.out.println(countMap);
        System.out.println("Word" + "\t\t\t\t" + "Count");
        System.out.println("======================================");

        for (Map.Entry<String, Integer> mapEntry: countMap.entrySet()){
            System.out.println(mapEntry.getKey() + "\t\t\t" + mapEntry.getValue());
        }

    }


}
