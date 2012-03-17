import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinReversingTest {

    protected CoinReversing solution;

    @Before
    public void setUp() {
        solution = new CoinReversing();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int N = 3;
        int[] a = new int[]{2, 2};

        double expected = 1.6666666666666667;
        double actual = solution.expectedHeads(N, a);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int N = 10;
        int[] a = new int[]{10, 10, 10};

        double expected = 0.0;
        double actual = solution.expectedHeads(N, a);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int N = 10;
        int[] a = new int[]{2, 7, 1, 8, 2, 8};

        double expected = 4.792639999999999;
        double actual = solution.expectedHeads(N, a);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int N = 1000;
        int[] a = new int[]{916, 153, 357, 729, 183, 848, 61, 672, 295, 936};

        double expected = 498.1980774932278;
        double actual = solution.expectedHeads(N, a);

        assertEquals(expected, actual);
    }
    
    @Test(timeout = 2000)
    public void testCase30() {
        int N = 900;
        int[] a = new int[]{423, 251, 299, 153, 636, 374, 535, 717, 118, 768, 393, 41, 399, 243, 243, 697, 433, 153, 249, 25, 174, 855, 848, 845, 857, 600, 409, 697, 874, 410, 120, 250, 299, 883, 31, 391, 864, 767, 346, 256, 2, 652, 256, 72, 812};

        double expected = 450.0;
        double actual = solution.expectedHeads(N, a);

        assertEquals(expected, actual);
    }
    
    

}
