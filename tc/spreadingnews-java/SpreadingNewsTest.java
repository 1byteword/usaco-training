import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpreadingNewsTest {

    protected SpreadingNews solution;

    @Before
    public void setUp() {
        solution = new SpreadingNews();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int[] supervisors = new int[]{-1, 0, 0};

        int expected = 2;
        int actual = solution.minTime(supervisors);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int[] supervisors = new int[]{-1, 0, 0, 2, 2};

        int expected = 3;
        int actual = solution.minTime(supervisors);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int[] supervisors = new int[]{-1, 0, 1, 2, 3};

        int expected = 4;
        int actual = solution.minTime(supervisors);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int[] supervisors = new int[]{-1, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 12, 13, 14, 16, 16, 16};

        int expected = 7;
        int actual = solution.minTime(supervisors);

        Assert.assertEquals(expected, actual);
    }
    
    

}
