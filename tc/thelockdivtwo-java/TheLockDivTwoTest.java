import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TheLockDivTwoTest {

    protected TheLockDivTwo solution;

    @Before
    public void setUp() {
        solution = new TheLockDivTwo();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int n = 2;
        int k = 4;

        String expected = "10";
        String actual = solution.password(n, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int n = 4;
        int k = 6;

        String expected = "0100";
        String actual = solution.password(n, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int n = 10;
        int k = 1;

        String expected = "0000000000";
        String actual = solution.password(n, k);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int n = 7;
        int k = 100;

        String expected = "1100001";
        String actual = solution.password(n, k);

        Assert.assertEquals(expected, actual);
    }

}
