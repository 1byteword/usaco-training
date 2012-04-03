import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheTicketsDivTwoTest {

    protected TheTicketsDivTwo solution;

    @Before
    public void setUp() {
        solution = new TheTicketsDivTwo();
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
        int n = 2;
        int m = 1;
        int k = 1;

        double expected = 0.16666666666666666;
        double actual = solution.find(n, m, k);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 2;
        int m = 1;
        int k = 2;

        double expected = 0.5833333333333334;
        double actual = solution.find(n, m, k);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 7;
        int m = 7;
        int k = 4;

        double expected = 0.0;
        double actual = solution.find(n, m, k);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int n = 4;
        int m = 2;
        int k = 10;

        double expected = 0.25264033564814814;
        double actual = solution.find(n, m, k);

        assertEquals(expected, actual);
    }

}
