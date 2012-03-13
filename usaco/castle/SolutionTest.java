import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected castle solution;

	@Before
	public void setUp() {
		solution = new castle();
	}

	@Test
	public void test0() {
		int m = 7;
		int n = 4;
		int[][] map = new int[][] { new int[] { 11, 6, 11, 6, 3, 10, 6 }, new int[] { 7, 9, 6, 13, 5, 15, 5 }, new int[] { 1, 10, 12, 7, 13, 7, 5 },
				new int[] { 13, 11, 10, 8, 10, 12, 13 } };
		String[] expected = new String[] { "5", "9", "16", "4 1 E" };
		String[] actual = solution.solve(m, n, map);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test1() {
		int m = 5;
		int n = 5;
		int[][] map = new int[][] { new int[] { 3, 2, 6, 3, 6 }, new int[] { 1, 8, 4, 1, 4 }, new int[] { 13, 7, 13, 9, 4 },
				new int[] { 3, 0, 2, 6, 5 }, new int[] { 9, 8, 8, 12, 13 } };
		String[] expected = new String[] { "3", "9", "17", "4 1 N" };
		String[] actual = solution.solve(m, n, map);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int m = 15;
		int n = 14;
		int[][] map = new int[][] { new int[] { 11, 14, 3, 6, 3, 6, 3, 6, 3, 6, 3, 6, 11, 2, 6 },
				new int[] { 3, 10, 12, 9, 12, 9, 12, 9, 12, 9, 12, 9, 6, 1, 4 }, new int[] { 13, 7, 11, 10, 10, 10, 10, 10, 10, 14, 11, 6, 5, 1, 4 },
				new int[] { 11, 4, 3, 10, 10, 10, 10, 10, 10, 10, 6, 5, 13, 1, 4 }, new int[] { 7, 13, 5, 7, 11, 10, 2, 10, 14, 7, 5, 13, 7, 9, 12 },
				new int[] { 1, 14, 5, 1, 10, 14, 5, 11, 10, 4, 9, 6, 1, 10, 6 }, new int[] { 13, 7, 5, 5, 3, 10, 8, 10, 6, 5, 3, 12, 9, 10, 12 },
				new int[] { 11, 4, 5, 13, 5, 3, 10, 6, 5, 13, 5, 3, 10, 10, 6 }, new int[] { 7, 13, 1, 10, 4, 1, 10, 4, 1, 10, 4, 5, 3, 10, 12 },
				new int[] { 1, 14, 5, 7, 5, 9, 10, 12, 5, 7, 5, 5, 9, 10, 6 }, new int[] { 13, 7, 13, 5, 9, 10, 2, 10, 12, 13, 13, 5, 3, 10, 12 },
				new int[] { 7, 5, 15, 9, 10, 14, 5, 11, 14, 11, 14, 5, 9, 10, 6 }, new int[] { 5, 13, 7, 7, 11, 10, 8, 10, 14, 7, 3, 12, 3, 10, 12 },
				new int[] { 13, 15, 13, 13, 11, 10, 14, 11, 10, 12, 9, 10, 8, 10, 14 } };
		String[] expected = new String[] { "27", "55", "85", "11 11 E" };
		String[] actual = solution.solve(m, n, map);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testTwoRooms() {
		int m = 2;
		int n = 1;
		int[][] map = new int[][] { new int[] { 15, 15 } };
		String[] expected = new String[] { "2", "1", "2", "1 1 E" };
		String[] actual = solution.solve(m, n, map);
		Assert.assertArrayEquals(expected, actual);
	}

}
