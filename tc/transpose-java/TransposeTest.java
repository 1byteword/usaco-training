import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransposeTest {

    protected Transpose solution;

    @Before
    public void setUp() {
        solution = new Transpose();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int M = 3;
        int N = 3;

        int expected = 3;
        int actual = solution.numSwaps(M, N);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int M = 2;
        int N = 3;

        int expected = 3;
        int actual = solution.numSwaps(M, N);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int M = 3;
        int N = 5;

        int expected = 10;
        int actual = solution.numSwaps(M, N);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int M = 50;
        int N = 50;

        int expected = 1225;
        int actual = solution.numSwaps(M, N);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int M = 49;
        int N = 51;

        int expected = 2492;
        int actual = solution.numSwaps(M, N);

        Assert.assertEquals(expected, actual);
    }

}
