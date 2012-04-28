import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivisorDigitsTest {

    protected DivisorDigits solution;

    @Before
    public void setUp() {
        solution = new DivisorDigits();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int number = 12345;

        int expected = 3;
        int actual = solution.howMany(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int number = 661232;

        int expected = 3;
        int actual = solution.howMany(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int number = 52527;

        int expected = 0;
        int actual = solution.howMany(number);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int number = 730000000;

        int expected = 0;
        int actual = solution.howMany(number);

        Assert.assertEquals(expected, actual);
    }

}
