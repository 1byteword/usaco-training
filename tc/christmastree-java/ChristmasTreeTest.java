import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChristmasTreeTest {

    protected ChristmasTree solution;

    @Before
    public void setUp() {
        solution = new ChristmasTree();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int N = 2;
        int red = 1;
        int green = 1;
        int blue = 1;

        long expected = 6L;
        long actual = solution.decorationWays(N, red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int N = 2;
        int red = 2;
        int green = 1;
        int blue = 0;

        long expected = 3L;
        long actual = solution.decorationWays(N, red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int N = 3;
        int red = 2;
        int green = 2;
        int blue = 1;

        long expected = 0L;
        long actual = solution.decorationWays(N, red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int N = 3;
        int red = 2;
        int green = 2;
        int blue = 2;

        long expected = 36L;
        long actual = solution.decorationWays(N, red, green, blue);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int N = 8;
        int red = 1;
        int green = 15;
        int blue = 20;

        long expected = 197121L;
        long actual = solution.decorationWays(N, red, green, blue);

        Assert.assertEquals(expected, actual);
    }
    
    @Test//(timeout = 2000)
    public void testCase37() {
        int N = 9;
        int red = 23;
        int green = 1;
        int blue = 22;

        long expected = 795052L;
        long actual = solution.decorationWays(N, red, green, blue);

        Assert.assertEquals(expected, actual);
    }

}
