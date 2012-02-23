import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected hamming solution;

	@Before
	public void setUp() {
		solution = new hamming();
	}

	@Test
	public void test0() {
		int n = 16;
		int b = 7;
		int d = 3;
		int[] expected = new int[] {0, 7, 25, 30, 42, 45, 51, 52, 75, 76, 82, 85, 97, 102, 120, 127};
		int[] actual = solution.solve(n, b, d);
		Assert.assertArrayEquals(expected, actual);
	}

}
