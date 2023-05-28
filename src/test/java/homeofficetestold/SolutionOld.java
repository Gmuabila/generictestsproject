package homeofficetestold;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionOld {

    public static final int TOTAL_MOVIES = 100000;
    public static final int MINIMUM_TO_WATCH = 1;

    public static String run(int stackMovies, int moviesToWatch, int[] movies) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        int[] numbers = movies;

        List<Integer> collection = new ArrayList<>();
        IntStream.rangeClosed(1, stackMovies).forEach(number -> collection.add(number));

        Stack<Integer> numberStack = new Stack<>();
        Collections.reverse(collection);
        numberStack.addAll(collection);

        List<String> resultList = new ArrayList<>();

        Arrays.stream(numbers).forEach(movie -> {
            if(numberStack.lastIndexOf(movie) >= 0) {
                List<Integer> integerList = numberStack.subList(numberStack.lastIndexOf(movie) + 1, numberStack.size());
                resultList.add(String.valueOf(integerList.size()));
                numberStack.remove(numberStack.lastIndexOf(movie));
                numberStack.push(movie);
            }
        });

        String result = resultList.stream().collect(Collectors.joining(","));
        return result;
    }

    public String process(int stackMovies, int moviesToWatch, int[] movies){


        if(stackMovies < MINIMUM_TO_WATCH || moviesToWatch > TOTAL_MOVIES){
            return "Inconsistent movies to watch state";
        }

        List<Integer> collection = new ArrayList<>();
        IntStream.rangeClosed(1, moviesToWatch).forEach(number -> collection.add(number));

        Stack<Integer> numberStack = new Stack<>();
        Collections.reverse(collection);
        numberStack.addAll(collection);

        List<String> resultList = new ArrayList<>();

        Arrays.stream(movies).forEach(movie -> {
            if(numberStack.lastIndexOf(movie) >= 0) {
                List<Integer> integerList = numberStack.subList(numberStack.lastIndexOf(movie) + 1, numberStack.size());
                resultList.add(String.valueOf(integerList.size()));
                numberStack.remove(numberStack.lastIndexOf(movie));
                numberStack.push(movie);
            }
        });

        String result = resultList.stream().collect(Collectors.joining(","));
        return result;
    }
}
