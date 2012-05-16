import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardsCheatingTest {

    protected CardsCheating solution;

    @Before
    public void setUp() {
        solution = new CardsCheating();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int[] cards = new int[]{0, 1, 2, 0, 1, 2};
        int[] shuffle = new int[]{1, 4, 0, 3, 2, 5};

        int expected = 0;
        int actual = solution.numberOfShuffles(cards, shuffle);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int[] cards = new int[]{2, 0, 1};
        int[] shuffle = new int[]{1, 2, 0};

        int expected = 2;
        int actual = solution.numberOfShuffles(cards, shuffle);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int[] cards = new int[]{1, 1, 2, 0, 2, 0, 1, 0, 2, 2, 1, 0};
        int[] shuffle = new int[]{5, 0, 9, 7, 1, 8, 3, 10, 4, 11, 6, 2};

        int expected = 59;
        int actual = solution.numberOfShuffles(cards, shuffle);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int[] cards = new int[]{1, 0, 2};
        int[] shuffle = new int[]{0, 2, 1};

        int expected = -1;
        int actual = solution.numberOfShuffles(cards, shuffle);

        Assert.assertEquals(expected, actual);
    }

}
