import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected numtri solution;

	@Before
	public void setUp() {
		solution = new numtri();
	}

	@Test
	public void testSimple() {
		int n = 5;
		int[][] triangle = new int[][] {
				new int[] {7}, 	
				new int[] {3, 8}, 	
				new int[] {8, 1, 0}, 	
				new int[] {2, 7, 4, 4}, 	
				new int[] {4, 5, 2, 6, 5} 	
		};
		int expected = 30;
		int actual = solution.solve(n, triangle);
		Assert.assertEquals(expected, actual);
	}
}
