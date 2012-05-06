import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TournamentRankerTest {

    protected TournamentRanker solution;

    @Before
    public void setUp() {
        solution = new TournamentRanker();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] names = new String[]{"RODDICK", "SCHUETTLER", "FERREIRA", "AGASSI"};
        String[] lostTo = new String[]{"SCHUETTLER", "AGASSI", "AGASSI", ""};

        String[] expected = new String[]{"AGASSI", "SCHUETTLER", "FERREIRA", "RODDICK"};
        String[] actual = solution.rankTeams(names, lostTo);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] names = new String[]{"DUKE", "SETON HALL", "ILLINOIS", "CINCINNATI", "NORTH CAROLINA", "TEXAS", "XAVIER", "MISSISSIPPI STATE"};
        String[] lostTo = new String[]{"", "DUKE", "DUKE", "ILLINOIS", "TEXAS", "XAVIER", "DUKE", "XAVIER"};

        String[] expected = new String[]{"DUKE", "XAVIER", "ILLINOIS", "TEXAS", "SETON HALL", "MISSISSIPPI STATE", "CINCINNATI", "NORTH CAROLINA"};
        String[] actual = solution.rankTeams(names, lostTo);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] names = new String[]{"JAVA", "VISUAL BASIC"};
        String[] lostTo = new String[]{"VISUAL BASIC", ""};

        String[] expected = new String[]{"VISUAL BASIC", "JAVA"};
        String[] actual = solution.rankTeams(names, lostTo);

        Assert.assertArrayEquals(expected, actual);
    }

}
