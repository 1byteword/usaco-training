import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FloodReliefTest {

    protected FloodRelief solution;

    @Before
    public void setUp() {
        solution = new FloodRelief();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] heights = new String[]{"ccccc", "cbbbc", "cbabc", "cbbbc", "ccccc"};

        int expected = 1;
        int actual = solution.minimumPumps(heights);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] heights = new String[]{"cbabcbabc", "cbabcbabc", "cbabcbabc", "cbabcbabc"};

        int expected = 2;
        int actual = solution.minimumPumps(heights);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] heights = new String[]{"ccccccccccc", "caaaaaaaaac", "caaaaaaaaac", "caazpppzaac", "caapdddpaac", "caapdddpaac", "caapdddpaac", "caazpppzaac", "caaaaaaaaac", "caaaaaaaaac", "ccccccccccc"};

        int expected = 2;
        int actual = solution.minimumPumps(heights);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] heights = new String[]{"ab", "ba"};

        int expected = 2;
        int actual = solution.minimumPumps(heights);

        Assert.assertEquals(expected, actual);
    }

}
