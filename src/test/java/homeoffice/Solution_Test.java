package homeoffice;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class Solution_Test  {
    private Solution solution;


    @Before
    public void setup(){
        solution = new Solution();
    }
    /*
    /* Example one test
    */
    @Test
    public void exampleOneTest() {

        int[] moviesId = {
                3, 1, 1
        };

        String result = solution.run(3, 3, moviesId);

        Assert.assertEquals("2,1,0", result);
    }
    /*
     /* Example two test
     **/
    @Test
    public void exampleTwoTest(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.run(5, 3, moviesId);

        Assert.assertEquals("3,0,4", result);

    }
    @Test
    public void testNotMatchingMoviesToWatchSize(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.run(5, 15, moviesId);

        Assert.assertEquals("Movies to watch must match supplied movies list", result);
    }

    @Test
    public void testInvalidMoviesToWatchSize(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.run(5, -1, moviesId);

        Assert.assertEquals("Inconsistent movies to watch size", result);
    }

    @Test
    public void testEmptyMoviesId(){
        int[] moviesId = {

        };

        String result = solution.run(5, 3, moviesId);

        Assert.assertEquals("Invalid movies ids list", result);
    }

    @Test
    public void testNegativeStackSize(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.run(-1, 3, moviesId);

        Assert.assertEquals("Invalid movie stack size", result);
    }

    @Test
    public void testNegativeZeroMovieToWatch(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.run(5, 0, moviesId);

        Assert.assertEquals("Inconsistent movies to watch size", result);
    }

    @Test
    public void testNegativeZeroStackSize(){
        int[] moviesId = {
                4, 4, 5
        };

        String result = solution.run(0, 3, moviesId);

        Assert.assertEquals("Invalid movie stack size", result);
    }
}
