import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected ratios solution;

	@Before
	public void setUp() {
		solution = new ratios();
	}


	@Test
	public void test0() {
		int[] goal = new int[] {3, 4, 5};
		int[][] mixtures = new int[][] {
				new int[] {1, 2, 3}, 
				new int[] {3, 7, 1}, 
				new int[] {2, 1, 2}
		};
		int[] expected = new int[] {8, 1, 5, 7};
		int[] actual = solution.solve(goal, mixtures);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test1() {
		int[] goal = new int[] {5, 8, 0};
		int[][] mixtures = new int[][] {
				new int[] {3, 5, 4}, 
				new int[] {1, 3, 0}, 
				new int[] {6, 2, 0}
		};
		int[] expected = new int[] {0 ,38, 7, 16};
		int[] actual = solution.solve(goal, mixtures);
		Assert.assertArrayEquals(expected, actual);
	}
}
