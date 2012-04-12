import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CubismTest {

    protected Cubism solution;

    @Before
    public void setUp() {
        solution = new Cubism();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] lattice = new String[]{"BBBBBWWWBWWWBWWW", "BWWWWWWWWWWWWWWW", "BWWWWWWWWWWWWWWW", "BWWWWWWWWWWWWWWW"};
        String color = "black";

        int expected = 3;
        int actual = solution.lines(lattice, color);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] lattice = new String[]{"BWWWWWWWWWWWWWWW", "WWWWWBWWWWWWWWWW", "WWWWWWWWWWBWWWWW", "WWWWWWWWWWWWWWWB"};
        String color = "black";

        int expected = 1;
        int actual = solution.lines(lattice, color);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] lattice = new String[]{"WWWWWWWWWWWWWWWW", "WWWWWWWWWWWWWWWW", "WWWWWWWWWWWWWWWW", "WWWWWWWWWWWWWWWW"};
        String color = "black";

        int expected = 0;
        int actual = solution.lines(lattice, color);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] lattice = new String[]{"WWWWWWWWWWWWWWWW", "WWWWWWWWWWWWWWWW", "WWWWWWWWWWWWWWWW", "WWWWWWWWWWWWWWWW"};
        String color = "white";

        int expected = 76;
        int actual = solution.lines(lattice, color);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String[] lattice = new String[]{"WWWWWWWWWBWWWWWW", "WWWBWWWWWWWWWWWW", "WWWWWWWWWWWWBWWW", "WWWBWWWWWWWWWWWW"};
        String color = "white";

        int expected = 58;
        int actual = solution.lines(lattice, color);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase5() {
        String[] lattice = new String[]{"BWBWBWBWBWBWBWBW", "BWBWBWBWBWBWBWBW", "BWBWBWBWBWBWBWBW", "BWBWBWBWBWBWBWBW"};
        String color = "white";

        int expected = 20;
        int actual = solution.lines(lattice, color);

        Assert.assertEquals(expected, actual);
    }

}
