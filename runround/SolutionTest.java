import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected runround solution;

	@Before
	public void setUp() {
		solution = new runround();
	}

	@Test
	public void test0() {
		long m = 81361;
		long expected = 81362;
		long actual = solution.solve(m);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		long m = 134259;
		long expected = 134859;
		long actual = solution.solve(m);
		Assert.assertEquals(expected, actual);
	}

}
