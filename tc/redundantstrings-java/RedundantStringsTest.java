import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedundantStringsTest {

    protected RedundantStrings solution;

    @Before
    public void setUp() {
        solution = new RedundantStrings();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int length = 1;

        int expected = 0;
        int actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int length = 2;

        int expected = 2;
        int actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int length = 4;

        int expected = 4;
        int actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int length = 10;

        int expected = 34;
        int actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int length = 30;

        int expected = 33814;
        int actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int length = 60;

        int expected = 1074793396;
        int actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

}
