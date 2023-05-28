package homeoffice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static final int TOTAL_MOVIES = 100000;
    public static final int MINIMUM_TO_WATCH = 1;
    public List<Integer> movieStack = new ArrayList<>();

    public String run(int stackSize, int moviesToWatch, int[] movies) {

        String validationErrorMessage = validateMovieToWatchRequest(stackSize, moviesToWatch, movies);

        if (validationErrorMessage != null) {
            return validationErrorMessage;
        }

        initializeMovies(stackSize);

        List<String> resultList = processMovieToWatch(movies);

        String result = resultList.stream().collect(Collectors.joining(","));

        return result;
    }

    /*
    The processMovieToWatch() method adds the initialised list of movies to a stack, removes the movie to watch from the
    stack, places it at the top of the stack and calculate the position of the movies.
     */
    private List<String> processMovieToWatch(int[] movies) {

        List<String> resultList = new ArrayList<>();
        Stack<Integer> numberStack = new Stack<>();
        Collections.reverse(movieStack);
        numberStack.addAll(movieStack);

        Arrays.stream(movies).forEach(movie -> {
            if (numberStack.lastIndexOf(movie) >= 0) {
                List<Integer> integerList = numberStack.subList(numberStack.lastIndexOf(movie) + 1, numberStack.size());
                resultList.add(String.valueOf(integerList.size()));
                numberStack.remove(numberStack.lastIndexOf(movie));
                numberStack.push(movie);
            }
        });

        return resultList;
    }

    /*
        Method to initialise a list of the movie collection.
        The method will use the number of movies in the stack parameter to initialise the list.
     */
    private void initializeMovies(int movieStackSize) {
        if (movieStack.size() == 0) {
            IntStream.rangeClosed(1, movieStackSize).forEach(number -> movieStack.add(number));
        }
    }

    //Method to validate inputs and provide error message.
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
