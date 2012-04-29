import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RunLengthEncodingTest {

    protected RunLengthEncoding solution;

    @Before
    public void setUp() {
        solution = new RunLengthEncoding();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String text = "4A3BC2DE";

        String expected = "AAAABBBCDDE";
        String actual = solution.decode(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String text = "1A1B1C1D1E";

        String expected = "ABCDE";
        String actual = solution.decode(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String text = "1A3A5A4BCCCC";

        String expected = "AAAAAAAAABBBBCCCC";
        String actual = solution.decode(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String text = "50A";

        String expected = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String actual = solution.decode(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String text = "21Z13S9A8M";

        String expected = "TOO LONG";
        String actual = solution.decode(text);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        String text = "123456789012345678901234567890B";

        String expected = "TOO LONG";
        String actual = solution.decode(text);

        Assert.assertEquals(expected, actual);
    }

}
