import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BadSubstringTest {

    protected BadSubstring solution;

    @Before
    public void setUp() {
        solution = new BadSubstring();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int length = 0;

        long expected = 1L;
        long actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int length = 3;

        long expected = 21L;
        long actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int length = 29;

        long expected = 1548008755920L;
        long actual = solution.howMany(length);

        Assert.assertEquals(expected, actual);
    }

}
