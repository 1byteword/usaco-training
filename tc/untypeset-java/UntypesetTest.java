import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UntypesetTest {

    protected Untypeset solution;

    @Before
    public void setUp() {
        solution = new Untypeset();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] expression = new String[]{"2801"};

        int expected = 2801;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] expression = new String[]{"  625       ", "------------", "        5   "};

        int expected = 125;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] expression = new String[]{"       ", "500    ", "       ", "    +  ", "       ", "       ", "      1", "       ", "       "};

        int expected = 501;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] expression = new String[]{"   120   ", "  -----  ", "    10   ", "---------", "    6    ", "   ---   ", "    2    "};

        int expected = 4;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String[] expression = new String[]{"       24       ", " 31 + ----      ", "       12   + 16", "-----------     ", "   5 + 6        "};

        int expected = 19;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase5() {
        String[] expression = new String[]{"3 + 4 + 6"};

        int expected = 13;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase6() {
        String[] expression = new String[]{" 1     4     9 ", "--- + --- + ---", " 1     2     3 "};

        int expected = 6;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase7() {
        String[] expression = new String[]{"34      ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "   +    ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "     924"};

        int expected = 958;
        int actual = solution.evaluate(expression);

        Assert.assertEquals(expected, actual);
    }

}
