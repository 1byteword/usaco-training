import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrossroadsTest {

    protected Crossroads solution;

    @Before
    public void setUp() {
        solution = new Crossroads();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int[] angles = new int[]{105, 75, 25, 120, 35, 75};

        int[] expected = new int[]{0, 1, 5};
        int[] actual = solution.getOut(angles);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int[] angles = new int[]{1, 1, 1, 1, 1, 1};

        int[] expected = new int[]{0, 1, 2, 3, 4, 5};
        int[] actual = solution.getOut(angles);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int[] angles = new int[]{13};

        int[] expected = new int[]{0};
        int[] actual = solution.getOut(angles);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int[] angles = new int[]{90, 123, 1, 23, 132, 11, 28, 179, 179, 77, 113, 91};

        int[] expected = new int[]{0};
        int[] actual = solution.getOut(angles);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int[] angles = new int[]{179, 89, 90, 91, 1};

        int[] expected = new int[]{0, 2, 4};
        int[] actual = solution.getOut(angles);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase5() {
        int[] angles = new int[]{89, 91};

        int[] expected = new int[]{0};
        int[] actual = solution.getOut(angles);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase6() {
        int[] angles = new int[]{140, 118, 54, 166, 151, 44, 90, 5, 14, 6, 64, 129, 74, 33, 134, 25, 11, 95, 65, 145, 29, 162, 24, 147, 45, 103, 63, 97, 120, 156, 167, 170, 19, 28, 100, 144, 161, 13, 157, 148};

        int[] expected = new int[]{0, 1, 6};
        int[] actual = solution.getOut(angles);

        Assert.assertArrayEquals(expected, actual);
    }

}
