import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputerExpertTest {

    protected ComputerExpert solution;

    @Before
    public void setUp() {
        solution = new ComputerExpert();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] facts = new String[]{"SKY_IS_CLOUDY", "HAVE_MONEY"};
        String[] rules = new String[]{"HAVE_MONEY,BAD_WEATHER -> WATCH_MOVIE", "SKY_IS_CLOUDY -> BAD_WEATHER", "GOOD_WEATHER -> PLAY_SOCCER"};

        String[] expected = new String[]{"BAD_WEATHER", "WATCH_MOVIE"};
        String[] actual = solution.operate(facts, rules);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] facts = new String[]{"NEEDLE_LEAF", "KEEPS_LEAVES"};
        String[] rules = new String[]{"KEEPS_LEAVES -> EVERGREEN", "NEEDLE_LEAF -> GYMNOSPERM", "EVERGREEN,GYMNOSPERM -> PINE_TREE"};

        String[] expected = new String[]{"EVERGREEN", "GYMNOSPERM", "PINE_TREE"};
        String[] actual = solution.operate(facts, rules);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] facts = new String[]{"I"};
        String[] rules = new String[]{"I -> I", "P -> CONSONANT", "Z -> CONSONANT", "A/E/I/O/U -> VOWEL"};

        String[] expected = new String[]{"VOWEL"};
        String[] actual = solution.operate(facts, rules);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] facts = new String[]{"Y", "W", "L", "T", "H", "J", "G", "T", "F", "P", "T", "P", "P", "N"};
        String[] rules = new String[]{"C/V,J,F/T,N,W,L -> M", "N/L,F,B/N/E,Y -> C", "M,G,G,S/F/Q,G,S/G,H/Z,W,F,C,Q/F,M -> E"};

        String[] expected = new String[]{"C", "E", "M"};
        String[] actual = solution.operate(facts, rules);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String[] facts = new String[]{"G", "H"};
        String[] rules = new String[]{"A/B/C/D/E/F,G/Z -> Y", "H,H,H,H,H,H,H,H -> Z"};

        String[] expected = new String[]{"Z"};
        String[] actual = solution.operate(facts, rules);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase5() {
        String[] facts = new String[]{"A", "B", "_X", "X_"};
        String[] rules = new String[]{"A/B,C -> D", "A,B,C -> D", "X -> Y", "_X_ -> Y"};

        String[] expected = new String[]{};
        String[] actual = solution.operate(facts, rules);

        Assert.assertArrayEquals(expected, actual);
    }

}
