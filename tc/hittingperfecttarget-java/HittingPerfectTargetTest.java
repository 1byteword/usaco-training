import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HittingPerfectTargetTest {

    protected HittingPerfectTarget solution;

    @Before
    public void setUp() {
        solution = new HittingPerfectTarget();
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.isNaN(expected)) {
            Assert.assertTrue("expected: <NaN> but was: <" + actual + ">", Double.isNaN(actual));
            return;
        }
        double delta = Math.max(1e-9, 1e-9 * Math.abs(expected));
        Assert.assertEquals(expected, actual, delta);
    }
    
	@Test
	public void test0() {
		int px = -100;
		int py = -100;
        int[] x = new int[]{-100, -100, 100, 100};
        int[] y = new int[]{-100, 100, 100, -100};
		boolean expected = true;
		boolean actual = solution.pointInPolygon(px, py, x, y);
		Assert.assertEquals(expected, actual);
	}



    @Test////(timeout = 2000)
    public void testCase0() {
        int[] x1 = new int[]{-100, -100, 100, 100};
        int[] y1 = new int[]{-100, 100, -100, 100};
        int[] x2 = new int[]{-100, -100, 100, 100};
        int[] y2 = new int[]{-100, 100, -100, 100};

        double expected = 1.0;
        double actual = solution.getProbability(x1, y1, x2, y2);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int[] x1 = new int[]{-99, -98, 0};
        int[] y1 = new int[]{-99, 99, 0};
        int[] x2 = new int[]{99, 98, 0};
        int[] y2 = new int[]{-99, 99, 0};

        double expected = 2.475186257765897E-5;
        double actual = solution.getProbability(x1, y1, x2, y2);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int[] x1 = new int[]{0, 0, 1, 1};
        int[] y1 = new int[]{0, 1, 0, 1};
        int[] x2 = new int[]{-54, -99, -100, -100};
        int[] y2 = new int[]{-54, 99, 100, -100};

        double expected = 0.0;
        double actual = solution.getProbability(x1, y1, x2, y2);

        assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int[] x1 = new int[]{-1, 1, -30, 30, 0};
        int[] y1 = new int[]{-1, -1, 30, 30, 50};
        int[] x2 = new int[]{-2, 2, -60, 60, 0};
        int[] y2 = new int[]{-2, -2, 60, 60, 100};

        double expected = 0.03895943169723522;
        double actual = solution.getProbability(x1, y1, x2, y2);

        assertEquals(expected, actual);
    }

}
