import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected zerosum solution;

	@Before
	public void setUp() {
		solution = new zerosum();
	}

	@Test
	public void test0() {
		int n = 7;
		String[] expected = new String[] {"1+2-3+4-5-6+7", "1+2-3-4+5+6-7", "1-2 3+4+5+6+7", "1-2 3-4 5+6 7", "1-2+3+4-5+6-7", "1-2-3-4-5+6+7"};
		String[]  actual = solution.solve(n);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testMax() {
		int n = 9;
		String[] expected = new String[] {"1+2-3+4-5-6+7", "1+2-3-4+5+6-7", "1-2 3+4+5+6+7", "1-2 3-4 5+6 7", "1-2+3+4-5+6-7", "1-2-3-4-5+6+7"};
		String[]  actual = solution.solve(n);
		Assert.assertArrayEquals(expected, actual);
	}


}
