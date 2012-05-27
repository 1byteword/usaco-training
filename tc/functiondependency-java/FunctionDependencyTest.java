import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FunctionDependencyTest {

    protected FunctionDependency solution;

    @Before
    public void setUp() {
        solution = new FunctionDependency();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] funcs = new String[]{"B", "C", "A"};
        String[] depends = new String[]{"1", "", "1"};

        String[] expected = new String[]{"C", "A", "B"};
        String[] actual = solution.scriptingOrder(funcs, depends);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] funcs = new String[]{"B", "C", "A"};
        String[] depends = new String[]{"1", "", "0"};

        String[] expected = new String[]{"C", "B", "A"};
        String[] actual = solution.scriptingOrder(funcs, depends);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] funcs = new String[]{"K", "A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] depends = new String[]{"", "", "1 1", "2", "3", "4", "5", "6", "7", "8"};

        String[] expected = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "K"};
        String[] actual = solution.scriptingOrder(funcs, depends);

        Assert.assertArrayEquals(expected, actual);
    }

}
