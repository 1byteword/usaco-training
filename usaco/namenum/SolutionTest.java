import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected namenum solution;

	@Before
	public void setUp() {
		solution = new namenum();
	}

	@Test
	public void testCase0() {
		String numStr = "4734";
		String[] expected = new String[] {"GREG"};
		String[] actual = solution.solve(numStr, namenum.VALID_NAMES);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testCase1() {
		String numStr = "5747867437";
		String[] expected = new String[] {"KRISTOPHER"};
		String[] actual = solution.solve(numStr, namenum.VALID_NAMES);
		Assert.assertArrayEquals(expected, actual);
	}

}
