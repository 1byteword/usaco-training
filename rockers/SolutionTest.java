import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected rockers solution;

	@Before
	public void setUp() {
		solution = new rockers();
	}

	@Test
	public void test0() {
		int t = 5;
		int m = 2;
		int[] songs = new int[] { 4, 3, 4, 2 };
		int expected = 3;
		int actual = solution.solve(t, m, songs);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int t = 1;
		int m = 5;
		int[] songs = new int[] { 6 };
		int expected = 0;
		int actual = solution.solve(t, m, songs);
		Assert.assertEquals(expected, actual);
	}
}
