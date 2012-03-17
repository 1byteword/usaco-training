import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphLabelTest {

    protected GraphLabel solution;

    @Before
    public void setUp() {
        solution = new GraphLabel();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] graph = new String[]{"010000", "101111", "010111", "011010", "011101", "011010"};

        int expected = 3;
        int actual = solution.adjacentDifference(graph);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] graph = new String[]{"01111001", "10101000", "11000101", "10000111", "11000111", "00111000", "00011000", "10111000"};

        int expected = 4;
        int actual = solution.adjacentDifference(graph);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] graph = new String[]{"011110101", "100111000", "100000111", "110011011", "110101001", "010110110", "101001010", "001101101", "101110010"};

        int expected = 4;
        int actual = solution.adjacentDifference(graph);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] graph = new String[]{"011111111", "101111111", "110111111", "111011111", "111101111", "111110111", "111111011", "111111101", "111111110"};

        int expected = 8;
        int actual = solution.adjacentDifference(graph);

        Assert.assertEquals(expected, actual);
    }

}
