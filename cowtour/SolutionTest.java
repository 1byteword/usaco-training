import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected cowtour solution;

	@Before
	public void setUp() {
		solution = new cowtour();
	}

	@Test
	public void test0() {
		
		int[] xs = new int[] {10, 15, 20, 15, 20, 30, 25, 30 };
		int[] ys = new int[] {10, 10, 10, 15, 15, 15, 10, 10 };
		String[] adjacency = new String[] {
				"01000000", 
				"10111000", 
				"01001000", 
				"01001000", 
				"01110000", 
				"00000010", 
				"00000101", 
				"00000010" 
		};

		String expected = "22.071068";
		String actual = solution.solve(xs, ys, adjacency);
		Assert.assertEquals(expected, actual);
	}

}
