import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AaagmnrsTest {

    protected Aaagmnrs solution;

    @Before
    public void setUp() {
        solution = new Aaagmnrs();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] phrases = new String[]{"Aaagmnrs", "TopCoder", "anagrams", "Drop Cote"};

        String[] expected = new String[]{"Aaagmnrs", "TopCoder"};
        String[] actual = solution.anagrams(phrases);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] phrases = new String[]{"SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok"};

        String[] expected = new String[]{"SnapDragon vs tomek"};
        String[] actual = solution.anagrams(phrases);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] phrases = new String[]{"Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM"};

        String[] expected = new String[]{"Radar ghost jilts Kim", "patched hers first"};
        String[] actual = solution.anagrams(phrases);

        Assert.assertArrayEquals(expected, actual);
    }

}
