import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    protected MergeSort solution;

    @Before
    public void setUp() {
        solution = new MergeSort();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        int[] numbers = new int[]{1, 2, 3, 4};

        int expected = 4;
        int actual = solution.howManyComparisons(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        int[] numbers = new int[]{2, 3, 2};

        int expected = 2;
        int actual = solution.howManyComparisons(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        int[] numbers = new int[]{-17};

        int expected = 0;
        int actual = solution.howManyComparisons(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        int[] numbers = new int[]{};

        int expected = 0;
        int actual = solution.howManyComparisons(numbers);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        int[] numbers = new int[]{-2000000000, 2000000000, 0, 0, 0, -2000000000, 2000000000, 0, 0, 0};

        int expected = 19;
        int actual = solution.howManyComparisons(numbers);

        Assert.assertEquals(expected, actual);
    }

}
