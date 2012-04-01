import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PoolTest {

    protected Pool solution;

    @Before
    public void setUp() {
        solution = new Pool();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] triangle = new int[]{6, 12, 14, 1, 8, 2, 11, 3, 9, 4, 7, 13, 5, 15, 10};

        int expected = 0;
        int actual = solution.rackMoves(triangle);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] triangle = new int[]{2, 10, 7, 1, 8, 12, 6, 11, 4, 9, 13, 3, 14, 15, 5};

        int expected = 2;
        int actual = solution.rackMoves(triangle);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] triangle = new int[]{8, 15, 9, 4, 10, 6, 11, 3, 14, 7, 2, 1, 13, 12, 5};

        int expected = 3;
        int actual = solution.rackMoves(triangle);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] triangle = new int[]{15, 5, 8, 13, 2, 14, 10, 3, 4, 6, 7, 9, 1, 12, 11};

        int expected = 4;
        int actual = solution.rackMoves(triangle);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] triangle = new int[]{1, 5, 15, 6, 10, 9, 11, 13, 7, 4, 3, 8, 2, 12, 14};

        int expected = 3;
        int actual = solution.rackMoves(triangle);

        Assert.assertEquals(expected, actual);
    }

}
