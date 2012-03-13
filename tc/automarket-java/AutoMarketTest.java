import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AutoMarketTest {

    protected AutoMarket solution;

    @Before
    public void setUp() {
        solution = new AutoMarket();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] cost = new int[]{10000, 14000, 8000, 12000};
        int[] features = new int[]{1, 2, 4, 3};
        int[] fixTimes = new int[]{17, 15, 8, 11};

        int expected = 3;
        int actual = solution.maxSet(cost, features, fixTimes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] cost = new int[]{1, 2, 3, 4, 5};
        int[] features = new int[]{1, 2, 3, 4, 5};
        int[] fixTimes = new int[]{1, 2, 3, 4, 5};

        int expected = 1;
        int actual = solution.maxSet(cost, features, fixTimes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] cost = new int[]{9000, 6000, 5000, 5000, 7000};
        int[] features = new int[]{1, 3, 4, 5, 2};
        int[] fixTimes = new int[]{10, 6, 6, 5, 9};

        int expected = 4;
        int actual = solution.maxSet(cost, features, fixTimes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] cost = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] features = new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] fixTimes = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int expected = 20;
        int actual = solution.maxSet(cost, features, fixTimes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] cost = new int[]{1000, 1000, 1000, 1000, 2000};
        int[] features = new int[]{3, 3, 4, 3, 3};
        int[] fixTimes = new int[]{3, 3, 3, 4, 3};

        int expected = 1;
        int actual = solution.maxSet(cost, features, fixTimes);

        Assert.assertEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase6() {
        int[] cost = new int[]{67317, 83190, 45908, 91506, 55612, 42120, 4630, 89946, 90456, 60775, 91710, 58483, 70921, 70623, 87758, 32637, 88187, 84961, 18306, 77693, 6417, 89040, 40347, 67078, 23908, 39843, 44454, 72498, 98135, 58588, 59089, 86672, 9444, 15913};
        int[] features = new int[]{68, 62, 20, 43, 14, 74, 57, 45, 72, 19, 8, 70, 19, 3, 87, 51, 4, 11, 41, 35, 69, 46, 37, 40, 23, 50, 72, 89, 84, 88, 81, 20, 54, 16};
        int[] fixTimes = new int[]{4, 24, 84, 52, 84, 43, 3, 35, 71, 49, 87, 3, 41, 12, 4, 13, 62, 17, 88, 82, 59, 84, 19, 80, 92, 47, 81, 81, 19, 66, 3, 68, 18, 49};

        int expected = 6;
        int actual = solution.maxSet(cost, features, fixTimes);

        Assert.assertEquals(expected, actual);
    }

}
