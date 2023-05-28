package genericclasses.arraydemo;

import java.util.Comparator;

public class WordCountComparator implements Comparator<WordCount> {

    @Override
    public int compare(WordCount wordCountOne, WordCount wordCountTwo){
        return Integer.compare(wordCountOne.getCount(), wordCountTwo.getCount());
    }
}
