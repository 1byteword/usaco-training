import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SRMSystemTestPhaseTest {

    protected SRMSystemTestPhase solution;

    @Before
    public void setUp() {
        solution = new SRMSystemTestPhase();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] description = new String[]{"YYY"};

        int expected = 27;
        int actual = solution.countWays(description);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] description = new String[]{"YNN", "NYN"};

        int expected = 6;
        int actual = solution.countWays(description);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] description = new String[]{"YNN", "NNN", "NNY"};

        int expected = 4;
        int actual = solution.countWays(description);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] description = new String[]{"NNN", "NNN"};

        int expected = 1;
        int actual = solution.countWays(description);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] description = new String[]{"YYY", "YNY", "NYY", "YYN", "YYY", "YNN"};

        int expected = 15176;
        int actual = solution.countWays(description);

        Assert.assertEquals(expected, actual);
    }

}
