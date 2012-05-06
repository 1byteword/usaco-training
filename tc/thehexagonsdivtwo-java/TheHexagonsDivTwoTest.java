import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheHexagonsDivTwoTest {

    protected TheHexagonsDivTwo solution;

    @Before
    public void setUp() {
        solution = new TheHexagonsDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 7;
        int k = 3;

        long expected = 0L;
        long actual = solution.count(n, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 8;
        int k = 3;

        long expected = 24L;
        long actual = solution.count(n, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 8;
        int k = 4;

        long expected = 256L;
        long actual = solution.count(n, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 20;
        int k = 5;

        long expected = 4692480L;
        long actual = solution.count(n, k);

        Assert.assertEquals(expected, actual);
    }

}
