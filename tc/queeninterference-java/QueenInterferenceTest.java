import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueenInterferenceTest {

    protected QueenInterference solution;

    @Before
    public void setUp() {
        solution = new QueenInterference();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 5;

        int expected = 4;
        int actual = solution.numSteps(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 7;

        int expected = 6;
        int actual = solution.numSteps(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 19;

        int expected = 475;
        int actual = solution.numSteps(n);

        Assert.assertEquals(expected, actual);
    }

}
