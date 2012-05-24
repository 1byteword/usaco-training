import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnagramListTest {

    protected AnagramList solution;

    @Before
    public void setUp() {
        solution = new AnagramList();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String s = "tree";
        int i = 1;

        String expected = "eetr";
        String actual = solution.getAnagram(s, i);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String s = "tree";
        int i = 6;

        String expected = "reet";
        String actual = solution.getAnagram(s, i);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String s = "tree";
        int i = 12;

        String expected = "";
        String actual = solution.getAnagram(s, i);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String s = "abcabfebda";
        int i = 5000;

        String expected = "aadfcabbbe";
        String actual = solution.getAnagram(s, i);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String s = "sdoijgfasdkhaiw";
        int i = 2000000000;

        String expected = "adsdghwiiokfjas";
        String actual = solution.getAnagram(s, i);

        Assert.assertEquals(expected, actual);
    }
    
    @Test//(timeout = 2000)
    public void testCase5() {
        String s = "hrsrqzsrfhhhfhtss";
        int i = 790187153;

        String expected = "fshhhrzshfsqtrrhs";
        String actual = solution.getAnagram(s, i);

        Assert.assertEquals(expected, actual);
    }
    
    
    

}
