package homeoffice;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private final Stack<Integer> movieStack = new Stack<>();

    public String run(int n, int m, int[] movies) {

        boolean valid = validateMovieToWatchRequest(n, m, movies);

        if (!valid) {
            return "Invalid input arguments";
        }

        initializeMovies(n);

        return processMovieToWatch(m, movies);
    }

    /*
    The processMovieToWatch() method adds the initialised list of movies to a stack, removes the movie to watch from the
    stack, places it at the top of the stack and calculate the position of the movies.
     */
    private String processMovieToWatch(int m, int[] movies) {

        AtomicInteger movieCount = new AtomicInteger(0);

        return IntStream.rangeClosed(1, m)
                .map(movie -> {
                    int currentMovieId = movies[movieCount.get()];
                    int stackIndex = movieStack.indexOf(currentMovieId);
                    movieStack.remove(stackIndex);
                    movieStack.add(0, currentMovieId);
                    if (movieCount.incrementAndGet() >= movies.length) {
                        movieCount.set(0);
                    }
                    return movieStack.subList(0, stackIndex).size();
                })
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    /*
        Method to initialise a list of the movie collection.
        The method will use the number of movies in the stack parameter to initialise the list.
     */
    private void initializeMovies(int movieStackSize) {
        if (movieStack.size() == 0) {
            IntStream.rangeClosed(1, movieStackSize).forEach(movieStack::add);
        }
    }

    private boolean validateMovieToWatchRequest(int n, int m, int[] movies) {
        if(n > 0 && m > 0 && movies.length > 0) {
            return m <= 100000;
        }
        return false;
    }
}
