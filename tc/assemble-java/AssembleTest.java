import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AssembleTest {

    protected Assemble solution;

    @Before
    public void setUp() {
        solution = new Assemble();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] connect = new int[]{19, 50, 10, 39};

        int expected = 19400;
        int actual = solution.minCost(connect);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] connect = new int[]{13, 18, 24, 11, 25, 100, 93, 92, 79};

        int expected = 407518;
        int actual = solution.minCost(connect);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] connect = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};

        int expected = 59;
        int actual = solution.minCost(connect);

        Assert.assertEquals(expected, actual);
    }

}
