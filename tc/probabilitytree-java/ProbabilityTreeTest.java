import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProbabilityTreeTest {

    protected ProbabilityTree solution;

    @Before
    public void setUp() {
        solution = new ProbabilityTree();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] tree = new String[]{"40", "0 70 10"};
        int lowerBound = 30;
        int upperBound = 50;

        int[] expected = new int[]{0, 1};
        int[] actual = solution.getOdds(tree, lowerBound, upperBound);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] tree = new String[]{"20", "2 50 50", "0 50 50"};
        int lowerBound = 49;
        int upperBound = 51;

        int[] expected = new int[]{1, 2};
        int[] actual = solution.getOdds(tree, lowerBound, upperBound);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] tree = new String[]{"10", "0 99 41", "1 40 3", "2 91 43"};
        int lowerBound = 81;
        int upperBound = 88;

        int[] expected = new int[]{};
        int[] actual = solution.getOdds(tree, lowerBound, upperBound);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] tree = new String[]{"79", "0 64 52", "1 70 87", "0 38 99", "1 24 8"};
        int lowerBound = 47;
        int upperBound = 81;

        int[] expected = new int[]{0, 1, 2, 3};
        int[] actual = solution.getOdds(tree, lowerBound, upperBound);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String[] tree = new String[]{"51", "29 58 3", "6 56 86", "18 97 1", "44 99 25", "33 69 90", "27 67 49", "32 15 19", "33 1 21", "45 12 33", "29 24 40", "45 86 74", "40 30 65", "0 18 27", "1 90 65", "0 47 62", "40 81 72", "42 25 56", "45 16 81", "8 94 92", "29 41 92", "24 4 29", "32 56 91", "20 16 77", "1 35 79", "45 77 61", "6 50 19", "20 69 43", "4 6 16", "15 55 26", "42 73 90", "40 8 49", "33 16 33", "15 95 47", "9 66 40", "25 80 39", "35 72 70", "27 10 36", "40 36 10", "32 2 48", "33 44 23", "22 51 45", "25 8 43", "18 32 96", "45 41 74", "0 51 6", "18 48 15"};
        int lowerBound = 8;
        int upperBound = 82;

        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 23, 24, 25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46};
        int[] actual = solution.getOdds(tree, lowerBound, upperBound);

        Assert.assertArrayEquals(expected, actual);
    }

}
