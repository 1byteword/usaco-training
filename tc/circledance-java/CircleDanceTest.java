import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircleDanceTest {

    protected CircleDance solution;

    @Before
    public void setUp() {
        solution = new CircleDance();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int[] heights = new int[]{180, 183, 178, 185};

        int expected = 5;
        int actual = solution.arrangeDancers(heights);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int[] heights = new int[]{170, 180, 190};

        int expected = 20;
        int actual = solution.arrangeDancers(heights);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int[] heights = new int[]{180, 180, 180, 180, 180};

        int expected = 0;
        int actual = solution.arrangeDancers(heights);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int[] heights = new int[]{184, 165, 175, 186, 192, 200, 176, 192, 194, 168, 205, 201};

        int expected = 10;
        int actual = solution.arrangeDancers(heights);

        Assert.assertEquals(expected, actual);
    }

}
