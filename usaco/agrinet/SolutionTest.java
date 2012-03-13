import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected agrinet solution;

	@Before
	public void setUp() {
		solution = new agrinet();
	}

	@Test
	public void test0() {
		int n = 4;
		int[][] map = new int[][] { new int[] { 0, 4, 9, 21 }, new int[] { 4, 0, 8, 17 }, new int[] { 9, 8, 0, 16 }, new int[] { 21, 17, 16, 0 } };

		int expected = 28;
		int actual = solution.solve(n, map);
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test1() {
		int n = 6;
		int[][] map = new int[][] { 
				new int[] {0, 45, 86, 12, 61, 51}, 
				new int[] {45, 0, 80, 99, 18, 2}, 
				new int[] {86, 80, 0, 9, 37, 14}, 
				new int[] {12, 99, 9, 0, 14, 90}, 
				new int[] {61, 18, 37, 14, 0, 52}, 
				new int[] {51, 2, 14, 90, 52, 0}
		};

		int expected = 51;
		int actual = solution.solve(n, map);
		Assert.assertEquals(expected, actual);
	}
}
