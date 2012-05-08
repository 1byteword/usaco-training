import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HilbertTest {

    protected Hilbert solution;

    @Before
    public void setUp() {
        solution = new Hilbert();
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int k = 5;
        int x = 1;
        int y = 1;

        int expected = 0;
        int actual = solution.steps(k, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int k = 15;
        int x = 32768;
        int y = 1;

        int expected = 1073741823;
        int actual = solution.steps(k, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int k = 1;
        int x = 2;
        int y = 2;

        int expected = 2;
        int actual = solution.steps(k, x, y);

        Assert.assertEquals(expected, actual);
    }
    
    @Test//(timeout = 2000)
    public void testCase5() {
        int k = 15;
        int x = 30000;
        int y = 30000;

        int expected = 706873514;
        int actual = solution.steps(k, x, y);

        Assert.assertEquals(expected, actual);
    }


    @Test//(timeout = 2000)
    public void testCase4() {
        int k = 10;
        int x = 546;
        int y = 109;

        int expected = 955129;
        int actual = solution.steps(k, x, y);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int k = 3;
        int x = 2;
        int y = 3;

        int expected = 13;
        int actual = solution.steps(k, x, y);

        Assert.assertEquals(expected, actual);
    }


}
