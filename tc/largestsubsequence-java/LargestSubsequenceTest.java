import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LargestSubsequenceTest {

    protected LargestSubsequence solution;

    @Before
    public void setUp() {
        solution = new LargestSubsequence();
    }

    @Test
    public void testCase0() {
        String s = "test";

        String expected = "tt";
        String actual = solution.getLargest(s);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String s = "a";

        String expected = "a";
        String actual = solution.getLargest(s);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String s = "example";

        String expected = "xple";
        String actual = solution.getLargest(s);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String s = "aquickbrownfoxjumpsoverthelazydog";

        String expected = "zyog";
        String actual = solution.getLargest(s);

        Assert.assertEquals(expected, actual);
    }

}
