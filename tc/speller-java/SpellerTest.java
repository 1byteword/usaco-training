import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpellerTest {

    protected Speller solution;

    @Before
    public void setUp() {
        solution = new Speller();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String number = "forty-two";

        int expected = 42;
        int actual = solution.value(number);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String number = "FORTY-TWO";

        int expected = -1;
        int actual = solution.value(number);

        Assert.assertEquals(expected, actual);
    }

    @Test ////(timeout = 2000)
    public void testCase2() {
        String number = "eightene";

        int expected = 18;
        int actual = solution.value(number);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String number = "fi";

        int expected = -1;
        int actual = solution.value(number);

        Assert.assertEquals(expected, actual);
    }

}
