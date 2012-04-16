import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PipePuzzleTest {

    protected PipePuzzle solution;

    @Before
    public void setUp() {
        solution = new PipePuzzle();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] pipes = new String[]{"LL-L-", "L+L+L", "--NL-", "L+--L", "LL+L-"};

        int expected = 19;
        int actual = solution.longest(pipes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] pipes = new String[]{"ELLL", "LLLL", "LLLL", "LLLL"};

        int expected = 13;
        int actual = solution.longest(pipes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] pipes = new String[]{"ELLLLL+", "++++++L", "L+++++L", "L+++++L", "L+++++L", "L+++++L", "+LLLLLL"};

        int expected = 71;
        int actual = solution.longest(pipes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] pipes = new String[]{"-+-+-+-+-+-+-+-+-+-W"};

        int expected = 19;
        int actual = solution.longest(pipes);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] pipes = new String[]{"N"};

        int expected = 0;
        int actual = solution.longest(pipes);

        Assert.assertEquals(expected, actual);
    }

}
