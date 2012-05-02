import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisRalliesTest {

    protected TennisRallies solution;

    @Before
    public void setUp() {
        solution = new TennisRallies();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int numLength = 3;
        String[] forbidden = new String[]{"cc", "dd"};
        int allowed = 1;

        int expected = 2;
        int actual = solution.howMany(numLength, forbidden, allowed);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int numLength = 10;
        String[] forbidden = new String[]{"c"};
        int allowed = 1;

        int expected = 1;
        int actual = solution.howMany(numLength, forbidden, allowed);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int numLength = 10;
        String[] forbidden = new String[]{"c"};
        int allowed = 2;

        int expected = 11;
        int actual = solution.howMany(numLength, forbidden, allowed);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int numLength = 18;
        String[] forbidden = new String[]{"c", "d"};
        int allowed = 1;

        int expected = 0;
        int actual = solution.howMany(numLength, forbidden, allowed);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int numLength = 18;
        String[] forbidden = new String[]{};
        int allowed = 1;

        int expected = 262144;
        int actual = solution.howMany(numLength, forbidden, allowed);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase5() {
        int numLength = 18;
        String[] forbidden = new String[]{"c", "cc", "ccc", "cccc", "ccccc", "cccccc", "ccccccc", "cccccccc", "ccccccccc", "cccccccccc"};
        int allowed = 100;

        int expected = 262122;
        int actual = solution.howMany(numLength, forbidden, allowed);

        Assert.assertEquals(expected, actual);
    }

}
