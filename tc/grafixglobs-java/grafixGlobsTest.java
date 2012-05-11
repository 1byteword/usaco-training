import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class grafixGlobsTest {

    protected grafixGlobs solution;

    @Before
    public void setUp() {
        solution = new grafixGlobs();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] commands = new String[]{"make polygon", "make circle", "make polygon", "merge 0 1", "merge 2 0", "split 2"};
        int sel = 0;

        int[] expected = new int[]{0, 1, 0};
        int[] actual = solution.execute(commands, sel);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] commands = new String[]{"make circle", "make circle", "make arc", "merge 2 1", "delete 0", "split 2", "delete 0", "make polygon"};
        int sel = 0;

        int[] expected = new int[]{0, 0, 1};
        int[] actual = solution.execute(commands, sel);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] commands = new String[]{"make circle", "make circle", "make arc", "merge 2 1", "delete 0", "split 2", "delete 0", "make polygon"};
        int sel = 2;

        int[] expected = new int[]{};
        int[] actual = solution.execute(commands, sel);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] commands = new String[]{"make arc"};
        int sel = 999;

        int[] expected = new int[]{};
        int[] actual = solution.execute(commands, sel);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] commands = new String[]{"make polygon", "make polygon", "make arc", "make circle", "make circle", "delete 3", "make polygon", "make arc", "make arc", "merge 1 3", "merge 1 4", "merge 2 1", "make arc", "make arc", "make circle", "make circle", "merge 6 5", "split 6", "merge 2 1"};
        int sel = 2;

        int[] expected = new int[]{2, 1, 2};
        int[] actual = solution.execute(commands, sel);

        Assert.assertArrayEquals(expected, actual);
    }

}
