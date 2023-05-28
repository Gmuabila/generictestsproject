package genericclasses.arraydemo;

import java.util.Comparator;

public class NumberComparator implements Comparator<NumberCount> {

    @Override
    public int compare(NumberCount numberCountOne, NumberCount numberCountTwo){
        return Integer.compare(numberCountOne.getCount(), numberCountTwo.getCount());
    }
}
