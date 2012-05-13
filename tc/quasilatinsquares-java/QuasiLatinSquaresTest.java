import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuasiLatinSquaresTest {

    protected QuasiLatinSquares solution;

    @Before
    public void setUp() {
        solution = new QuasiLatinSquares();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int n = 3;
        int d = 3;

        String[] expected = new String[]{"0 1 2", "1 2 0", "2 0 1"};
        String[] actual = solution.makeSquare(n, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int n = 5;
        int d = 2;

        String[] expected = new String[]{"0 0 0 0 1", "0 0 0 0 1", "0 0 0 0 1", "0 0 0 0 1", "1 1 1 1 0"};
        String[] actual = solution.makeSquare(n, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int n = 5;
        int d = 4;

        String[] expected = new String[]{"0 0 1 2 3", "0 0 1 2 3", "1 1 0 3 2", "2 2 3 0 1", "3 3 2 1 0"};
        String[] actual = solution.makeSquare(n, d);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int n = 9;
        int d = 7;

        String[] expected = new String[]{"0 0 0 1 2 3 4 5 6", "0 0 0 1 2 3 4 5 6", "0 0 0 1 2 3 4 5 6", "1 1 1 0 3 2 5 6 4", "2 2 2 3 0 1 6 4 5", "3 3 3 4 5 6 0 1 2", "4 4 4 2 6 5 1 0 3", "5 5 5 6 1 4 2 3 0", "6 6 6 5 4 0 3 2 1"};
        String[] actual = solution.makeSquare(n, d);

        Assert.assertArrayEquals(expected, actual);
    }
}
