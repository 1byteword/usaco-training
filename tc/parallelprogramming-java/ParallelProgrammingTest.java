import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParallelProgrammingTest {

    protected ParallelProgramming solution;

    @Before
    public void setUp() {
        solution = new ParallelProgramming();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] time = new int[]{150, 200, 250};
        String[] prec = new String[]{"NNN", "NNN", "NNN"};

        int expected = 250;
        int actual = solution.minTime(time, prec);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] time = new int[]{150, 200, 250};
        String[] prec = new String[]{"NNN", "YNN", "NNN"};

        int expected = 350;
        int actual = solution.minTime(time, prec);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] time = new int[]{150, 200, 250};
        String[] prec = new String[]{"NYN", "NNY", "NNN"};

        int expected = 600;
        int actual = solution.minTime(time, prec);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] time = new int[]{150, 200, 250};
        String[] prec = new String[]{"NYN", "NNY", "YNN"};

        int expected = -1;
        int actual = solution.minTime(time, prec);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] time = new int[]{345, 335, 325, 350, 321, 620};
        String[] prec = new String[]{"NNNNNN", "NNYYYY", "YNNNNN", "NNYNYN", "NNNNNN", "NNNNNN"};

        int expected = 1355;
        int actual = solution.minTime(time, prec);

        Assert.assertEquals(expected, actual);
    }

}
