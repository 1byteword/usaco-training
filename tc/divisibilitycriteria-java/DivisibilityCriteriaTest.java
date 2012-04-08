import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivisibilityCriteriaTest {

    protected DivisibilityCriteria solution;

    @Before
    public void setUp() {
        solution = new DivisibilityCriteria();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 6;
        int P = 7;

        int[] expected = new int[]{5, 4, 6, 2, 3, 1};
        int[] actual = solution.multipliers(N, P);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 7;
        int P = 11;

        int[] expected = new int[]{1, 10, 1, 10, 1, 10, 1};
        int[] actual = solution.multipliers(N, P);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 5;
        int P = 13;

        int[] expected = new int[]{3, 12, 9, 10, 1};
        int[] actual = solution.multipliers(N, P);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 2;
        int P = 2;

        int[] expected = new int[]{0, 1};
        int[] actual = solution.multipliers(N, P);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int N = 16;
        int P = 97;

        int[] expected = new int[]{45, 53, 15, 50, 5, 49, 34, 81, 76, 27, 90, 9, 30, 3, 10, 1};
        int[] actual = solution.multipliers(N, P);

        Assert.assertArrayEquals(expected, actual);
    }

}
