import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected lamps solution;

	@Before
	public void setUp() {
		solution = new lamps();
	}

	@Test
	public void testNoSolution() {
		int n = 10;
		int c = 1;
		int[] ons = new int[] {};
		int[] offs = new int[] {7};
		String[] expected = new String[ ] {"0000000000", "0101010101", "0110110110"};
		String[] actual = solution.solve(n, c, ons, offs);
		Assert.assertArrayEquals(expected, actual);
	}

}
