import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BirdsCountingTest {

    protected BirdsCounting solution;

    @Before
    public void setUp() {
        solution = new BirdsCounting();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int birdsNumber = 3;
        int caughtPerDay = 1;
        int daysNumber = 2;
        int birdsMarked = 2;

        double expected = 0.6666666666666666;
        double actual = solution.computeProbability(birdsNumber, caughtPerDay, daysNumber, birdsMarked);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int birdsNumber = 3;
        int caughtPerDay = 1;
        int daysNumber = 5;
        int birdsMarked = 1;

        double expected = 0.012345679012345678;
        double actual = solution.computeProbability(birdsNumber, caughtPerDay, daysNumber, birdsMarked);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int birdsNumber = 8;
        int caughtPerDay = 3;
        int daysNumber = 3;
        int birdsMarked = 7;

        double expected = 0.2582908163265306;
        double actual = solution.computeProbability(birdsNumber, caughtPerDay, daysNumber, birdsMarked);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int birdsNumber = 5;
        int caughtPerDay = 3;
        int daysNumber = 2;
        int birdsMarked = 4;

        double expected = 0.6;
        double actual = solution.computeProbability(birdsNumber, caughtPerDay, daysNumber, birdsMarked);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int birdsNumber = 20;
        int caughtPerDay = 6;
        int daysNumber = 5;
        int birdsMarked = 17;

        double expected = 0.30035494805367574;
        double actual = solution.computeProbability(birdsNumber, caughtPerDay, daysNumber, birdsMarked);

        assertEquals(expected, actual);
    }
    

    @Test//(timeout = 2000)
    public void testCase5() {
        int birdsNumber = 20;
        int caughtPerDay = 1;
        int daysNumber = 3;
        int birdsMarked = 14;

        double expected = 0.0;
        double actual = solution.computeProbability(birdsNumber, caughtPerDay, daysNumber, birdsMarked);

        assertEquals(expected, actual);
    }
    

}
