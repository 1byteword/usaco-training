import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SteeplechaseTrackTest {

    protected SteeplechaseTrack solution;

    @Before
    public void setUp() {
        solution = new SteeplechaseTrack();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] fences = new String[]{"310", "300", "301"};
        String[] tracks = new String[]{"010", "001", "000"};
        int N = 4;

        int expected = 13;
        int actual = solution.maxComplexity(fences, tracks, N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] fences = new String[]{"923"};
        String[] tracks = new String[]{"1"};
        int N = 100;

        int expected = 1004;
        int actual = solution.maxComplexity(fences, tracks, N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] fences = new String[]{"111", "222", "333"};
        String[] tracks = new String[]{"743", "985", "380"};
        int N = 1;

        int expected = 9;
        int actual = solution.maxComplexity(fences, tracks, N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] fences = new String[]{"101", "202", "303"};
        String[] tracks = new String[]{"659", "431", "770"};
        int N = 5;

        int expected = -1;
        int actual = solution.maxComplexity(fences, tracks, N);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] fences = new String[]{"693", "982", "236"};
        String[] tracks = new String[]{"603", "986", "780"};
        int N = 10;

        int expected = 172;
        int actual = solution.maxComplexity(fences, tracks, N);

        Assert.assertEquals(expected, actual);
    }

}
