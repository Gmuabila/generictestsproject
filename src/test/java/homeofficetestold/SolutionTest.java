package homeofficetestold;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void exampleOneTest(){

        int[] moviesId = {
                3, 1, 1
        };

        String result = solution.process(3, 3, moviesId);

        assertEquals("2,1,0", result);

    }

    @Test
    public void exampleTwoTest(){

        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.process(5, 3, moviesId);

        assertEquals("3,0,4", result);

    }


    @Test
    public void testNOtMatchingMoviesToWatchSize(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.process(5, 15, moviesId);

        assertEquals("Movies to watch must match supplied movies list", result);
    }

    @Test
    public void testInvalidMoviesToWatchSize(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.process(5, -1, moviesId);

        assertEquals("Inconsistent movies to watch size", result);
    }

    @Test
    public void testEmptyMoviesId(){
        int[] moviesId = {

        };

        String result = solution.process(5, 3, moviesId);

        assertEquals("Invalid movies ids list", result);
    }

    @Test
    public void testNegativeStackSize(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.process(-1, 3, moviesId);

        assertEquals("Invalid movie stack size", result);
    }
}
