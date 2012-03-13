import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected sort3 solution;

	@Before
	public void setUp() {
		solution = new sort3();
	}

	@Test
	public void test0() {
		int[] arr = new int[] { 2, 2, 1, 3, 3, 3, 2, 3, 1 };
		int expected =4; 
		int actual = solution.solve(arr);
		Assert.assertEquals(expected, actual);
	}
	}
