import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MNSTest {

    protected MNS solution;

    @Before
    public void setUp() {
        solution = new MNS();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] numbers = new int[]{1, 2, 3, 3, 2, 1, 2, 2, 2};

        int expected = 18;
        int actual = solution.combos(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] numbers = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4};

        int expected = 1;
        int actual = solution.combos(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] numbers = new int[]{1, 5, 1, 2, 5, 6, 2, 3, 2};

        int expected = 36;
        int actual = solution.combos(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] numbers = new int[]{1, 2, 6, 6, 6, 4, 2, 6, 4};

        int expected = 0;
        int actual = solution.combos(numbers);

        Assert.assertEquals(expected, actual);
    }

}
