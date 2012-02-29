import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected inflate solution;

	@Before
	public void setUp() {
		solution = new inflate();
	}

	@Test
	public void test0() {
		int m = 300;
		int[] points = new int[] {100, 250, 120, 35};
		int[] minutes = new int[] { 60, 120, 100, 20};

		int expected = 605;
		int actual = solution.solve(m, points, minutes);
		Assert.assertEquals(expected, actual);
	}

}
