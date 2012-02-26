import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected concom solution;

	@Before
	public void setUp() {
		solution = new concom();
	}

	@Test
	public void test0() {
		int[] froms = new int[] { 1, 2, 3 };
		int[] tos = new int[] { 2, 3, 1 };
		int[] percentages = new int[] { 80, 80, 20 };

		String[] expected = new String[] { "1 2", "1 3", "2 3" };
		String[] actual = solution.solve(froms, tos, percentages);
		Assert.assertArrayEquals(expected, actual);
	}

}
