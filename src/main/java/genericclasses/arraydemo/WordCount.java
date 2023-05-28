package genericclasses.arraydemo;

import java.util.Comparator;

public class WordCount {
    String word;
    Integer count;

    public WordCount() {
    }

    public WordCount(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "\"" + word + "\t\t\t\t" +  count + "\n";
    }
}
