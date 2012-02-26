import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected money solution;

	@Before
	public void setUp() {
		solution = new money();
	}

	@Test
	public void test0() {
		int n = 10;
		int[] values = new int[] {1, 2, 5};
		long expected = 10L;
		long actual = solution.solve(n, values);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLong() {
		int n = 500;
		int[] values = new int[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
		long expected = 18390132498L;
		long actual = solution.solve(n, values);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMax() {
		int n = 10000;
		int[] values = new int[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
		long expected = 1458505034935112402L;
		long actual = solution.solve(n, values);
		Assert.assertEquals(expected, actual);
	}


}
