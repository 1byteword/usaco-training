import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected nocows solution;

	@Before
	public void setUp() {
		solution = new nocows();
	}

	@Test
	public void test0() {
		int n = 5;
		int k = 3;
		int expected = 2;
		int actual = solution.solve(n, k);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int n = 7;
		int k = 3;
		int expected = 1;
		int actual = solution.solve(n, k);
		Assert.assertEquals(expected, actual);
	}


}
