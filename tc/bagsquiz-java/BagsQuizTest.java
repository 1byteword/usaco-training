import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BagsQuizTest {

    protected BagsQuiz solution;

    @Before
    public void setUp() {
        solution = new BagsQuiz();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int n = 2;
        String[] actions = new String[]{"PUT 1 INSIDE 2"};

        int expected = 1;
        int actual = solution.checkIfProper(n, actions);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int n = 2;
        String[] actions = new String[]{"PUT 1 INSIDE 2", "SET 2 LOOSE"};

        int expected = 2;
        int actual = solution.checkIfProper(n, actions);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int n = 2;
        String[] actions = new String[]{"PUT 2 INSIDE 1"};

        int expected = -1;
        int actual = solution.checkIfProper(n, actions);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int n = 4;
        String[] actions = new String[]{"PUT 3 INSIDE 2", "SWAP 4 WITH 2", "PUT 2 INSIDE 4", "SET 1 LOOSE"};

        int expected = 2;
        int actual = solution.checkIfProper(n, actions);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        int n = 3;
        String[] actions = new String[]{"PUT 1 INSIDE 2", "PUT 3 INSIDE 1"};

        int expected = -1;
        int actual = solution.checkIfProper(n, actions);

        Assert.assertEquals(expected, actual);
    }

}
