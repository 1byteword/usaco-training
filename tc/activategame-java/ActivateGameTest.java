import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActivateGameTest {

    protected ActivateGame solution;

    @Before
    public void setUp() {
        solution = new ActivateGame();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] grid = new String[]{"05", "aB"};

        int expected = 69;
        int actual = solution.findMaxScore(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] grid = new String[]{"03", "21"};

        int expected = 7;
        int actual = solution.findMaxScore(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] grid = new String[]{"John", "Brus", "Gogo"};

        int expected = 118;
        int actual = solution.findMaxScore(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] grid = new String[]{"AAA", "AAA", "AAA"};

        int expected = 0;
        int actual = solution.findMaxScore(grid);

        Assert.assertEquals(expected, actual);
    }

}
