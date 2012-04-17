import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolynomialMultiplierTest {

    protected PolynomialMultiplier solution;

    @Before
    public void setUp() {
        solution = new PolynomialMultiplier();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String f1 = "1 + x";
        String f2 = "1 + x";

        String expected = "x^2 + 2*x + 1";
        String actual = solution.product(f1, f2);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String f1 = "4*x^4 + 1";
        String f2 = "3*x^5 + 7*x";

        String expected = "12*x^9 + 31*x^5 + 7*x";
        String actual = solution.product(f1, f2);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String f1 = "1 + x + 1 + x";
        String f2 = "5 + 5";

        String expected = "20*x + 20";
        String actual = solution.product(f1, f2);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String f1 = "8*x^5";
        String f2 = "9*x^7";

        String expected = "72*x^12";
        String actual = solution.product(f1, f2);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String f1 = "5*x^3 + x^4 + 8 + 2*x^6";
        String f2 = "3*x^5 + 4*x + 7*x^9";

        String expected = "14*x^15 + 7*x^13 + 35*x^12 + 6*x^11 + 59*x^9 + 15*x^8 + 8*x^7 + 28*x^5 + 20*x^4 + 32*x";
        String actual = solution.product(f1, f2);

        Assert.assertEquals(expected, actual);
    }

}
