import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected fence solution;

	@Before
	public void setUp() {
		solution = new fence();
	}

	@Test
	public void test0() {
		String[] edges = new String[] { "1 2", " 2 3", " 3 4", " 4 2", " 4 5", " 2 5", " 5 6", " 5 7", " 4 6"};
		int[] expected = new int[] {1, 2, 3, 4, 2, 5, 4, 6, 5, 7};
		int[] actual = solution.solve(edges);
		Assert.assertArrayEquals(expected, actual);
	}
	@Test
	public void test1() {
		String[] edges = new String[] { "1 2", " 2 3", " 3 1"};
		int[] expected = new int[] {1, 2, 3, 1};
		int[] actual = solution.solve(edges);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String[] edges = new String[] { "2 9", "9 7", "9 5", "5 10", "10 1", "1 7", 
				"7 10", "7 3", "3 4", "4 5", "5 3", "3 6", "6 5", "4 10", "5 2"};
		int[] expected = new int[] {4, 3, 5, 2, 9, 5, 4, 10, 1, 7, 3, 6, 5, 10, 7, 9};
		int[] actual = solution.solve(edges);
		Assert.assertArrayEquals(expected, actual);
	}
	
}
