import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected holstein solution;

	@Before
	public void setUp() {
		solution = new holstein();
	}

	@Test
	public void test0() {
		int[] vitamins = new int[] { 100, 200, 300, 400 };
		int[][] scoops = new int[][] { new int[] { 50, 50, 50, 50 }, new int[] { 200, 300, 200, 300 }, new int[] { 900, 150, 389, 399 } };
		String expected = "2 1 3";
		String actual = solution.solve(scoops, vitamins);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int[] vitamins = new int[] { 100, 200, 300 };
		int[][] scoops = new int[][] { new int[] { 99, 199, 299 }, 
				new int[] { 2, 2, 2 }, 
				new int[] { 1000, 1000, 1000 } };
		String expected = "1 3";
		String actual = solution.solve(scoops, vitamins);
		Assert.assertEquals(expected, actual);
	}
}
