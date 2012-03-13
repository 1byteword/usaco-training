import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTest {

    protected Diving solution;

    @Before
    public void setUp() {
        solution = new Diving();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String difficulty = "3.2";
        String need = "50.32";
        String ratings = "5.5 7.5 10.0 ?.? 4.5";

        String expected = "0.0";
        String actual = solution.needed(difficulty, need, ratings);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String difficulty = "3.2";
        String need = "50.32";
        String ratings = "5.5 5.5 10.0 ?.? 4.5";

        String expected = "5.0";
        String actual = solution.needed(difficulty, need, ratings);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String difficulty = "4.0";
        String need = "120.00";
        String ratings = "9.5 10.0 ?.? 10.0 10.0";

        String expected = "10.0";
        String actual = solution.needed(difficulty, need, ratings);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String difficulty = "4.0";
        String need = "120.00";
        String ratings = "9.5 10.0 ?.? 9.5 10.0";

        String expected = "-1.0";
        String actual = solution.needed(difficulty, need, ratings);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String difficulty = "2.3";
        String need = ".01";
        String ratings = "0.0 0.0 ?.? 0.0 0.5";

        String expected = "0.5";
        String actual = solution.needed(difficulty, need, ratings);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase5() {
        String difficulty = "3.3";
        String need = "47.85";
        String ratings = "0.5 5.5 3.5 7.0 ?.?";

        String expected = "5.5";
        String actual = solution.needed(difficulty, need, ratings);

        Assert.assertEquals(expected, actual);
    }

}
