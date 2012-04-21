import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GreedyGovernmentTest {

    protected GreedyGovernment solution;

    @Before
    public void setUp() {
        solution = new GreedyGovernment();
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
        String[] tolls = new String[]{"X324", "XXX2", "12X5", "991X"};
        int tollHike = 9;

        double expected = 10.0;
        double actual = solution.maxAverageCost(tolls, tollHike);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] tolls = new String[]{"X324", "5X22", "12X5", "991X"};
        int tollHike = 57;

        double expected = 29.2;
        double actual = solution.maxAverageCost(tolls, tollHike);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] tolls = new String[]{"X11", "2X1", "37X"};
        int tollHike = 76;

        double expected = 39.5;
        double actual = solution.maxAverageCost(tolls, tollHike);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] tolls = new String[]{"X32X", "XXXX", "XXXX", "XXXX"};
        int tollHike = 99;

        double expected = 0.0;
        double actual = solution.maxAverageCost(tolls, tollHike);

        assertEquals(expected, actual);
    }

}
