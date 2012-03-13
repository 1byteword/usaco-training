import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected subset solution;

	@Before
	public void setUp() {
		solution = new subset();
	}

	@Test
	public void testNoSolution() {
		int n = 6;
		long expected = 0L;
		long actual = solution.solve(n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test0() {
		int n = 7;
		long expected = 4L;
		long actual = solution.solve(n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int n = 3;
		long expected = 1L;
		long actual = solution.solve(n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMax() {
		int n = 39;
		long expected = 1L;
		long actual = solution.solve(n);
		Assert.assertEquals(expected, actual);
	}

}
