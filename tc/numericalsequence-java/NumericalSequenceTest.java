import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumericalSequenceTest {

    protected NumericalSequence solution;

    @Before
    public void setUp() {
        solution = new NumericalSequence();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] sequence = new int[]{15, 78, 78, 15};

        int expected = 0;
        int actual = solution.makePalindrome(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] sequence = new int[]{1, 1, 1, 3};

        int expected = 2;
        int actual = solution.makePalindrome(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] sequence = new int[]{15, 78, 87, 51};

        int expected = 3;
        int actual = solution.makePalindrome(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] sequence = new int[]{3, 23, 21, 23, 42, 39, 63, 76, 13, 13, 13, 32, 12, 42, 26};

        int expected = 8;
        int actual = solution.makePalindrome(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase7() {
        int[] sequence = new int[]{10000, 9999, 10000, 9999};

        int expected = 2;
        int actual = solution.makePalindrome(sequence);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase54() {
        int[] sequence = new int[]{529, 6135, 616, 3230, 4330, 3780, 4420, 9106, 5039, 1334, 917, 1302, 1325, 34, 19, 60, 48, 3903, 226, 1370, 1701, 1906, 4420, 202, 292, 1457, 1722, 55, 21, 20, 11, 4330, 1747, 463, 667, 226, 52, 75, 575, 33, 8, 101, 6034, 26, 401, 47, 34, 8, 13};

        int expected = 31;
        int actual = solution.makePalindrome(sequence);

        Assert.assertEquals(expected, actual);
    }
    
    
    

}
