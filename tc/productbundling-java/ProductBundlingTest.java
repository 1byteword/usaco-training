import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductBundlingTest {

    protected ProductBundling solution;

    @Before
    public void setUp() {
        solution = new ProductBundling();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] data = new String[]{"11100"};

        int expected = 2;
        int actual = solution.howManyBundles(data);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] data = new String[]{"1010", "1100"};

        int expected = 4;
        int actual = solution.howManyBundles(data);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] data = new String[]{"1100000000", "1100000000", "0011000000", "0011000000", "0000110000", "0000110000", "0000001100", "0000001100", "0000000011", "0000000011"};

        int expected = 5;
        int actual = solution.howManyBundles(data);

        Assert.assertEquals(expected, actual);
    }

}
