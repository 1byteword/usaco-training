import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected fact4 solution;

	@Before
	public void setUp() {
		solution = new fact4();
	}

	@Test
	public void test0() {
		int n = 7;
		int expected = 4;
		int actual = solution.solve(n);
		Assert.assertEquals(expected, actual);
	}
}
