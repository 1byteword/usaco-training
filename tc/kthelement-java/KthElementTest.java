import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KthElementTest {

    protected KthElement solution;

    @Before
    public void setUp() {
        solution = new KthElement();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int A = 0;
        int B = 12;
        int K = 5;

        int expected = 12;
        int actual = solution.find(A, B, K);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int A = 1;
        int B = 7;
        int K = 15;

        int expected = 9;
        int actual = solution.find(A, B, K);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int A = 15;
        int B = 21;
        int K = 500000001;

        int expected = 51;
        int actual = solution.find(A, B, K);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int A = 79;
        int B = 4;
        int K = 700000000;

        int expected = 478;
        int actual = solution.find(A, B, K);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int A = 293451;
        int B = 765339;
        int K = 900000000;

        int expected = 3993300;
        int actual = solution.find(A, B, K);

        Assert.assertEquals(expected, actual);
    }

}
