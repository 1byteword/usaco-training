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

	@Test
	public void testNoCow() {
		
		int[] xs = new int[] {0, 0, 1, 100, 200};
		int[] ys = new int[] {0, 1, 0, 100, 200};
		String[] adjacency = new String[] {
				"00000", 
				"00100", 
				"01000", 
				"00001", 
				"00010"
		};

		String expected = "2.414214";
		String actual = solution.solve(xs, ys, adjacency);
		Assert.assertEquals(expected, actual);
	}

}
