import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivisibleByDigitsTest {

    protected DivisibleByDigits solution;

    @Before
    public void setUp() {
        solution = new DivisibleByDigits();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int n = 13;

        long expected = 132L;
        long actual = solution.getContinuation(n);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int n = 648;

        long expected = 648L;
        long actual = solution.getContinuation(n);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int n = 566;

        long expected = 56610L;
        long actual = solution.getContinuation(n);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int n = 1000000000;

        long expected = 1000000000L;
        long actual = solution.getContinuation(n);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int n = 987654321;

        long expected = 987654321360L;
        long actual = solution.getContinuation(n);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase5() {
        int n = 83;

        long expected = 8304L;
        long actual = solution.getContinuation(n);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase04() {
        int n = 191;

        long expected = 1917L;
        long actual = solution.getContinuation(n);

        Assert.assertEquals(expected, actual);
    }

}
