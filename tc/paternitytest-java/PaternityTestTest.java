import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaternityTestTest {

    protected PaternityTest solution;

    @Before
    public void setUp() {
        solution = new PaternityTest();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String child = "ABCD";
        String mother = "AXCY";
        String[] men = new String[]{"SBTD", "QRCD"};

        int[] expected = new int[]{0};
        int[] actual = solution.possibleFathers(child, mother, men);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String child = "ABCD";
        String mother = "ABCX";
        String[] men = new String[]{"ABCY", "ASTD", "QBCD"};

        int[] expected = new int[]{1, 2};
        int[] actual = solution.possibleFathers(child, mother, men);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String child = "ABABAB";
        String mother = "ABABAB";
        String[] men = new String[]{"ABABAB", "ABABCC", "ABCCDD", "CCDDEE"};

        int[] expected = new int[]{0, 1};
        int[] actual = solution.possibleFathers(child, mother, men);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String child = "YZGLSYQT";
        String mother = "YUQRWYQT";
        String[] men = new String[]{"YZQLDPWT", "BZELSWQM", "OZGPSFKT", "GZTKFYQT", "WQJLSMQT"};

        int[] expected = new int[]{};
        int[] actual = solution.possibleFathers(child, mother, men);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String child = "WXETPYCHUWSQEMKKYNVP";
        String mother = "AXQTUQVAUOSQEEKCYNVP";
        String[] men = new String[]{"WNELPYCHXWXPCMNKDDXD", "WFEEPYCHFWDNPMKKALIW", "WSEFPYCHEWEFGMPKIQCK", "WAEXPYCHAWEQXMSKYARN", "WKEXPYCHYWLLFMGKKFBB"};

        int[] expected = new int[]{1, 3};
        int[] actual = solution.possibleFathers(child, mother, men);

        Assert.assertArrayEquals(expected, actual);
    }

}
