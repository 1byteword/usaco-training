import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected sprime solution;

	@Before
	public void setUp() {
		solution = new sprime();
	}

	@Test
	public void testSimple() {
		int length = 4;
		long[] expected = new long[] { 2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193, 7331, 7333, 7393 };
		long[] actual = solution.solve(length);
		Assert.assertArrayEquals(expected, actual);
	}

}
