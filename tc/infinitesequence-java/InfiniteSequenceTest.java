import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InfiniteSequenceTest {

    protected InfiniteSequence solution;

    @Before
    public void setUp() {
        solution = new InfiniteSequence();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        long n = 0L;
        int p = 2;
        int q = 3;

        long expected = 1L;
        long actual = solution.calc(n, p, q);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        long n = 7L;
        int p = 2;
        int q = 3;

        long expected = 7L;
        long actual = solution.calc(n, p, q);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        long n = 10000000L;
        int p = 3;
        int q = 3;

        long expected = 32768L;
        long actual = solution.calc(n, p, q);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        long n = 256L;
        int p = 2;
        int q = 4;

        long expected = 89L;
        long actual = solution.calc(n, p, q);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        long n = 1L;
        int p = 1000000;
        int q = 1000000;

        long expected = 2L;
        long actual = solution.calc(n, p, q);

        Assert.assertEquals(expected, actual);
    }
    
    
    
    @Test//(timeout = 2000)
    public void testCase5() {
        long n = 1000000000000L;
        int p = 2;
        int q = 2;

        long expected =  1099511627776L;
        long actual = solution.calc(n, p, q);

        Assert.assertEquals(expected, actual);
    }
    
    @Test//(timeout = 2000)
    public void testCase10() {
        long n = 987654321234L;
        int p = 2;
        int q = 3;

        long expected = 4135435417L;
        long actual = solution.calc(n, p, q);

        Assert.assertEquals(expected, actual);
    }
    

}
