import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected milk solution;

	@Before
	public void setUp() {
		solution = new milk();
	}

	@Test
	public void testCase0() {
		int total = 100;
		int farmers = 5;
		int[] prices = new int[] {5, 9, 3, 8, 6	};
		int[] amounts = new int[] {20, 40, 10, 80, 30};
		int expected = 630;
		int actual = solution.solve(total, farmers, prices, amounts);
		Assert.assertEquals(expected, actual);
	}

}
