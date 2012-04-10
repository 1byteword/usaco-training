import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KingdomReorganizationTest {

    protected KingdomReorganization solution;

    @Before
    public void setUp() {
        solution = new KingdomReorganization();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] kingdom = new String[]{"000", "000", "000"};
        String[] build = new String[]{"ABD", "BAC", "DCA"};
        String[] destroy = new String[]{"ABD", "BAC", "DCA"};

        int expected = 3;
        int actual = solution.getCost(kingdom, build, destroy);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] kingdom = new String[]{"011", "101", "110"};
        String[] build = new String[]{"ABD", "BAC", "DCA"};
        String[] destroy = new String[]{"ABD", "BAC", "DCA"};

        int expected = 1;
        int actual = solution.getCost(kingdom, build, destroy);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] kingdom = new String[]{"011000", "101000", "110000", "000011", "000101", "000110"};
        String[] build = new String[]{"ABDFFF", "BACFFF", "DCAFFF", "FFFABD", "FFFBAC", "FFFDCA"};
        String[] destroy = new String[]{"ABDFFF", "BACFFF", "DCAFFF", "FFFABD", "FFFBAC", "FFFDCA"};

        int expected = 7;
        int actual = solution.getCost(kingdom, build, destroy);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] kingdom = new String[]{"0"};
        String[] build = new String[]{"A"};
        String[] destroy = new String[]{"A"};

        int expected = 0;
        int actual = solution.getCost(kingdom, build, destroy);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String[] kingdom = new String[]{"0001", "0001", "0001", "1110"};
        String[] build = new String[]{"AfOj", "fAcC", "OcAP", "jCPA"};
        String[] destroy = new String[]{"AWFH", "WAxU", "FxAV", "HUVA"};

        int expected = 0;
        int actual = solution.getCost(kingdom, build, destroy);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase5() {
        String[] kingdom = new String[]{"0000000000", "0000000011", "0001010000", "0010010000", "0000001000", "0011000000", "0000100000", "0000000011", "0100000101", "0100000110"};
        String[] build = new String[]{"AhPEqkSFMM", "hAfKPtsDad", "PfAyGQkaqN", "EKyAeLpRpm", "qPGeASfNwo", "ktQLSAnCAK", "SskpfnAdJS", "FDaRNCdAZz", "MaqpwAJZAn", "MdNmoKSznA"};
        String[] destroy = new String[]{"AgTqWWxEYH", "gAXPgjzIRA", "TXAleTmWvT", "qPlAQkwxRO", "WgeQAqgbJJ", "WjTkqAiTzl", "xzmwgiAuHb", "EIWxbTuAwk", "YRvRJzHwAn", "HATOJlbknA"};

        int expected = 65;
        int actual = solution.getCost(kingdom, build, destroy);

        Assert.assertEquals(expected, actual);
    }

}
