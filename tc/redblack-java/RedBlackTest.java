import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedBlackTest {

    protected RedBlack solution;

    @Before
    public void setUp() {
        solution = new RedBlack();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] keys = new int[]{1, 2, 3};

        int expected = 1;
        int actual = solution.numTwists(keys);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] keys = new int[]{1, 2, 3, 4, 5, 6, 7};

        int expected = 4;
        int actual = solution.numTwists(keys);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] keys = new int[]{7, 1, 4, 6, 3, 5, 2};

        int expected = 3;
        int actual = solution.numTwists(keys);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] keys = new int[]{5, 10, 15, 14, 3, 4, 11, 2, 1, 12, 6, 9, 7, 13, 8};

        int expected = 11;
        int actual = solution.numTwists(keys);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] keys = new int[]{6, 8, 10, 12, 4, 2, 18, 14, 16, 19, 7, 15, 9, 17, 13, 5, 11, 3, 1};

        int expected = 5;
        int actual = solution.numTwists(keys);

        Assert.assertEquals(expected, actual);
    }

}
