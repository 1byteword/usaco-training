import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    protected Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testCase0() {
    	int length = 6;
    	int maxAdjcent = 2;
    	int[] boards = new int[] {1, 2, 3, 4, 5, 6};
    	int expected = 16;
    	
    	int actual = solution.solve(length, maxAdjcent, boards);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
    	int length = 5;
    	int maxAdjcent = 4;
    	int[] boards = new int[] {1, 2, 3, 4, 5};
    	int expected = 14;
    	
    	int actual = solution.solve(length, maxAdjcent, boards);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
    	int length = 8;
    	int maxAdjcent = 2;
    	int[] boards = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    	int expected = 27;
    	
    	int actual = solution.solve(length, maxAdjcent, boards);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
    	int length = 3;
    	int maxAdjcent = 1;
    	int[] boards = new int[] {6, 8, 7};
    	int expected = 13;
    	
    	int actual = solution.solve(length, maxAdjcent, boards);
        Assert.assertEquals(expected, actual);
    }


}
