import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImportsListTest {

    protected ImportsList solution;

    @Before
    public void setUp() {
        solution = new ImportsList();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] requires = new String[]{"NNN", "NNN", "NNN"};

        int[] expected = new int[]{0, 0, 0};
        int[] actual = solution.importsCount(requires);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] requires = new String[]{"NYYY", "NNYY", "NNNY", "NNNN"};

        int[] expected = new int[]{1, 1, 1, 0};
        int[] actual = solution.importsCount(requires);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] requires = new String[]{"NNNNY", "NNNNY", "YNNNY", "NNNNN", "NNNNN"};

        int[] expected = new int[]{1, 1, 1, 0, 0};
        int[] actual = solution.importsCount(requires);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] requires = new String[]{"NYYNYNYYYNYYNYNN", "NNNNNNNNNNNNNNNN", "NNNNNNNNNNYNNNNN", "NNNNNNNNNYNNYNNN", "NYNNNNYNNNYYNNNN", "NYNNYNYNYNYYNNNN", "NNNNNNNNNNYNNNNN", "NNYNNNYNYNYNNNNN", "NNNNNNYNNNYNNNNN", "NNNNNNNNNNNNYNNN", "NNNNNNNNNNNNNNNN", "NNNNNNNNNNNNNNNN", "NNNNNNNNNNNNNNNN", "NNNNNNYNNNYNNNNN", "YYYYYNYYYYYYYYNY", "NYYYNNYNNYYNYYNN"};

        int[] expected = new int[]{3, 0, 1, 1, 3, 2, 1, 2, 1, 1, 0, 0, 0, 1, 2, 4};
        int[] actual = solution.importsCount(requires);

        Assert.assertArrayEquals(expected, actual);
    }

}
