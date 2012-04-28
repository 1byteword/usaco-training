import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThesaurusTest {

    protected Thesaurus solution;

    @Before
    public void setUp() {
        solution = new Thesaurus();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] entry = new String[]{"ape monkey wrench", "wrench twist strain"};

        String[] expected = new String[]{"ape monkey wrench", "strain twist wrench"};
        String[] actual = solution.edit(entry);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] entry = new String[]{"ape monkey wrench", "wrench twist strain", "monkey twist frugue"};

        String[] expected = new String[]{"ape monkey wrench", "frugue monkey twist", "strain twist wrench"};
        String[] actual = solution.edit(entry);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] entry = new String[]{"ape monkey wrench", "wrench twist strain", "monkey twist frugue strain"};

        String[] expected = new String[]{"ape frugue monkey strain twist wrench"};
        String[] actual = solution.edit(entry);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] entry = new String[]{"point run score", "point dot", "cut run tear score", "cut valley", "cute pretty"};

        String[] expected = new String[]{"cut point run score tear", "cut valley", "cute pretty", "dot point"};
        String[] actual = solution.edit(entry);

        Assert.assertArrayEquals(expected, actual);
    }
    
    @Test//(timeout = 2000)
    public void testCase4() {
        String[] entry = new String[]{"a b c", "d e f", "g h i", "b g c e f"};

        String[] expected = new String[]{"a b c d e f g", "g h i"};
        String[] actual = solution.edit(entry);

        Assert.assertArrayEquals(expected, actual);
    }
    
}
