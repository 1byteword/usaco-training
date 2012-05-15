import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FairWorkloadTest {

    protected FairWorkload solution;

    @Before
    public void setUp() {
        solution = new FairWorkload();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] folders = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90};
        int workers = 3;

        int expected = 170;
        int actual = solution.getMostWork(folders, workers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] folders = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90};
        int workers = 5;

        int expected = 110;
        int actual = solution.getMostWork(folders, workers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] folders = new int[]{568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782};
        int workers = 4;

        int expected = 1785;
        int actual = solution.getMostWork(folders, workers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] folders = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000};
        int workers = 2;

        int expected = 1000;
        int actual = solution.getMostWork(folders, workers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] folders = new int[]{50, 50, 50, 50, 50, 50, 50};
        int workers = 2;

        int expected = 200;
        int actual = solution.getMostWork(folders, workers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase5() {
        int[] folders = new int[]{1, 1, 1, 1, 100};
        int workers = 5;

        int expected = 100;
        int actual = solution.getMostWork(folders, workers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase6() {
        int[] folders = new int[]{950, 650, 250, 250, 350, 100, 650, 150, 150, 700};
        int workers = 6;

        int expected = 950;
        int actual = solution.getMostWork(folders, workers);

        Assert.assertEquals(expected, actual);
    }

}
