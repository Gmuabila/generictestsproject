package homeofficetestold;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static final int TOTAL_MOVIES = 100000;
    public static final int MINIMUM_TO_WATCH = 1;
    public static List<Integer> movieStack = new ArrayList<>();


    public String process(int stackSize, int moviesToWatch, int[] movies){


        String validationErrorMessage = validateMovieToWatchRequest(stackSize, moviesToWatch, movies);

        if (validationErrorMessage != null) {
            return validationErrorMessage;
        }

        initializeMovies(stackSize);

        List<String> resultList = processMovieToWach(movies);

        String result = resultList.stream().collect(Collectors.joining(","));

        return result;
    }

    private List<String> processMovieToWach(int[] movies) {

        List<String> resultList = new ArrayList<>();
        Stack<Integer> numberStack = new Stack<>();
        Collections.reverse(movieStack);
        numberStack.addAll(movieStack);

        Arrays.stream(movies).forEach(movie -> {
            if(numberStack.lastIndexOf(movie) >= 0) {
                List<Integer> integerList = numberStack.subList(numberStack.lastIndexOf(movie) + 1, numberStack.size());
                resultList.add(String.valueOf(integerList.size()));
                numberStack.remove(numberStack.lastIndexOf(movie));
                numberStack.push(movie);
            }
        });

        return resultList;
    }

    private void initializeMovies(int movieStackSize) {
        if(movieStack.size() == 0) {
            IntStream.rangeClosed(1, movieStackSize).forEach(number -> movieStack.add(number));
        }
    }

    private String validateMovieToWatchRequest(int stackMovies, int moviesToWatch, int[] movies) {
        String errorMessage = null;
        if(stackMovies < MINIMUM_TO_WATCH){
            errorMessage = "Invalid movie stack size";
        }else if(movies == null || movies.length == 0){
            errorMessage = "Invalid movies ids list";
        }else  if(moviesToWatch < MINIMUM_TO_WATCH || moviesToWatch > TOTAL_MOVIES){
            errorMessage =  "Inconsistent movies to watch size";
        }else  if(moviesToWatch != movies.length){
            errorMessage =  "Movies to watch must match supplied movies list";
        }


        return errorMessage;
    }
}
