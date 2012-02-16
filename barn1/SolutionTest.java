import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected barn1 solution;

	@Before
	public void setUp() {
		solution = new barn1();
	}

	@Test
	public void testCase0() {
		int boards = 4;
		int[] stalls = new int[] { 3, 4, 6, 8, 14, 15, 16, 17, 21, 25, 26, 27, 30, 31, 40, 41, 42, 43 };
		int expected = 25;
		int actual = solution.solve(boards, stalls);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase1() {
		int boards = 50;
		int[] stalls = new int[] { 18, 69, 195, 38, 73, 28, 6, 172, 53, 99 };
		int expected = 10;
		int actual = solution.solve(boards, stalls);
		Assert.assertEquals(expected, actual);
	}

}
