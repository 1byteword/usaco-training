import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangingSoundsTest {

    protected ChangingSounds solution;

    @Before
    public void setUp() {
        solution = new ChangingSounds();
    }

    @Test
    public void testCase0() {
        int[] changeIntervals = new int[]{5, 3, 7};
        int beginLevel = 5;
        int maxLevel = 10;

        int expected = 10;
        int actual = solution.maxFinal(changeIntervals, beginLevel, maxLevel);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] changeIntervals = new int[]{15, 2, 9, 10};
        int beginLevel = 8;
        int maxLevel = 20;

        int expected = -1;
        int actual = solution.maxFinal(changeIntervals, beginLevel, maxLevel);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] changeIntervals = new int[]{74, 39, 127, 95, 63, 140, 99, 96, 154, 18, 137, 162, 14, 88};
        int beginLevel = 40;
        int maxLevel = 243;

        int expected = 238;
        int actual = solution.maxFinal(changeIntervals, beginLevel, maxLevel);

        Assert.assertEquals(expected, actual);
    }

}
