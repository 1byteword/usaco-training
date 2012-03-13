import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected milk2 solution;

	@Before
	public void setUp() {
		solution = new milk2();
	}

	@Test
	public void testCase0() {
		String expected = "900 300";
		int[] starts = new int[] {300, 700, 1500};
		int[] ends = new int[] {1000, 1200, 2100};
		String actual = solution.solve(starts, ends);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase1() {
		String expected = "9 3";
		int[] starts = new int[] {3, 7, 15};
		int[] ends = new int[] {10, 12, 21};
		String actual = solution.solve(starts, ends);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase2() {
		String expected = "100 0";
		int[] starts = new int[] {100};
		int[] ends = new int[] {200};
		String actual = solution.solve(starts, ends);
		Assert.assertEquals(expected, actual);
	}

}
