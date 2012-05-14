import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgramScheduleTest {

    protected ProgramSchedule solution;

    @Before
    public void setUp() {
        solution = new ProgramSchedule();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{2, 2, 4, 2};

        int expected = 12;
        int actual = solution.schedule(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] A = new int[]{3, 1, 2};
        int[] B = new int[]{4, 3, 9};

        int expected = 11;
        int actual = solution.schedule(A, B);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] A = new int[]{1000};
        int[] B = new int[]{1000};

        int expected = 2000;
        int actual = solution.schedule(A, B);

        Assert.assertEquals(expected, actual);
    }

}
