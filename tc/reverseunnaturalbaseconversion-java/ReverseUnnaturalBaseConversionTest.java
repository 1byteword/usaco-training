import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseUnnaturalBaseConversionTest {

    protected ReverseUnnaturalBaseConversion solution;

    @Before
    public void setUp() {
        solution = new ReverseUnnaturalBaseConversion();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int x = 12345;
        int b = 10;

        String expected = "12345";
        String actual = solution.convertToBase(x, b);

        Assert.assertEquals(expected, actual);
    }

    @Test //(timeout = 2000)
    public void testCase1() {
        int x = 8265;
        int b = -10;

        String expected = "12345";
        String actual = solution.convertToBase(x, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int x = 1001;
        int b = -2;

        String expected = "10000111001";
        String actual = solution.convertToBase(x, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int x = -52;
        int b = -2;

        String expected = "11011100";
        String actual = solution.convertToBase(x, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int x = -38;
        int b = 4;

        String expected = "-212";
        String actual = solution.convertToBase(x, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int x = -123456789;
        int b = -7;

        String expected = "3031330536";
        String actual = solution.convertToBase(x, b);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        int x = 0;
        int b = 2;

        String expected = "0";
        String actual = solution.convertToBase(x, b);

        Assert.assertEquals(expected, actual);
    }

}
