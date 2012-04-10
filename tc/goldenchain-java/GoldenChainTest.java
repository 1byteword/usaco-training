import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoldenChainTest {

    protected GoldenChain solution;

    @Before
    public void setUp() {
        solution = new GoldenChain();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] sections = new int[]{3, 3, 3, 3};

        int expected = 3;
        int actual = solution.minCuts(sections);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] sections = new int[]{2000000000};

        int expected = 1;
        int actual = solution.minCuts(sections);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] sections = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};

        int expected = 42;
        int actual = solution.minCuts(sections);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] sections = new int[]{20000000, 20000000, 2000000000};

        int expected = 3;
        int actual = solution.minCuts(sections);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] sections = new int[]{10, 10, 10, 10, 10, 1, 1, 1, 1, 1};

        int expected = 5;
        int actual = solution.minCuts(sections);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] sections = new int[]{1, 10};

        int expected = 1;
        int actual = solution.minCuts(sections);

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCase6() {
        int[] sections = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int expected = 25;
        int actual = solution.minCuts(sections);

        Assert.assertEquals(expected, actual);
    }
    
    


}
