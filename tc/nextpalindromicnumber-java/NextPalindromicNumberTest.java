import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NextPalindromicNumberTest {

    protected NextPalindromicNumber solution;

    @Before
    public void setUp() {
        solution = new NextPalindromicNumber();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String n = "12345";

        String expected = "12421";
        String actual = solution.getNext(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String n = "858";

        String expected = "868";
        String actual = solution.getNext(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String n = "1999";

        String expected = "2002";
        String actual = solution.getNext(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String n = "1";

        String expected = "2";
        String actual = solution.getNext(n);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String n = "9999";

        String expected = "10001";
        String actual = solution.getNext(n);

        Assert.assertEquals(expected, actual);
    }

}
