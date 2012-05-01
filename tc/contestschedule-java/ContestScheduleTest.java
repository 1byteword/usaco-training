import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContestScheduleTest {

    protected ContestSchedule solution;

    @Before
    public void setUp() {
        solution = new ContestSchedule();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] contests = new String[]{"1 10 100", "10 20 100", "20 30 100", "30 40 100"};

        double expected = 4.0;
        double actual = solution.expectedWinnings(contests);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] contests = new String[]{"10 20 20", "30 40 60", "15 35 90"};

        double expected = 0.9;
        double actual = solution.expectedWinnings(contests);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] contests = new String[]{"1 100 85", "99 102 100", "101 200 60"};

        double expected = 1.45;
        double actual = solution.expectedWinnings(contests);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] contests = new String[]{"1 1000000000 1"};

        double expected = 0.01;
        double actual = solution.expectedWinnings(contests);

        assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] contests = new String[]{"1361955 8940967 10", "628145516 644285978 17", "883515280 910484865 36", "762888635 769291174 52", "98152102 136328674 1", "9580638 20450682 50", "646139319 664648341 20", "484027666 505290970 57", "841082555 879295329 99", "940563715 966953344 4", "579113528 595261527 25", "925801172 962952912 9", "285845005 307916055 45", "403573723 410697485 10", "9467290 25698952 90", "631265400 650639733 3", "520690249 559261759 96", "491747709 531061081 86", "643215695 672420161 94", "614608448 617341712 44", "456517316 491770747 24", "806956091 828414045 88", "528156706 559510719 15", "158398859 190439269 4", "743974602 761975244 49", "882264704 887725893 1", "877444309 884479317 59", "785986538 806192822 19", "732553407 747696021 81", "132099860 148305810 97", "555144412 572785730 99", "506507263 535927950 82", "489726669 505160939 90", "793692316 804153358 99", "901329638 919179990 10", "29523791 44318662 58", "570497239 595701008 73", "706091347 730328348 23", "118054686 135301010 39", "307178252 337804001 93", "896162463 900667971 39", "271356542 273095245 80", "865692962 891795950 91", "593986003 596160000 58", "807688147 831190344 59", "468916697 496462595 92"};

        double expected = 14.12;
        double actual = solution.expectedWinnings(contests);

        assertEquals(expected, actual);
    }

}
