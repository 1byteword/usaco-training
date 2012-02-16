import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class SolutionTest {

	protected packrec solution;

	@Before
	public void setUp() {
		solution = new packrec();
	}

	@Test
	public void testCase0() {
		int[] ls = new int[]{1, 2, 3, 4};
		int[] ws = new int[]{2, 3, 4, 5};
		String[] expected = new String[]{"40", "4 10", "5 8"};
		String[] actual = solution.solve(ls, ws);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testCase1() {
		int[] ls = new int[]{4, 2, 5, 2};
		int[] ws = new int[]{5, 5, 2, 10};
		String[] expected = new String[]{"60", "4 15", "6 10"};
		String[] actual = solution.solve(ls, ws);
		Assert.assertArrayEquals(expected, actual);
	}

}
